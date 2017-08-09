package com.ldroid.pbox.dao;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.ldroid.pbox.MainApp;
import com.ldroid.pbox.common.util.JsonUtils;
import com.ldroid.pbox.entities.out.UserOutEntity;

public class ConfigDao {

    private static ConfigDao sInstance;
    private final String SETTING_INFOS = "xx";
    private final SharedPreferences mSharePref;
    private final Editor mEditor;

    public static ConfigDao getInstance() {
        if (sInstance == null) {
            synchronized (ConfigDao.class) {
                if (sInstance == null) {
                    sInstance = new ConfigDao(MainApp.getContext());
                }
            }
        }
        return sInstance;
    }

    private ConfigDao(Context context) {
        mSharePref = context.getSharedPreferences(SETTING_INFOS, Context.MODE_PRIVATE);
        mEditor = mSharePref.edit();
    }

    // //////////////////////////////////////////////////////////////////////////////////////////

    // //////////////////////////////////////////////////////////////////////////////////////////

    public void setUser(UserOutEntity user) {
        if (user != null) {
            mEditor.putString("user_info", JsonUtils.toJson(user)).commit();
        } else {
            mEditor.putString("user_info", "").commit();
        }
    }

    public UserOutEntity getUser() {
        String user = mSharePref.getString("user_info", "");
        if (TextUtils.isEmpty(user)) {
            return null;
        }
        return JsonUtils.fromJson(user, UserOutEntity.class);
    }

    public void setCookie(String s) {
        mEditor.putString("user_cookie", s).commit();
    }

    public String getCookie() {
        return mSharePref.getString("user_cookie", null);
    }

}
