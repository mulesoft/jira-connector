Mule jira Cloud Connector
=========================

Mule Cloud connector to jira

Installation
------------

The connector can either be installed for all applications running within the Mule instance or can be setup to be used
for a single application.

*All Applications*

Download the connector from the link above and place the resulting jar file in
/lib/user directory of the Mule installation folder.

*Single Application*

To make the connector available only to single application then place it in the
lib directory of the application otherwise if using Maven to compile and deploy
your application the following can be done:

Add the connector's maven repo to your pom.xml:

    <repositories>
        <repository>
            <id>muleforge-releases</id>
            <name>MuleForge Snapshot Repository</name>
            <url>https://repository.muleforge.org/release/</url>
            <layout>default</layout>
        </repsitory>
    </repositories>

Add the connector as a dependency to your project. This can be done by adding
the following under the dependencies element in the pom.xml file of the
application:

    <dependency>
        <groupId>org.mule.modules</groupId>
        <artifactId>mule-module-jira</artifactId>
        <version>1.1</version>
    </dependency>

Configuration
-------------

You can configure the connector as follows:

    <jira:config username="value" password="value" address="value"/>

Here is detailed list of all the configuration attributes:

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|name|Give a name to this configuration so it can be later referenced by config-ref.|yes||
|username|The user login username|no|
|password|The user login password|no|
|address|The JIRA Server Soap address. It usually looks like
https://&lt;jira server hostname&gt;/rpc/soap/jirasoapservice-v2
or http://&lt;jira server hostname&gt;/rpc/soap/jirasoapservice-v2|no|


Get Comment
-----------

Finds a comment.
<p/>


     <jira:get-comment commentId="123"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|commentId|the commentId of the comment|no||

Returns RemoteComment



Get Configuration
-----------------

Returns information about the current configuration of JIRA.
<p/>


     <jira:get-configuration/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns RemoteConfiguration object which contains information about the current configuration of JIRA.



Create Group
------------

Creates a group with the given name optionally adding the given user to it.
<p/>


     <jira:create-group groupName="someGroupName" userName="someUserName"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|groupName|the name of the group to create.|no||
|userName|the user to add to the group (if null, no user will be added).|yes||

Returns RemoteGroup created



Get Server Info
---------------

Returns information about the server JIRA is running on including build number and base URL.



     <jira:get-server-info/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns about the server JIRA is running on including build number and base URL.



Get Group
---------

Find the group with the specified name in JIRA.

 

     <jira:get-group groupName="someGroupName"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|groupName|the name of the group to find|no||

Returns RemoteGroup object for the found group or null if it cant be found.



Create User
-----------

Creates a user in JIRA with the specified user details



     <jira:create-user username="someUserName" password="somePassword" fullName="some full name" email="some email"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|username|the user name to create|no||
|password|the password for the new user|no||
|fullName|the full name of the new user|no||
|email|the email of the new user|no||

Returns newly created RemoteUser



Add Comment
-----------

Adds a new comment to the issue.



     <jira:add-comment issueKey="someIssueKey" commentAuthor="someUserName" commentBody="someComment"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the key of the issue|no||
|commentAuthor|the author of the comment|no||
|commentBody|the body of the comment|no||
|commentGroupLevel|the group level of the comment|yes||
|commentRoleLevel|the role level of the comment|yes||



Get Components
--------------

Returns an array of all the components for the specified project key.



      <jira:get-components projectKey="someProjectKey"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key of the requested project|no||

Returns array of RemoteComponent objects



Get User
--------

Returns information about a user defined to JIRA.



      <jira:get-user username="someUserName"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|username|the user name to look up|no||

Returns RemoteUser or null if it cant be found



Update Group
------------

Updates the given group name with the provided users.



     <jira:update-group groupName="someGroupName">
    <jira:usernames>
    <jira:username>someUserName</jira:username>
    </jira:usernames>
    </jira:update-group>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|groupName|the group name to update|no||
|usernames|the updated usernames|no||

Returns updated group



Add User To Group
-----------------

Adds a user to the given group name.



     <jira:add-user-to-group groupName="someGroupName" userName="someUserName"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|groupName|the group name|no||
|userName|the user name|no||



Remove User From Group
----------------------

Removes a user from the group name.



     <jira:remove-user-from-group groupName="someGroupName" userName="someUserName"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|groupName|the group name for which to remove the user|no||
|userName|the username to remove|no||



Get Issue
---------

Finds an issue by key.



      <jira:get-issue issueKey="someIssueKey"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the key of the issue to find.|no||

