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
import java.util.Properties;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mule.api.ConnectionException;
import org.mule.tools.devkit.ctf.configuration.util.ConfigurationUtils;
import org.mule.tools.devkit.ctf.exceptions.ConfigurationLoadingFailedException;

/**
 * Test driver for {@link JiraConnector}
 */
public class JiraConnectorTestDriver {

    private String endpoint;
    private String username;
    private String password;

    private JiraConnector connector;

    @Before
    public void init() throws ConnectionException, ConfigurationLoadingFailedException {
        Config config = new Config();
        final Properties prop = ConfigurationUtils.getAutomationCredentialsProperties();
        username = prop.getProperty("config.username");
        password = prop.getProperty("config.password");
        endpoint = prop.getProperty("config.endpoint");

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
