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

import com.atlassian.jira.rpc.soap.beans.RemoteIssue;

public interface JiraClient<ExceptionType extends Throwable>
{
    void createssue(RemoteIssue issue) throws ExceptionType;

    void deleteIssue(String key) throws ExceptionType;

    RemoteIssue getIssue(String key) throws ExceptionType;
}
