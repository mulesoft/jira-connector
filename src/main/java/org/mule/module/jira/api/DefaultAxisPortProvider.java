/**
 * Mule Jira Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.jira.api;


import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapService;
import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapServiceServiceLocator;

import java.rmi.RemoteException;

import javax.validation.constraints.NotNull;
import javax.xml.rpc.ServiceException;

import org.apache.commons.lang.Validate;

public class DefaultAxisPortProvider implements AxisJiraSoapServiceProvider
{
    private final String username;
    private final String password;
    private final String address;

    /**
     * Creates the port provider
     * 
     * @param username
     * @param password
     * @param address
     */
    public DefaultAxisPortProvider(@NotNull String username, @NotNull String password, @NotNull String address)
    {
        Validate.notNull(username);
        Validate.notNull(password);
        Validate.notNull(address);
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public JiraSoapService getService() throws RemoteException
    {
        JiraSoapServiceServiceLocator serviceLocator = new JiraSoapServiceServiceLocator();
        serviceLocator.setJirasoapserviceV2EndpointAddress(address);
        try
        {
            return serviceLocator.getJirasoapserviceV2();
        }
        catch (ServiceException e)
        {
            throw new RemoteException("A Service exception occured while trying to create the service", e);
        }
    }

    /**
     * Need to authenticate before every call
     * 
     * @return Jira session ID
     * @throws Exception
     */
    public String getToken() throws RemoteException
    {
        return getService().login(username, password);
    }
}
