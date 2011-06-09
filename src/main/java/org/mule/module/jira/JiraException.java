/**
 * Mule Jira Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.module.jira;

public class JiraException extends RuntimeException
{
    private static final long serialVersionUID = -2109364149460283327L;

    public JiraException(Throwable cause)
    {
        super(cause);
    }

    public JiraException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
