/**
 * 
 */
package com.ldroid.pbox.common.net;

import com.ldroid.pbox.common.lib.volley.VolleyError;

public interface ResponseListener<T> {

	void onResponse(T response);

	void onErrorResponse(VolleyError error);

}
