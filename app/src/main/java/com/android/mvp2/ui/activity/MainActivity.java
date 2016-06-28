package com.android.mvp2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.mvp2.R;
import com.android.mvp2.base.BaseActivity;

import javax.inject.Inject;

import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {

    private static final String TAG = MainActivity.class.getName();

    // Inject 当注解一个属性的时候，表示该属性需要依赖（需要被注入一个对象）。
    //        当注解一个构造函数的时候，表示该构造函数可以提供依赖。
    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMainPresenter.attachView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }


    @Override
    public int getLayoutId(){
        return R.layout.activity_main;
    }

    @Override
    public void injectDagger(){

        activityComponent().inject(this);
        //DaggerMainComponent.builder().mainPresenterModule(new MainPresenterModule(this)).build().inject(this);
    }

    @OnClick(R.id.id_main_button)
    public void onShowRepositoriesClick() {
        Log.e(TAG, "1. click");
        mMainPresenter.getClick();
    }

    @Override
    public void toReposListActivity() {
        Log.e(TAG, "3. click back");
        startActivity(new Intent(this, ReposListActivity.class));
    }
}
