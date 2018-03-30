package com.fooock.sharkarch.domain.rx;

import io.reactivex.Completable;
import io.reactivex.observers.DisposableCompletableObserver;

/**
 * Base class for all interactors that return an {@link Completable}
 */
public abstract class BaseCompletableInteractor<P> extends BaseRxInteractor<P, Completable> {

    /**
     * Creates this interactor
     *
     * @param mainThread     Thread to observe on
     * @param threadExecutor Thread to subscribe on
     */
    public BaseCompletableInteractor(RxMainThread mainThread, RxThreadExecutor threadExecutor) {
        super(mainThread, threadExecutor);
    }

    /**
     * Execute this interactor with the given parameters. Note that the result of this
     * interactor only can be success or failure, by the nature of {@link Completable}
     *
     * @param observer Abstract observer
     * @param params   Parameters for this interactor
     */
    public final void execute(DisposableCompletableObserver observer, P params) {
        Completable completable = build(params).observeOn(mMainThread.get())
                .subscribeOn(mThreadExecutor.get());
        addDisposable(completable.subscribeWith(observer));
    }
}
