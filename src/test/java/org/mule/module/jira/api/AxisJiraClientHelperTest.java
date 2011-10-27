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

import com.atlassian.jira.rpc.soap.beans.RemoteCustomFieldValue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AxisJiraClientHelperTest {

    @Mock
    private AxisJiraClient axisJiraClient;

    @Before
    public void setUpTests() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getRemoteCustomFieldValues() {
        Map<String, List<String>> customeFields = new LinkedHashMap<String, List<String>>(2);
        customeFields.put("fieldId1", Arrays.asList("value1"));
        customeFields.put("fieldId2", Arrays.asList("value21", "value22"));
        RemoteCustomFieldValue[] remoteCustomFieldValues = new AxisJiraClientHelper(axisJiraClient).getRemoteCustomFieldValues(customeFields);

        assertEquals("fieldId1", remoteCustomFieldValues[0].getCustomfieldId());
        assertArrayEquals(new String[]{"value1"}, remoteCustomFieldValues[0].getValues());

        assertEquals("fieldId2", remoteCustomFieldValues[1].getCustomfieldId());
        assertArrayEquals(new String[]{"value21", "value22"}, remoteCustomFieldValues[1].getValues());
    }
}