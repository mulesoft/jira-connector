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
 * Similar to {@link JiraClientAuthorizationException}, but specifically for use when authentication is required and has failed or has not yet been provided.
 * Ergo, this is a wrapper for a 401
 * @author marianosimone
 */
public class JiraClientAuthenticationException extends RuntimeException {
    private static final long serialVersionUID = 303445801165797261L;

    public JiraClientAuthenticationException(RestClientException e) {
        super(e);
    }

}
