package com.android.mvp2.ui.activity;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by cjw on 2016/6/27.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;
    private Context mContext;

    @Inject
    public MainPresenter( Context context) {
        this.mContext = context;
    }

    @Override
    public void getClick() {
        Log.e("MainPresenterImpl", "2. in P");
        mView.toReposListActivity();
    }

    @Override
    public void attachView(MainContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        // if (mSubscription != null) mSubscription.unsubscribe();
    }
}
