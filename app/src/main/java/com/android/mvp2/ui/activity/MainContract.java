package com.android.mvp2.ui.activity;

import com.android.mvp2.base.BasePresenter;
import com.android.mvp2.base.BaseView;

/**
 * Created by cjw on 2016/6/28.
 */
public interface MainContract {

    interface Presenter extends BasePresenter<View> {
        void getClick();
    }

    interface View extends BaseView {
        void toReposListActivity();
    }

}
