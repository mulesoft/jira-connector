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

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

import org.mule.api.lifecycle.InitialisationException;

import com.atlassian.jira.rpc.soap.beans.RemoteIssue;

import org.junit.Before;
import org.junit.Test;

public class JiraTestDriver
{
    private JiraCloudConnector connector;

    @Before
    public void setup() throws InitialisationException
    {
        connector = new JiraCloudConnector();
        connector.setAddress("http://localhost:8080/rpc/soap/jirasoapservice-v2");
        connector.setPassword("admin");
        connector.setUsername("admin");
        connector.initialise();
    }

    /**
     * Creates an issue an verifies it can be fetched by key 
     */
    @Test
    public void createIssue() throws Exception
    {
        RemoteIssue issue = new RemoteIssue();
        issue.setProject("TEST");
        issue.setSummary("A big bug!");
        issue.setDescription("This occurs when fooing, baring or bazing");
        issue.setType("3");
        String key = connector.createIssue(issue);
        try
        {
            assertNotNull(connector.getIssue(key));
        }
        finally
        {
            connector.deleteIssue(key);
        }
    }

    /**
     * Tries to get an inexistent issue 
     */
    @Test(expected = JiraException.class)
    public void getIssueInexistent() throws Exception
    {
        connector.getIssue("FOOBAR-600");
    }
    
    @Test(expected = JiraException.class)
    public void deleteInexistent() throws Exception
    {
        connector.deleteIssue("BAZ-986");
    }

}
