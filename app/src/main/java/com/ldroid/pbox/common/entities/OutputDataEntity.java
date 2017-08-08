package com.ldroid.pbox.common.entities;


import com.google.gson.annotations.Expose;

public class OutputDataEntity<Data> extends OutputEntity {
    /**
     *
     */
    private static final long serialVersionUID = -8297238643328522856L;


    @Expose
    public Data data;

}