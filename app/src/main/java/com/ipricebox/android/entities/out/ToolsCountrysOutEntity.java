package com.ipricebox.android.entities.out;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.BaseEntity;

import java.util.ArrayList;

public class ToolsCountrysOutEntity extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 415265707009583303L;

    @Expose
    public ArrayList<CountrysEntity> Countrys;


    public class CountrysEntity {
        @Expose
        public String CountryName;
    }
}
