package com.ldroid.pbox.entities.in;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.ldroid.pbox.common.entities.InputEntity;

import java.util.Map;

public class UserPhoneInEntity extends InputEntity {

    @Expose
    public String userid;
    @Expose
    public String phone;


    public UserPhoneInEntity(String userid, String phone) {
        this.userid = userid;
        this.phone = phone;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("phone", phone);
        return params;
    }


    @Override
    public Boolean checkInput() {
        if (TextUtils.isEmpty(phone)) {
            errors.add("请输入电话号码");
            return false;
        }
        if (phone.length() < 11) {
            errors.add("电话号码格式不正确");
            return false;
        }
        return true;
    }
}
