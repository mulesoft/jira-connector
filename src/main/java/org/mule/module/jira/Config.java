/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */
package org.mule.module.jira;

import java.util.List;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.Optional;
import org.mule.module.jira.api.JiraClient;

@ConnectionManagement(friendlyName = "Configuration", configElementName = "config")
public class Config {

    /**
     * if external custom fields names (instead of internal ids) are used when modifying custom fields, the provided user must be a Jira administrator in order to be able to use
     * this feature
     */
    @Configurable
    @Optional
    @Default("false")
    private Boolean useCustomFieldsExternalName;
    private JiraClient<List<Object>> client;
    private String token;
    private String connectionUser;
    private String connectionAddress;

    /**
     * Creates a connection to Jira by making a login call with the given credentials to the specified address. The login call, if successfull, returns a token which will be used
     * in the subsequent calls to Jira.
     *
     * @param connectionUser
     *            the user login user
     * @param connectionPassword
     *            the user login pass
     * @param connectionAddress
     *            the JIRA Server Soap address. It usually looks like https://&lt;jira server hostname&gt;/rpc/soap/jirasoapservice-v2 or http://&lt;jira server
     *            hostname&gt;/rpc/soap/jirasoapservice-v2
     */
    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String connectionUser, @Password String connectionPassword, String connectionAddress) throws ConnectionException {
        this.connectionUser = connectionUser;
        this.connectionAddress = connectionAddress;
        client = JiraClientAdaptor.adapt(JiraClientFactory.getClient(connectionAddress)); // (JiraClientFactory.getClient(connectionAddress));
        token = client.login(connectionUser, connectionPassword);
    }

    /**
     * Performs a logout call to Jira.
     */
    @Disconnect
    public void disconnect() {
        if (token != null) {
            String oldToken = token;
            token = null;
            client.logout(oldToken);
            client = null;
        }
    }

    /**
     * Returns whether the current user is authenticated. It does not mean tell anything whether the current session has expired
     */
    @ValidateConnection
    public boolean validateConnection() {
        return token != null;
    }

    /**
     * Returns a connection identifier.
     */
    @Override
    @ConnectionIdentifier
    public String toString() {
        return "{username='" + connectionUser + "\', address='" + connectionAddress + "\'}";
    }

    public JiraClient<List<Object>> getClient() {
        return client;
    }

    public String getConnectionUser() {
        return connectionUser;
    }

    public void setConnectionUser(String connectionUser) {
        this.connectionUser = connectionUser;
    }

    public String getConnectionAddress() {
        return connectionAddress;
    }

    public void setConnectionAddress(String connectionAddress) {
        this.connectionAddress = connectionAddress;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getUseCustomFieldsExternalName() {
        return useCustomFieldsExternalName;
    }

    public void setUseCustomFieldsExternalName(Boolean useCustomFieldsExternalName) {
        this.useCustomFieldsExternalName = useCustomFieldsExternalName;
    }
}
