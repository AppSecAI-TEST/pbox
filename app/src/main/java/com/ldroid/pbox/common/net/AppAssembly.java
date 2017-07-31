package com.ldroid.pbox.common.net;

import android.content.res.Resources;

import com.ldroid.pbox.MainApp;

public class AppAssembly {

	private AppAssembly() {
	}

	public static Resources getResources() {
		return MainApp.getContext().getResources();
	}


	public static String getUrl() {
		return null ;
	}

}
