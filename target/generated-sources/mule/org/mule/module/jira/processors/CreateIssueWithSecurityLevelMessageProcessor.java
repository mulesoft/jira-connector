
package org.mule.module.jira.processors;

import com.atlassian.jira.rpc.soap.beans.RemoteIssue;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.config.ConfigurationException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.registry.RegistrationException;
import org.mule.common.DefaultResult;
import org.mule.common.FailureType;
import org.mule.common.Result;
import org.mule.common.metadata.ConnectorMetaDataEnabled;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultPojoMetaDataModel;
import org.mule.common.metadata.DefaultSimpleMetaDataModel;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.OperationMetaDataEnabled;
import org.mule.common.metadata.datatype.DataType;
import org.mule.common.metadata.datatype.DataTypeFactory;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;
import org.mule.module.jira.JiraConnector;
import org.mule.module.jira.JiraConnectorException;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * CreateIssueWithSecurityLevelMessageProcessor invokes the {@link org.mule.module.jira.JiraConnector#createIssueWithSecurityLevel(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.util.Map, java.lang.Long, java.lang.String, java.lang.String)} method in {@link JiraConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class CreateIssueWithSecurityLevelMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object assignee;
    protected String _assigneeType;
    protected Object summary;
    protected String _summaryType;
    protected Object description;
    protected String _descriptionType;
    protected Object dueDate;
    protected String _dueDateType;
    protected Object environment;
    protected String _environmentType;
    protected Object priority;
    protected String _priorityType;
    protected Object project;
    protected String _projectType;
    protected Object reporter;
    protected String _reporterType;
    protected Object type;
    protected String _typeType;
    protected Object votes;
    protected Long _votesType;
    protected Object customFields;
    protected Map<String, String> _customFieldsType;
    protected Object securityLevelId;
    protected Long _securityLevelIdType;
    protected Object componentName;
    protected String _componentNameType;
    protected Object componentId;
    protected String _componentIdType;

    public CreateIssueWithSecurityLevelMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets summary
     * 
     * @param value Value to set
     */
    public void setSummary(Object value) {
        this.summary = value;
    }

    /**
     * Sets customFields
     * 
     * @param value Value to set
     */
    public void setCustomFields(Object value) {
        this.customFields = value;
    }

    /**
     * Sets votes
     * 
     * @param value Value to set
     */
    public void setVotes(Object value) {
        this.votes = value;
    }

    /**
     * Sets assignee
     * 
     * @param value Value to set
     */
    public void setAssignee(Object value) {
        this.assignee = value;
    }

    /**
     * Sets securityLevelId
     * 
     * @param value Value to set
     */
    public void setSecurityLevelId(Object value) {
        this.securityLevelId = value;
    }

    /**
     * Sets type
     * 
     * @param value Value to set
     */
    public void setType(Object value) {
        this.type = value;
    }

    /**
     * Sets componentId
     * 
     * @param value Value to set
     */
    public void setComponentId(Object value) {
        this.componentId = value;
    }

    /**
     * Sets reporter
     * 
     * @param value Value to set
     */
    public void setReporter(Object value) {
        this.reporter = value;
    }

    /**
     * Sets project
     * 
     * @param value Value to set
     */
    public void setProject(Object value) {
        this.project = value;
    }

    /**
     * Sets componentName
     * 
     * @param value Value to set
     */
    public void setComponentName(Object value) {
        this.componentName = value;
    }

    /**
     * Sets environment
     * 
     * @param value Value to set
     */
    public void setEnvironment(Object value) {
        this.environment = value;
    }

    /**
     * Sets description
     * 
     * @param value Value to set
     */
    public void setDescription(Object value) {
        this.description = value;
    }

    /**
     * Sets priority
     * 
     * @param value Value to set
     */
    public void setPriority(Object value) {
        this.priority = value;
    }

    /**
     * Sets dueDate
     * 
     * @param value Value to set
     */
    public void setDueDate(Object value) {
        this.dueDate = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(null, false, event);
            final String _transformedAssignee = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_assigneeType").getGenericType(), null, assignee));
            final String _transformedSummary = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_summaryType").getGenericType(), null, summary));
            final String _transformedDescription = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_descriptionType").getGenericType(), null, description));
            final String _transformedDueDate = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_dueDateType").getGenericType(), null, dueDate));
            final String _transformedEnvironment = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_environmentType").getGenericType(), null, environment));
            final String _transformedPriority = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_priorityType").getGenericType(), null, priority));
            final String _transformedProject = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_projectType").getGenericType(), null, project));
            final String _transformedReporter = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_reporterType").getGenericType(), null, reporter));
            final String _transformedType = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_typeType").getGenericType(), null, type));
            final Long _transformedVotes = ((Long) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_votesType").getGenericType(), null, votes));
            final Map<String, String> _transformedCustomFields = ((Map<String, String> ) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_customFieldsType").getGenericType(), null, customFields));
            final Long _transformedSecurityLevelId = ((Long) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_securityLevelIdType").getGenericType(), null, securityLevelId));
            final String _transformedComponentName = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_componentNameType").getGenericType(), null, componentName));
            final String _transformedComponentId = ((String) evaluateAndTransform(getMuleContext(), event, CreateIssueWithSecurityLevelMessageProcessor.class.getDeclaredField("_componentIdType").getGenericType(), null, componentId));
            Object resultPayload;
            final ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return Arrays.asList(((Class<? extends Exception> []) new Class[] {JiraConnectorException.class }));
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((JiraConnector) object).createIssueWithSecurityLevel(_transformedAssignee, _transformedSummary, _transformedDescription, _transformedDueDate, _transformedEnvironment, _transformedPriority, _transformedProject, _transformedReporter, _transformedType, _transformedVotes, _transformedCustomFields, _transformedSecurityLevelId, _transformedComponentName, _transformedComponentId);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Result<MetaData> getInputMetaData() {
        return new DefaultResult<MetaData>(null, (Result.Status.SUCCESS));
    }

    @Override
    public Result<MetaData> getOutputMetaData(MetaData inputMetadata) {
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(RemoteIssue.class)));
    }

    private MetaDataModel getPojoOrSimpleModel(Class clazz) {
        DataType dataType = DataTypeFactory.getInstance().getDataType(clazz);
        if (DataType.POJO.equals(dataType)) {
            return new DefaultPojoMetaDataModel(clazz);
        } else {
            return new DefaultSimpleMetaDataModel(dataType);
        }
    }

    public Result<MetaData> getGenericMetaData(MetaDataKey metaDataKey) {
        ConnectorMetaDataEnabled connector;
        try {
            connector = ((ConnectorMetaDataEnabled) findOrCreate(null, false, null));
            try {
                Result<MetaData> metadata = connector.getMetaData(metaDataKey);
                if ((Result.Status.FAILURE).equals(metadata.getStatus())) {
                    return metadata;
                }
                if (metadata.get() == null) {
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at JiraConnector at createIssueWithSecurityLevel retrieving was successful but result is null");
                }
                return metadata;
            } catch (Exception e) {
                return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
            }
        } catch (ClassCastException cast) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error getting metadata, there was no connection manager available. Maybe you're trying to use metadata from an Oauth connector");
        } catch (ConfigurationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (RegistrationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (IllegalAccessException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (InstantiationException e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        } catch (Exception e) {
            return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), e.getMessage(), FailureType.UNSPECIFIED, e);
        }
    }

}
