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

import org.mule.module.jira.api.JiraClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.apache.axis.AxisFault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class JiraClientAdaptor {
    private static Logger log = LoggerFactory.getLogger(JiraConnector.class);

    private JiraClientAdaptor() {
    }

    @SuppressWarnings("unchecked")
    public static JiraClient<List<Object>> adapt(final JiraClient<?> receptor) {
        return (JiraClient) Proxy.newProxyInstance(
                JiraClientAdaptor.class.getClassLoader(), new Class[]{JiraClient.class},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        try {
                            if (log.isDebugEnabled()) {
                                log.debug("Entering {} with args {}", method.getName(), args);
                            }
                            Object ret = adaptReturnType(method.invoke(receptor, args));
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
    

    private static Object adaptReturnType(Object result)
    {
        if(result instanceof Object[])
            return Arrays.asList((Object[])result);
        return result;
    }

    private static Throwable adaptException(Throwable e) {
        if (e instanceof AxisFault) {
            return new JiraConnectorException(((AxisFault) e).getFaultString(), e);
        }
        if (e instanceof RemoteException) {
            return new JiraConnectorException(e);
        }
        return e;
    }

}
