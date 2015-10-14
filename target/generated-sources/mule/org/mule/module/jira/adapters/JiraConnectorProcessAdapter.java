
package org.mule.module.jira.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.module.jira.JiraConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>JiraConnectorProcessAdapter</code> is a wrapper around {@link JiraConnector } that enables custom processing strategies.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class JiraConnectorProcessAdapter
    extends JiraConnectorLifecycleInjectionAdapter
    implements ProcessAdapter<JiraConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, JiraConnectorCapabilitiesAdapter> getProcessTemplate() {
        final JiraConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,JiraConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, JiraConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, JiraConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