Returns issue matching the given key.



Create Issue
------------

Creates an issue.



      <jira:create-issue summary="someSummary" project="someProject" type="someType" assignee="someUserName" reporter="someUserName"
    dueDate="someDueDate" description="someDescription" environment="someEnvironment" priority="somePriority" votes="voteCount" >
    <jira:customFieldKeys>
    <jira:customFieldKey>key1</jira:customFieldKey>
    <jira:customFieldKey>key2</jira:customFieldKey>
    </jira:customFieldKeys>
    <jira:customFieldValues>
    <jira:customFieldValue>value1</jira:customFieldValue>
    <jira:customFieldValue>value2</jira:customFieldValue>
    </jira:customFieldValues>
    </jira:create-issue>   

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|assignee|the assignee of the new issue|yes||
|summary|the summary of the new issue|no||
|description|the description of the new issue|yes||
|dueDate|the due date of the new issue using the format MM-dd-yyy'T'HH:mm:ss|yes||
|environment|the environment of the new issue|yes||
|priority|the priority of the new issue|yes||
|project|the project of the new issue|no||
|reporter|the reporter of the new issue|yes||
|type|the type of the new issue|no||
|votes|the votes of the new issue|yes||
|customFieldKeys|the custom field keys of the new issue (must contain same number of elements as custom field values array)|yes||
|customFieldValues|the custome field values  (must contain same number of elements as custom field keys array)|yes||

Returns new created issue



Create Issue With Security Level
--------------------------------

Creates an issue using the the security level denoted by the given id.



     <jira:create-issue-with-security-level summary="someSummary" project="someProject" type="someType"
    assignee="someUserName" reporter="someUserName"
    dueDate="someDueDate" description="someDescription"
    environment="someEnvironment" priority="somePriority" votes="voteCount"
    securityLevelId="someSecurityLevelId">
    <jira:customFieldKeys>
    <jira:customFieldKey>key1</jira:customFieldKey>
    <jira:customFieldKey>key2</jira:customFieldKey>
    </jira:customFieldKeys>
    <jira:customFieldValues>
    <jira:customFieldValue>value1</jira:customFieldValue>
    <jira:customFieldValue>value2</jira:customFieldValue>
    </jira:customFieldValues>
    </jira:create-issue-with-security-level> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|assignee|the assignee of the new issue|yes||
|summary|the summary of the new issue|no||
|description|the description of the new issue|yes||
|dueDate|the due date of the new issue using the format MM-dd-yyy'T'HH:mm:ss|yes||
|environment|the environment of the new issue|yes||
|priority|the priority of the new issue|yes||
|project|the project of the new issue|no||
|reporter|the reporter of the new issue|yes||
|type|the type of the new issue|no||
|votes|the votes of the new issue|yes||
|customFieldKeys|the custom field keys of the new issue (must contain same number of elements as custom field values array)|yes||
|customFieldValues|the custome field values  (must contain same number of elements as custom field keys array)|yes||
|securityLevelId|the id of the security level to use|no||

Returns new created issue



Update Issue
------------

This will update an issue with new values.
NOTE : You cannot update the 'status' field of the issue via this method.



     <jira:update-issue issueKey="someIssueKey">
    <jira:fieldIds>
    <jira:fieldId>fieldId1</jira:fieldId>
    <jira:fieldId>fieldId2</jira:fieldId>
    </jira:fieldIds>
    <jira:fieldValues>
    <jira:fieldValue>value1</jira:fieldValue>
    <jira:fieldValue>value2</jira:fieldValue>
    </jira:fieldValues>
    </jira:update-issue> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the issue to update.|no||
|fieldIds|the ids of the custom fields|no||
|fieldValues|the values for each custom field id|no||

Returns updated RemoteIssue



Delete Issue
------------

Deletes the issue with the given key



     <jira:delete-issue issueKey="someIssueKey"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the key of the issue to delete|no||



Get Available Actions
---------------------

Finds the available actions for the given issue key

$

      <jira:get-available-actions issueKey="someIssueKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the key of the issue|no||

Returns available actions for the given issue key



Get Sub Task Issue Types
------------------------

Returns an array of all the sub task issue types in JIRA.



     <jira:get-sub-task-issue-types/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns array of RemoteIssueType objects



Create Project
--------------

Creates a new project



             <jira:create-project key="someProjectKey" name="someProjectName" description="someProjectDescription"
    lead="someUserName" permissionSchemeName="somePermissionSchemeName"
    notificationSchemeName="someNotificationSchemeName"
    securityShemeName="someSecuritySchemeName" url="someUrl"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|key|the key for the new project|no||
