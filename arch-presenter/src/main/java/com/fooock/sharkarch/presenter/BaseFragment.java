package com.fooock.sharkarch.presenter;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * Base class for all {@link android.app.Fragment}s
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Change the title of the current activity. Note that if the current
     * {@link android.app.Activity} is {@code null}, this method does not take
     * effect and the title wouldn't be changed
     * <p/>
     * This method expect as argument a localized string
     *
     * @param titleId String resource id for the title
     */
    protected void setTitle(@StringRes int titleId) {
        setTitle(getString(titleId));
    }

    /**
     * Change the title of the current activity. Note that if the current
     * {@link android.app.Activity} is {@code null}, this method does not take
     * effect and the title wouldn't be changed
     *
     * @param title New string for the activity title
     */
    protected void setTitle(@NonNull String title) {
        if (getActivity() == null) return;
        getActivity().setTitle(title);
    }
}
