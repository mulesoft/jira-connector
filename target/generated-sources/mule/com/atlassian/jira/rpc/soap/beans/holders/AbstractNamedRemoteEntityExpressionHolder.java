
package com.atlassian.jira.rpc.soap.beans.holders;

import javax.annotation.Generated;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class AbstractNamedRemoteEntityExpressionHolder
    extends AbstractRemoteEntityExpressionHolder
{

    protected Object name;
    protected String _nameType;

    /**
     * Sets name
     * 
     * @param value Value to set
     */
    public void setName(Object value) {
        this.name = value;
    }

    /**
     * Retrieves name
     * 
     */
    public Object getName() {
        return this.name;
    }

}
