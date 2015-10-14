
package org.mule.module.jira.config;

import com.atlassian.jira.rpc.soap.beans.holders.RemoteIssueExpressionHolder;
import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.jira.processors.CreateIssueWithParentMessageProcessor;
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
public class CreateIssueWithParentDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(CreateIssueWithParentDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(CreateIssueWithParentMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [create-issue-with-parent] within the connector [jira] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [create-issue-with-parent] within the connector [jira] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("createIssueWithParent");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        if (!hasAttribute(element, "config-ref")) {
            throw new BeanDefinitionParsingException(new Problem("It seems that the config-ref for @Processor [create-issue-with-parent] within the connector [jira] is null or missing. Please, fill the value with the correct global element.", new Location(parserContext.getReaderContext().getResource()), null));
        }
        parseConfigRef(element, builder);
        if (!parseObjectRefWithDefault(element, builder, "issue", "issue", "#[payload]")) {
            BeanDefinitionBuilder issueBuilder = BeanDefinitionBuilder.rootBeanDefinition(RemoteIssueExpressionHolder.class.getName());
            Element issueChildElement = DomUtils.getChildElementByTagName(element, "issue");
            if (issueChildElement!= null) {
                parseProperty(issueBuilder, issueChildElement, "id", "id");
                if (hasAttribute(issueChildElement, "__equalsCalc-ref")) {
                    if (issueChildElement.getAttribute("__equalsCalc-ref").startsWith("#")) {
                        issueBuilder.addPropertyValue("__equalsCalc", issueChildElement.getAttribute("__equalsCalc-ref"));
                    } else {
                        issueBuilder.addPropertyValue("__equalsCalc", (("#[registry:"+ issueChildElement.getAttribute("__equalsCalc-ref"))+"]"));
                    }
                }
                parseProperty(issueBuilder, issueChildElement, "__hashCodeCalc", "__hashCodeCalc");
                if (hasAttribute(issueChildElement, "typeDesc-ref")) {
                    if (issueChildElement.getAttribute("typeDesc-ref").startsWith("#")) {
                        issueBuilder.addPropertyValue("typeDesc", issueChildElement.getAttribute("typeDesc-ref"));
                    } else {
                        issueBuilder.addPropertyValue("typeDesc", (("#[registry:"+ issueChildElement.getAttribute("typeDesc-ref"))+"]"));
                    }
                }
                if (hasAttribute(issueChildElement, "affectsVersions-ref")) {
                    if (issueChildElement.getAttribute("affectsVersions-ref").startsWith("#")) {
                        issueBuilder.addPropertyValue("affectsVersions", issueChildElement.getAttribute("affectsVersions-ref"));
                    } else {
                        issueBuilder.addPropertyValue("affectsVersions", (("#[registry:"+ issueChildElement.getAttribute("affectsVersions-ref"))+"]"));
                    }
                }
                parseProperty(issueBuilder, issueChildElement, "assignee", "assignee");
                if (hasAttribute(issueChildElement, "attachmentNames-ref")) {
                    if (issueChildElement.getAttribute("attachmentNames-ref").startsWith("#")) {
                        issueBuilder.addPropertyValue("attachmentNames", issueChildElement.getAttribute("attachmentNames-ref"));
                    } else {
                        issueBuilder.addPropertyValue("attachmentNames", (("#[registry:"+ issueChildElement.getAttribute("attachmentNames-ref"))+"]"));
                    }
                }
                if (hasAttribute(issueChildElement, "components-ref")) {
                    if (issueChildElement.getAttribute("components-ref").startsWith("#")) {
                        issueBuilder.addPropertyValue("components", issueChildElement.getAttribute("components-ref"));
                    } else {
                        issueBuilder.addPropertyValue("components", (("#[registry:"+ issueChildElement.getAttribute("components-ref"))+"]"));
                    }
                }
                parseProperty(issueBuilder, issueChildElement, "created", "created");
                if (hasAttribute(issueChildElement, "customFieldValues-ref")) {
                    if (issueChildElement.getAttribute("customFieldValues-ref").startsWith("#")) {
                        issueBuilder.addPropertyValue("customFieldValues", issueChildElement.getAttribute("customFieldValues-ref"));
                    } else {
                        issueBuilder.addPropertyValue("customFieldValues", (("#[registry:"+ issueChildElement.getAttribute("customFieldValues-ref"))+"]"));
                    }
                }
                parseProperty(issueBuilder, issueChildElement, "description", "description");
                parseProperty(issueBuilder, issueChildElement, "duedate", "duedate");
                parseProperty(issueBuilder, issueChildElement, "environment", "environment");
                if (hasAttribute(issueChildElement, "fixVersions-ref")) {
                    if (issueChildElement.getAttribute("fixVersions-ref").startsWith("#")) {
                        issueBuilder.addPropertyValue("fixVersions", issueChildElement.getAttribute("fixVersions-ref"));
                    } else {
                        issueBuilder.addPropertyValue("fixVersions", (("#[registry:"+ issueChildElement.getAttribute("fixVersions-ref"))+"]"));
                    }
                }
                parseProperty(issueBuilder, issueChildElement, "key", "key");
                parseProperty(issueBuilder, issueChildElement, "priority", "priority");
                parseProperty(issueBuilder, issueChildElement, "project", "project");
                parseProperty(issueBuilder, issueChildElement, "reporter", "reporter");
                parseProperty(issueBuilder, issueChildElement, "resolution", "resolution");
                parseProperty(issueBuilder, issueChildElement, "status", "status");
                parseProperty(issueBuilder, issueChildElement, "summary", "summary");
                parseProperty(issueBuilder, issueChildElement, "type", "type");
                parseProperty(issueBuilder, issueChildElement, "updated", "updated");
                parseProperty(issueBuilder, issueChildElement, "votes", "votes");
                builder.addPropertyValue("issue", issueBuilder.getBeanDefinition());
            }
        }
        parseProperty(builder, element, "parentIssueKey", "parentIssueKey");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
