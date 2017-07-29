package net.klakegg.commons.builder.impl;

import net.klakegg.commons.builder.BuildHandler;
import net.klakegg.commons.builder.Builder;
import net.klakegg.commons.builder.Properties;
import net.klakegg.commons.builder.Property;

/**
 * @author erlend
 */
public class SampleObject {

    public static final Property<Boolean> BOOLEAN_PROPERTY = Property.create(true);

    public static final Property<String> STRING_PROPERTY = Property.create();

    private Properties properties;

    public static Builder<SampleObject> builder() {
        return new Builder<>(new BuildHandler<SampleObject>() {
            @Override
            public SampleObject perform(Properties properties) {
                return new SampleObject(properties);
            }
        });
    }

    public SampleObject(Properties properties) {
        this.properties = properties;
    }

    public <T> T get(Property<T> property) {
        return properties.get(property);
    }
}
