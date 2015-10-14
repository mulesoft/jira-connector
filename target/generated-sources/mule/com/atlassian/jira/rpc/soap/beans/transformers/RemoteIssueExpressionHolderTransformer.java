
package com.atlassian.jira.rpc.soap.beans.transformers;

import com.atlassian.jira.rpc.soap.beans.RemoteComponent;
import com.atlassian.jira.rpc.soap.beans.RemoteCustomFieldValue;
import com.atlassian.jira.rpc.soap.beans.RemoteIssue;
import com.atlassian.jira.rpc.soap.beans.RemoteVersion;
import com.atlassian.jira.rpc.soap.beans.holders.AbstractRemoteEntityExpressionHolder;
import com.atlassian.jira.rpc.soap.beans.holders.RemoteIssueExpressionHolder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.api.endpoint.ImmutableEndpoint;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.transformer.DataType;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.MessageTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transformer.TransformerMessagingException;
import org.mule.config.i18n.CoreMessages;
import org.mule.devkit.processor.ExpressionEvaluatorSupport;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class RemoteIssueExpressionHolderTransformer
    extends ExpressionEvaluatorSupport
    implements DiscoverableTransformer, MessageTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;
    private ImmutableEndpoint endpoint;
    private MuleContext muleContext;
    private String name;

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

    public boolean isSourceTypeSupported(Class<?> aClass) {
        return (aClass == RemoteIssueExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == RemoteIssueExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {RemoteIssueExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(RemoteIssueExpressionHolder.class)});
    }

    public boolean isAcceptNull() {
        return false;
    }

    public boolean isIgnoreBadInput() {
        return false;
    }

    public Object transform(Object src)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public Object transform(Object src, String encoding)
        throws TransformerException
    {
        throw new UnsupportedOperationException();
    }

    public void setReturnClass(Class<?> theClass) {
        throw new UnsupportedOperationException();
    }

    public Class<?> getReturnClass() {
        return RemoteIssue.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(RemoteIssue.class);
    }

    public void setEndpoint(ImmutableEndpoint ep) {
        endpoint = ep;
    }

    public ImmutableEndpoint getEndpoint() {
        return endpoint;
    }

    public void dispose() {
    }

    public void initialise()
        throws InitialisationException
    {
    }

    public void setMuleContext(MuleContext context) {
        muleContext = context;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public Object transform(Object src, MuleEvent event)
        throws TransformerMessagingException
    {
        return transform(src, null, event);
    }

    public Object transform(Object src, String encoding, MuleEvent event)
        throws TransformerMessagingException
    {
        if (src == null) {
            return null;
        }
        RemoteIssueExpressionHolder holder = ((RemoteIssueExpressionHolder) src);
        RemoteIssue result = new RemoteIssue();
        try {
            final RemoteVersion[] _transformedAffectsVersions = ((RemoteVersion[]) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_affectsVersionsType").getGenericType(), null, holder.getAffectsVersions()));
            result.setAffectsVersions(_transformedAffectsVersions);
            final String _transformedAssignee = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_assigneeType").getGenericType(), null, holder.getAssignee()));
            result.setAssignee(_transformedAssignee);
            final String[] _transformedAttachmentNames = ((String[]) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_attachmentNamesType").getGenericType(), null, holder.getAttachmentNames()));
            result.setAttachmentNames(_transformedAttachmentNames);
            final RemoteComponent[] _transformedComponents = ((RemoteComponent[]) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_componentsType").getGenericType(), null, holder.getComponents()));
            result.setComponents(_transformedComponents);
            final Calendar _transformedCreated = ((Calendar) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_createdType").getGenericType(), null, holder.getCreated()));
            result.setCreated(_transformedCreated);
            final RemoteCustomFieldValue[] _transformedCustomFieldValues = ((RemoteCustomFieldValue[]) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_customFieldValuesType").getGenericType(), null, holder.getCustomFieldValues()));
            result.setCustomFieldValues(_transformedCustomFieldValues);
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final Calendar _transformedDuedate = ((Calendar) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_duedateType").getGenericType(), null, holder.getDuedate()));
            result.setDuedate(_transformedDuedate);
            final String _transformedEnvironment = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_environmentType").getGenericType(), null, holder.getEnvironment()));
            result.setEnvironment(_transformedEnvironment);
            final RemoteVersion[] _transformedFixVersions = ((RemoteVersion[]) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_fixVersionsType").getGenericType(), null, holder.getFixVersions()));
            result.setFixVersions(_transformedFixVersions);
            final String _transformedKey = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_keyType").getGenericType(), null, holder.getKey()));
            result.setKey(_transformedKey);
            final String _transformedPriority = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_priorityType").getGenericType(), null, holder.getPriority()));
            result.setPriority(_transformedPriority);
            final String _transformedProject = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_projectType").getGenericType(), null, holder.getProject()));
            result.setProject(_transformedProject);
            final String _transformedReporter = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_reporterType").getGenericType(), null, holder.getReporter()));
            result.setReporter(_transformedReporter);
            final String _transformedResolution = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_resolutionType").getGenericType(), null, holder.getResolution()));
            result.setResolution(_transformedResolution);
            final String _transformedStatus = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_statusType").getGenericType(), null, holder.getStatus()));
            result.setStatus(_transformedStatus);
            final String _transformedSummary = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_summaryType").getGenericType(), null, holder.getSummary()));
            result.setSummary(_transformedSummary);
            final String _transformedType = ((String) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_typeType").getGenericType(), null, holder.getType()));
            result.setType(_transformedType);
            final Calendar _transformedUpdated = ((Calendar) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_updatedType").getGenericType(), null, holder.getUpdated()));
            result.setUpdated(_transformedUpdated);
            final Long _transformedVotes = ((Long) evaluateAndTransform(this.muleContext, event, RemoteIssueExpressionHolder.class.getDeclaredField("_votesType").getGenericType(), null, holder.getVotes()));
            result.setVotes(_transformedVotes);
            final String _transformedId = ((String) evaluateAndTransform(this.muleContext, event, AbstractRemoteEntityExpressionHolder.class.getDeclaredField("_idType").getGenericType(), null, holder.getId()));
            result.setId(_transformedId);
        } catch (NoSuchFieldException e) {
            throw new TransformerMessagingException(CoreMessages.createStaticMessage("internal error"), event, this, e);
        } catch (TransformerException e) {
            throw new TransformerMessagingException(e.getI18nMessage(), event, this, e);
        }
        return result;
    }

    public MuleEvent process(MuleEvent event) {
        return null;
    }

    public String getMimeType() {
        return null;
    }

    public String getEncoding() {
        return null;
    }

    public MuleContext getMuleContext() {
        return muleContext;
    }

}
