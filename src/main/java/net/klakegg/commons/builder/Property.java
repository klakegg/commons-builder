package net.klakegg.commons.builder;

import java.util.*;

/**
 * @author erlend
 */
public class Property<T> {

    private final T defaultValue;

    public static <T> Property<T> create() {
        return new Property<>(null);
    }

    public static <T> Property<T> create(T defaultValue) {
        return new Property<>(defaultValue);
    }

    public static <T> Property<List<T>> serviceLoader(Class<T> tClass) {
        Iterator<T> iterator = ServiceLoader.load(tClass).iterator();
        List<T> result = new ArrayList<>();

        while (iterator.hasNext())
            result.add(iterator.next());

        return new Property<>(Collections.unmodifiableList(result));
    }

    private Property(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public T getDefaultValue() {
        return defaultValue;
    }

}
