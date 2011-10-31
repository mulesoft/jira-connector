/**
 * Mule Jira Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * This file was automatically generated by the Mule Cloud Connector Development Kit
 */

package org.mule.module.jira.config;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mule.api.processor.MessageProcessor;
import org.mule.module.jira.JiraClientFactory;
import org.mule.module.jira.api.JiraClient;
import org.mule.tck.FunctionalTestCase;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class JiraNamespaceHandlerTestCase extends FunctionalTestCase {

    private static final String TOKEN = "aToken";
    private static final String GROUP_NAME = "someGroupName";
    private static final String USER_NAME = "someUserName";
    private static final String PASSWORD = "somePassword";
    private static final String FULL_NAME = "some full name";
    private static final String EMAIL = "some email";
    private static final String ISSUE_KEY = "someIssueKey";
    private static final String PROJECT_KEY = "someProjectKey";
    private static final String SOME_URL = "someUrl";
    private static final String PERMISSION_SCHEME_NAME = "somePermissionSchemeName";
    private static final String NOTIFICATION_SCHEME_NAME = "someNotificationSchemeName";
    private static final String SECURITY_SCHEME_NAME = "someSecuritySchemeName";
    private static final String PROJECT_ROLE_NAME = "someProjectRoleName";
    private static final String WORKLOG_ID = "someWorklogId";
    private static final String ESTIMATE = "1h";
    private static final int OFFSET = 12;
    private static final int MAX_NUM_RESULTS = 10;
    private static final List<String> ACTORS = Arrays.asList( "actor1", "actor2" );
    private static final String COMMENT = "someComment";
    @Mock
    private JiraClient mockJiraClient;
    private Map<String,List<String>> fields;

    @Override
    protected void doSetUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(mockJiraClient.login("fede", "fede")).thenReturn(TOKEN);
        JiraClientFactory.setDefaultClient(mockJiraClient);

        fields = new LinkedHashMap<String, List<String>>(2);
        fields.put("customfield_10000", Arrays.asList("value1"));
        fields.put("customfield_20000", Arrays.asList("value21", "value22"));
    }

    @Override
    protected String getConfigResources() {
        return "jira-namespace-config.xml";
    }

    public void testGetComment() throws Exception {
        lookupFlowConstruct("getComment").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getComment(TOKEN, 123L);
    }

    public void testGetConfiguration() throws Exception {
        lookupFlowConstruct("getConfiguration").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getConfiguration(TOKEN);
    }

    public void testCreateGroup() throws Exception {
        lookupFlowConstruct("createGroup").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).createGroup(TOKEN, GROUP_NAME, USER_NAME);
    }

    public void testGetServerInfo() throws Exception {
        lookupFlowConstruct("getServerInfo").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getServerInfo(TOKEN);
    }

    public void testGetGroup() throws Exception {
        lookupFlowConstruct("getGroup").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getGroup(TOKEN, GROUP_NAME);
    }

    public void testCreateUser() throws Exception {
        lookupFlowConstruct("createUser").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).createUser(TOKEN, USER_NAME, PASSWORD, FULL_NAME, EMAIL);
    }

    public void testAddComment() throws Exception {
        lookupFlowConstruct("addComment").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).addComment(TOKEN, ISSUE_KEY, USER_NAME, COMMENT, null, null);
    }

    public void testGetComponents() throws Exception {
        lookupFlowConstruct("getComponents").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getComponents(TOKEN, PROJECT_KEY);
    }

    public void testGetUser() throws Exception {
        lookupFlowConstruct("getUser").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getUser(TOKEN, USER_NAME);
    }

    public void testUpdateGroup() throws Exception {
        lookupFlowConstruct("updateGroup").process(getTestEvent(""));
        List<String> usernames = Arrays.asList(USER_NAME);
        Mockito.verify(mockJiraClient).updateGroup(TOKEN, GROUP_NAME, usernames);
    }

    public void testAddUserToGroup() throws Exception {
        lookupFlowConstruct("addUserToGroup").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).addUserToGroup(TOKEN, GROUP_NAME, USER_NAME);
    }

    public void testRemoveUserFromGroup() throws Exception {
        lookupFlowConstruct("removeUserFromGroup").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).removeUserFromGroup(TOKEN, GROUP_NAME, USER_NAME);
    }

    public void testGetIssue() throws Exception {
        lookupFlowConstruct("getIssue").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssue(TOKEN, ISSUE_KEY);
    }

    public void testCreateIssue() throws Exception {
        lookupFlowConstruct("createIssue").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).createIssue(TOKEN, USER_NAME, "someSummary", "someDescription", "someDueDate",
                "someEnvironment", "somePriority", "someProject", USER_NAME, "someType", 10L, fields);
    }

    public void testCreateIssueWithSecurityLevel() throws Exception {
        lookupFlowConstruct("createIssueWithSecurityLevel").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).createIssueWithSecurityLevel(TOKEN, USER_NAME, "someSummary", "someDescription",
                "someDueDate", "someEnvironment", "somePriority", "someProject", USER_NAME, "someType", 10L,
                fields, 1L);
    }

    public void testUpdateIssue() throws Exception {
        lookupFlowConstruct("updateIssue").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).updateIssue(TOKEN, ISSUE_KEY, fields);
    }


    public void testDeleteIssue() throws Exception {
        lookupFlowConstruct("deleteIssue").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteIssue(TOKEN, ISSUE_KEY);
    }

    public void testGetAvailableActions() throws Exception {
        lookupFlowConstruct("getAvailableActions").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getAvailableActions(TOKEN, ISSUE_KEY);
    }

    public void testGetSubTaskIssueTypes() throws Exception {
        lookupFlowConstruct("getSubTaskIssueTypes").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getSubTaskIssueTypes(TOKEN);
    }

    public void testCreateProject() throws Exception {
        lookupFlowConstruct("createProject").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).createProject(TOKEN, PROJECT_KEY, "someProjectName", "someProjectDescription",
                SOME_URL, USER_NAME, PERMISSION_SCHEME_NAME, NOTIFICATION_SCHEME_NAME, SECURITY_SCHEME_NAME);
    }

    public void testUpdateProject() throws Exception {
        lookupFlowConstruct("updateProject").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).updateProject(TOKEN, PROJECT_KEY, "someProjectDescription", SOME_URL, USER_NAME,
                PERMISSION_SCHEME_NAME, NOTIFICATION_SCHEME_NAME, SECURITY_SCHEME_NAME);
    }

    public void testGetProjectByKey() throws Exception {
        lookupFlowConstruct("getProjectByKey").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectByKey(TOKEN, PROJECT_KEY);
    }

    public void testRemoveAllRoleActorsByProject() throws Exception {
        lookupFlowConstruct("removeAllRoleActorsByProject").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).removeAllRoleActorsByProject(TOKEN, PROJECT_KEY);
    }

    public void testGetPriorities() throws Exception {
        lookupFlowConstruct("getPriorities").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getPriorities(TOKEN);
    }

    public void testGetResolutions() throws Exception {
        lookupFlowConstruct("getResolutions").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getResolutions(TOKEN);
    }

    public void testGetIssueTypes() throws Exception {
        lookupFlowConstruct("getIssueTypes").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssueTypes(TOKEN);
    }

    public void testGetStatuses() throws Exception {
        lookupFlowConstruct("getStatuses").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getStatuses(TOKEN);
    }

    public void testGetIssueTypesForProject() throws Exception {
        lookupFlowConstruct("getIssueTypesForProject").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssueTypesForProject(TOKEN, "someProjectId");
    }

    public void testGetProjectRoles() throws Exception {
        lookupFlowConstruct("getProjectRoles").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectRoles(TOKEN);
    }

    public void testGetProjectRole() throws Exception {
        lookupFlowConstruct("getProjectRole").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectRole(TOKEN, 123L);
    }

    public void testGetProjectRoleActors() throws Exception {
        lookupFlowConstruct("getProjectRoleActors").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectRoleActors(TOKEN, 123L, PROJECT_KEY);
    }

    public void testGetDefaultRoleActors() throws Exception {
        lookupFlowConstruct("getDefaultRoleActors").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getDefaultRoleActors(TOKEN, 123L);
    }

    public void testRemoveAllRoleActorsByNameAndType() throws Exception {
        lookupFlowConstruct("removeAllRoleActorsByNameAndType").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).removeAllRoleActorsByNameAndType(TOKEN, "someName", "someType");
    }

    public void testDeleteProjectRole() throws Exception {
        lookupFlowConstruct("deleteProjectRole").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteProjectRole(TOKEN, 123L, false);
    }

    public void testUpdateProjectRole() throws Exception {
        lookupFlowConstruct("updateProjectRole").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).updateProjectRole(TOKEN, 123L, PROJECT_ROLE_NAME, "someProjectRoleDescription");
    }

    public void testCreateProjectRole() throws Exception {
        lookupFlowConstruct("createProjectRole").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).createProjectRole(TOKEN, PROJECT_ROLE_NAME, "someProjectRoleDescription");
    }

    public void testIsProjectRoleNameUnique() throws Exception {
        lookupFlowConstruct("isProjectRoleNameUnique").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).isProjectRoleNameUnique(TOKEN, PROJECT_ROLE_NAME);
    }

    public void testAddDefaultActorsToProjectRole() throws Exception {
        lookupFlowConstruct("addDefaultActorsToProjectRole").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).addDefaultActorsToProjectRole(TOKEN, ACTORS, 123L, "someType");
    }

    public void testRemoveDefaultActorsFromProjectRole() throws Exception {
        lookupFlowConstruct("removeDefaultActorsFromProjectRole").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).removeDefaultActorsFromProjectRole(TOKEN, ACTORS, 123L, "someType");
    }

    public void testGetAssociatedNotificationSchemes() throws Exception {
        lookupFlowConstruct("getAssociatedNotificationSchemes").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getAssociatedNotificationSchemes(TOKEN, 123L);
    }

    public void testGetAssociatedPermissionSchemes() throws Exception {
        lookupFlowConstruct("getAssociatedPermissionSchemes").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getAssociatedPermissionSchemes(TOKEN, 123L);
    }

    public void testDeleteProject() throws Exception {
        lookupFlowConstruct("deleteProject").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteProject(TOKEN, PROJECT_KEY);
    }

    public void testGetProjectById() throws Exception {
        lookupFlowConstruct("getProjectById").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectById(TOKEN, 123L);
    }

    public void testGetVersions() throws Exception {
        lookupFlowConstruct("getVersions").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getVersions(TOKEN, PROJECT_KEY);
    }

    public void testGetComments() throws Exception {
        lookupFlowConstruct("getComments").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getComments(TOKEN, ISSUE_KEY);
    }

    public void testGetFavouriteFilters() throws Exception {
        lookupFlowConstruct("getFavouriteFilters").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getFavouriteFilters(TOKEN);
    }

    public void testArchiveVersion() throws Exception {
        lookupFlowConstruct("archiveVersion").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).archiveVersion(TOKEN, PROJECT_KEY, "someVersionName", true);
    }

    public void testGetFieldsForEdit() throws Exception {
        lookupFlowConstruct("getFieldsForEdit").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getFieldsForEdit(TOKEN, ISSUE_KEY);
    }

    public void testGetSubTaskIssueTypesForProject() throws Exception {
        lookupFlowConstruct("getSubTaskIssueTypesForProject").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getSubTaskIssueTypesForProject(TOKEN, "someProjectId");
    }

    public void testLogin() throws Exception {
        lookupFlowConstruct("login").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).login(USER_NAME, "somePassword");
    }

    public void testGetSecurityLevel() throws Exception {
        lookupFlowConstruct("getSecurityLevel").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getSecurityLevel(TOKEN, ISSUE_KEY);
    }

    public void testGetCustomFields() throws Exception {
        lookupFlowConstruct("getCustomFields").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getCustomFields(TOKEN);
    }

    public void testLogout() throws Exception {
        lookupFlowConstruct("logout").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).logout(TOKEN);
    }

    public void testGetProjectWithSchemesById() throws Exception {
        lookupFlowConstruct("getProjectWithSchemesById").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectWithSchemesById(TOKEN, 123L);
    }

    public void testAddActorsToProjectRole() throws Exception {
        lookupFlowConstruct("addActorsToProjectRole").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).addActorsToProjectRole(TOKEN, ACTORS, 123L, PROJECT_KEY, "someActorType");
    }

    public void testRemoveActorsFromProjectRole() throws Exception {
        lookupFlowConstruct("removeActorsFromProjectRole").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).removeActorsFromProjectRole(TOKEN, ACTORS, 123L, PROJECT_KEY, "someActorType");
    }

    public void testReleaseVersion() throws Exception {
        lookupFlowConstruct("releaseVersion").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).releaseVersion(TOKEN, PROJECT_KEY, "someVersionName");
    }

    public void testUpdateWorklogWithNewRemainingEstimate() throws Exception {
        lookupFlowConstruct("updateWorklogWithNewRemainingEstimate").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).updateWorklogWithNewRemainingEstimate(TOKEN, ISSUE_KEY, WORKLOG_ID, COMMENT, "someGroupLevel", "someRoleLevelId", "1d");
    }

    public void testAddVersion() throws Exception {
        lookupFlowConstruct("addVersion").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).addVersion(TOKEN, PROJECT_KEY, "someVersionName", true, false, "someDate");
    }

    public void testGetSecurityLevels() throws Exception {
        lookupFlowConstruct("getSecurityLevels").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getSecurityLevels(TOKEN, PROJECT_KEY);
    }

    public void testGetProjectAvatars() throws Exception {
        lookupFlowConstruct("getProjectAvatars").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectAvatars(TOKEN, PROJECT_KEY, true);
    }

    public void testSetProjectAvatar() throws Exception {
        lookupFlowConstruct("setProjectAvatar").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).setProjectAvatar(TOKEN, PROJECT_KEY, 123L);
    }

    public void testGetProjectAvatar() throws Exception {
        lookupFlowConstruct("getProjectAvatar").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectAvatar(TOKEN, PROJECT_KEY);
    }

    public void testDeleteProjectAvatar() throws Exception {
        lookupFlowConstruct("deleteProjectAvatar").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteProjectAvatar(TOKEN, 123L);
    }

    public void testGetNotificationSchemes() throws Exception {
        lookupFlowConstruct("getNotificationSchemes").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getNotificationSchemes(TOKEN);
    }

    public void testGetPermissionSchemes() throws Exception {
        lookupFlowConstruct("getPermissionSchemes").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getPermissionSchemes(TOKEN);
    }

    public void testGetAttachmentsFromIssue() throws Exception {
        lookupFlowConstruct("getAttachmentsFromIssue").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getAttachmentsFromIssue(TOKEN, ISSUE_KEY);
    }

    public void testGetFieldsForAction() throws Exception {
        lookupFlowConstruct("getFieldsForAction").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getFieldsForAction(TOKEN, ISSUE_KEY, "someActionIdString");
    }

    public void testDeleteWorklogWithNewRemainingEstimate() throws Exception {
        lookupFlowConstruct("deleteWorklogWithNewRemainingEstimate").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteWorklogWithNewRemainingEstimate(TOKEN, WORKLOG_ID, ESTIMATE);
    }

    public void testDeleteWorklogAndAutoAdjustRemainingEstimate() throws Exception {
        lookupFlowConstruct("deleteWorklogAndAutoAdjustRemainingEstimate").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteWorklogAndAutoAdjustRemainingEstimate(TOKEN, WORKLOG_ID);
    }

    public void testDeleteWorklogAndRetainRemainingEstimate() throws Exception {
        lookupFlowConstruct("deleteWorklogAndRetainRemainingEstimate").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteWorklogAndRetainRemainingEstimate(TOKEN, WORKLOG_ID);
    }

    public void testGetWorklogs() throws Exception {
        lookupFlowConstruct("getWorklogs").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getWorklogs(TOKEN, ISSUE_KEY);
    }

    public void testHasPermissionToCreateWorklog() throws Exception {
        lookupFlowConstruct("hasPermissionToCreateWorklog").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).hasPermissionToCreateWorklog(TOKEN, ISSUE_KEY);
    }

    public void testHasPermissionToDeleteWorklog() throws Exception {
        lookupFlowConstruct("hasPermissionToDeleteWorklog").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).hasPermissionToDeleteWorklog(TOKEN, WORKLOG_ID);
    }

    public void testHasPermissionToUpdateWorklog() throws Exception {
        lookupFlowConstruct("hasPermissionToUpdateWorklog").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).hasPermissionToUpdateWorklog(TOKEN, WORKLOG_ID);
    }

    public void testGetResolutionDateByKey() throws Exception {
        lookupFlowConstruct("getResolutionDateByKey").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getResolutionDateByKey(TOKEN, ISSUE_KEY);
    }

    public void testGetResolutionDateById() throws Exception {
        lookupFlowConstruct("getResolutionDateById").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getResolutionDateById(TOKEN, 123L);
    }

    public void testGetIssueCountForFilter() throws Exception {
        lookupFlowConstruct("getIssueCountForFilter").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssueCountForFilter(TOKEN, "someFilterId");
    }

    public void testGetIssuesFromTextSearchWithProject() throws Exception {
        lookupFlowConstruct("getIssuesFromTextSearchWithProject").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssuesFromTextSearchWithProject(TOKEN, Arrays.asList("projectKey1", "projectKey2"), "someSearchTerms", MAX_NUM_RESULTS);
    }

    public void testGetIssuesFromJqlSearch() throws Exception {
        lookupFlowConstruct("getIssuesFromJqlSearch").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssuesFromJqlSearch(TOKEN, "someJqlSearch", MAX_NUM_RESULTS);
    }

    public void testDeleteUser() throws Exception {
        lookupFlowConstruct("deleteUser").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteUser(TOKEN, USER_NAME);
    }

    public void testDeleteGroup() throws Exception {
        lookupFlowConstruct("deleteGroup").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deleteGroup(TOKEN, GROUP_NAME, "someSwapGroupName");
    }

    public void testRefreshCustomFields() throws Exception {
        lookupFlowConstruct("refreshCustomFields").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).refreshCustomFields(TOKEN);
    }

    public void testAddBase64EncodedAttachmentsToIssue() throws Exception {
        lookupFlowConstruct("addBase64EncodedAttachmentsToIssue").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).addBase64EncodedAttachmentsToIssue(TOKEN, ISSUE_KEY, Arrays.asList("fileName1", "fileName2"),
                Arrays.asList("base64EncodedAttachment1", "base64EncodedAttachment2"));
    }

    public void testGetIssuesFromFilterWithLimit() throws Exception {
        lookupFlowConstruct("getIssuesFromFilterWithLimit").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssuesFromFilterWithLimit(TOKEN, "someFilterId", OFFSET, MAX_NUM_RESULTS);
    }

    public void testGetIssuesFromTextSearchWithLimit() throws Exception {
        lookupFlowConstruct("getIssuesFromTextSearchWithLimit").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssuesFromTextSearchWithLimit(TOKEN, "someSearchTerms", OFFSET, MAX_NUM_RESULTS);
    }

    public void testGetProjectsNoSchemes() throws Exception {
        lookupFlowConstruct("getProjectsNoSchemes").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getProjectsNoSchemes(TOKEN);
    }

    public void testGetSecuritySchemes() throws Exception {
        lookupFlowConstruct("getSecuritySchemes").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getSecuritySchemes(TOKEN);
    }

    public void testSetNewProjectAvatar() throws Exception {
        lookupFlowConstruct("setNewProjectAvatar").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).setNewProjectAvatar(TOKEN, PROJECT_KEY, "someContentType", "someBase64ImageData");
    }

    public void testDeletePermissionScheme() throws Exception {
        lookupFlowConstruct("deletePermissionScheme").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deletePermissionScheme(TOKEN, PERMISSION_SCHEME_NAME);
    }

    public void testGetIssueById() throws Exception {
        lookupFlowConstruct("getIssueById").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getIssueById(TOKEN, "someIssueId");
    }

    public void testGetAllPermissions() throws Exception {
        lookupFlowConstruct("getAllPermissions").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).getAllPermissions(TOKEN);
    }

    public void testCreatePermissionScheme() throws Exception {
        lookupFlowConstruct("createPermissionScheme").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).createPermissionScheme(TOKEN, PERMISSION_SCHEME_NAME, "somePermissionSchemeDesc");
    }

    public void testHasPermissionToEditComment() throws Exception {
        lookupFlowConstruct("hasPermissionToEditComment").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).hasPermissionToEditComment(TOKEN, 123L);
    }

    public void testAddPermissionTo() throws Exception {
        lookupFlowConstruct("addPermissionTo").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).addPermissionTo(TOKEN, PERMISSION_SCHEME_NAME, 123L, "someEntityName");
    }

    public void testDeletePermissionFrom() throws Exception {
        lookupFlowConstruct("deletePermissionFrom").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).deletePermissionFrom(TOKEN, PERMISSION_SCHEME_NAME, 123L, "someEntityName");
    }

    public void testProgressWorkflowAction() throws Exception {
        lookupFlowConstruct("progressWorkflowAction").process(getTestEvent(""));
        Mockito.verify(mockJiraClient).progressWorkflowAction(TOKEN, ISSUE_KEY, "someActionIdString", fields);
    }

    private MessageProcessor lookupFlowConstruct(String name) {
        return (MessageProcessor) muleContext.getRegistry().lookupFlowConstruct(name);
    }
}