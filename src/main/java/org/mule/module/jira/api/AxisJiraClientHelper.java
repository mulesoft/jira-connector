package org.mule.module.jira.api;

import com.atlassian.jira.rpc.soap.beans.*;
import org.mule.module.jira.JiraCloudConnectorException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AxisJiraClientHelper {

    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final SimpleDateFormat DATE_FOMAT = new SimpleDateFormat(DATE_FORMAT);
    private AxisJiraClient axisJiraClient;

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

    protected RemoteIssue createIssue(String token, String assignee, String description, String dueDate, String environment, String priority, String project, String reporter, String type, Long votes, String[] customFieldKeys, String[][] customerFieldValues) {
        RemoteIssue remoteIssue = new RemoteIssue();
        remoteIssue.setAssignee(assignee);
        remoteIssue.setDescription(description);
        remoteIssue.setDuedate(getCalendar(dueDate));
        remoteIssue.setEnvironment(environment);
        remoteIssue.setPriority(priority);
        remoteIssue.setProject(project);
        remoteIssue.setReporter(reporter);
        remoteIssue.setType(type);
        remoteIssue.setVotes(votes);
//        remoteIssue.setCustomFieldValues(getRemoteCustomFieldValues(token, customFieldKeys, customerFieldValues));
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

//    private RemoteCustomFieldValue[] getRemoteCustomFieldValues(String token, String[] customFieldKeys, String[][] customerFieldValues) {
//        List<RemoteCustomFieldValue> result = new ArrayList<RemoteCustomFieldValue>(customFieldKeys.length);
//        List<C
//
//        RemoteField[] remoteCustomFields = new ArrayList<RemoteFieldaxisJiraClient.getCustomFields(token);
//
//        for(RemoteField remoteCustomField : remoteCustomFields) {
//
//        }
//
//        new RemoteCustomFieldValue(customFieldId, key, values);
//
//        return result.toArray(new RemoteCustomFieldValue[result.size()]);
//    }

    private Calendar getCalendar(String dateString) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DATE_FOMAT.parse(dateString));
            return calendar;
        } catch (ParseException e) {
            throw new JiraCloudConnectorException("Could not parse date string: " + dateString + " expected format is: " + DATE_FORMAT, e);
        }
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
        throw new JiraCloudConnectorException("Permission scheme not found found with name: " + permissionSchemeName);
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
        throw new JiraCloudConnectorException("Notification scheme not found with name: " + notificationSchemeName);
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
        throw new JiraCloudConnectorException("Security scheme not found with name: " + securityShemeName);
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

    public void updateDescription(RemoteProject project, String description) {
        if (description != null) {
            project.setDescription(description);
        }
    }

    public void updateUrl(RemoteProject project, String url) {
        if (url != null) {
            project.setUrl(url);
        }
    }

    public void updateLead(RemoteProject project, String lead) {
        if (lead != null) {
            project.setLead(lead);
        }
    }

    public void updateProjectRoleName(RemoteProjectRole projectRole, String projectRoleName) {
        if (projectRoleName != null) {
            projectRole.setName(projectRoleName);
        }
    }

    public void updateProjectRoleDescription(RemoteProjectRole projectRole, String projectRoleDescription) {
        if (projectRoleDescription != null) {
            projectRole.setName(projectRoleDescription);
        }
    }

    public void updateCommentBody(RemoteComment comment, String body) {
        if (body != null) {
            comment.setBody(body);
        }
    }

    public void updateCommentAuthor(RemoteComment comment, String updateAuthor) {
        if (updateAuthor != null) {
            comment.setUpdateAuthor(updateAuthor);
        }
    }
}