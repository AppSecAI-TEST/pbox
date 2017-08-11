package com.ipricebox.android.entities.out;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.module.main.tools.ToolsResultEntity;

import java.util.ArrayList;

/**
 * Created by xianglong.liang on 2017/7/31.
 */
public class ToolsTYOutEntity {


    @Expose
    public String SellingPrice1;
    @Expose
    public String SellingPrice2;
    @Expose
    public String SellingPrice3;
    @Expose
    public String Profit1;
    @Expose
    public String Profit2;
    @Expose
    public String Profit3;
    @Expose
    public String Cost1;
    @Expose
    public String Cost2;
    @Expose
    public String Cost3;
    @Expose
    public String HomeFreight1;
    @Expose
    public String ForeignFreight1;
    @Expose
    public String ForeignFreight2;
    @Expose
    public String ForeignFreight3;
    @Expose
    public String HomeFreight2;
    @Expose
    public String HomeFreight3;
    @Expose
    public String Incidentals1;
    @Expose
    public String Incidentals2;
    @Expose
    public String Incidentals3;
    @Expose
    public String Commission1;
    @Expose
    public String Commission2;
    @Expose
    public String Commission3;


    public ArrayList<ToolsResultEntity> generateList() {
        ArrayList<ToolsResultEntity> result = new ArrayList<>();
        result.add(new ToolsResultEntity("产品售价", SellingPrice1, SellingPrice2, SellingPrice3));
        result.add(new ToolsResultEntity("产品利润", Profit1, Profit2, Profit3));
        result.add(new ToolsResultEntity("采购成本", Cost1, Cost2, Cost3));
        result.add(new ToolsResultEntity("国内运费", HomeFreight1, HomeFreight2, HomeFreight3));
        result.add(new ToolsResultEntity("国外运费", ForeignFreight1, ForeignFreight2, ForeignFreight3));
        result.add(new ToolsResultEntity("杂        费", Incidentals1, Incidentals2, Incidentals3));
        result.add(new ToolsResultEntity("平台佣金", Commission1, Commission2, Commission3));


        return result;
    }

    /**
     SellingPrice1	产品售价(外币)
     SellingPrice2	产品售价(本币)
     SellingPrice3	产品售价(比例)
     Profit1	产品利润(外币)
     Profit2	产品利润(本币)
     Profit3	产品利润(比例)
     Cost1	采购成本(外币)
     Cost2	采购成本(本币)
     Cost3	采购成本(比例)
     HomeFreight1	E邮宝运费(外币)
     HomeFreight2	E邮宝运费(本币)
     HomeFreight3	E邮宝运费(比例)
     Incidentals1	杂费(外币)
     Incidentals2	杂费(本币)
     Incidentals3	杂费(比例)
     Commission1	平台佣金(外币)
     Commission2	平台佣金(本币)
     Commission3	平台佣金(比例)
     */

}
