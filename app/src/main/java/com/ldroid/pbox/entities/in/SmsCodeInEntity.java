package com.ldroid.pbox.entities.in;

import com.google.gson.annotations.Expose;
import com.ldroid.pbox.common.entities.InputEntity;

import java.util.HashMap;
import java.util.Map;

public class SmsCodeInEntity extends InputEntity {


    @Expose
    public String phone;


    public SmsCodeInEntity(String phone) {
        this.phone = phone;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("phone", phone);
        return params;
    }
}
