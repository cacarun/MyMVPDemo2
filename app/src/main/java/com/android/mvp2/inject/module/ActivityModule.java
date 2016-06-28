package com.android.mvp2.inject.module;

import android.app.Activity;
import android.content.Context;

import com.android.mvp2.inject.scope.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    Context provideContext() {
        return mActivity;
    }
}
