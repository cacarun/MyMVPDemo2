package com.android.mvp2.util;

import android.preference.PreferenceManager;

import com.android.mvp2.inject.component.AppComponent;

/**
 * @author lsxiao
 * @date 2015-11-08 23:21
 */
public class SpUtil {
    public static void saveOrUpdate(String key, String json) {
        PreferenceManager.getDefaultSharedPreferences(AppComponent
                .Instance
                .get()
                .getApplication())
                .edit().putString(key, json).apply();
    }

    public static String find(String key) {
        return PreferenceManager.getDefaultSharedPreferences(AppComponent
                .Instance
                .get()
                .getApplication()).getString(key, null);
    }

    public static void delete(String key) {
        PreferenceManager.getDefaultSharedPreferences(AppComponent
                .Instance
                .get()
                .getApplication()).edit().remove(key).apply();
    }

    public static void clearAll() {
        PreferenceManager.getDefaultSharedPreferences(AppComponent
                .Instance
                .get()
                .getApplication()).edit().clear().apply();
    }
}
