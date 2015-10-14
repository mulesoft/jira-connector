
package org.mule.module.jira.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/jira</code>.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class JiraNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(JiraNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [jira] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [jira] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new JiraConnectorConfigConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-comment", new GetCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-configuration", new GetConfigurationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-configuration", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-group", new CreateGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-server-info", new GetServerInfoDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-server-info", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-group", new GetGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-user", new CreateUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-comment", new AddCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-components", new GetComponentsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-components", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-user", new GetUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-group", new UpdateGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-user-to-group", new AddUserToGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-user-to-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-user-from-group", new RemoveUserFromGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-user-from-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issue", new GetIssueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issue", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-issue", new CreateIssueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-issue", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-issue-using-object", new CreateIssueUsingObjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-issue-using-object", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-issue-with-parent", new CreateIssueWithParentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-issue-with-parent", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-issue-with-security-level", new CreateIssueWithSecurityLevelDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-issue-with-security-level", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-issue", new UpdateIssueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-issue", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-issues-by-jql", new UpdateIssuesByJqlDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-issues-by-jql", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-issue", new DeleteIssueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-issue", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-available-actions", new GetAvailableActionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-available-actions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-sub-task-issue-types", new GetSubTaskIssueTypesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-sub-task-issue-types", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-project", new CreateProjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-project", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-project-using-object", new CreateProjectUsingObjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-project-using-object", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-project", new UpdateProjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-project", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-by-key", new GetProjectByKeyDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-by-key", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-all-role-actors-by-project", new RemoveAllRoleActorsByProjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-all-role-actors-by-project", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-priorities", new GetPrioritiesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-priorities", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-resolutions", new GetResolutionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-resolutions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issue-types", new GetIssueTypesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issue-types", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-statuses", new GetStatusesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-statuses", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issue-types-for-project", new GetIssueTypesForProjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issue-types-for-project", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-roles", new GetProjectRolesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-roles", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-role", new GetProjectRoleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-role", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-role-actors", new GetProjectRoleActorsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-role-actors", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-default-role-actors", new GetDefaultRoleActorsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-default-role-actors", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-all-role-actors-by-name-and-type", new RemoveAllRoleActorsByNameAndTypeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-all-role-actors-by-name-and-type", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-project-role", new DeleteProjectRoleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-project-role", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-project-role", new UpdateProjectRoleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-project-role", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-project-role", new CreateProjectRoleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-project-role", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("is-project-role-name-unique", new IsProjectRoleNameUniqueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("is-project-role-name-unique", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("release-version", new ReleaseVersionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("release-version", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-actors-to-project-role", new AddActorsToProjectRoleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-actors-to-project-role", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-actors-from-project-role", new RemoveActorsFromProjectRoleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-actors-from-project-role", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-default-actors-to-project-role", new AddDefaultActorsToProjectRoleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-default-actors-to-project-role", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("remove-default-actors-from-project-role", new RemoveDefaultActorsFromProjectRoleDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("remove-default-actors-from-project-role", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-associated-notification-schemes", new GetAssociatedNotificationSchemesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-associated-notification-schemes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-associated-permission-schemes", new GetAssociatedPermissionSchemesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-associated-permission-schemes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-project", new DeleteProjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-project", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-by-id", new GetProjectByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-versions", new GetVersionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-versions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-comments", new GetCommentsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-comments", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-favourite-filters", new GetFavouriteFiltersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-favourite-filters", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("archive-version", new ArchiveVersionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("archive-version", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-fields-for-edit", new GetFieldsForEditDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-fields-for-edit", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-sub-task-issue-types-for-project", new GetSubTaskIssueTypesForProjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-sub-task-issue-types-for-project", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("login", new LoginDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("login", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-security-level", new GetSecurityLevelDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-security-level", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-custom-fields", new GetCustomFieldsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-custom-fields", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("logout", new LogoutDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("logout", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-with-schemes-by-id", new GetProjectWithSchemesByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-with-schemes-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-security-levels", new GetSecurityLevelsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-security-levels", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-avatars", new GetProjectAvatarsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-avatars", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-project-avatar", new SetProjectAvatarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-project-avatar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-project-avatar", new GetProjectAvatarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-project-avatar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-project-avatar", new DeleteProjectAvatarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-project-avatar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-notification-schemes", new GetNotificationSchemesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-notification-schemes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-permission-schemes", new GetPermissionSchemesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-permission-schemes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-permissions", new GetAllPermissionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-permissions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-permission-scheme", new CreatePermissionSchemeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-permission-scheme", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-permission-to", new AddPermissionToDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-permission-to", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-permission-from", new DeletePermissionFromDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-permission-from", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-permission-scheme", new DeletePermissionSchemeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-permission-scheme", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-attachments-from-issue", new GetAttachmentsFromIssueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-attachments-from-issue", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("has-permission-to-edit-comment", new HasPermissionToEditCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("has-permission-to-edit-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("edit-comment", new EditCommentDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("edit-comment", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-fields-for-action", new GetFieldsForActionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-fields-for-action", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issue-by-id", new GetIssueByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issue-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-worklog-with-new-remaining-estimate", new DeleteWorklogWithNewRemainingEstimateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-worklog-with-new-remaining-estimate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-worklog-and-auto-adjust-remaining-estimate", new DeleteWorklogAndAutoAdjustRemainingEstimateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-worklog-and-auto-adjust-remaining-estimate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-worklog-and-retain-remaining-estimate", new DeleteWorklogAndRetainRemainingEstimateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-worklog-and-retain-remaining-estimate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-worklogs", new GetWorklogsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-worklogs", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("has-permission-to-create-worklog", new HasPermissionToCreateWorklogDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("has-permission-to-create-worklog", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("has-permission-to-delete-worklog", new HasPermissionToDeleteWorklogDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("has-permission-to-delete-worklog", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("has-permission-to-update-worklog", new HasPermissionToUpdateWorklogDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("has-permission-to-update-worklog", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-worklog-with-new-remaining-estimate", new UpdateWorklogWithNewRemainingEstimateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-worklog-with-new-remaining-estimate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-version", new AddVersionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-version", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-resolution-date-by-key", new GetResolutionDateByKeyDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-resolution-date-by-key", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-resolution-date-by-id", new GetResolutionDateByIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-resolution-date-by-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issue-count-for-filter", new GetIssueCountForFilterDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issue-count-for-filter", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issues-from-text-search-with-project", new GetIssuesFromTextSearchWithProjectDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issues-from-text-search-with-project", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issues-from-jql-search", new GetIssuesFromJqlSearchDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issues-from-jql-search", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-user", new DeleteUserDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-user", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-group", new DeleteGroupDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-group", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("refresh-custom-fields", new RefreshCustomFieldsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("refresh-custom-fields", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-base64-encoded-attachments-to-issue", new AddBase64EncodedAttachmentsToIssueDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-base64-encoded-attachments-to-issue", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issues-from-filter-with-limit", new GetIssuesFromFilterWithLimitDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issues-from-filter-with-limit", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-issues-from-text-search-with-limit", new GetIssuesFromTextSearchWithLimitDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-issues-from-text-search-with-limit", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-projects-no-schemes", new GetProjectsNoSchemesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-projects-no-schemes", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("set-new-project-avatar", new SetNewProjectAvatarDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("set-new-project-avatar", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("progress-workflow-action", new ProgressWorkflowActionDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("progress-workflow-action", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-worklog-and-auto-adjust-remaining-estimate", new AddWorklogAndAutoAdjustRemainingEstimateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-worklog-and-auto-adjust-remaining-estimate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-worklog-with-new-remaining-estimate", new AddWorklogWithNewRemainingEstimateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-worklog-with-new-remaining-estimate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-worklog-and-retain-remaining-estimate", new AddWorklogAndRetainRemainingEstimateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-worklog-and-retain-remaining-estimate", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-security-schemes", new GetSecuritySchemesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-security-schemes", "@Processor", ex);
        }
    }

}
