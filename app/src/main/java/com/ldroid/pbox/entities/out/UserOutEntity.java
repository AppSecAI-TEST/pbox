package com.ldroid.pbox.entities.out;

import com.google.gson.annotations.Expose;
import com.ldroid.pbox.common.entities.BaseEntity;

public class UserOutEntity extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 415265707009583303L;

    @Expose public String UserID;
    @Expose public String UserCode;
    @Expose public String Phone;
    @Expose public String NickName;
    @Expose public String Avatar;
    @Expose public String IsSubscribed;
    @Expose public String SubscribeType;
    @Expose public String SubscribeStartTime;
    @Expose public String SubscribeEndTime;
    @Expose public String RegisteredTime;
    @Expose public String UpdatedTime;





}
