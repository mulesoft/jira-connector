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

import java.util.Calendar;

public interface JiraClient {

    RemoteComment getComment(String token, Long id);

    RemoteConfiguration getConfiguration(String token);

    RemoteGroup createGroup(String token, String groupName, String userName);

    RemoteServerInfo getServerInfo(String token);

    RemoteGroup getGroup(String token, String groupName);

    RemoteUser createUser(String token, String username, String password, String fullName, String email);

    void addComment(String token, String issueKey, String commentAuthor, String commentBody, String commentGroupLevel, String commentRoleLevel);

    RemoteComponent[] getComponents(String token, String projectKey);

    RemoteUser getUser(String token, String username);

    void addUserToGroup(String token, String groupName, String userName);

    void removeUserFromGroup(String token, String groupName, String userName);

    RemoteIssue getIssue(String token, String issueKey);

    RemoteIssue createIssue(String token, String assignee, String summary, String description, String dueDate, String environment, String priority, String project, String reporter, String type, Long votes, String[] customFieldKeys, String[] customerFieldValues);

    RemoteIssue createIssueWithSecurityLevel(String token, String asignee, String summary, String description, String dueDate, String environment, String priority, String project, String reporter, String type, Long votes, String[] customFieldKeys, String[] customFieldValues, Long securityLevelId);

    void deleteIssue(String token, String issueKey);

    RemoteNamedObject[] getAvailableActions(String token, String issueKey);

    RemoteIssueType[] getSubTaskIssueTypes(String token);

    RemoteProject getProjectByKey(String token, String projectKey);

    RemotePriority[] getPriorities(String token);

    RemoteResolution[] getResolutions(String token);

    RemoteIssueType[] getIssueTypes(String token);

    RemoteStatus[] getStatuses(String token);

    RemoteIssueType[] getIssueTypesForProject(String token, String projectId);

    RemoteProjectRole[] getProjectRoles(String token);

    RemoteProjectRole getProjectRole(String token, Long id);

    RemoteRoleActors getDefaultRoleActors(String token, Long projectRoleId);

    void removeAllRoleActorsByNameAndType(String token, String name, String type);

    void deleteProjectRole(String token, Long projectRoleId, Boolean confirm);

    void addDefaultActorsToProjectRole(String token, String[] actors, Long projectRoleId, String type);

    RemoteProject getProjectById(String token, Long projectId);

    RemoteProjectRole createProjectRole(String token, String projectRoleName, String projectRoleDescription);

    boolean isProjectRoleNameUnique(String token, String name);

    void updateProjectRole(String token, Long projectRoleId, String projectRoleName, String projectRoleDescription);

    void removeDefaultActorsFromProjectRole(String token, String[] actors, Long projectRoleId, String type);

    RemoteScheme[] getAssociatedNotificationSchemes(String token, Long projectRoleId);

    RemoteScheme[] getAssociatedPermissionSchemes(String token, Long projectRoleId);

    RemoteVersion[] getVersions(String token, String projectKey);

    RemoteComment[] getComments(String token, String issueKey);

    void deleteProject(String token, String projectKey);

    RemoteField[] getFieldsForEdit(String token, String issueKey);

    RemoteIssueType[] getSubTaskIssueTypesForProject(String token, String projectId);

    RemoteSecurityLevel getSecurityLevel(String token, String issueKey);

    RemoteProject getProjectWithSchemesById(String token, Long projectId);

    RemoteFilter[] getFavouriteFilters(String token);

    void archiveVersion(String token, String projectKey, String versionName, Boolean archive);

    RemoteSecurityLevel[] getSecurityLevels(String token, String projectKey);

    RemoteAvatar[] getProjectAvatars(String token, String projectKey, Boolean includeSystemAvatars);

    void setProjectAvatar(String token, String projectKey, Long avatarId);

    RemoteAvatar getProjectAvatar(String token, String projectKey);

    void deleteProjectAvatar(String token, Long avatarId);

    RemoteScheme[] getNotificationSchemes(String token);

    RemotePermissionScheme[] getPermissionSchemes(String token);

