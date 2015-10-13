/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.jira;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.api.ConnectionException;

/**
 * Test driver for {@link JiraConnector}
 */
public class JiraConnectorTestDriver {

    private String endpoint = System.getenv("jira.endpoint");
    private String username = System.getenv("jira.username");
    private String password = System.getenv("jira.password");

    private JiraConnector connector;

    @Before
    public void init() throws ConnectionException {
        Config config = new Config();
        config.connect(username, password, endpoint);
        connector.setConfig(config);
    }

    @Test(expected = JiraConnectorException.class)
    public void createIssue() {
        connector.createIssue(null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    @Test
    @Ignore
    public void updateIssuesByJql() {
        Map<String, String> fields = new HashMap<String, String>();
        fields.put("priority", "1");
        connector.updateIssuesByJql("status = Open", fields, null);
    }

}
