/**
 * Mule Jira Cloud Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

/**
 * JiraSoapServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.atlassian.jira.rpc.soap.jirasoapservice_v2;

public interface JiraSoapServiceService extends javax.xml.rpc.Service {
    public java.lang.String getJirasoapserviceV2Address();

    public com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapService getJirasoapserviceV2() throws javax.xml.rpc.ServiceException;

    public com.atlassian.jira.rpc.soap.jirasoapservice_v2.JiraSoapService getJirasoapserviceV2(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
