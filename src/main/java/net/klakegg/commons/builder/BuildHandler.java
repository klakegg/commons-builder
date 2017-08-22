package net.klakegg.commons.builder;

/**
 * @author erlend
 */
public interface BuildHandler<T> {

    T build(Properties properties);

}
