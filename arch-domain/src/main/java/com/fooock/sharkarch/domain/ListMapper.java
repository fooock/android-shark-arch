package com.fooock.sharkarch.domain;

import java.util.List;

/**
 *
 */
public interface ListMapper<F, T> extends SimpleMapper<F, T> {

    List<T> map(List<F> from);
}