|name|the name for the new project|no||
|description|the description for the new project|no||
|url|the url for the new project|yes||
|lead|the lead of the new project|no||
|permissionSchemeName|the name of the permission scheme for the new project|yes||
|notificationSchemeName|the name of the notification scheme for the new project|yes||
|securityShemeName|the name of the security scheme  for the new project|yes||

Returns new project



Update Project
--------------

Updates the project denoted by the given key.



             <jira:update-project key="someProjectKey" description="someProjectDescription" lead="someUserName"
    permissionSchemeName="somePermissionSchemeName"
    notificationSchemeName="someNotificationSchemeName"
    securityShemeName="someSecuritySchemeName" url="someUrl"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|key|the key of the project to update|no||
|description|the new description|no||
|url|the new url|yes||
|lead|the new lead|no||
|permissionSchemeName|the new permission scheme name|yes||
|notificationSchemeName|the new notification scheme name|yes||
|securityShemeName|the new security scheme name|yes||

Returns updated project



Get Project By Key
------------------

Returns the Project with the matching key (if the user has permission to browse it).



      <jira:get-project-by-key projectKey="someProjectKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key of the requested projec|no||

Returns RemoteProject object specified by the key, if it exists and the user has the BROWSE permission for it



Remove All Role Actors By Project
---------------------------------

Removes all role actors for the given project key.



      <jira:remove-all-role-actors-by-project projectKey="someProjectKey"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the project key for which to remove all role actors|no||



Get Priorities
--------------

Returns an array of all the issue statuses in JIRA.



      <jira:get-priorities/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns array of RemoteStatus objects



Get Resolutions
---------------

Returns an array of all the issue resolutions in JIRA.



     <jira:get-resolutions/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns array of RemoteResolution objects



Get Issue Types
---------------

Returns an array of all the issue types for all projects in JIRA.



     <jira:get-issue-types/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns array of RemoteIssueType objects



Get Statuses
------------

Returns an array of all the issue statuses in JIRA.



     <jira:get-statuses/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns array of RemoteStatus objects



Get Issue Types For Project
---------------------------

Returns an array of all the (non-sub task) issue types for the specified project id.



     <jira:get-issue-types-for-project projectId="someProjectId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectId|id of the project|no||

Returns array of RemoteIssueType objects



Get Project Roles
-----------------

Returns the project roles.



      <jira:get-project-roles/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns project roles.



Get Project Role
----------------

Returns the project role by projectRoleId.



      <jira:get-project-role projectRoleId="123"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectRoleId|the projectRoleId of the project role|no||

Returns project role by projectRoleId.



Get Project Role Actors
-----------------------

Returns the project role actors for the given project



     <jira:get-project-role-actors projectRoleId="123" projectKey="someProjectKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectRoleId|the project role id to use|no||
|projectKey|the project key to use|no||

Returns project role actors for the given project



Get Default Role Actors
-----------------------

Returns the default role actors for the given project role id.

 

     <jira:get-default-role-actors projectRoleId="123"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectRoleId|the id of the project role|no||

Returns default role actors for the given project role id.



Remove All Role Actors By Name And Type
---------------------------------------

Removes all role actors using the given name and type.

 

     <jira:remove-all-role-actors-by-name-and-type name="someName" type="someType"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|name|the name to delete|no||
|type|the type to delete|no||



Delete Project Role
-------------------

Deletes the project role denoted by the given project role id.



     <jira:delete-project-role projectRoleId="123" confirm="false"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectRoleId|the id of the project role to delete|no||
|confirm||no||



Update Project Role
-------------------

Updates the project role with the given id.



     <jira:update-project-role projectRoleId="123" projectRoleName="someProjectRoleName"
    projectRoleDescription="someProjectDescription"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectRoleId|the id of the project role to update|no||
|projectRoleName|the new project role name|yes||
|projectRoleDescription|the new project role description|yes||



Create Project Role
-------------------

Creates a new project role.



     <jira:create-project-role projectRoleName="someProjectRoleName"
    projectRoleDescription="someProjectRoleDescription"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectRoleName|the name of the new project role|no||
|projectRoleDescription|the description of the new project role|no||

Returns created project role



Is Project Role Name Unique
---------------------------

Checks if the given project role name is unique.



     <jira:is-project-role-name-unique name="someProjectRoleName"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|name|the project role name to check for uniqueness|no||

Returns if the given project role name is unique, false otherwise.



Release Version
---------------

