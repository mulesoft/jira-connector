Mule JIRA Cloud Connector
=========================

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
            <url>https://repository.mulesoft.org/releases/</url>
            <layout>default</layout>
        </repsitory>
    </repositories>

Add the connector as a dependency to your project. This can be done by adding
the following under the dependencies element in the pom.xml file of the
application:

    <dependency>
        <groupId>org.mule.modules</groupId>
        <artifactId>mule-module-jira</artifactId>
        <version>1.0</version>
    </dependency>

Configuration
-------------

You can configure the connector as follows:

    <jira:config client="value" username="value" password="value" address="value"/>

Here is detailed list of all the configuration attributes:

| attribute | description | optional | default value |
|:-----------|:-----------|:---------|:--------------|
|name|Give a name to this configuration so it can be later referenced by config-ref.|yes||
|client||yes|
|username|The user login username|no|
|password|The user login password|no|
|address|The JIRA Server Soap address. It usually looks like 
https://&lt;jira server hostname&gt;/rpc/soap/jirasoapservice-v2
or http://&lt;jira server hostname&gt;/rpc/soap/jirasoapservice-v2|yes|DEFAULT_ADDRESS


Create Issue
------------

Creates an issue. 



      <jira:create-issue issue="#[map-payload:anIssue]" />

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|issue|the issue to create in Jira|no||

Returns new issue's key



Get Issue
---------

Answers an existent issue by key.



     <jira:get-issue key="#[header:key]" />

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|key|the key of the issue|no||

Returns non null issue. If it not exists, a JiraException will be thrown



Delete Issue
------------

Deletes an existent issue by key. 
If it does not exist, a JiraExcpetion will be thrown.  



     <jira:delete-issue key="aKey" />

| attribute | description | optional | default value | possible values |
|:-----------|:-----------|:---------|:--------------|:----------------|
|config-ref|Specify which configuration to use for this invocation|yes||
|key|the key of the issue|no||













































