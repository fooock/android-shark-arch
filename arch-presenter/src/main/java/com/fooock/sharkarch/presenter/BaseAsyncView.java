package com.fooock.sharkarch.presenter;

import android.support.annotation.StringRes;

/**
 * Base class used when the view needs to make async operations
 */
public interface BaseAsyncView<T> extends BaseView {

    /**
     * Method called to show any progress indicator in the screen. When this method is called,
     * an async operation normally starts
     */
    void onShowLoading();

    /**
     * Hide any progress indicator. Method called when the async operation finish or
     * an error occurs
     */
    void onHideLoading();

    /**
     * Show an error when occurs
     *
     * @param messageId String resource id
     * @param error     Throwable error
     */
    void onError(@StringRes int messageId, Throwable error);

    /**
     * Show the result of the async operation is success
     *
     * @param content Content to show in the view
     */
    void onShow(T content);

    /**
     * When no results found, this method should be called
     */
    void onEmptyContent();
}
