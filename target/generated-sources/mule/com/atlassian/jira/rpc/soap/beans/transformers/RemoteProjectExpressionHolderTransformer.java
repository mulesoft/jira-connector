
package com.atlassian.jira.rpc.soap.beans.transformers;

import com.atlassian.jira.rpc.soap.beans.RemotePermissionScheme;
import com.atlassian.jira.rpc.soap.beans.RemoteProject;
import com.atlassian.jira.rpc.soap.beans.RemoteScheme;
import com.atlassian.jira.rpc.soap.beans.holders.AbstractNamedRemoteEntityExpressionHolder;
import com.atlassian.jira.rpc.soap.beans.holders.AbstractRemoteEntityExpressionHolder;
import com.atlassian.jira.rpc.soap.beans.holders.RemoteProjectExpressionHolder;
import java.util.Arrays;
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
public class RemoteProjectExpressionHolderTransformer
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
        return (aClass == RemoteProjectExpressionHolder.class);
    }

    public boolean isSourceDataTypeSupported(DataType<?> dataType) {
        return (dataType.getType() == RemoteProjectExpressionHolder.class);
    }

    public List<Class<?>> getSourceTypes() {
        return Arrays.asList(new Class<?> [] {RemoteProjectExpressionHolder.class });
    }

    public List<DataType<?>> getSourceDataTypes() {
        return Arrays.asList(new DataType<?> [] {DataTypeFactory.create(RemoteProjectExpressionHolder.class)});
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
        return RemoteProject.class;
    }

    public void setReturnDataType(DataType<?> type) {
        throw new UnsupportedOperationException();
    }

    public DataType<?> getReturnDataType() {
        return DataTypeFactory.create(RemoteProject.class);
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
        RemoteProjectExpressionHolder holder = ((RemoteProjectExpressionHolder) src);
        RemoteProject result = new RemoteProject();
        try {
            final String _transformedDescription = ((String) evaluateAndTransform(this.muleContext, event, RemoteProjectExpressionHolder.class.getDeclaredField("_descriptionType").getGenericType(), null, holder.getDescription()));
            result.setDescription(_transformedDescription);
            final RemoteScheme _transformedIssueSecurityScheme = ((RemoteScheme) evaluateAndTransform(this.muleContext, event, RemoteProjectExpressionHolder.class.getDeclaredField("_issueSecuritySchemeType").getGenericType(), null, holder.getIssueSecurityScheme()));
            result.setIssueSecurityScheme(_transformedIssueSecurityScheme);
            final String _transformedKey = ((String) evaluateAndTransform(this.muleContext, event, RemoteProjectExpressionHolder.class.getDeclaredField("_keyType").getGenericType(), null, holder.getKey()));
            result.setKey(_transformedKey);
            final String _transformedLead = ((String) evaluateAndTransform(this.muleContext, event, RemoteProjectExpressionHolder.class.getDeclaredField("_leadType").getGenericType(), null, holder.getLead()));
            result.setLead(_transformedLead);
            final RemoteScheme _transformedNotificationScheme = ((RemoteScheme) evaluateAndTransform(this.muleContext, event, RemoteProjectExpressionHolder.class.getDeclaredField("_notificationSchemeType").getGenericType(), null, holder.getNotificationScheme()));
            result.setNotificationScheme(_transformedNotificationScheme);
            final RemotePermissionScheme _transformedPermissionScheme = ((RemotePermissionScheme) evaluateAndTransform(this.muleContext, event, RemoteProjectExpressionHolder.class.getDeclaredField("_permissionSchemeType").getGenericType(), null, holder.getPermissionScheme()));
            result.setPermissionScheme(_transformedPermissionScheme);
            final String _transformedProjectUrl = ((String) evaluateAndTransform(this.muleContext, event, RemoteProjectExpressionHolder.class.getDeclaredField("_projectUrlType").getGenericType(), null, holder.getProjectUrl()));
            result.setProjectUrl(_transformedProjectUrl);
            final String _transformedUrl = ((String) evaluateAndTransform(this.muleContext, event, RemoteProjectExpressionHolder.class.getDeclaredField("_urlType").getGenericType(), null, holder.getUrl()));
            result.setUrl(_transformedUrl);
            final String _transformedName = ((String) evaluateAndTransform(this.muleContext, event, AbstractNamedRemoteEntityExpressionHolder.class.getDeclaredField("_nameType").getGenericType(), null, holder.getName()));
            result.setName(_transformedName);
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
