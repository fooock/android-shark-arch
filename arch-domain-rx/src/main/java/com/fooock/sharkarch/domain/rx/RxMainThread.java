package com.fooock.sharkarch.domain.rx;

import com.fooock.sharkarch.domain.Executor;

import io.reactivex.Scheduler;

/**
 * Thread where observe on
 */
public interface RxMainThread extends Executor<Scheduler> {

}
