package com.fooock.sharkarch.domain;

/**
 * Simple mapper to transform an entity from type {@code F} to type {@link T}
 */
public interface SimpleMapper<F, T> {

    /**
     * Map an entity from the given type {@code F} to type {@link T}
     *
     * @param from Entity to be mapped
     * @return Entity from type {@code T}
     */
    T map(F from);
}