Releases the version denoted by the given name



     <jira:release-version projectKey="someProjectKey" versionName="someVersionName"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the project key to use|no||
|versionName|the version name to release|no||



Add Actors To Project Role
--------------------------

Adds the given actors to the project role.



             <jira:add-default-actors-to-project-role projectRoleId="123" type="someType">
    <jira:actors>
    <jira:actor>actor1</jira:actor>
    <jira:actor>actor2</jira:actor>
    </jira:actors>
    </jira:add-default-actors-to-project-role>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|actors|the actors to add|no||
|projectRoleId|the id of the project role to use|no||
|projectKey|the key of project to use|no||
|actorType|the actor type to use|yes||



Remove Actors From Project Role
-------------------------------

Removes the given actors from the project role



             <jira:remove-default-actors-from-project-role remoteProjectRoleId="123" type="someType">
    <jira:actors>
    <jira:actor>actor1</jira:actor>
    <jira:actor>actor2</jira:actor>
    </jira:actors>
    </jira:remove-default-actors-from-project-role>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|actors|the actors to remove|no||
|projectRoleId|the id of the project role to use|no||
|projectKey|the key of project to use|no||
|actorType|the actor type to use|yes||



Add Default Actors To Project Role
----------------------------------

Adds the default actors to the project role denoted by this id.



             <jira:add-default-actors-to-project-role projectRoleId="123" type="someType">
    <jira:actors>
    <jira:actor>actor1</jira:actor>
    <jira:actor>actor2</jira:actor>
    </jira:actors>
    </jira:add-default-actors-to-project-role>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|actors|the actors to add|no||
|projectRoleId|the id of the project role|no||
|type|the type|yes||



Remove Default Actors From Project Role
---------------------------------------

Removes the default actors from the project role denoted by this id.



             <jira:remove-default-actors-from-project-role remoteProjectRoleId="123" type="someType">
    <jira:actors>
    <jira:actor>actor1</jira:actor>
    <jira:actor>actor2</jira:actor>
    </jira:actors>
    </jira:remove-default-actors-from-project-role>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|actors|the actors to remove|no||
|remoteProjectRoleId|the id of the project role|no||
|type|the type|yes||



Get Associated Notification Schemes
-----------------------------------

Returns the associated notification schemes for the given project role.



     <jira:get-associated-notification-schemes projectRoleId="123"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectRoleId|the project role to search|no||

Returns associated notification schemes for the given project role.



Get Associated Permission Schemes
---------------------------------

Returns the associated permission schemas for the given project role.



     <jira:get-associated-permission-schemes projectRoleId="123"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectRoleId|the project role to search|no||

Returns associated permission schemas for the given project role.



Delete Project
--------------

Deletes the project represented by the given project key.



     <jira:delete-project projectKey="someProjectKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key of the project to delete|no||



Get Project By Id
-----------------

Returns the Project with the matching id (if the user has permission to browse it).



      <jira:get-project-by-id projectId="123"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectId|the id of the requested project|no||

Returns RemoteProject object specified by the key, if it exists and the user has the BROWSE permission for it



Get Versions
------------

Returns an array of all the versions for the specified project key.



     <jira:get-versions projectKey="someProjectKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key of the requested project|no||

Returns array of RemoteVersion objects



Get Comments
------------

Returns the comments for the issue denoted by the given key.



     <jira:get-comments issueKey="someIssueKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the key of the issue to get the comments for|no||

Returns comments for the issue denoted by the given key.



Get Favourite Filters
---------------------

This retreives a list of the currently logged in user's favourite fitlers.



     <jira:get-favourite-filters/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns list of the currently logged in user's favourite fitlers.



Archive Version
---------------

Archieves the given version/



     <jira:archive-version projectKey="someProjectKey" versionName="someVersionName" archive="true"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the project key to use|no||
|versionName|the version name to use|no||
|archive|whether it should be archived|no||



Get Fields For Edit
-------------------

Returns the fields for edit for the given issue key



     <jira:get-fields-for-edit issueKey="someIssueKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the issue key to get the fields for|no||

Returns fields for edit



Get Sub Task Issue Types For Project
------------------------------------

Returns an array of all the sub task issue types for the specified project id.



     <jira:get-sub-task-issue-types-for-project projectId="someProjectId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectId|id of the project|no||

Returns array of RemoteIssueType objects



Login
-----

Log in using the given credentials, it returns the authentication token.



     <jira:login username="someUserName" password="somePassword"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|username|the username to use|no||
|password|the password to use|no||

Returns authentication token



