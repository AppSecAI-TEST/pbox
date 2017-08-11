package com.ipricebox.android.common.net;

import android.util.Log;

import com.ipricebox.android.common.lib.volley.Request;
import com.ipricebox.android.common.lib.volley.RequestQueue;
import com.ipricebox.android.common.util.JsonUtils;

public class NetManager {

	public static final String TAG = "NetManager";

	private NetRequestQueue mRequestQueue;

	private static class NetManagerHolder {
		private static NetManager sEngine = new NetManager();
	}

	public static NetManager getInstance() {
		return NetManagerHolder.sEngine;
	}

	private NetManager() {
		mRequestQueue = NetRequestQueue.getInstance();

	}

	public <T> void addToRequestQueue(Request<T> req, String tag) {
		if (mRequestQueue != null) {
			mRequestQueue.addToRequestQueue(req, tag);
		}
		print((GsonRequest<T>) req, tag);

	}

	private <T> void print(GsonRequest<T> req, String tag) {
		try {
			GsonRequest<T> cReq = req;
			String sUrl = "url=[ " + cReq.getUrl() + " ]  params= ["
					+ JsonUtils.toJson(cReq.getParams()) + " ]";
			Log.d(tag == null ? TAG : tag, sUrl);
		} catch (Exception e) {
		}
	}

	public <T> void addToRequestQueue(Request<T> req) {
		if (mRequestQueue != null) {
			mRequestQueue.addToRequestQueue(req);
		}

	}

	public void clearCache(Runnable r) {
		if (mRequestQueue != null) {
			mRequestQueue.clearCache(r);
		}
	}

	public RequestQueue getRequestQueue() {
		return mRequestQueue.getRequestQueue();
	}
}
