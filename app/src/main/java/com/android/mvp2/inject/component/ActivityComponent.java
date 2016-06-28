package com.android.mvp2.inject.component;

import com.android.mvp2.inject.module.ActivityModule;
import com.android.mvp2.inject.module.GitHubApiModule;
import com.android.mvp2.inject.scope.ActivityScope;
import com.android.mvp2.ui.activity.MainActivity;
import com.android.mvp2.ui.activity.ReposListActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, GitHubApiModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    void inject(ReposListActivity reposListActivity);

}
