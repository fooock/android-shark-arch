package com.fooock.sharkarch.domain.rx;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Base class for all interactors that return an {@link io.reactivex.Observable}
 */
public abstract class BaseObservableInteractor<P, R> extends BaseRxInteractor<P, Observable<R>> {

    /**
     * Create this object
     *
     * @param mainThread     Main thread
     * @param threadExecutor Thread work executor
     */
    public BaseObservableInteractor(RxMainThread mainThread, RxThreadExecutor threadExecutor) {
        super(mainThread, threadExecutor);
    }

    /**
     * Execute this interactor with the given parameters
     *
     * @param observer Abstract observer
     * @param params   Parameters for this interactor
     */
    public final void execute(DisposableObserver<R> observer, P params) {
        Observable<R> obs = build(params).observeOn(mMainThread.get())
                .subscribeOn(mThreadExecutor.get());
        addDisposable(obs.subscribeWith(observer));
    }
}
