package com.mixky.mvprxjava;

import android.app.Application;
import android.content.Context;

import com.mixky.mvprxjava.utils.AppContextUtil;

/**
 * Created by Administrator on 2017/12/28.
 */

public class MyApplication extends Application {
    public static Context applicationContext;

    public static Context getContext() {
        return applicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppContextUtil.init(this);
        applicationContext = this;
    }
}
