package com.fooock.sharkarch.domain.rx;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Base class for all interactors using rx
 */
public abstract class BaseRxInteractor<P, R> {

    final RxMainThread mMainThread;
    final RxThreadExecutor mThreadExecutor;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    /**
     * Creates this interactor
     *
     * @param mainThread     Thread to observe on
     * @param threadExecutor Thread to subscribe on
     */
    BaseRxInteractor(RxMainThread mainThread, RxThreadExecutor threadExecutor) {
        mMainThread = mainThread;
        mThreadExecutor = threadExecutor;
    }

    /**
     * Build this interactor with the given params
     *
     * @param params Params for this interactor
     * @return Interactor for the given type {@code R}
     */
    abstract R build(P params);

    /**
     * Add a disposable
     *
     * @param disposable Disposable to be added to the composite disposable
     */
    void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }

    /**
     * Close all disposables if not disposed
     */
    public void close() {
        if (!mCompositeDisposable.isDisposed()) mCompositeDisposable.dispose();
    }
}
