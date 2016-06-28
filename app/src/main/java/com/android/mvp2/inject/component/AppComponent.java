package com.android.mvp2.inject.component;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.android.mvp2.AppApplication;
import com.android.mvp2.inject.module.GitHubApiModule;
import com.android.mvp2.inject.scope.ApplicationContext;
import com.android.mvp2.ui.activity.MainActivity;
import com.android.mvp2.ui.activity.ReposListActivity;
import com.android.mvp2.inject.module.AppModule;
import com.android.mvp2.util.OSHelper;

import javax.inject.Singleton;

import dagger.Component;

// @Module 提供依赖，@Inject请求依赖，而@Component 就是联系这两者的纽带。
// Component 是modules与injection之间的桥接接口,有自己的生命周期，生命周期结束，接口下提供的对象也会被回收。
@Singleton
@Component(modules = { AppModule.class})
public interface AppComponent {

    void inject(AppApplication application);

    @ApplicationContext
    Context context();

    Application getApplication();

    // 写在这里是可以在使用的时候才开始创建；或者可以不写，直接通过在 ReposListActivity 注释 inject，这样的话在注入时就会得到OSHelper对象。
    OSHelper getOSHelper();

    // useless
    class Instance {
        private static AppComponent sComponent;

        public static void init(@NonNull AppComponent component) {
            sComponent = component;
        }

        public static AppComponent get() {
            return sComponent;
        }
    }
}