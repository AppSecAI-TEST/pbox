package com.ipricebox.android.entities.in;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class UserAvatarInEntity extends InputEntity {

    @Expose
    public String userid;
    @Expose
    public String avatar;


    public UserAvatarInEntity(String userid, String nickname) {
        this.userid = userid;
        this.avatar = nickname;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("nickname", avatar);
        return params;
    }


    @Override
    public Boolean checkInput() {
        return true;
    }
}
