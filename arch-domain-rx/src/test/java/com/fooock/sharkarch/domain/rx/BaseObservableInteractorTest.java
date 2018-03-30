package com.fooock.sharkarch.domain.rx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import io.reactivex.Observable;

import static org.mockito.Mockito.mock;

/**
 *
 */
public class BaseObservableInteractorTest {

    private RxMainThread mRxMainThread;
    private RxThreadExecutor mRxThreadExecutor;
    private FakeObservableInteractor mFakeObservableInteractor;

    @Before
    public void setUp() {
        mRxMainThread = mock(RxMainThread.class);
        mRxThreadExecutor = mock(RxThreadExecutor.class);
        mFakeObservableInteractor = new FakeObservableInteractor(mRxMainThread, mRxThreadExecutor);
    }

    @Test
    public void testObservableResult() {
        mFakeObservableInteractor.build(1).test()
                .assertComplete()
                .assertNoErrors()
                .assertValue("1");
    }

    @After
    public void tearDown() {
        mFakeObservableInteractor.close();
        mRxMainThread = null;
        mRxThreadExecutor = null;
        mFakeObservableInteractor = null;
    }

    /**
     * Fake observable interactor
     */
    static class FakeObservableInteractor extends BaseObservableInteractor<Integer, String> {

        FakeObservableInteractor(RxMainThread mainThread, RxThreadExecutor threadExecutor) {
            super(mainThread, threadExecutor);
        }

        @Override
        Observable<String> build(Integer params) {
            return Observable.just(String.valueOf(params));
        }
    }
}