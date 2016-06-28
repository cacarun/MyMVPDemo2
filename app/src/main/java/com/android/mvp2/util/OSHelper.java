package com.android.mvp2.util;

import android.os.Build;

import javax.inject.Inject;

/**
 * Created by cjw on 2016/6/28.
 */
public class OSHelper {
    @Inject
    public OSHelper() {  //inject 注解的构造函数是必要的
    }

    public String getDeviceBrand() {
        return Build.BRAND;
    }
}
