package com.ldroid.pbox.common.net;

import com.google.gson.JsonSyntaxException;
import com.ldroid.pbox.common.entities.InputEntity;
import com.ldroid.pbox.common.lib.volley.AuthFailureError;
import com.ldroid.pbox.common.lib.volley.NetworkResponse;
import com.ldroid.pbox.common.lib.volley.ParseError;
import com.ldroid.pbox.common.lib.volley.Request;
import com.ldroid.pbox.common.lib.volley.Response;
import com.ldroid.pbox.common.lib.volley.Response.ErrorListener;
import com.ldroid.pbox.common.lib.volley.Response.Listener;
import com.ldroid.pbox.common.lib.volley.toolbox.HttpHeaderParser;
import com.ldroid.pbox.common.util.JsonUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class GsonRequest<T> extends Request<T> {

	private Listener<T> mListener;
	private Type mTypeOfT;
	private InputEntity mIn;

	/**
	 * 
	 * @param method
	 *            {@link Method}
	 * @param url
	 * @param listener
	 * @param errorListener
	 */
	public GsonRequest(int method, String url, Listener<T> listener, ErrorListener errorListener) {
		super(method, url, errorListener);
		mListener = listener;
	}

	public GsonRequest(String url, Listener<T> listener, ErrorListener errorListener) {
		this(Method.POST, url, listener, errorListener);
	}

	public <In extends InputEntity> GsonRequest(String url, Listener<T> listener,
												ErrorListener errorListener, In in) {
		this(Method.POST, url, listener, errorListener);
		this.mIn = in;
	}

	public void setTypeOfT(Type typeOfT) {
		this.mTypeOfT = typeOfT;
	}

	@Override
	public Map<String, String> getParams() throws AuthFailureError {
		return this.mIn.getParams();
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		try {
			String jsonString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			// applicaton/json
			JSONObject jsonResponse = new JSONObject(jsonString) ;
			T parsedGSON = JsonUtils.fromJson(jsonResponse.toString(), mTypeOfT);
//			return (Response<T>) Response.success(new JSONObject(jsonString),
//					HttpHeaderParser.parseCacheHeaders(response));
			return Response.success(parsedGSON, HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException je) {
			return Response.error(new ParseError(je));
		} catch (JSONException e) {
			return Response.error(new ParseError(e));
		}
	}

	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		HashMap<String, String> headers = new HashMap<String, String>();
		//headers.put("Accept-Encoding", "gzip");
		return headers;
	}

}