package com.ipricebox.android.entities.in;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class LoginInEntity extends InputEntity {


    @Expose
    public String phone;
    @Expose
    public String password;

    public LoginInEntity(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }


    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("phone", phone);
        params.put("password", password);
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

        if (TextUtils.isEmpty(password)) {
            errors.add("请输入密码");
            return false;
        }
        return true;
    }
}
