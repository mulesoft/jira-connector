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

import com.atlassian.jira.rpc.soap.beans.RemoteIssue;
import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapService;

import java.rmi.RemoteException;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.Validate;

public class AxisJiraClient implements JiraClient<RemoteException>
{
    private AxisJiraSoapServiceProvider serviceProvider;

    public AxisJiraClient(@NotNull AxisJiraSoapServiceProvider serviceProvider)
    {
        Validate.notNull(serviceProvider);
        this.serviceProvider = serviceProvider;
    }

    public void createssue(RemoteIssue issue) throws RemoteException
    {
        getService().createIssue(getToken(), issue);
    }
    
    public void deleteIssue(String key) throws RemoteException
    {
        getService().deleteIssue(getToken(), key);
    }
    
    public RemoteIssue getIssue(String key) throws RemoteException
    {
        return getService().getIssue(getToken(), key);
    }

    private JiraSoapService getService() throws RemoteException
    {
        return serviceProvider.getService();
    }

    private String getToken() throws RemoteException
    {
        return serviceProvider.getToken();
    }
    

}
