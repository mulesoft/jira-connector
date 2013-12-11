/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.jira.api.rest;

import com.atlassian.jira.rest.client.api.RestClientException;
import com.google.common.base.Optional;

/**
 * Common class to wrap all calls to the JiraRestClient, and do some custom
 * Exception handling
 * 
 * @author marianosimone
 * 
 */
public abstract class JiraRestClientCallWrapper {
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    public static <T> T wrap(final JiraRestClientInvocation<T> invocation) {
        try {
            return invocation.invoke();
        } catch (final RestClientException e) {
            final Optional<Integer> status = e.getStatusCode();
            if (status.isPresent()) {
                switch (status.get()) {
                case UNAUTHORIZED:
                    throw new JiraClientAuthenticationException(e);
                case FORBIDDEN:
                    throw new JiraClientAuthorizationException(e);
                default:
                    throw e;
                }
            } else {
                throw new JiraClientOperationNotSupportedException(e);
            }
        }
    }
}
