package com.ipricebox.android.entities.in;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class ToolsWLZZInEntity extends InputEntity {


    @Expose
    public String userid;
    @Expose
    public String num;

    public ToolsWLZZInEntity(String userid, String num) {
        this.userid = userid;
        this.num = num;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("num", num);

        return params;
    }

    @Override
    public Boolean checkInput() {
        return true;
    }


    /**
     userid	int	是	用户ID
     num	string	是	快递单号
     */
}
