package com.ipricebox.android.entities.in;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class ToolsPZHSInEntity extends InputEntity {


    @Expose
    public String userid;
   @Expose public String length;
   @Expose public String width;
   @Expose public String height;
   @Expose public String countingbase;


    public ToolsPZHSInEntity(String userid, String length, String width, String height, String countingbase) {
        this.userid = userid;
        this.length = length;
        this.width = width;
        this.height = height;
        this.countingbase = countingbase;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("length", length);
        params.put("width", width);
        params.put("height", height);
        params.put("countingbase", countingbase);

        return params;
    }

    @Override
    public Boolean checkInput() {
        return true;
    }


    /**
     userid	int	是	用户ID
     length	int	是	长度
     width	int	是	宽度
     height	int	是	高度
     countingbase	decimal	是	计抛基数
     */
}