Get Security Level
------------------

Returns the current security level for given issue



     <jira:get-security-level issueKey="someIssueKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the issue key|no||

Returns security level



Get Custom Fields
-----------------

Returns the custom fields for the current user



     <jira:get-custom-fields/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns custom fields for the current user



Logout
------

Cleans up an authentication token that was previously created with a call to login



     <jira:logout token="aToken"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|the token to invalidate|no||

Returns if the logout succeeded



Get Project With Schemes By Id
------------------------------

Returns the Project with the matching id (if the user has permission to browse it) with notification, issue security and permission schemes attached.



     <jira:get-project-with-schemes-by-id projectId="123"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectId|the id of the requested project|no||

Returns RemoteProject object specified by the key, if it exists and the user has the BROWSE permission for it



Get Security Levels
-------------------

Returns an array of all security levels for a given project.



     <jira:get-security-levels projectKey="someProjectKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key for the project|no||

Returns of RemoteSecurityLevels for the project



Get Project Avatars
-------------------

Retrieves avatars for the given project. If the includeSystemAvatars parameter is true, this will include both
system (built-in) avatars as well as custom (user-supplied) avatars for that project, otherwise it will include
only the custom avatars. Project browse permission is required.



      <jira:get-project-avatars projectKey="someProjectKey" includeSystemAvatars="true"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key for the project.|no||
|includeSystemAvatars|if false, only custom avatars will be included in the returned array.|no||

Returns avatars for the project, possibly empty.



Set Project Avatar
------------------

Sets the current avatar for the given project to that with the given id. Project administration permission is required.



     <jira:set-project-avatar projectKey="someProjectKey" avatarId="123"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key for the project.|no||
|avatarId|the id of an existing avatar to use for the project or null for the default avatar.|no||



Get Project Avatar
------------------

Retrieves the current avatar for the given project. Project browse permission is required.



     <jira:get-project-avatar projectKey="someProjectKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key for the project.|no||

Returns current avatar for the project.



Delete Project Avatar
---------------------

Deletes the given custom Avatar from the system. System avatars cannot be deleted. Project administration permission is required.



      <jira:delete-project-avatar avatarId="123"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|avatarId|id of the custom avatar to delete.|no||



Get Notification Schemes
------------------------

Returns notification schemes.



      <jira:get-notification-schemes/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns notification schemes.



Get Permission Schemes
----------------------

Returns the permission schemes.



     <jira:get-permission-schemes/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns permission schemes.



Get All Permissions
-------------------

Returns all the permissions.



      <jira:get-all-permissions/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns the permissions



Create Permission Scheme
------------------------

Creates a new permission schema using the given name and description.



     <jira:create-permission-scheme name="somePermissionSchemeName" description="somePermissionSchemeDesc"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|name|the name of the new permission scheme|no||
|description|the description of the new permission scheme|no||

Returns created permission scheme



Add Permission To
-----------------

Adds the permission to the given entity name (username or group name)



     <jira:add-permission-to permissionSchemeName="somePermissionSchemeName" permissionCode="123"
    entityName="someEntityName" /> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|permissionSchemeName|the name of the permission scheme to use|no||
|permissionCode|the permission code to use|no||
|entityName|the entity name, username or group name|no||

Returns modified permission scheme



Delete Permission From
----------------------

Removes the permission to the given entity name (username or group name)



          <jira:delete-permission-from permissionSchemeName="somePermissionSchemeName" permissionCode="123"
    entityName="someEntityName"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|permissionSchemeName|the name of the permission scheme to use|no||
|permissionCode|the permission code to use|no||
|entityName|the entity name, username or group name|no||

Returns modified permission scheme



Delete Permission Scheme
------------------------

Deletes the permission scheme denoted by the given name



      <jira:delete-permission-scheme permissionSchemeName="somePermissionSchemeName"/> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|permissionSchemeName|the name of the permission scheme to delete|no||



Get Attachments From Issue
--------------------------

Returns the attachments for the issue denoted by the given key.



     <jira:get-attachments-from-issue issueKey="someIssueKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the issue key to use|no||

Returns attachments for the issue denoted by the given key.



Has Permission To Edit Comment
------------------------------

Returns whether the current user has permissions to edit the comment denoted by the given id.



     <jira:has-permission-to-edit-comment commentId="123"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|commentId|the comment id to use|no||

Returns the current user has permissions to edit the comment denoted by the given id.



Edit Comment
------------

Edits the comment denoted by the given id



     <jira:edit-comment commentId="123" body="someBody" updateAuthor="someUserName" /> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|commentId|the id of the comment to edit|no||
