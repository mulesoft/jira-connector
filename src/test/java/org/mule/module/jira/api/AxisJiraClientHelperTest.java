/**
 * Copyright (c) MuleSoft, Inc. All rights reserved. http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.md file.
 */

package org.mule.module.jira.api;

import com.atlassian.jira.rpc.soap.beans.RemoteCustomFieldValue;
import com.atlassian.jira.rpc.soap.beans.RemoteFieldValue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AxisJiraClientHelperTest {

    @Mock
    private AxisJiraClient axisJiraClient;
    private AxisJiraClientHelper axisJiraClientHelper;

    @Before
    public void setUpTests() {
        MockitoAnnotations.initMocks(this);
        axisJiraClientHelper = new AxisJiraClientHelper(axisJiraClient);
    }

    @Test
    public void getRemoteCustomFieldValues() {
        Map<String, List<String>> customeFields = new LinkedHashMap<String, List<String>>(2);
        customeFields.put("fieldId1", Arrays.asList("value1"));
        customeFields.put("fieldId2", Arrays.asList("value21", "value22"));

        RemoteCustomFieldValue[] remoteCustomFieldValues = axisJiraClientHelper.getRemoteCustomFieldValues(customeFields);

        assertEquals("fieldId1", remoteCustomFieldValues[0].getCustomfieldId());
        assertArrayEquals(new String[]{"value1"}, remoteCustomFieldValues[0].getValues());

        assertEquals("fieldId2", remoteCustomFieldValues[1].getCustomfieldId());
        assertArrayEquals(new String[]{"value21", "value22"}, remoteCustomFieldValues[1].getValues());
    }

    @Test
    public void createRemoteFieldValues() throws Exception {
        Map<String, List<String>> fields = new HashMap<String, List<String>>(1);
        fields.put("fieldId", Arrays.asList("value1", "value2"));
        RemoteFieldValue[] remoteFieldValues = axisJiraClientHelper.createRemoteFieldValues(fields);
        assertEquals(1, remoteFieldValues.length);
        RemoteFieldValue remoteFieldValue = remoteFieldValues[0];
        assertEquals("fieldId", remoteFieldValue.getId());
        assertArrayEquals(new String[]{"value1", "value2"}, remoteFieldValue.getValues());
    }

    @Test
    public void createRemoteFieldValuesEmptyValues() throws Exception {
        Map<String, List<String>> fields = new HashMap<String, List<String>>(1);
        fields.put("fieldId", Collections.<String>emptyList());
        RemoteFieldValue[] remoteFieldValues = axisJiraClientHelper.createRemoteFieldValues(fields);
        assertEquals(1, remoteFieldValues.length);
        RemoteFieldValue remoteFieldValue = remoteFieldValues[0];
        assertEquals("fieldId", remoteFieldValue.getId());
        assertArrayEquals(new String[0], remoteFieldValue.getValues());
    }

    @Test
    public void createRemoteFieldValuesEmptyFields() throws Exception {
        RemoteFieldValue[] remoteFieldValues = axisJiraClientHelper.createRemoteFieldValues(Collections.<String, List<String>>emptyMap());
        assertEquals(0, remoteFieldValues.length);
    }
}