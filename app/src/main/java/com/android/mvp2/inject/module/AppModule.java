package com.android.mvp2.inject.module;

import android.app.Application;
import android.content.Context;

import com.android.mvp2.inject.scope.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

// Module 用来提供依赖，或者通俗的说，完成各种对象的实例化的一个集合。类里面可以包含很多 @Provides 注解的方法，每个方法对应一种对象的创建。
@Singleton
@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application){
        this.mApplication = application;
    }

    @Provides
    public Application provideApplication(){
        return mApplication;
    }

    @Provides
    @ApplicationContext
    public Context provideContext() {
        return mApplication;
    }
}