package com.ipricebox.android.entities.out;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.BaseEntity;

public class SmsOutEntity extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 415265707009583303L;

    @Expose
    public String phone;

}
