
package org.mule.module.jira.connectivity;

import javax.annotation.Generated;
import org.mule.api.ConnectionException;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionAdapter;
import org.mule.devkit.internal.connection.management.TestableConnection;
import org.mule.module.jira.Config;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class ConfigJiraConnectorAdapter
    extends Config
    implements ConnectionManagementConnectionAdapter<Config, ConnectionManagementConfigJiraConnectorConnectionKey> , TestableConnection<ConnectionManagementConfigJiraConnectorConnectionKey>
{


    @Override
    public void connect(ConnectionManagementConfigJiraConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getConnectionUser(), connectionKey.getConnectionPassword(), connectionKey.getConnectionAddress());
    }

    @Override
    public void test(ConnectionManagementConfigJiraConnectorConnectionKey connectionKey)
        throws ConnectionException
    {
        super.connect(connectionKey.getConnectionUser(), connectionKey.getConnectionPassword(), connectionKey.getConnectionAddress());
    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public String connectionId() {
        return super.toString();
    }

    @Override
    public boolean isConnected() {
        return super.validateConnection();
    }

    @Override
    public Config getStrategy() {
        return this;
    }

}
