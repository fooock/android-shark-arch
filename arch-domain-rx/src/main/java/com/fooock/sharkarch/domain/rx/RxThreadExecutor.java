package com.fooock.sharkarch.domain.rx;

import com.fooock.sharkarch.domain.Executor;

import io.reactivex.Scheduler;

/**
 * Thread where subscribe on
 */
public interface RxThreadExecutor extends Executor<Scheduler> {

}
