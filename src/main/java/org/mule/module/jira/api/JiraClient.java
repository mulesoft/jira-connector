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

import com.atlassian.jira.rpc.soap.beans.RemoteAvatar;
import com.atlassian.jira.rpc.soap.beans.RemoteComment;
import com.atlassian.jira.rpc.soap.beans.RemoteConfiguration;
import com.atlassian.jira.rpc.soap.beans.RemoteGroup;
import com.atlassian.jira.rpc.soap.beans.RemoteIssue;
import com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme;
import com.atlassian.jira.rpc.soap.beans.RemoteProject;
import com.atlassian.jira.rpc.soap.beans.RemoteProjectRole;
import com.atlassian.jira.rpc.soap.beans.RemoteProjectRoleActors;
import com.atlassian.jira.rpc.soap.beans.RemoteRoleActors;
import com.atlassian.jira.rpc.soap.beans.RemoteSecurityLevel;
import com.atlassian.jira.rpc.soap.beans.RemoteServerInfo;
import com.atlassian.jira.rpc.soap.beans.RemoteUser;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import com.atlassian.jira.rpc.soap.beans.RemoteWorklog;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public interface JiraClient<CollectionType>
{

    RemoteComment getComment(String token, Long id);

    RemoteConfiguration getConfiguration(String token);

    RemoteGroup createGroup(String token, String groupName, String userName);

    RemoteServerInfo getServerInfo(String token);

    RemoteGroup getGroup(String token, String groupName);

    RemoteUser createUser(String token, String username, String password, String fullName, String email);

    void addComment(String token,
                    String issueKey,
                    String commentAuthor,
                    String commentBody,
                    String commentGroupLevel,
                    String commentRoleLevel);

    CollectionType getComponents(String token, String projectKey);

    RemoteUser getUser(String token, String username);

    void addUserToGroup(String token, String groupName, String userName);

    void removeUserFromGroup(String token, String groupName, String userName);

    RemoteIssue getIssue(String token, String issueKey);

    RemoteIssue createIssue(String token,
                            String assignee,
                            String summary,
                            String description,
                            String dueDate,
                            String environment,
                            String priority,
                            String project,
                            String reporter,
                            String type,
                            Long votes,
                            Map<String, List<String>> customFields,
                            String componentName,
                            String componentId);

    RemoteIssue createIssue(String token, RemoteIssue issue);

    RemoteIssue createIssueWithSecurityLevel(String token,
                                             String asignee,
                                             String summary,
                                             String description,
                                             String dueDate,
                                             String environment,
                                             String priority,
                                             String project,
                                             String reporter,
                                             String type,
                                             Long votes,
                                             Map<String, List<String>> customFields,
                                             Long securityLevelId,
                                             String componentName,
                                             String componentId);

    void deleteIssue(String token, String issueKey);

    CollectionType getAvailableActions(String token, String issueKey);

    CollectionType getSubTaskIssueTypes(String token);

    RemoteProject getProjectByKey(String token, String projectKey);

    CollectionType getPriorities(String token);

    CollectionType getResolutions(String token);

    CollectionType getIssueTypes(String token);

    CollectionType getStatuses(String token);

    CollectionType getIssueTypesForProject(String token, String projectId);

    CollectionType getProjectRoles(String token);

    RemoteProjectRole getProjectRole(String token, Long id);

    RemoteRoleActors getDefaultRoleActors(String token, Long projectRoleId);

    void removeAllRoleActorsByNameAndType(String token, String name, String type);

    void deleteProjectRole(String token, Long projectRoleId, Boolean confirm);

    void addDefaultActorsToProjectRole(String token, List<String> actors, Long projectRoleId, String type);

    RemoteProject getProjectById(String token, Long projectId);

    RemoteProjectRole createProjectRole(String token, String projectRoleName, String projectRoleDescription);

    boolean isProjectRoleNameUnique(String token, String name);

    void updateProjectRole(String token,
                           Long projectRoleId,
                           String projectRoleName,
                           String projectRoleDescription);

    void removeDefaultActorsFromProjectRole(String token, List<String> actors, Long projectRoleId, String type);

    CollectionType getAssociatedNotificationSchemes(String token, Long projectRoleId);

    CollectionType getAssociatedPermissionSchemes(String token, Long projectRoleId);

    CollectionType getVersions(String token, String projectKey);

    CollectionType getComments(String token, String issueKey);

    void deleteProject(String token, String projectKey);

    CollectionType getFieldsForEdit(String token, String issueKey);

    CollectionType getSubTaskIssueTypesForProject(String token, String projectId);

    RemoteSecurityLevel getSecurityLevel(String token, String issueKey);

    RemoteProject getProjectWithSchemesById(String token, Long projectId);

    CollectionType getFavouriteFilters(String token);

    void archiveVersion(String token, String projectKey, String versionName, Boolean archive);

    CollectionType getSecurityLevels(String token, String projectKey);

    CollectionType getProjectAvatars(String token, String projectKey, Boolean includeSystemAvatars);

    void setProjectAvatar(String token, String projectKey, Long avatarId);

    RemoteAvatar getProjectAvatar(String token, String projectKey);

    void deleteProjectAvatar(String token, Long avatarId);

    CollectionType getNotificationSchemes(String token);

    CollectionType getPermissionSchemes(String token);

    CollectionType getAttachmentsFromIssue(String token, String issueKey);

    CollectionType getFieldsForAction(String token, String issueKey, String actionIdString);

    void deleteWorklogWithNewRemainingEstimate(String token, String workLogId, String newRemainingEstimate);

    void deleteWorklogAndAutoAdjustRemainingEstimate(String token, String worklogId);

    void deleteWorklogAndRetainRemainingEstimate(String token, String worklogId);

    CollectionType getWorklogs(String token, String issueKey);

    boolean hasPermissionToCreateWorklog(String token, String issueKey);

    boolean hasPermissionToDeleteWorklog(String token, String worklogId);

    boolean hasPermissionToUpdateWorklog(String token, String worklogId);

    Calendar getResolutionDateByKey(String token, String issueKey);

    Calendar getResolutionDateById(String token, Long issueId);

    long getIssueCountForFilter(String token, String filterId);

    CollectionType getIssuesFromTextSearchWithProject(String token,
                                                      List<String> projectKeys,
                                                      String searchTerms,
                                                      Integer maxNumResults);

    CollectionType getIssuesFromJqlSearch(String token, String jqlSearch, Integer maxNumResults);

    void deleteUser(String token, String username);

    void deleteGroup(String token, String groupName, String swapGroupName);

    void refreshCustomFields(String token);

    boolean addBase64EncodedAttachmentsToIssue(String token,
                                               String issueKey,
                                               List<String> fileNames,
                                               List<String> base64EncodedAttachmentData);

    CollectionType getIssuesFromFilterWithLimit(String token,
                                                String filterId,
                                                Integer offset,
                                                Integer maxNumResults);

    CollectionType getIssuesFromTextSearchWithLimit(String token,
                                                    String searchTerms,
                                                    Integer offset,
                                                    Integer maxNumResults);

    CollectionType getProjectsNoSchemes(String token);

    CollectionType getSecuritySchemes(String token);

    void setNewProjectAvatar(String token, String projectKey, String contentType, String base64ImageData);

    CollectionType getCustomFields(String token);

    void deletePermissionScheme(String token, String permissionSchemeName);

    RemoteIssue getIssueById(String token, String issueId);

    RemoteGroup updateGroup(String token, String groupName, List<String> usernames);

    void removeAllRoleActorsByProject(String token, String projectKey);

    RemoteProjectRoleActors getProjectRoleActors(String token, Long projectRoleId, String projectKey);

    boolean logout(String token);

    CollectionType getAllPermissions(String token);

    RemotePermissionScheme createPermissionScheme(String token, String name, String description);

    String login(String username, String password);

    boolean hasPermissionToEditComment(String token, Long commentId);

    RemoteComment editComment(String token, Long commentId, String body, String updateAuthor);

    RemoteProject createProject(String token,
                                String key,
                                String name,
                                String description,
                                String url,
                                String lead,
                                String permissionSchemeName,
                                String notificationSchemeName,
                                String securityShemeName);

    RemoteProject updateProject(String token,
                                String key,
                                String description,
                                String url,
                                String lead,
                                String permissionSchemeName,
                                String notificationSchemeName,
                                String securityShemeName);

    void addActorsToProjectRole(String token,
                                List<String> actors,
                                Long projectRoleId,
                                String projectKey,
                                String actorType);

    void removeActorsFromProjectRole(String token,
                                     List<String> actors,
                                     Long projectRoleId,
                                     String projectKey,
                                     String actorType);

    void releaseVersion(String token, String projectKey, String versionName);

    void updateWorklogWithNewRemainingEstimate(String token,
                                               String issueKey,
                                               String worklogId,
                                               String comment,
                                               String groupLevel,
                                               String roleLevelId,
                                               String newRemainingEstimate);

    RemoteVersion addVersion(String token,
                             String projectKey,
                             String versionName,
                             Boolean archived,
                             Boolean released,
                             String releaseDate);

    RemoteIssue updateIssue(String token, String issueKey, Map<String, List<String>> fields);

    RemotePermissionScheme addPermissionTo(String token,
                                           String permissionSchemeName,
                                           Long permissionCode,
                                           String entityName);

    RemotePermissionScheme deletePermissionFrom(String token,
                                                String permissionSchemeName,
                                                Long permissionCode,
                                                String entityName);

    RemoteIssue progressWorkflowAction(String token,
                                       String issueKey,
                                       String actionIdString,
                                       Map<String, List<String>> fields);

    RemoteWorklog addWorklogAndAutoAdjustRemainingEstimate(String token,
                                                           String issueKey,
                                                           String timeSpent,
                                                           String startDate,
                                                           String comment,
                                                           String groupLevel,
                                                           String roleLevelId);

    RemoteWorklog addWorklogWithNewRemainingEstimate(String token,
                                                     String issueKey,
                                                     String timeSpent,
                                                     String startDate,
                                                     String newRemainingEstimate,
                                                     String comment,
                                                     String groupLevel,
                                                     String roleLevelId);

    RemoteWorklog addWorklogAndRetainRemainingEstimate(String token,
                                                       String issueKey,
                                                       String timeSpent,
                                                       String startDate,
                                                       String comment,
                                                       String groupLevel,
                                                       String roleLevelId);
}
