package com.ipricebox.android.entities.in;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class ToolsCountrysInEntity extends InputEntity {


    @Expose
    public String userid;
    @Expose
    public String type;


    public ToolsCountrysInEntity(String userid, String type) {
        this.userid = userid;
        this.type = type;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("type", type);
        return params;
    }

    @Override
    public Boolean checkInput() {
        return true;
    }


}
