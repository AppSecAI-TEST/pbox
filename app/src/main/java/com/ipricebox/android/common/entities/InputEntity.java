package com.ipricebox.android.common.entities;


import com.ipricebox.android.common.net.AppAssembly;
import com.ipricebox.android.common.util.JsonUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class InputEntity {

    protected ArrayList<String> errors = new ArrayList<String>();

    protected String method;

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean checkInput() {
        return true;
    }

    public ArrayList<String> getErrors() {
        return this.errors;
    }

    public Map<String, String> getParams() {
        HashMap<String, String> params = new HashMap<>();
        //params.put("data", jsonThis());
        params.put("appid", "92a9ec6a-7c67-422a-8011-c32d24361ee8");
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        return params;
    }

    public String jsonThis() {
        return JsonUtils.toJson(this);
    }

    public String getUrlPrefix() {
        return AppAssembly.getUrl();
    }

    public String getUrl() {
        return new StringBuffer().append(getUrlPrefix()).append(method).toString();
    }

}