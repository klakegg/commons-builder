package net.klakegg.commons.builder;

/**
 * @author erlend
 */
public interface BuildHandler<T, E extends Exception> {

    T build(Properties properties) throws E;

}