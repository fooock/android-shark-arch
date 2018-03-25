package com.fooock.sharkarch.domain;

/**
 *
 */
public interface SimpleMapper<F, T> {

    T map(F from);
}