|body|the updated body comment|yes||
|updateAuthor|the update author|yes||

Returns edited comment



Get Fields For Action
---------------------

Returns the fields for the given action.



     <jira:get-fields-for-action issueKey="someIssueKey" actionIdString="someActionIdString"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the issue key to use|no||
|actionIdString|the action id to use|no||

Returns fields for the given action



Get Issue By Id
---------------

Returns the issue for the given issue id.



     <jira:get-issue-by-id issueId="someIssueId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueId|the issue id to use|no||

Returns issue for the given issue id.



Delete Worklog With New Remaining Estimate
------------------------------------------

Deletes the worklog with the given id and sets the remaining estimate field on the isssue to the given value. The time spent field of the issue is reduced by the time spent amount on the worklog being deleted.



     <jira:delete-worklog-with-new-remaining-estimate workLogId="someWorklogId" newRemainingEstimate="1h"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used                the SOAP auth token.|yes||
|workLogId|the id of the worklog to delete.|no||
|newRemainingEstimate|the new value for the issue's remaining estimate as a duration string, eg 1d 2h.|no||



Delete Worklog And Auto Adjust Remaining Estimate
-------------------------------------------------

Deletes the worklog with the given id and updates the remaining estimate field on the isssue by increasing it
by the time spent amount on the worklog being deleted. The time spent field of the issue is reduced by the
time spent amount on the worklog being deleted.



     <jira:delete-worklog-and-auto-adjust-remaining-estimate worklogId="someWorklogId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used     the SOAP auth token.|yes||
|worklogId|the id of the worklog to delete.|no||



Delete Worklog And Retain Remaining Estimate
--------------------------------------------

Deletes the worklog with the given id but leaves the remaining estimate field on the isssue unchanged. The time
spent field of the issue is reduced by the time spent amount on the worklog being deleted.



     <jira:delete-worklog-and-retain-remaining-estimate worklogId="someWorklogId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used     the SOAP auth token.|yes||
|worklogId|the id of the worklog to delete.|no||



Get Worklogs
------------

Returns all worklogs for the given issue.



     <jira:get-worklogs issueKey="someIssueKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used    the SOAP auth token.|yes||
|issueKey|the key of the issue.|no||

Returns the worklogs of the issue.



Has Permission To Create Worklog
--------------------------------

Determines if the user has the permission to add worklogs to the specified issue, that timetracking is enabled
in JIRA and that the specified issue is in an editable workflow state.



     <jira:has-permission-to-create-worklog issueKey="someIssueKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used    the SOAP auth token.|yes||
|issueKey|the key of the issue.|no||

Returns if the user has permission to create a worklog on the specified issue, false otherwise



Has Permission To Delete Worklog
--------------------------------

Determine whether the current user has the permission to delete the supplied worklog, that timetracking is enabled in JIRA and that the associated issue is in an editable workflow state.
This method will return true if the user is a member of the worklog's group/role level (if specified) AND
The user has the WORKLOG_DELETE_ALL permission; OR
The user is the worklog author and has the WORKLOG_DELETE_OWN permission
and false otherwise.



     <jira:has-permission-to-delete-worklog worklogId="someWorklogId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used     the SOAP auth token.|yes||
|worklogId|the id of the worklog wishes to delete.|no||

Returns if the user has permission to delete the supplied worklog, false otherwise



Has Permission To Update Worklog
--------------------------------

Determine whether the current user has the permission to update the supplied worklog, that timetracking is enabled in JIRA and that the associated issue is in an editable workflow state.
This method will return true if the user is a member of the worklog's group/role level (if specified) AND
The user has the WORKLOG_EDIT_ALL permission; OR
The user is the worklog author and has the WORKLOG_EDIT_OWN permission
and false otherwise.



     <jira:has-permission-to-update-worklog worklogId="someWorklogId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|worklogId|the ide of the worklog wishes to update.|no||

Returns if the user has permission to update the supplied worklog, false otherwise



Update Worklog With New Remaining Estimate
------------------------------------------

Modifies the worklog with the id of the given worklog, updating its fields to match the given worklog and sets
the remaining estimate field on the relevant issue to the given value. The time spent field of the issue is
changed by subtracting the previous value of the worklog's time spent amount and adding the new value in the
given worklog.



             <jira:update-worklog-with-new-remaining-estimate issueKey="someIssueKey" worklogId="someWorklogId"
    newRemainingEstimate="1d" comment="someComment"
    groupLevel="someGroupLevel" roleLevelId="someRoleLevelId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the issue key to use|no||
