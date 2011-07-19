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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Before;
import org.junit.Test;
import org.mule.api.lifecycle.InitialisationException;

public class JiraTestDriver {
    private JiraCloudConnector connector;

    @Before
    public void setup() throws InitialisationException {
        connector = new JiraCloudConnector();
        connector.setAddress("http://localhost:8080/rpc/soap/jirasoapservice-v2");
        connector.setPassword("fede");
        connector.setUsername("1024");
    }

    /**
     * Creates an issue an verifies it can be fetched by key
     */
    @Test
    public void createIssue() throws Exception {
        String token = connector.login("fede", "1024");

        connector.getIssueTypesForProject(token, "TST");
    }

    private void printObject(Object obj) {
        System.out.println(ToStringBuilder.reflectionToString(obj, ToStringStyle.MULTI_LINE_STYLE));
    }

//    /**
//     * Tries to get an inexistent issue
//     */
//    @Test(expected = JiraCloudConnectorException.class)
//    public void getIssueInexistent() throws Exception
//    {
//        connector.getIssue("FOOBAR-600");
//    }
//
//    @Test(expected = JiraCloudConnectorException.class)
//    public void deleteInexistent() throws Exception
//    {
//        connector.deleteIssue("BAZ-986");
//    }

}
