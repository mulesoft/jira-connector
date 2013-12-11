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
 * The request was a valid request, but the server is refusing to respond to it.
 * Unlike as when getting a {@link JiraClientAuthenticationException}, authenticating will make no difference.
 * This commonly means that the provided credentials were successfully authenticated but that the credentials still do not grant the client permission to access the restricted content.
 * Ergo, this is a wrapper for a 403
 * @author marianosimone
 */
public class JiraClientAuthorizationException extends RuntimeException {
    private static final long serialVersionUID = 4784099376863359287L;

    public JiraClientAuthorizationException(RestClientException e) {
        super(e);
    }
}