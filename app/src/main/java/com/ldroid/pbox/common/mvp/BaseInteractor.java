package com.ldroid.pbox.common.mvp;

import com.ldroid.pbox.common.entities.InputEntity;
import com.ldroid.pbox.common.lib.volley.Response;
import com.ldroid.pbox.common.lib.volley.VolleyError;
import com.ldroid.pbox.common.net.GsonRequest;
import com.ldroid.pbox.common.net.NetManager;
import com.ldroid.pbox.common.net.ResponseListener;

import java.lang.reflect.Type;

public abstract class BaseInteractor {

	public NetManager mNetManager;

	public BaseInteractor() {
		mNetManager = NetManager.getInstance();
	}

	public <In extends InputEntity, Out> void performRequest(InputEntity requester,
															 final ResponseListener<Out> listener, Type type, String tag) {
		GsonRequest<Out> req = new GsonRequest<Out>(requester.getUrl(),
				new Response.Listener<Out>() {
					@Override
					public void onResponse(Out response) {
						listener.onResponse(response);
					}

				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						listener.onErrorResponse(error);
					}
				}, requester);
		req.setTypeOfT(type);
		mNetManager.addToRequestQueue(req, tag);
	}

}
