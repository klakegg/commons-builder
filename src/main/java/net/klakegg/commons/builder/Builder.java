package net.klakegg.commons.builder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author erlend
 */
public class Builder<T> {

    protected final BuildHandler<T> buildHandler;

    protected final Map<Property<?>, Object> map;

    public static <T> Builder<T> of(BuildHandler<T> buildHandler) {
        return new Builder<>(buildHandler, new HashMap<Property<?>, Object>());
    }

    public static <T> Builder<T> of(Properties properties, BuildHandler<T> buildHandler) {
        return new Builder<>(buildHandler, properties.map);
    }

    public static Builder<Properties> raw() {
        return of(new BuildHandler<Properties>() {
            @Override
            public Properties build(Properties properties) {
                return properties;
            }
        });
    }

    private Builder(BuildHandler<T> buildHandler, Map<Property<?>, Object> map) {
        this.buildHandler = buildHandler;
        this.map = map;
    }

    public <S> Builder<T> set(Property<S> property, S value) {
        Map<Property<?>, Object> map = new HashMap<>(this.map);
        map.put(property, value);

        return new Builder<>(buildHandler, map);
    }

    public <S> Builder<T> set(Property<List<S>> property, S... value) {
        Map<Property<?>, Object> map = new HashMap<>(this.map);
        map.put(property, Arrays.asList(value));

        return new Builder<>(buildHandler, map);
    }

    public T build() {
        return buildHandler.build(new Properties(map));
    }
}
