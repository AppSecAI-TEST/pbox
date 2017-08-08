package com.ldroid.pbox.entities.in;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.ldroid.pbox.common.entities.InputEntity;

import java.util.Map;

public class RegisterInEntity extends InputEntity {


    @Expose
    public String nickname;
    @Expose
    public String phone;
    @Expose
    public String code;


    public RegisterInEntity(String nickname, String phone, String code) {
        this.nickname = nickname;
        this.phone = phone;
        this.code = code;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("nickname", nickname);
        params.put("phone", phone);
        params.put("code", code);
        return params;
    }


    @Override
    public Boolean checkInput() {
        if (TextUtils.isEmpty(nickname)) {
            errors.add("请输入昵称");
            return false;
        }
        if (TextUtils.isEmpty(phone)) {
            errors.add("请输入电话号码");
            return false;
        }
        if (phone.length() < 11) {
            errors.add("电话号码格式不正确");
            return false;
        }
        if (TextUtils.isEmpty(code)) {
            errors.add("请输入验证码");
            return false;
        }
        return true;
    }
}
