package com.ipricebox.android.entities.in;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class UserNickNameInEntity extends InputEntity {

    @Expose
    public String userid;
    @Expose
    public String nickname;


    public UserNickNameInEntity(String userid, String nickname) {
        this.userid = userid;
        this.nickname = nickname;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("nickname", nickname);
        return params;
    }


    @Override
    public Boolean checkInput() {
        if (TextUtils.isEmpty(nickname)) {
            errors.add("请输入昵称");
            return false;
        }
        return true;
    }
}
