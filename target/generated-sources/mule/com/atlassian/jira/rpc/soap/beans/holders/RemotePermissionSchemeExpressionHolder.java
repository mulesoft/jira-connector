
package com.atlassian.jira.rpc.soap.beans.holders;

import com.atlassian.jira.rpc.soap.beans.RemotePermissionMapping;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class RemotePermissionSchemeExpressionHolder
    extends RemoteSchemeExpressionHolder
{

    protected Object permissionMappings;
    protected RemotePermissionMapping[] _permissionMappingsType;

    /**
     * Sets permissionMappings
     * 
     * @param value Value to set
     */
    public void setPermissionMappings(Object value) {
        this.permissionMappings = value;
    }

    /**
     * Retrieves permissionMappings
     * 
     */
    public Object getPermissionMappings() {
        return this.permissionMappings;
    }

}
