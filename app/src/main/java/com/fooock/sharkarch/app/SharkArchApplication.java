package com.fooock.sharkarch.app;

import android.app.Application;

/**
 * Base application class
 */
public abstract class SharkArchApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initialize();
    }

   /**
    *
    */
    abstract void initialize();
}