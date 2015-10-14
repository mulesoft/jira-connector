
package org.mule.module.jira.connectivity;

import javax.annotation.Generated;
import org.mule.devkit.internal.connection.management.ConnectionManagementConnectionKey;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class ConnectionManagementConfigJiraConnectorConnectionKey implements ConnectionManagementConnectionKey
{

    /**
     * 
     */
    private String connectionUser;
    /**
     * 
     */
    private String connectionPassword;
    /**
     * 
     */
    private String connectionAddress;

    public ConnectionManagementConfigJiraConnectorConnectionKey(String connectionUser, String connectionPassword, String connectionAddress) {
        this.connectionUser = connectionUser;
        this.connectionPassword = connectionPassword;
        this.connectionAddress = connectionAddress;
    }

    /**
     * Sets connectionUser
     * 
     * @param value Value to set
     */
    public void setConnectionUser(String value) {
        this.connectionUser = value;
    }

    /**
     * Retrieves connectionUser
     * 
     */
    public String getConnectionUser() {
        return this.connectionUser;
    }

    /**
     * Sets connectionPassword
     * 
     * @param value Value to set
     */
    public void setConnectionPassword(String value) {
        this.connectionPassword = value;
    }

    /**
     * Retrieves connectionPassword
     * 
     */
    public String getConnectionPassword() {
        return this.connectionPassword;
    }

    /**
     * Sets connectionAddress
     * 
     * @param value Value to set
     */
    public void setConnectionAddress(String value) {
        this.connectionAddress = value;
    }

    /**
     * Retrieves connectionAddress
     * 
     */
    public String getConnectionAddress() {
        return this.connectionAddress;
    }

    @Override
    public int hashCode() {
        int result = ((this.connectionUser!= null)?this.connectionUser.hashCode(): 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConnectionManagementConfigJiraConnectorConnectionKey)) {
            return false;
        }
        ConnectionManagementConfigJiraConnectorConnectionKey that = ((ConnectionManagementConfigJiraConnectorConnectionKey) o);
        if (((this.connectionUser!= null)?(!this.connectionUser.equals(that.connectionUser)):(that.connectionUser!= null))) {
            return false;
        }
        return true;
    }

}
