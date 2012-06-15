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

import org.junit.Before;
import org.junit.Test;
import org.mule.module.jira.api.AxisJiraClient;
import org.mule.module.jira.api.DefaultAxisPortProvider;

/**
 * Test driver for {@link JiraConnector}
 * */
public class JiraConnectorTestDriver
{
    private JiraConnector connector;
    private String endpoint = System.getenv("jira.endpoint");
    
    @Before
    public void init()
    {
        this.connector = new JiraConnector();
        connector.setClient(new AxisJiraClient(new DefaultAxisPortProvider(endpoint)));
    }
    
    @Test(expected = JiraConnectorException.class)
    public void createIssue()
    {
        connector.createIssue(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }
}