|worklogId|the worklog id to use|no||
|newRemainingEstimate|the new value for the issue's remaining estimate as a duration string, eg 1d 2h.|no||
|comment|the new comment|yes||
|groupLevel|the new group level|yes||
|roleLevelId|the new role level id|yes||



Add Version
-----------

Adds a new version



             <jira:add-version projectKey="someProjectKey" versionName="someVersionName" archived="true" released="false"
    releaseDate="someDate"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the project key to use|no||
|versionName|the version name to use|no||
|archived|whether is archived|no||
|released|whether is released|no||
|releaseDate|the release date to use in the format MM-dd-yyy'T'HH:mm:ss|no||

Returns new version



Get Resolution Date By Key
--------------------------

Given an issue key, this method returns the resolution date for this issue. If the issue hasn't been resolved
yet, this method will return null.



     <jira:get-resolution-date-by-key issueKey="someIssueKey"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the key of the issue|no||

Returns resolution date of the issue. May be null



Get Resolution Date By Id
-------------------------

Given an issue id, this method returns the resolution date for this issue. If the issue hasn't been resolved yet, this method will return null.
If the no issue with the given id exists a RemoteException will be thrown.



     <jira:get-resolution-date-by-id issueId="123"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueId|the id of the issue|no||

Returns resolution date of the issue. May be null



Get Issue Count For Filter
--------------------------

Returns the issue count for the filter denoted by this id.



     <jira:get-issue-count-for-filter filterId="someFilterId"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|filterId|the fiter id to use|no||

Returns issue count for the filter denoted by this id.



Get Issues From Text Search With Project
----------------------------------------

Returns issues containing searchTerms that are within the specified projects.
Note: this is a fuzzy search, returned in order of 'relevance', so the results are only generally useful for
human consumption.
<p/>
This method will return no more than the maxNumResults.
<p/>
This method also respects the jira.search.views.max.limit and jira.search.views.max.unlimited.group JIRA
properties which will override the max number of results returned.
<p/>
If the jira.search.views.max.limit property is set and you are not in a group specified by
jira.search.views.max.unlimited.group then the number of results returned will be constrained by the value of
jira.search.views.max.limit if it is less than the specified maxNumResults.



             <jira:get-issues-from-text-search-with-project searchTerms="someSearchTerms" maxNumResults="10">
    <jira:projectKeys>
    <jira:projectKey>projectKey1</jira:projectKey>
    <jira:projectKey>projectKey2</jira:projectKey>
    </jira:projectKeys>
    </jira:get-issues-from-text-search-with-project>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKeys|the project keys to use|no||
|searchTerms|earch terms|no||
|maxNumResults|the maximum number of results that this method will return.|no||

Returns matching the search terms



Get Issues From Jql Search
--------------------------

Execute a specified JQL query and return the resulting issues.
This method also respects the jira.search.views.max.limit and jira.search.views.max.unlimited.group JIRA properties
which will override the max number of results returned.
<p/>
If the jira.search.views.max.limit property is set and you are not in a group specified by
jira.search.views.max.unlimited.group then the number of results returned will be constrained by the value of
jira.search.views.max.limit if it is less than the specified maxNumResults.



     <jira:get-issues-from-jql-search jqlSearch="someJqlSearch" maxNumResults="10"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|jqlSearch|JQL query string to execute|no||
|maxNumResults|the maximum number of results that this method will return|no||

Returns matching the JQL query



Delete User
-----------

Deletes a user in JIRA with the specified username.



     <jira:delete-user username="someUserName"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|username|the user name to delete|no||



Delete Group
------------

Deletes the group denoted by the given group name.



      <jira:delete-group groupName="someGroupName" swapGroupName="someSwapGroupName"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|groupName|the group name to use|no||
|swapGroupName|the swap group name to use|yes||



Refresh Custom Fields
---------------------

Refreshs custom fields for the current user.



     <jira:refresh-custom-fields/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||



Add Base64 Encoded Attachments To Issue
---------------------------------------

An alternative mechanism for adding attachments to an issue. This method accepts the data of the attachments as
Base64 encoded strings instead of byte arrays. This is to combat the XML message bloat created by Axis when
SOAP-ifying byte arrays.
For more information, please see JRA-11693.



             <jira:add-base64-encoded-attachments-to-issue issueKey="someIssueKey">
    <jira:fileNames>
    <jira:fileName>fileName1</jira:fileName>
    <jira:fileName>fileName2</jira:fileName>
    </jira:fileNames>
    <jira:base64EncodedAttachmentData>
    <jira:base64EncodedAttachmentDatum>base64EncodedAttachment1</jira:base64EncodedAttachmentDatum>
    <jira:base64EncodedAttachmentDatum>base64EncodedAttachment2</jira:base64EncodedAttachmentDatum>
    </jira:base64EncodedAttachmentData>
    </jira:add-base64-encoded-attachments-to-issue>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the issue to attach to|no||
