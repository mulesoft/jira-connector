
package org.mule.module.jira.transformers;

import java.util.Calendar;
import javax.annotation.Generated;
import javax.xml.bind.DatatypeConverter;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@SuppressWarnings("all")
@Generated(value = "Mule DevKit Version 3.7.1", date = "2015-10-14T02:51:30-03:00", comments = "Build UNNAMED.2613.77421cc")
public class StringToCalendarTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int priorityWeighting = 1;

    public StringToCalendarTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(Calendar.class);
        setName("StringToCalendarTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        try {
            return DatatypeConverter.parseDateTime(src.toString());
        } catch (IllegalArgumentException e) {
            throw new TransformerException(MessageFactory.createStaticMessage(String.format("Could not parse %s as a valid xsd:dateTime", src)), this, e);
        }
    }

    /**
     * Retrieves priorityWeighting
     * 
     */
    public int getPriorityWeighting() {
        return this.priorityWeighting;
    }

    /**
     * Sets priorityWeighting
     * 
     * @param value Value to set
     */
    public void setPriorityWeighting(int value) {
        this.priorityWeighting = value;
    }

}
