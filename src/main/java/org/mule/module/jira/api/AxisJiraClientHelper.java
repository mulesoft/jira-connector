/**
 * Mule Jira Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.jira.api;

import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteCustomFieldValue;
import com.atlassian.jira.rpc.soap.beans.RemoteEntity;
import com.atlassian.jira.rpc.soap.beans.RemoteFieldValue;
import com.atlassian.jira.rpc.soap.beans.RemoteGroup;
import com.atlassian.jira.rpc.soap.beans.RemoteIssue;
import com.atlassian.jira.rpc.soap.beans.RemotePermission;
import com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme;
import com.atlassian.jira.rpc.soap.beans.RemoteProject;
import com.atlassian.jira.rpc.soap.beans.RemoteProjectRole;
import com.atlassian.jira.rpc.soap.beans.RemoteScheme;
import com.atlassian.jira.rpc.soap.beans.RemoteUser;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import com.atlassian.jira.rpc.soap.beans.RemoteWorklog;
import org.mule.module.jira.JiraConnectorException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AxisJiraClientHelper {

    private static final String DATE_FORMAT = "MM-dd-yyy'T'HH:mm:ss";
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
    private static final String EMPTY_PARENT_KEY = "";
    private static final RemoteCustomFieldValue[] EMPTY_REMOTE_CUSTOM_FIELDS = new RemoteCustomFieldValue[0];
    private AxisJiraClient axisJiraClient;
    private static final RemoteFieldValue[] EMPTY_FIELDS = new RemoteFieldValue[0];

    public AxisJiraClientHelper(AxisJiraClient axisJiraClient) {
        this.axisJiraClient = axisJiraClient;
    }

    protected RemoteComment createComment(String commentAuthor, String commentBody, String commentGroupLevel, String commentRoleLevel) {
        RemoteComment remoteComment = new RemoteComment();
        remoteComment.setAuthor(commentAuthor);
        remoteComment.setBody(commentBody);
        remoteComment.setGroupLevel(commentGroupLevel);
        remoteComment.setRoleLevel(commentRoleLevel);
        return remoteComment;
    }

    protected RemoteIssue createIssue(String assignee, String summary, String description, String dueDate, String environment,
                                      String priority, String project, String reporter, String type, Long votes, Map<String, List<String>> customFields) {
        RemoteIssue remoteIssue = new RemoteIssue();
        remoteIssue.setAssignee(assignee);
        remoteIssue.setSummary(summary);
        remoteIssue.setDescription(description);
        remoteIssue.setDuedate(getCalendar(dueDate));
        remoteIssue.setEnvironment(environment);
        remoteIssue.setPriority(priority);
        remoteIssue.setProject(project);
        remoteIssue.setReporter(reporter);
        remoteIssue.setType(type);
        remoteIssue.setVotes(votes);
        remoteIssue.setCustomFieldValues(getRemoteCustomFieldValues(customFields));
        return remoteIssue;
    }

    protected RemoteCustomFieldValue[] getRemoteCustomFieldValues(Map<String, List<String>> customFields) {
        if (customFields == null) {
            return EMPTY_REMOTE_CUSTOM_FIELDS;
        }
        RemoteCustomFieldValue[] result = new RemoteCustomFieldValue[customFields.size()];
        int i = 0;
        for(Entry<String, List<String>> entry : customFields.entrySet()) {
            String customeFieldId = entry.getKey();
            List<String> fieldValues = entry.getValue();
            result[i++] = new RemoteCustomFieldValue(customeFieldId, EMPTY_PARENT_KEY, (String[]) fieldValues.toArray());
        }
        return result;
    }

    protected RemoteFieldValue[] createRemoteFieldValues(Map<String, List<String>> fields) {
        if (fields == null) {
            return EMPTY_FIELDS;
        }
        RemoteFieldValue[] result = new RemoteFieldValue[fields.size()];
        int i = 0;
        for(Entry<String, List<String>> entry : fields.entrySet()) {
            String customeFieldId = entry.getKey();
            List<String> fieldValues = entry.getValue();
            result[i++] = new RemoteFieldValue(customeFieldId, (String[]) fieldValues.toArray());
        }
        return result;
    }

    protected Calendar getCalendar(String dateString) {
        if (dateString == null) {
            return null;
        }
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = SIMPLE_DATE_FORMAT.parse(dateString);
            calendar.setTime(date);
            return calendar;
        } catch (ParseException e) {
            throw new JiraConnectorException("Could not parse date string: " + dateString + " expected format is: " + DATE_FORMAT, e);
        }
    }

    protected List<RemoteUser> getRemoteUsers(String token, String[] usernames) {
        if (usernames.length == 0) {
            return Collections.emptyList();
        }
        List<RemoteUser> remoteUsers = new ArrayList<RemoteUser>(usernames.length);
        for (String username : usernames) {
            RemoteUser user = axisJiraClient.getUser(token, username);
            if(user == null) {
                throw new JiraConnectorException("No user exists with username: " + username);
            }
            remoteUsers.add(user);
        }
        return remoteUsers;
    }

    protected RemotePermissionScheme getPermissionScheme(String token, String permissionSchemeName) {
        if (permissionSchemeName == null) {
            return null;
        }
        RemotePermissionScheme[] permissionSchemes = axisJiraClient.getPermissionSchemes(token);
        for (RemotePermissionScheme permissionScheme : permissionSchemes) {
            if (permissionScheme.getName().equals(permissionSchemeName)) {
                return permissionScheme;
            }
        }
        throw new JiraConnectorException("Permission scheme not found found with name: " + permissionSchemeName);
    }

    protected RemoteScheme getNotificationScheme(String token, String notificationSchemeName) {
        if (notificationSchemeName == null) {
            return null;
        }
        RemoteScheme[] notificationSchemes = axisJiraClient.getNotificationSchemes(token);
        for (RemoteScheme notificationScheme : notificationSchemes) {
            if (notificationScheme.getName().equals(notificationSchemeName)) {
                return notificationScheme;
            }
        }
        throw new JiraConnectorException("Notification scheme not found with name: " + notificationSchemeName);
    }

    protected RemoteScheme getSecurityScheme(String token, String securityShemeName) {
        if (securityShemeName == null) {
            return null;
        }
        RemoteScheme[] securitySchemes = axisJiraClient.getSecuritySchemes(token);
        for (RemoteScheme securityScheme : securitySchemes) {
            if (securityScheme.getName().equals(securityShemeName)) {
                return securityScheme;
            }
        }
        throw new JiraConnectorException("Security scheme not found with name: " + securityShemeName);
    }

    protected void upateSecurityScheme(String token, String securityShemeName, RemoteProject project) {
        RemoteScheme securityScheme = getSecurityScheme(token, securityShemeName);
        if (securityScheme != null) {
            project.setIssueSecurityScheme(securityScheme);
        }
    }

    protected void updateNotificationScheme(String token, String notificationSchemeName, RemoteProject project) {
        RemoteScheme notificationScheme = getNotificationScheme(token, notificationSchemeName);
        if (notificationScheme != null) {
            project.setNotificationScheme(notificationScheme);
        }
    }

    protected void updatePermissionScheme(String token, String permissionSchemeName, RemoteProject project) {
        RemotePermissionScheme permissionScheme = getPermissionScheme(token, permissionSchemeName);
        if (permissionScheme != null) {
            project.setPermissionScheme(permissionScheme);
        }
    }

    protected void updateDescription(RemoteProject project, String description) {
        if (description != null) {
            project.setDescription(description);
        }
    }

    protected void updateUrl(RemoteProject project, String url) {
        if (url != null) {
            project.setUrl(url);
        }
    }

    protected void updateLead(RemoteProject project, String lead) {
        if (lead != null) {
            project.setLead(lead);
        }
    }

    protected void updateProjectRoleName(RemoteProjectRole projectRole, String projectRoleName) {
        if (projectRoleName != null) {
            projectRole.setName(projectRoleName);
        }
    }

    protected void updateProjectRoleDescription(RemoteProjectRole projectRole, String projectRoleDescription) {
        if (projectRoleDescription != null) {
            projectRole.setName(projectRoleDescription);
        }
    }

    protected void updateCommentBody(RemoteComment comment, String body) {
        if (body != null) {
            comment.setBody(body);
        }
    }

    protected void updateCommentAuthor(RemoteComment comment, String updateAuthor) {
        if (updateAuthor != null) {
            comment.setUpdateAuthor(updateAuthor);
        }
    }

    protected RemoteVersion getVersion(String token, String projectKey, String versionName) {
        RemoteVersion[] versions = axisJiraClient.getVersions(token, projectKey);
        for (RemoteVersion version : versions) {
            if (version.getName().equals(versionName)) {
                return version;
            }
        }
        throw new JiraConnectorException("Version not found found with name: " + versionName);
    }

    protected RemoteWorklog getWorklog(String token, String issueKey, String worklogId) {
        RemoteWorklog[] worklogs = axisJiraClient.getWorklogs(token, issueKey);
        for (RemoteWorklog worklog : worklogs) {
            if (worklog.getId().equals(worklogId)) {
                return worklog;
            }
        }
        throw new JiraConnectorException("Worklok not found found with id: " + worklogId);
    }

    protected void updateWorkLog(RemoteWorklog worklog, String comment, String groupLevel, String roleLevelId) {
        if (comment != null) {
            worklog.setComment(comment);
        }
        if (groupLevel != null) {
            worklog.setGroupLevel(groupLevel);
        }
        if (roleLevelId != null) {
            worklog.setRoleLevelId(roleLevelId);
        }
    }

    protected RemoteVersion createVersion(String versionName, Boolean archived, Boolean released, String releaseDate) {
        RemoteVersion version = new RemoteVersion();
        version.setName(versionName);
        version.setArchived(archived);
        version.setReleased(released);
        version.setReleaseDate(getCalendar(releaseDate));
        return version;
    }

    protected RemoteEntity getUserOrUserGroupByName(String token, String entityName) {
        RemoteUser user = axisJiraClient.getUser(token, entityName);
        if (user != null) {
            return user;
        }
        RemoteGroup group = axisJiraClient.getGroup(token, entityName);
        if (group != null) {
            return group;
        }
        throw new JiraConnectorException("No user or group found with name: " + entityName);
    }

    protected RemotePermission getPermission(String token, Long permissionCode) {
        RemotePermission[] allPermissions = axisJiraClient.getAllPermissions(token);
        for (RemotePermission permission : allPermissions) {
            if (permission.getPermission().equals(permissionCode)) {
                return permission;
            }
        }
        throw new JiraConnectorException("No permission found for code: " + permissionCode);
    }
}