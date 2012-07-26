/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mulesoft.demo.jira;

import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.tck.junit4.FunctionalTestCase;

import com.atlassian.jira.rpc.soap.beans.RemoteIssue;

import org.junit.Test;

public class JiraFunctionalTestDriver extends FunctionalTestCase
{
    @Override
    protected String getConfigResources()
    {
        return "mule-config.xml";
    }

    @Test
    public void getIssues() throws Exception
    {
        MuleEvent event = getTestEvent(null);
        ((RemoteIssue) lookupFlowConstruct("GetIssue").process(event).getMessage().getPayload()).getDescription();
    }

    private MessageProcessor lookupFlowConstruct(final String name)
    {
        return (MessageProcessor) muleContext.getRegistry().lookupFlowConstruct(name);
    }

}
