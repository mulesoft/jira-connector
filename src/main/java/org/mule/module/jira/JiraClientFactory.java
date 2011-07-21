package org.mule.module.jira;

import org.mule.module.jira.api.AxisJiraClient;
import org.mule.module.jira.api.DefaultAxisPortProvider;
import org.mule.module.jira.api.JiraClient;

public class JiraClientFactory {

    private static JiraClient defaultClient;

    public static JiraClient getClient(String address) {
        if (defaultClient != null) {
            return defaultClient;
        }
        return new AxisJiraClient(new DefaultAxisPortProvider(address));
    }

    public static void setDefaultClient(JiraClient defaultClient) {
        JiraClientFactory.defaultClient = defaultClient;
    }
}