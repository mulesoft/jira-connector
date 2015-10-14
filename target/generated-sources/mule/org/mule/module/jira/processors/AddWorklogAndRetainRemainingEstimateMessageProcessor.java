
package org.mule.module.jira.processors;

import com.atlassian.jira.rpc.soap.beans.RemoteWorklog;
import java.util.Arrays;
import java.util.List;
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
 * AddWorklogAndRetainRemainingEstimateMessageProcessor invokes the {@link org.mule.module.jira.JiraConnector#addWorklogAndRetainRemainingEstimate(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)} method in {@link JiraConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class AddWorklogAndRetainRemainingEstimateMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor, OperationMetaDataEnabled
{

    protected Object issueKey;
    protected String _issueKeyType;
    protected Object timeSpent;
    protected String _timeSpentType;
    protected Object startDate;
    protected String _startDateType;
    protected Object comment;
    protected String _commentType;
    protected Object groupLevel;
    protected String _groupLevelType;
    protected Object roleLevelId;
    protected String _roleLevelIdType;

    public AddWorklogAndRetainRemainingEstimateMessageProcessor(String operationName) {
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
     * Sets startDate
     * 
     * @param value Value to set
     */
    public void setStartDate(Object value) {
        this.startDate = value;
    }

    /**
     * Sets groupLevel
     * 
     * @param value Value to set
     */
    public void setGroupLevel(Object value) {
        this.groupLevel = value;
    }

    /**
     * Sets issueKey
     * 
     * @param value Value to set
     */
    public void setIssueKey(Object value) {
        this.issueKey = value;
    }

    /**
     * Sets roleLevelId
     * 
     * @param value Value to set
     */
    public void setRoleLevelId(Object value) {
        this.roleLevelId = value;
    }

    /**
     * Sets comment
     * 
     * @param value Value to set
     */
    public void setComment(Object value) {
        this.comment = value;
    }

    /**
     * Sets timeSpent
     * 
     * @param value Value to set
     */
    public void setTimeSpent(Object value) {
        this.timeSpent = value;
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
            final String _transformedIssueKey = ((String) evaluateAndTransform(getMuleContext(), event, AddWorklogAndRetainRemainingEstimateMessageProcessor.class.getDeclaredField("_issueKeyType").getGenericType(), null, issueKey));
            final String _transformedTimeSpent = ((String) evaluateAndTransform(getMuleContext(), event, AddWorklogAndRetainRemainingEstimateMessageProcessor.class.getDeclaredField("_timeSpentType").getGenericType(), null, timeSpent));
            final String _transformedStartDate = ((String) evaluateAndTransform(getMuleContext(), event, AddWorklogAndRetainRemainingEstimateMessageProcessor.class.getDeclaredField("_startDateType").getGenericType(), null, startDate));
            final String _transformedComment = ((String) evaluateAndTransform(getMuleContext(), event, AddWorklogAndRetainRemainingEstimateMessageProcessor.class.getDeclaredField("_commentType").getGenericType(), null, comment));
            final String _transformedGroupLevel = ((String) evaluateAndTransform(getMuleContext(), event, AddWorklogAndRetainRemainingEstimateMessageProcessor.class.getDeclaredField("_groupLevelType").getGenericType(), null, groupLevel));
            final String _transformedRoleLevelId = ((String) evaluateAndTransform(getMuleContext(), event, AddWorklogAndRetainRemainingEstimateMessageProcessor.class.getDeclaredField("_roleLevelIdType").getGenericType(), null, roleLevelId));
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
                    return ((JiraConnector) object).addWorklogAndRetainRemainingEstimate(_transformedIssueKey, _transformedTimeSpent, _transformedStartDate, _transformedComment, _transformedGroupLevel, _transformedRoleLevelId);
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
        return new DefaultResult<MetaData>(new DefaultMetaData(getPojoOrSimpleModel(RemoteWorklog.class)));
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
                    return new DefaultResult<MetaData>(null, (Result.Status.FAILURE), "There was an error processing metadata at JiraConnector at addWorklogAndRetainRemainingEstimate retrieving was successful but result is null");
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
