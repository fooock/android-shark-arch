package com.fooock.sharkarch.domain;

import java.util.List;

/**
 * Mapper to transform a list from type {@code F} to type {@link T}
 */
public interface ListMapper<F, T> extends SimpleMapper<F, T> {

    /**
     * Map an entity from the given list of type {@code F} to list of type {@link T}
     *
     * @param from List od entities to be mapped
     * @return List of entities from type {@code T}
     */
    List<T> map(List<F> from);
}
