package com.fooock.sharkarch.presenter;

import android.app.Application;

/**
 * Base class for the Android {@link Application}. You can extend this class in
 * different flavors or build types to initialize custom things, like loggers, dependency
 * injection etc
 */
public abstract class BaseApplication extends Application {

    /**
     * Initialize this application. Note that you can have multiple application classes,
     * for example, for the debug and release build types, and initialize different
     * things like analytics systems for release builds.
     * <p/>
     * This method is called after {@link super#onCreate()}
     */
    protected abstract void initialize();

    @Override
    public final void onCreate() {
        super.onCreate();
        initialize();
    }
}
