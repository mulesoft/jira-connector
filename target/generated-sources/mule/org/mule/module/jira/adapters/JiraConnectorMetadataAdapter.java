
package org.mule.module.jira.adapters;

import javax.annotation.Generated;
import org.mule.api.MetadataAware;
import org.mule.module.jira.JiraConnector;


/**
 * A <code>JiraConnectorMetadataAdapter</code> is a wrapper around {@link JiraConnector } that adds support for querying metadata about the extension.
 * 
 */
@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class JiraConnectorMetadataAdapter
    extends JiraConnectorCapabilitiesAdapter
    implements MetadataAware
{

    private final static String MODULE_NAME = "Jira";
    private final static String MODULE_VERSION = "5.0.0";
    private final static String DEVKIT_VERSION = "3.7.1";
    private final static String DEVKIT_BUILD = "UNNAMED.2613.77421cc";
    private final static String MIN_MULE_VERSION = "3.6";

    public String getModuleName() {
        return MODULE_NAME;
    }

    public String getModuleVersion() {
        return MODULE_VERSION;
    }

    public String getDevkitVersion() {
        return DEVKIT_VERSION;
    }

    public String getDevkitBuild() {
        return DEVKIT_BUILD;
    }

    public String getMinMuleVersion() {
        return MIN_MULE_VERSION;
    }

}
