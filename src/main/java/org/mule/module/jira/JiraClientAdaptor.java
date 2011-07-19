/**
 * Mule Jira Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.jira;

import org.apache.axis.AxisFault;
import org.mule.module.jira.api.JiraClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;

public final class JiraClientAdaptor {
    private static Logger log = LoggerFactory.getLogger(JiraCloudConnector.class);

    private JiraClientAdaptor() {
    }

    @SuppressWarnings("unchecked")
    public static JiraClient adapt(final JiraClient receptor) {
        return (JiraClient) Proxy.newProxyInstance(
                JiraClientAdaptor.class.getClassLoader(), new Class[]{JiraClient.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            if (log.isDebugEnabled()) {
                                log.debug("Entering {} with args {}", method.getName(), args);
                            }
                            Object ret = method.invoke(receptor, args);
                            if (log.isDebugEnabled()) {
                                log.debug("Returning from {} with value {}", method.getName(), ret);
                            }
                            return ret;
                        } catch (InvocationTargetException e) {
                            if (log.isWarnEnabled()) {
                                log.warn("An exception was thrown while invoking {}: {}", method.getName(),
                                        e.getCause());
                            }
                            throw adaptException(e.getCause());
                        }
                    }

                });
    }

    private static Throwable adaptException(Throwable e) {
        if (e instanceof AxisFault) {
            return new JiraCloudConnectorException(((AxisFault) e).getFaultString(), e);
        }
        if (e instanceof RemoteException) {
            return new JiraCloudConnectorException(e);
        }
        return e;
    }

}
