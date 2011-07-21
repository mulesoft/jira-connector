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

import com.atlassian.jira.rpc.soap.beans.*;
import com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapService;
import org.apache.commons.lang.Validate;
import org.mule.module.jira.JiraCloudConnectorException;

import javax.validation.constraints.NotNull;
import java.rmi.RemoteException;
import java.util.Calendar;

public class AxisJiraClient implements JiraClient {

    private AxisJiraSoapServiceProvider serviceProvider;
    private AxisJiraClientHelper helper;

    public AxisJiraClient(@NotNull AxisJiraSoapServiceProvider serviceProvider) {
        Validate.notNull(serviceProvider);
        this.serviceProvider = serviceProvider;
        helper = new AxisJiraClientHelper(this);
    }

    public RemoteComment getComment(String token, Long id) {
        try {
            return getService().getComment(token, id);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteConfiguration getConfiguration(String token) {
        try {
            return getService().getConfiguration(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteGroup createGroup(String token, String groupName, String userName) {
        try {
            RemoteUser user = getUser(token, userName);
            return getService().createGroup(token, groupName, user);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteServerInfo getServerInfo(String token) {
        try {
            return getService().getServerInfo(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteGroup getGroup(String token, String groupName) {
        try {
            return getService().getGroup(token, groupName);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteUser createUser(String token, String username, String password, String fullName, String email) {
        try {
            return getService().createUser(token, username, password, fullName, email);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void addComment(String token, String issueKey, String commentAuthor, String commentBody, String commentGroupLevel, String commentRoleLevel) {
        try {
            RemoteComment comment = helper.createComment(commentAuthor, commentBody, commentGroupLevel, commentRoleLevel);
            getService().addComment(token, issueKey, comment);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteComponent[] getComponents(String token, String projectKey) {
        try {
            return getService().getComponents(token, projectKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteUser getUser(String token, String username) {
        try {
            return getService().getUser(token, username);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void addUserToGroup(String token, String groupName, String userName) {
        try {
            getService().addUserToGroup(token, getGroup(token, groupName), getUser(token, userName));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void removeUserFromGroup(String token, String groupName, String userName) {
        try {
            getService().removeUserFromGroup(token, getGroup(token, groupName), getUser(token, userName));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue getIssue(String token, String issueKey) {
        try {
            return getService().getIssue(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue createIssue(String token, String assignee, String summary, String description, String dueDate, String environment, String priority, String project, String reporter, String type, Long votes, String[] customFieldKeys, String[] customFieldValues) {
        RemoteIssue issue = helper.createIssue(assignee, summary, description, dueDate, environment, priority, project, reporter, type, votes, customFieldKeys, customFieldValues);
        try {
            return getService().createIssue(token, issue);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue updateIssue(String token, String issueKey, String[] fieldIds, String[] fieldValues) {
        try {
            return getService().updateIssue(token, issueKey, helper.createFieldValues(fieldIds, fieldValues));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemotePermissionScheme addPermissionTo(String token, String permissionSchemeName, Long permissionCode, String entityName) {
        try {
            RemotePermissionScheme permissionScheme = helper.getPermissionScheme(token, permissionSchemeName);
            RemotePermission remotePermission = helper.getPermission(token, permissionCode);
            RemoteEntity entity = helper.getUserOrUserGroupByName(token, entityName);
            return getService().addPermissionTo(token, permissionScheme, remotePermission, entity);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemotePermissionScheme deletePermissionFrom(String token, String permissionSchemeName, Long permissionCode, String entityName) {
        try {
            RemotePermissionScheme permissionScheme = helper.getPermissionScheme(token, permissionSchemeName);
            RemotePermission remotePermission = helper.getPermission(token, permissionCode);
            RemoteEntity entity = helper.getUserOrUserGroupByName(token, entityName);
            return getService().deletePermissionFrom(token, permissionScheme, remotePermission, entity);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteIssue(String token, String issueKey) {
        try {
            getService().deleteIssue(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteNamedObject[] getAvailableActions(String token, String issueKey) {
        try {
            return getService().getAvailableActions(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssueType[] getSubTaskIssueTypes(String token) {
        try {
            return getService().getSubTaskIssueTypes(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProject getProjectByKey(String token, String projectKey) {
        try {
            return getService().getProjectByKey(token, projectKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemotePriority[] getPriorities(String token) {
        try {
            return getService().getPriorities(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteResolution[] getResolutions(String token) {
        try {
            return getService().getResolutions(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssueType[] getIssueTypes(String token) {
        try {
            return getService().getIssueTypes(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteStatus[] getStatuses(String token) {
        try {
            return getService().getStatuses(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssueType[] getIssueTypesForProject(String token, String projectId) {
        try {
            return getService().getIssueTypesForProject(token, projectId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProjectRole[] getProjectRoles(String token) {
        try {
            return getService().getProjectRoles(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProjectRole getProjectRole(String token, Long id) {
        try {
            return getService().getProjectRole(token, id);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteRoleActors getDefaultRoleActors(String token, Long projectRoleId) {
        try {
            return getService().getDefaultRoleActors(token, getProjectRole(token, projectRoleId));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void removeAllRoleActorsByNameAndType(String token, String name, String type) {
        try {
            getService().removeAllRoleActorsByNameAndType(token, name, type);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteProjectRole(String token, Long projectRoleId, Boolean confirm) {
        try {
            getService().deleteProjectRole(token, getProjectRole(token, projectRoleId), confirm);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void addDefaultActorsToProjectRole(String token, String[] actors, Long projectRoleId, String type) {
        try {
            getService().addDefaultActorsToProjectRole(token, actors, getProjectRole(token, projectRoleId), type);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProject getProjectById(String token, Long projectId) {
        try {
            return getService().getProjectById(token, projectId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProjectRole createProjectRole(String token, String projectRoleName, String projectRoleDescription) {
        RemoteProjectRole projectRole = new RemoteProjectRole();
        projectRole.setName(projectRoleName);
        projectRole.setDescription(projectRoleDescription);
        try {
            return getService().createProjectRole(token, projectRole);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void addActorsToProjectRole(String token, String[] actors, Long projectRoleId, String projectKey, String actorType) {
        RemoteProjectRole projectRole = getProjectRole(token, projectRoleId);
        RemoteProject project = getProjectByKey(token, projectKey);
        try {
            getService().addActorsToProjectRole(token, actors, projectRole, project, actorType);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void removeActorsFromProjectRole(String token, String[] actors, Long projectRoleId, String projectKey, String actorType) {
        RemoteProjectRole projectRole = getProjectRole(token, projectRoleId);
        RemoteProject project = getProjectByKey(token, projectKey);
        try {
            getService().removeActorsFromProjectRole(token, actors, projectRole, project, actorType);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public boolean isProjectRoleNameUnique(String token, String name) {
        try {
            return getService().isProjectRoleNameUnique(token, name);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void updateProjectRole(String token, Long projectRoleId, String projectRoleName, String projectRoleDescription) {
        RemoteProjectRole projectRole = getProjectRole(token, projectRoleId);
        helper.updateProjectRoleName(projectRole, projectRoleName);
        helper.updateProjectRoleDescription(projectRole, projectRoleDescription);
        try {
            getService().updateProjectRole(token, projectRole);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void removeDefaultActorsFromProjectRole(String token, String[] actors, Long projectRoleId, String type) {
        try {
            getService().removeDefaultActorsFromProjectRole(token, actors, getProjectRole(token, projectRoleId), type);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteScheme[] getAssociatedNotificationSchemes(String token, Long projectRoleId) {
        try {
            return getService().getAssociatedNotificationSchemes(token, getProjectRole(token, projectRoleId));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteScheme[] getAssociatedPermissionSchemes(String token, Long projectRoleId) {
        try {
            return getService().getAssociatedPermissionSchemes(token, getProjectRole(token, projectRoleId));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteVersion[] getVersions(String token, String projectKey) {
        try {
            return getService().getVersions(token, projectKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteComment[] getComments(String token, String issueKey) {
        try {
            return getService().getComments(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteProject(String token, String projectKey) {
        try {
            getService().deleteProject(token, projectKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteField[] getFieldsForEdit(String token, String issueKey) {
        try {
            return getService().getFieldsForEdit(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssueType[] getSubTaskIssueTypesForProject(String token, String projectId) {
        try {
            return getService().getSubTaskIssueTypesForProject(token, projectId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteSecurityLevel getSecurityLevel(String token, String issueKey) {
        try {
            return getService().getSecurityLevel(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProject getProjectWithSchemesById(String token, Long projectId) {
        try {
            return getService().getProjectWithSchemesById(token, projectId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteFilter[] getFavouriteFilters(String token) {
        try {
            return getService().getFavouriteFilters(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void archiveVersion(String token, String projectKey, String versionName, Boolean archive) {
        try {
            getService().archiveVersion(token, projectKey, versionName, archive);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void releaseVersion(String token, String projectKey, String versionName) {
        RemoteVersion version = helper.getVersion(token, projectKey, versionName);
        try {
            getService().releaseVersion(token, projectKey, version);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteSecurityLevel[] getSecurityLevels(String token, String projectKey) {
        try {
            return getService().getSecurityLevels(token, projectKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteAvatar[] getProjectAvatars(String token, String projectKey, Boolean includeSystemAvatars) {
        try {
            return getService().getProjectAvatars(token, projectKey, includeSystemAvatars);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void setProjectAvatar(String token, String projectKey, Long avatarId) {
        try {
            getService().setProjectAvatar(token, projectKey, avatarId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteAvatar getProjectAvatar(String token, String projectKey) {
        try {
            return getService().getProjectAvatar(token, projectKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteProjectAvatar(String token, Long avatarId) {
        try {
            getService().deleteProjectAvatar(token, avatarId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteScheme[] getNotificationSchemes(String token) {
        try {
            return getService().getNotificationSchemes(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemotePermissionScheme[] getPermissionSchemes(String token) {
        try {
            return getService().getPermissionSchemes(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteAttachment[] getAttachmentsFromIssue(String token, String issueKey) {
        try {
            return getService().getAttachmentsFromIssue(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteField[] getFieldsForAction(String token, String issueKey, String actionIdString) {
        try {
            return getService().getFieldsForAction(token, issueKey, actionIdString);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue progressWorkflowAction(String token, String issueKey, String actionIdString, String[] fieldIds, String[] fieldsValues) {
        try {
            return getService().progressWorkflowAction(token, issueKey, actionIdString, helper.createFieldValues(fieldIds, fieldsValues));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteWorklogWithNewRemainingEstimate(String token, String workLogId, String newRemainingEstimate) {
        try {
            getService().deleteWorklogWithNewRemainingEstimate(token, workLogId, newRemainingEstimate);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteWorklogAndAutoAdjustRemainingEstimate(String token, String worklogId) {
        try {
            getService().deleteWorklogAndAutoAdjustRemainingEstimate(token, worklogId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void updateWorklogWithNewRemainingEstimate(String token, String issueKey, String worklogId, String comment,
                                                      String groupLevel, String roleLevelId, String newRemainingEstimate) {
        RemoteWorklog worklog = helper.getWorklog(token, issueKey, worklogId);
        helper.updateWorkLog(worklog, comment, groupLevel, roleLevelId);
        try {
            getService().updateWorklogWithNewRemainingEstimate(token, worklog, newRemainingEstimate);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteWorklogAndRetainRemainingEstimate(String token, String worklogId) {
        try {
            getService().deleteWorklogAndRetainRemainingEstimate(token, worklogId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteWorklog[] getWorklogs(String token, String issueKey) {
        try {
            return getService().getWorklogs(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public boolean hasPermissionToCreateWorklog(String token, String issueKey) {
        try {
            return getService().hasPermissionToCreateWorklog(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public boolean hasPermissionToDeleteWorklog(String token, String worklogId) {
        try {
            return getService().hasPermissionToDeleteWorklog(token, worklogId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public boolean hasPermissionToUpdateWorklog(String token, String worklogId) {
        try {
            return getService().hasPermissionToUpdateWorklog(token, worklogId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public Calendar getResolutionDateByKey(String token, String issueKey) {
        try {
            return getService().getResolutionDateByKey(token, issueKey);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public Calendar getResolutionDateById(String token, Long issueId) {
        try {
            return getService().getResolutionDateById(token, issueId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public long getIssueCountForFilter(String token, String filterId) {
        try {
            return getService().getIssueCountForFilter(token, filterId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue[] getIssuesFromTextSearchWithProject(String token, String[] projectKeys, String searchTerms, Integer maxNumResults) {
        try {
            return getService().getIssuesFromTextSearchWithProject(token, projectKeys, searchTerms, maxNumResults);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue[] getIssuesFromJqlSearch(String token, String jqlSearch, Integer maxNumResults) {
        try {
            return getService().getIssuesFromJqlSearch(token, jqlSearch, maxNumResults);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteUser(String token, String username) {
        try {
            getService().deleteUser(token, username);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deleteGroup(String token, String groupName, String swapGroupName) {
        try {
            getService().deleteGroup(token, groupName, swapGroupName);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void refreshCustomFields(String token) {
        try {
            getService().refreshCustomFields(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public boolean addBase64EncodedAttachmentsToIssue(String token, String issueKey, String[] fileNames, String[] base64EncodedAttachmentData) {
        try {
            return getService().addBase64EncodedAttachmentsToIssue(token, issueKey, fileNames, base64EncodedAttachmentData);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue[] getIssuesFromFilterWithLimit(String token, String filterId, Integer offset, Integer maxNumResults) {
        try {
            return getService().getIssuesFromFilterWithLimit(token, filterId, offset, maxNumResults);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue[] getIssuesFromTextSearchWithLimit(String token, String searchTerms, Integer offset, Integer maxNumResults) {
        try {
            return getService().getIssuesFromTextSearchWithLimit(token, searchTerms, offset, maxNumResults);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProject[] getProjectsNoSchemes(String token) {
        try {
            return getService().getProjectsNoSchemes(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteScheme[] getSecuritySchemes(String token) {
        try {
            return getService().getSecuritySchemes(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteVersion addVersion(String token, String projectKey, String versionName, Boolean archived, Boolean released, String releaseDate) {
        RemoteVersion version = helper.createVersion(versionName, archived, released, releaseDate);
        try {
            return getService().addVersion(token, projectKey, version);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void setNewProjectAvatar(String token, String projectKey, String contentType, String base64ImageData) {
        try {
            getService().setNewProjectAvatar(token, projectKey, contentType, base64ImageData);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteField[] getCustomFields(String token) {
        try {
            return getService().getCustomFields(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void deletePermissionScheme(String token, String permissionSchemeName) {
        try {
            getService().deletePermissionScheme(token, permissionSchemeName);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue getIssueById(String token, String issueId) {
        try {
            return getService().getIssueById(token, issueId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteGroup updateGroup(String token, String groupName, String[] usernames) {
        RemoteGroup group = getGroup(token, groupName);
        RemoteUser[] usersToAddToGroup = helper.getRemoteUsers(token, usernames).toArray(new RemoteUser[usernames.length]);
        group.setUsers(usersToAddToGroup);
        try {
            return getService().updateGroup(token, group);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public void removeAllRoleActorsByProject(String token, String projectKey) {
        try {
            getService().removeAllRoleActorsByProject(token, getProjectByKey(token, projectKey));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProjectRoleActors getProjectRoleActors(String token, Long projectRoleId, String projectKey) {
        try {
            return getService().getProjectRoleActors(token, getProjectRole(token, projectRoleId), getProjectByKey(token, projectKey));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public boolean logout(String token) {
        try {
            return getService().logout(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemotePermission[] getAllPermissions(String token) {
        try {
            return getService().getAllPermissions(token);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemotePermissionScheme createPermissionScheme(String token, String name, String description) {
        try {
            return getService().createPermissionScheme(token, name, description);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public String login(String username, String password) {
        try {
            return getService().login(username, password);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteIssue createIssueWithSecurityLevel(String token, String asignee, String summary, String description,
                                                    String dueDate, String environment, String priority, String project,
                                                    String reporter, String type, Long votes, String[] customFieldKeys, String[] customFieldValues, Long securityLevelId) {
        RemoteIssue issue = createIssue(token, asignee, summary, description, dueDate, environment, priority, project, reporter, type, votes, customFieldKeys, customFieldValues);
        try {
            return getService().createIssueWithSecurityLevel(token, issue, securityLevelId);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public boolean hasPermissionToEditComment(String token, Long commentId) {
        try {
            return getService().hasPermissionToEditComment(token, getComment(token, commentId));
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteComment editComment(String token, Long commentId, String body, String updateAuthor) {
        RemoteComment comment = getComment(token, commentId);
        helper.updateCommentBody(comment, body);
        helper.updateCommentAuthor(comment, updateAuthor);
        try {
            return getService().editComment(token, comment);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProject createProject(String token, String key, String name, String description, String url, String lead,
                                       String permissionSchemeName, String notificationSchemeName, String securityShemeName) {
        RemotePermissionScheme permissionScheme = helper.getPermissionScheme(token, permissionSchemeName);
        RemoteScheme notificationScheme = helper.getNotificationScheme(token, notificationSchemeName);
        RemoteScheme securityScheme = helper.getSecurityScheme(token, securityShemeName);
        try {
            return getService().createProject(token, key, name, description, url, lead, permissionScheme, notificationScheme, securityScheme);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    public RemoteProject updateProject(String token, String key, String description, String url, String lead,
                                       String permissionSchemeName, String notificationSchemeName, String securityShemeName) {
        RemoteProject project = getProjectByKey(token, key);
        helper.updateDescription(project, description);
        helper.updateUrl(project, url);
        helper.updateLead(project, lead);
        helper.updatePermissionScheme(token, permissionSchemeName, project);
        helper.updateNotificationScheme(token, notificationSchemeName, project);
        helper.upateSecurityScheme(token, securityShemeName, project);
        try {
            return getService().updateProject(token, project);
        } catch (RemoteException e) {
            throw new JiraCloudConnectorException(e);
        }
    }

    private JiraSoapService getService() throws RemoteException {
        return serviceProvider.getService();
    }
}