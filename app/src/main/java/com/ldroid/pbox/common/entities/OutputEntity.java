package com.ldroid.pbox.common.entities;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OutputEntity extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = -8297238643328522856L;

    @Expose
    @SerializedName("error_code")
    public String code;
    @Expose
    @SerializedName("error_msg")
    public String message;


    public String getErrorMsg() {
        return TextUtils.isEmpty(message) ? "网络或服务器异常" : message;
    }

}