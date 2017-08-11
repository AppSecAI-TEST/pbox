package com.ipricebox.android.entities.in;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class UserPhoneInEntity extends InputEntity {

    @Expose
    public String userid;
    @Expose
    public String oldphone;
    @Expose
    public String phone;
    @Expose
    public String code;


    public UserPhoneInEntity(String userid, String oldphone, String phone, String code) {
        this.userid = userid;
        this.oldphone = oldphone;
        this.phone = phone;
        this.code = code;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("oldphone", oldphone);
        params.put("phone", phone);
        params.put("code", code);
        return params;
    }


    @Override
    public Boolean checkInput() {
        if (TextUtils.isEmpty(oldphone)) {
            errors.add("请输入原电话号码");
            return false;
        }
        if (oldphone.length() < 11) {
            errors.add("原手机号码格式不正确");
            return false;
        }

        if (TextUtils.isEmpty(phone)) {
            errors.add("请输入新电话号码");
            return false;
        }
        if (phone.length() < 11) {
            errors.add("新手机号码格式不正确");
            return false;
        }
        if (TextUtils.isEmpty(code)) {
            errors.add("请输入验证码");
            return false;
        }
        return true;
    }
}
