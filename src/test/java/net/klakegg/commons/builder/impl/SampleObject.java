package net.klakegg.commons.builder.impl;

import net.klakegg.commons.builder.BuildHandler;
import net.klakegg.commons.builder.Builder;
import net.klakegg.commons.builder.Properties;
import net.klakegg.commons.builder.Property;

import java.util.List;

/**
 * @author erlend
 */
public class SampleObject {

    public static final Property<Boolean> BOOLEAN_PROPERTY = Property.create(true);

    public static final Property<String> STRING_PROPERTY = Property.create();

    public static final Property<List<String>> STRINGS_PROPERTY = Property.createList("Test", "123");

    private Properties properties;

    public static Builder<SampleObject, RuntimeException> builder() {
        return Builder.of(new BuildHandler<SampleObject, RuntimeException>() {
            @Override
            public SampleObject build(Properties properties) {
                return new SampleObject(properties);
            }
        });
    }

    private SampleObject(Properties properties) {
        this.properties = properties;
    }

    public <T> T get(Property<T> property) {
        return properties.get(property);
    }
}
