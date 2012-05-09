JIRA GET ISSUE DEMO
=============

INTRODUCTION
  This is minimalistic a demo about fetch a issue from JIRA. This demo covers the fetch a issue from jira and show your summary.

HOW TO DEMO:
  1. Set the following system properties:
    a. jiraUsername, the username with permission access to jira
    b. jiraPassword, the password with permission access to jira
    c. jiraAddress, the jira url (ex: http://localhost:8080/jira/rpc/soap/jirasoapservice-v2)
    d. jiraIssue, the issue id
    
  2. Run the "GetIssue" flow. This will fetch a issue from Jira and show your summary.
  
HOW IT WORKS:
   - The fetch issue from {jiraAddress} with {jiraUsername} and {jiraPassword}.
   - Use logger to show the issue's summary.