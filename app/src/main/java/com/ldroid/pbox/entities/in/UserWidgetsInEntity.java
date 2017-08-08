package com.ldroid.pbox.entities.in;

import com.google.gson.annotations.Expose;
import com.ldroid.pbox.common.entities.InputEntity;

import java.util.Map;

public class UserWidgetsInEntity extends InputEntity {


    @Expose
    public String userid;
    @Expose
    public String actiontype; //操作类型（1:初次订阅 2:续订）
    @Expose
    public String widgetstype; // 订阅类型（1:一个月 2:三个月 3:半年 4:一年）
    @Expose
    public String price;

    @Expose
    public String starttime;
    @Expose
    public String endtime;


    public UserWidgetsInEntity(String userid, String actiontype, String widgetstype, String price, String starttime, String endtime) {
        this.userid = userid;
        this.actiontype = actiontype;
        this.widgetstype = widgetstype;
        this.price = price;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("actiontype", actiontype);
        params.put("widgetstype", widgetstype);
        params.put("price", price);
        params.put("starttime", starttime);
        params.put("endtime", endtime);
        return params;
    }

    @Override
    public Boolean checkInput() {

        return true;
    }
}