    RemoteAttachment[] getAttachmentsFromIssue(String token, String issueKey);

    RemoteField[] getFieldsForAction(String token, String issueKey, String actionIdString);

    void deleteWorklogWithNewRemainingEstimate(String token, String workLogId, String newRemainingEstimate);

    void deleteWorklogAndAutoAdjustRemainingEstimate(String token, String worklogId);

    void deleteWorklogAndRetainRemainingEstimate(String token, String worklogId);

    RemoteWorklog[] getWorklogs(String token, String issueKey);

    boolean hasPermissionToCreateWorklog(String token, String issueKey);

    boolean hasPermissionToDeleteWorklog(String token, String worklogId);

    boolean hasPermissionToUpdateWorklog(String token, String worklogId);

    Calendar getResolutionDateByKey(String token, String issueKey);

    Calendar getResolutionDateById(String token, Long issueId);

    long getIssueCountForFilter(String token, String filterId);

    RemoteIssue[] getIssuesFromTextSearchWithProject(String token, String[] projectKeys, String searchTerms, Integer maxNumResults);

    RemoteIssue[] getIssuesFromJqlSearch(String token, String jqlSearch, Integer maxNumResults);

    void deleteUser(String token, String username);

    void deleteGroup(String token, String groupName, String swapGroupName);

    void refreshCustomFields(String token);

    boolean addBase64EncodedAttachmentsToIssue(String token, String issueKey, String[] fileNames, String[] base64EncodedAttachmentData);

    RemoteIssue[] getIssuesFromFilterWithLimit(String token, String filterId, Integer offset, Integer maxNumResults);

    RemoteIssue[] getIssuesFromTextSearchWithLimit(String token, String searchTerms, Integer offset, Integer maxNumResults);

    RemoteProject[] getProjectsNoSchemes(String token);

    RemoteScheme[] getSecuritySchemes(String token);

    void setNewProjectAvatar(String token, String projectKey, String contentType, String base64ImageData);

    RemoteField[] getCustomFields(String token);

    void deletePermissionScheme(String token, String permissionSchemeName);

    RemoteIssue getIssueById(String token, String issueId);

    RemoteGroup updateGroup(String token, String groupName, String[] usernames);

    void removeAllRoleActorsByProject(String token, String projectKey);

    RemoteProjectRoleActors getProjectRoleActors(String token, Long projectRoleId, String projectKey);

    boolean logout(String token);

    RemotePermission[] getAllPermissions(String token);

    RemotePermissionScheme createPermissionScheme(String token, String name, String description);

    String login(String username, String password);

    boolean hasPermissionToEditComment(String token, Long commentId);

    RemoteComment editComment(String token, Long commentId, String body, String updateAuthor);

    RemoteProject createProject(String token, String key, String name, String description, String url, String lead, String permissionSchemeName, String notificationSchemeName, String securityShemeName);

    RemoteProject updateProject(String token, String key, String description, String url, String lead, String permissionSchemeName, String notificationSchemeName, String securityShemeName);

    void addActorsToProjectRole(String token, String[] actors, Long projectRoleId, String projectKey, String actorType);

    void removeActorsFromProjectRole(String token, String[] actors, Long projectRoleId, String projectKey, String actorType);

    void releaseVersion(String token, String projectKey, String versionName);

    void updateWorklogWithNewRemainingEstimate(String token, String issueKey, String worklogId, String comment, String groupLevel, String roleLevelId, String newRemainingEstimate);

    RemoteVersion addVersion(String token, String projectKey, String versionName, Boolean archived, Boolean released, String releaseDate);

    RemoteIssue updateIssue(String token, String issueKey, String[] fieldIds, String[] fieldValues);

    RemotePermissionScheme addPermissionTo(String token, String permissionSchemeName, Long permissionCode, String entityName);

    RemotePermissionScheme deletePermissionFrom(String token, String permissionSchemeName, Long permissionCode, String entityName);

    RemoteIssue progressWorkflowAction(String token, String issueKey, String actionIdString, String[] fieldIds, String[] fieldsValues);
}