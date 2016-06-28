package com.android.mvp2.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.mvp2.AppApplication;
import com.android.mvp2.inject.component.ActivityComponent;
import com.android.mvp2.inject.component.DaggerActivityComponent;
import com.android.mvp2.inject.module.ActivityModule;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getLayoutId() != 0)
            setContentView(getLayoutId());

        ButterKnife.bind(this);
        injectDagger();
    }

    protected abstract void injectDagger();
    protected abstract int getLayoutId();


    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .appComponent(AppApplication.get(this).getAppComponent())
                    .build();
        }
        return mActivityComponent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    // base view implement

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void close() {

    }

    @Override
    public void showProgress(String msg) {

    }

    @Override
    public void showProgress(String msg, int progress) {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showErrorMessage(String msg, String content) {

    }
}