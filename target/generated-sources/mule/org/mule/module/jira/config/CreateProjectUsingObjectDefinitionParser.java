
package org.mule.module.jira.config;

import com.atlassian.jira.rpc.soap.beans.holders.RemotePermissionSchemeExpressionHolder;
import com.atlassian.jira.rpc.soap.beans.holders.RemoteProjectExpressionHolder;
import com.atlassian.jira.rpc.soap.beans.holders.RemoteSchemeExpressionHolder;
import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.jira.processors.CreateProjectUsingObjectMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class CreateProjectUsingObjectDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateProjectUsingObjectDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateProjectUsingObjectMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-project-using-object] within the connector [jira] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-project-using-object] within the connector [jira] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createProjectUsingObject");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-project-using-object] within the connector [jira] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "project", "project", "#[payload]")) {
            BeanDefinitionBuilder projectBuilder = BeanDefinitionBuilder.rootBeanDefinition(RemoteProjectExpressionHolder.class.getName());
            Element projectChildElement = DomUtils.getChildElementByTagName(element, "project");
            if (projectChildElement!= null) {
                parseProperty(projectBuilder, projectChildElement, "name", "name");
                if (hasAttribute(projectChildElement, "__equalsCalc-ref")) {
                    if (projectChildElement.getAttribute("__equalsCalc-ref").startsWith("#")) {
                        projectBuilder.addPropertyValue("__equalsCalc", projectChildElement.getAttribute("__equalsCalc-ref"));
                    } else {
                        projectBuilder.addPropertyValue("__equalsCalc", (("#[registry:"+ projectChildElement.getAttribute("__equalsCalc-ref"))+"]"));
                    }
                }
                parseProperty(projectBuilder, projectChildElement, "__hashCodeCalc", "__hashCodeCalc");
                if (hasAttribute(projectChildElement, "typeDesc-ref")) {
                    if (projectChildElement.getAttribute("typeDesc-ref").startsWith("#")) {
                        projectBuilder.addPropertyValue("typeDesc", projectChildElement.getAttribute("typeDesc-ref"));
                    } else {
                        projectBuilder.addPropertyValue("typeDesc", (("#[registry:"+ projectChildElement.getAttribute("typeDesc-ref"))+"]"));
                    }
                }
                parseProperty(projectBuilder, projectChildElement, "id", "id");
                if (hasAttribute(projectChildElement, "__equalsCalc-ref")) {
                    if (projectChildElement.getAttribute("__equalsCalc-ref").startsWith("#")) {
                        projectBuilder.addPropertyValue("__equalsCalc", projectChildElement.getAttribute("__equalsCalc-ref"));
                    } else {
                        projectBuilder.addPropertyValue("__equalsCalc", (("#[registry:"+ projectChildElement.getAttribute("__equalsCalc-ref"))+"]"));
                    }
                }
                parseProperty(projectBuilder, projectChildElement, "__hashCodeCalc", "__hashCodeCalc");
                if (hasAttribute(projectChildElement, "typeDesc-ref")) {
                    if (projectChildElement.getAttribute("typeDesc-ref").startsWith("#")) {
                        projectBuilder.addPropertyValue("typeDesc", projectChildElement.getAttribute("typeDesc-ref"));
                    } else {
                        projectBuilder.addPropertyValue("typeDesc", (("#[registry:"+ projectChildElement.getAttribute("typeDesc-ref"))+"]"));
                    }
                }
                parseProperty(projectBuilder, projectChildElement, "description", "description");
                if (!parseObjectRef(projectChildElement, projectBuilder, "issue-security-scheme", "issueSecurityScheme")) {
                    BeanDefinitionBuilder _issueSecuritySchemeBuilder = BeanDefinitionBuilder.rootBeanDefinition(RemoteSchemeExpressionHolder.class.getName());
                    Element _issueSecuritySchemeChildElement = DomUtils.getChildElementByTagName(projectChildElement, "issue-security-scheme");
                    if (_issueSecuritySchemeChildElement!= null) {
                        parseProperty(_issueSecuritySchemeBuilder, _issueSecuritySchemeChildElement, "description", "description");
                        parseProperty(_issueSecuritySchemeBuilder, _issueSecuritySchemeChildElement, "id", "id");
                        parseProperty(_issueSecuritySchemeBuilder, _issueSecuritySchemeChildElement, "name", "name");
                        parseProperty(_issueSecuritySchemeBuilder, _issueSecuritySchemeChildElement, "type", "type");
                        projectBuilder.addPropertyValue("issueSecurityScheme", _issueSecuritySchemeBuilder.getBeanDefinition());
                    }
                }
                parseProperty(projectBuilder, projectChildElement, "key", "key");
                parseProperty(projectBuilder, projectChildElement, "lead", "lead");
                if (!parseObjectRef(projectChildElement, projectBuilder, "notification-scheme", "notificationScheme")) {
                    BeanDefinitionBuilder _notificationSchemeBuilder = BeanDefinitionBuilder.rootBeanDefinition(RemoteSchemeExpressionHolder.class.getName());
                    Element _notificationSchemeChildElement = DomUtils.getChildElementByTagName(projectChildElement, "notification-scheme");
                    if (_notificationSchemeChildElement!= null) {
                        parseProperty(_notificationSchemeBuilder, _notificationSchemeChildElement, "description", "description");
                        parseProperty(_notificationSchemeBuilder, _notificationSchemeChildElement, "id", "id");
                        parseProperty(_notificationSchemeBuilder, _notificationSchemeChildElement, "name", "name");
                        parseProperty(_notificationSchemeBuilder, _notificationSchemeChildElement, "type", "type");
                        projectBuilder.addPropertyValue("notificationScheme", _notificationSchemeBuilder.getBeanDefinition());
                    }
                }
                if (!parseObjectRef(projectChildElement, projectBuilder, "permission-scheme", "permissionScheme")) {
                    BeanDefinitionBuilder _permissionSchemeBuilder = BeanDefinitionBuilder.rootBeanDefinition(RemotePermissionSchemeExpressionHolder.class.getName());
                    Element _permissionSchemeChildElement = DomUtils.getChildElementByTagName(projectChildElement, "permission-scheme");
                    if (_permissionSchemeChildElement!= null) {
                        parseProperty(_permissionSchemeBuilder, _permissionSchemeChildElement, "description", "description");
                        parseProperty(_permissionSchemeBuilder, _permissionSchemeChildElement, "id", "id");
                        parseProperty(_permissionSchemeBuilder, _permissionSchemeChildElement, "name", "name");
                        parseProperty(_permissionSchemeBuilder, _permissionSchemeChildElement, "type", "type");
                        if (hasAttribute(_permissionSchemeChildElement, "__equalsCalc-ref")) {
                            if (_permissionSchemeChildElement.getAttribute("__equalsCalc-ref").startsWith("#")) {
                                _permissionSchemeBuilder.addPropertyValue("__equalsCalc", _permissionSchemeChildElement.getAttribute("__equalsCalc-ref"));
                            } else {
                                _permissionSchemeBuilder.addPropertyValue("__equalsCalc", (("#[registry:"+ _permissionSchemeChildElement.getAttribute("__equalsCalc-ref"))+"]"));
                            }
                        }
                        parseProperty(_permissionSchemeBuilder, _permissionSchemeChildElement, "__hashCodeCalc", "__hashCodeCalc");
                        if (hasAttribute(_permissionSchemeChildElement, "typeDesc-ref")) {
                            if (_permissionSchemeChildElement.getAttribute("typeDesc-ref").startsWith("#")) {
                                _permissionSchemeBuilder.addPropertyValue("typeDesc", _permissionSchemeChildElement.getAttribute("typeDesc-ref"));
                            } else {
                                _permissionSchemeBuilder.addPropertyValue("typeDesc", (("#[registry:"+ _permissionSchemeChildElement.getAttribute("typeDesc-ref"))+"]"));
                            }
                        }
                        if (hasAttribute(_permissionSchemeChildElement, "permissionMappings-ref")) {
                            if (_permissionSchemeChildElement.getAttribute("permissionMappings-ref").startsWith("#")) {
                                _permissionSchemeBuilder.addPropertyValue("permissionMappings", _permissionSchemeChildElement.getAttribute("permissionMappings-ref"));
                            } else {
                                _permissionSchemeBuilder.addPropertyValue("permissionMappings", (("#[registry:"+ _permissionSchemeChildElement.getAttribute("permissionMappings-ref"))+"]"));
                            }
                        }
                        projectBuilder.addPropertyValue("permissionScheme", _permissionSchemeBuilder.getBeanDefinition());
                    }
                }
                parseProperty(projectBuilder, projectChildElement, "projectUrl", "projectUrl");
                parseProperty(projectBuilder, projectChildElement, "url", "url");
                builder.addPropertyValue("project", projectBuilder.getBeanDefinition());
            }
        }
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
