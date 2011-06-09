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

import static org.junit.Assert.assertNotNull;

import org.mule.api.lifecycle.InitialisationException;

import com.atlassian.jira.rpc.soap.beans.RemoteIssue;

import org.junit.Before;
import org.junit.Test;
public class JiraTestDriver
{
    private static final String ISSUE_ID = "TST-12722";
    private JiraCloudConnector connector;

    @Before
    public void setup() throws InitialisationException
    {
        connector = new JiraCloudConnector();
        connector.setAddress(JiraCloudConnector.DEFAULT_ADDRESS);
        connector.setPassword("soaptester");
        connector.setUsername("soaptester");
        connector.initialise();
    }

    @Test
    public void createIssue() throws Exception
    {
        RemoteIssue issue = new RemoteIssue();
        issue.setSummary("A big bug!");
        issue.setDescription("This occurs when fooing, baring or bazing");
        connector.createIssue(issue);
        try
        {
            assertNotNull(connector.getIssue(issue.getKey()));
        }
        finally
        {
            connector.deleteIssue(issue.getKey());
        }
    }

}
