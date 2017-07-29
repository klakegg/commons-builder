package net.klakegg.commons.builder;

/**
 * @author erlend
 */
public interface BuildHandler<T> {

    T perform(Properties properties);

}
