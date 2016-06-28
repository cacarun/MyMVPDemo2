package com.android.mvp2;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.mvp2.inject.component.AppComponent;
import com.android.mvp2.inject.component.DaggerAppComponent;
import com.android.mvp2.inject.module.AppModule;

public class AppApplication extends Application {

//    private static AppApplication sInstance;
//
//    public static AppApplication getsInstance() {
//        return sInstance;
//    }

    private AppComponent mAppComponent = null;

    @Override
    public void onCreate() {
        super.onCreate();
//        this.sInstance = this;

        getAppComponent().inject(this);
    }

    public AppComponent getAppComponent() {

        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        }

        String band = mAppComponent.getOSHelper().getDeviceBrand();
        Log.e("App", band);

        return mAppComponent;
    }

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    public void setAppComponent(AppComponent appComponent) {
        mAppComponent = appComponent;
    }
}
