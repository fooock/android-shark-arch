package com.fooock.sharkarch.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class BasePresenterTest {

    private FakePresenter mFakePresenter;
    private BaseView mBaseView;

    @Before
    public void setUp() throws Exception {
        mBaseView = Mockito.mock(BaseView.class);
        mFakePresenter = new FakePresenter();
        mFakePresenter.attach(mBaseView);
    }

    @After
    public void tearDown() throws Exception {
        mFakePresenter.detach();
        mFakePresenter = null;
    }

    @Test
    public void testPresenterAttached() throws Exception {
        assertTrue(mFakePresenter.isAttached());
        assertNotNull(mFakePresenter.getView());
    }

    @Test
    public void testPresenterDetached() throws Exception {
        mFakePresenter.detach();
        assertFalse(mFakePresenter.isAttached());
        assertNull(mFakePresenter.getView());
    }

    @Test
    public void testReattachPresenter() throws Exception {
        assertTrue(mFakePresenter.isAttached());
        mFakePresenter.detach();
        assertFalse(mFakePresenter.isAttached());
        mFakePresenter.attach(mBaseView);
        assertNotNull(mFakePresenter.getView());
    }

    /**
     * Fake presenter class just for testing
     */
    private static class FakePresenter extends BasePresenter<BaseView> {

    }
}
