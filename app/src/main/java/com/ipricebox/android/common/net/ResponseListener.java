/**
 * 
 */
package com.ipricebox.android.common.net;

import com.ipricebox.android.common.lib.volley.VolleyError;

public interface ResponseListener<T> {

	void onResponse(T response);

	void onErrorResponse(VolleyError error);

}
