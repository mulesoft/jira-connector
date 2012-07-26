/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.jira.api;


import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapService;
import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapServiceServiceLocator;
import org.apache.commons.lang.Validate;

import javax.validation.constraints.NotNull;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class DefaultAxisPortProvider implements AxisJiraSoapServiceProvider {

    private final String address;

    public DefaultAxisPortProvider(@NotNull String address) {
        Validate.notNull(address);
        this.address = address;
    }

    public JiraSoapService getService() throws RemoteException {
        JiraSoapServiceServiceLocator serviceLocator = new JiraSoapServiceServiceLocator();
        serviceLocator.setJirasoapserviceV2EndpointAddress(address);
        try {
            return serviceLocator.getJirasoapserviceV2();
        } catch (ServiceException e) {
            throw new RemoteException("A Service exception occured while trying to create the service", e);
        }
    }
}