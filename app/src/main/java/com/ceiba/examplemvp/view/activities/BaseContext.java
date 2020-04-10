package com.ceiba.examplemvp.view.activities;

import android.app.Application;
import android.content.Context;

public class BaseContext extends Application {

    private static Context context;

    public static Context getContext() {
        return BaseContext.context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        BaseContext.context = getApplicationContext();
    }
}
