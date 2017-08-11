package com.ipricebox.android.module.main.tools;

import java.math.BigDecimal;

/**
 * Created by xianglong.liang on 2017/8/3.
 */
public class ToolsResultEntity {

    public String key;
    private String value1;
    public String value2;
    public String value3;

    public ToolsResultEntity() {
    }

    public ToolsResultEntity(String key, String value1, String value2, String value3) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public String getValue1() {
        return String.valueOf(parseDouble(value1));
    }

    public String getValue2() {
        return String.valueOf(parseDouble(value2));
    }

    public String getValue3() {
        return String.valueOf(parseDouble(value3));
    }


    double parseDouble(String s) {
        try {
            BigDecimal b = new BigDecimal(Double.parseDouble(s));
            return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        } catch (Exception e) {
        }
        return 0;
    }
}
