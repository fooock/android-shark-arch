package com.fooock.sharkarch.domain.rx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Completable;

import static org.mockito.Mockito.mock;

/**
 *
 */
public class BaseCompletableInteractorTest {

    private RxMainThread mRxMainThread;
    private RxThreadExecutor mRxThreadExecutor;
    private FakeCompletableInteractor mFakeCompletableInteractor;

    @Before
    public void setUp() {
        mRxMainThread = mock(RxMainThread.class);
        mRxThreadExecutor = mock(RxThreadExecutor.class);
        mFakeCompletableInteractor = new FakeCompletableInteractor(mRxMainThread, mRxThreadExecutor);
    }

    @Test
    public void testCompletableSuccess() {
        mFakeCompletableInteractor.build(1).test()
                .assertComplete()
                .assertNoErrors();
    }

    @After
    public void tearDown() {
        mFakeCompletableInteractor.close();
        mRxMainThread = null;
        mRxThreadExecutor = null;
        mFakeCompletableInteractor = null;
    }

    /**
     * Fake completable interactor
     */
    static class FakeCompletableInteractor extends BaseCompletableInteractor<Integer> {

        FakeCompletableInteractor(RxMainThread mainThread, RxThreadExecutor threadExecutor) {
            super(mainThread, threadExecutor);
        }

        @Override
        Completable build(Integer params) {
            return Completable.complete();
        }
    }
}