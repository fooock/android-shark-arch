package com.fooock.sharkarch.presenter;

import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Base class for all presenters
 */
public abstract class BasePresenter<V extends BaseView> {

    private V mView;

    /**
     * Attach the given view to this presenter
     *
     * @param view View to attach to this presenter
     */
    @CallSuper
    public void attach(@NonNull V view) {
        mView = view;
    }

    /**
     * Detach the view from this presenter
     */
    @CallSuper
    public void detach() {
        mView = null;
    }

    /**
     * Check if this presenter is attached to the view
     *
     * @return True if attached, false otherwise
     */
    public final boolean isAttached() {
        return mView != null;
    }

    /**
     * Get the view attached to this presenter if any
     *
     * @return Attached view if any
     */
    @Nullable
    public final V getView() {
        return mView;
    }
}
