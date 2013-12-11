/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.jira.api.rest;

import com.atlassian.jira.rest.client.api.RestClientException;

/**
 * Exception to represent an error while trying to invoke an action on a Jira instance that doesn't support it
 * 
 * In general, it means that you are connecting to an instance with an old version (below 5)
 * @author marianosimone
 */
public class JiraClientOperationNotSupportedException extends RuntimeException {
    private static final long serialVersionUID = 6015791650109988432L;

    public JiraClientOperationNotSupportedException(RestClientException e) {
        super(e);
    }
}