|fileNames|an array of filenames; each element names an attachment to be uploaded|no||
|base64EncodedAttachmentData|an array of Base 64 encoded Strings; each element contains the data of the attachment to be uploaded|no||

Returns if attachments were successfully added; if the operation was not successful, an exception would be thrown



Get Issues From Filter With Limit
---------------------------------

Returns issues that match the saved filter specified by the filterId.
This method will return no more than the maxNumResults.
<p/>
It will start the result set at the provided off set.
<p/>
This method also respects the jira.search.views.max.limit and jira.search.views.max.unlimited.group JIRA properties
which will override the max number of results returned.
<p/>
If the jira.search.views.max.limit property is set and you are not in a group specified by
jira.search.views.max.unlimited.group then the number of results returned will be constrained by the value of
jira.search.views.max.limit if it is less than the specified maxNumResults.



     <jira:get-issues-from-filter-with-limit filterId="someFilterId" offset="12" maxNumResults="10"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|filterId|identifies the saved filter to use for the search.|no||
|offset|the place in the result set to use as the first result returned|no||
|maxNumResults|the maximum number of results that this method will return.|no||

Returns matching the saved filter



Get Issues From Text Search With Limit
--------------------------------------

Returns issues containing searchTerms.
Note: this is a fuzzy search, returned in order of 'relevance', so the results are only generally useful for human
consumption.
<p/>
This method will return no more than the maxNumResults.
<p/>
It will start the result set at the provided off set.
<p/>
This method also respects the jira.search.views.max.limit and jira.search.views.max.unlimited.group JIRA properties
which will override the max number of results returned.
<p/>
If the jira.search.views.max.limit property is set and you are not in a group specified by
jira.search.views.max.unlimited.group then the number of results returned will be constrained by the value of
jira.search.views.max.limit if it is less than the specified maxNumResults.



     <jira:get-issues-from-text-search-with-limit searchTerms="someSearchTerms" offset="12" maxNumResults="10"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|searchTerms|search terms|no||
|offset|the place in the result set to use as the first result returned|no||
|maxNumResults|the maximum number of results that this method will return.|no||

Returns matching the search terms



Get Projects No Schemes
-----------------------

Returns an array of all the Projects defined in JIRA.



     <jira:get-projects-no-schemes/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns array of RemoteProject objects.



Set New Project Avatar
----------------------

Creates a new custom avatar for the given project and sets it to be current for the project. The image data
must be provided as base64 encoded data and should be 48 pixels square. If the image is larger, the top left
48 pixels are taken, if it is smaller it is upscaled to 48 pixels. The small version of the avatar image (16
pixels) is generated automatically. Project administration permission is required.



     <jira:set-new-project-avatar projectKey="someProjectKey" contentType="someContentType"
    base64ImageData="someBase64ImageData"/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|projectKey|the key for the project.|no||
|contentType|the MIME type of the image provided, e.g. image/gif, image/jpeg, image/png.|no||
|base64ImageData|a base 64 encoded image, 48 pixels square.|no||



Progress Workflow Action
------------------------

This will progress an issue through a workflow.



             <jira:progress-workflow-action issueKey="someIssueKey" actionIdString="someActionIdString">
    <jira:fieldIds>
    <jira:fieldId>fieldId1</jira:fieldId>
    <jira:fieldId>fieldId2</jira:fieldId>
    </jira:fieldIds>
    <jira:fieldsValues>
    <jira:fieldsValue>value1</jira:fieldsValue>
    <jira:fieldsValue>value2</jira:fieldsValue>
    </jira:fieldsValues>
    </jira:progress-workflow-action> 

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||
|issueKey|the issue to update.|no||
|actionIdString|the workflow action to progress to|no||
|fieldIds|the ids of the remote fields|yes||
|fieldsValues|the values of the remote fields|yes||

Returns updated RemoteIssue



Get Security Schemes
--------------------

Returns the security schemes.



     <jira:get-security-schemes/>

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|token|optionally provide a token to use, if not provided {@link JiraCloudConnector#username} and {@link JiraCloudConnector#password} will be used|yes||

Returns security schemes.











































