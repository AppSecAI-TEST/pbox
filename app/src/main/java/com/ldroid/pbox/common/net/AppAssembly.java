package com.ldroid.pbox.common.net;

import android.content.res.Resources;

import com.ldroid.pbox.MainApp;
import com.ldroid.pbox.R;

public class AppAssembly {

    private AppAssembly() {
    }

    public static Resources getResources() {
        return MainApp.getContext().getResources();
    }


    public static boolean isDebug() {
        return !getResources().getBoolean(R.bool.env_release);
    }

    public static String getUrl() {
        if (isDebug()) {
            return getResources().getString(R.string.url_debug);
        }
        return getResources().getString(R.string.url_release);
    }

}
