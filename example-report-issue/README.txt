Jira Search and Upload Demo
==============================

INTRODUCTION
  This is minimalistic a demo creating issues in a Jira Tracker. 

HOW TO DEMO:
  1. Set the following system properties:
    a. jiraUsername This is the username of your Jira Account
    b. jiraPassword This is the password of your Jira account
  	c. jiraAddress This is the url of your Jira server
  2. Run the "MainFlow". This will create an issue given its description and summary. You can run it by either running the JiraFunctionalTestDriver or hitting 
  http://localhost:9090/jira-demo-report-issue?summary=<SUMMARY>&description=<DESCRIPTION>&type=<ISSUE_TYPE_ID>&project=<PROJECT_KEY>

    
