package com.fooock.sharkarch.domain.rx;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Base class for all interactors that return an {@link io.reactivex.Observable}
 */
public abstract class BaseObservableInteractor<P, R> extends BaseRxInteractor<P, Observable<R>> {

    public BaseObservableInteractor(RxMainThread mainThread, RxThreadExecutor threadExecutor) {
        super(mainThread, threadExecutor);
    }

    public void execute(DisposableObserver<R> observer, P params) {
        Observable<R> obs = build(params)
                .observeOn(mMainThread.get())
                .subscribeOn(mThreadExecutor.get());
        addDisposable(obs.subscribeWith(observer));
    }
}
