
package com.atlassian.jira.rpc.soap.beans.holders;

import com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme;
import com.atlassian.jira.rpc.soap.beans.RemoteScheme;
import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class RemoteProjectExpressionHolder
    extends AbstractNamedRemoteEntityExpressionHolder
{

    protected Object description;
    protected String _descriptionType;
    protected Object issueSecurityScheme;
    protected RemoteScheme _issueSecuritySchemeType;
    protected Object key;
    protected String _keyType;
    protected Object lead;
    protected String _leadType;
    protected Object notificationScheme;
    protected RemoteScheme _notificationSchemeType;
    protected Object permissionScheme;
    protected RemotePermissionScheme _permissionSchemeType;
    protected Object projectUrl;
    protected String _projectUrlType;
    protected Object url;
    protected String _urlType;

    /**
     * Sets description
     * 
     * @param value Value to set
     */
    public void setDescription(Object value) {
        this.description = value;
    }

    /**
     * Retrieves description
     * 
     */
    public Object getDescription() {
        return this.description;
    }

    /**
     * Sets issueSecurityScheme
     * 
     * @param value Value to set
     */
    public void setIssueSecurityScheme(Object value) {
        this.issueSecurityScheme = value;
    }

    /**
     * Retrieves issueSecurityScheme
     * 
     */
    public Object getIssueSecurityScheme() {
        return this.issueSecurityScheme;
    }

    /**
     * Sets key
     * 
     * @param value Value to set
     */
    public void setKey(Object value) {
        this.key = value;
    }

    /**
     * Retrieves key
     * 
     */
    public Object getKey() {
        return this.key;
    }

    /**
     * Sets lead
     * 
     * @param value Value to set
     */
    public void setLead(Object value) {
        this.lead = value;
    }

    /**
     * Retrieves lead
     * 
     */
    public Object getLead() {
        return this.lead;
    }

    /**
     * Sets notificationScheme
     * 
     * @param value Value to set
     */
    public void setNotificationScheme(Object value) {
        this.notificationScheme = value;
    }

    /**
     * Retrieves notificationScheme
     * 
     */
    public Object getNotificationScheme() {
        return this.notificationScheme;
    }

    /**
     * Sets permissionScheme
     * 
     * @param value Value to set
     */
    public void setPermissionScheme(Object value) {
        this.permissionScheme = value;
    }

    /**
     * Retrieves permissionScheme
     * 
     */
    public Object getPermissionScheme() {
        return this.permissionScheme;
    }

    /**
     * Sets projectUrl
     * 
     * @param value Value to set
     */
    public void setProjectUrl(Object value) {
        this.projectUrl = value;
    }

    /**
     * Retrieves projectUrl
     * 
     */
    public Object getProjectUrl() {
        return this.projectUrl;
    }

    /**
     * Sets url
     * 
     * @param value Value to set
     */
    public void setUrl(Object value) {
        this.url = value;
    }

    /**
     * Retrieves url
     * 
     */
    public Object getUrl() {
        return this.url;
    }

}
