package com.ldroid.pbox.entities.out;

import com.google.gson.annotations.Expose;
import com.ldroid.pbox.module.main.tools.ToolsResultEntity;

import java.util.ArrayList;

/**
 * Created by xianglong.liang on 2017/7/31.
 */
public class ToolsHWCOutEntity {


    @Expose public String Type ; // 类型(1:单品; 2:批量)
    @Expose public String SellingPrice1 ;
    @Expose public String SellingPrice2 ;
    @Expose public String SellingPrice3 ;
    @Expose public String Profit1 ;
    @Expose public String Profit2 ;
    @Expose public String Profit3 ;
    @Expose public String Cost1 ;
    @Expose public String Cost2 ;
    @Expose public String Cost3 ;
    @Expose public String HomeFreight1 ;
    @Expose public String HomeFreight2 ;
    @Expose public String HomeFreight3 ;
    @Expose public String FirstFreight1 ;
    @Expose public String FirstFreight2 ;
    @Expose public String FirstFreight3 ;
    @Expose public String SecondFreight1 ;
    @Expose public String SecondFreight2 ;
    @Expose public String SecondFreight3 ;
    @Expose public String Incidentals1 ;
    @Expose public String Incidentals2 ;
    @Expose public String Incidentals3 ;
    @Expose public String Commission1 ;
    @Expose public String Commission2 ;
    @Expose public String Commission3 ;
    @Expose public String CapitalCost1 ;
    @Expose public String CapitalCost2 ;
    @Expose public String CapitalCost3 ;

    public ArrayList<ToolsResultEntity> generateList() {
        ArrayList<ToolsResultEntity> result = new ArrayList<>();
        result.add(new ToolsResultEntity("产品售价", SellingPrice1, SellingPrice2, SellingPrice3));
        result.add(new ToolsResultEntity("产品利润", Profit1, Profit2, Profit3));
        result.add(new ToolsResultEntity("采购成本", Cost1, Cost2, Cost3));
        result.add(new ToolsResultEntity("国内运费", HomeFreight1, HomeFreight2, HomeFreight3));
        result.add(new ToolsResultEntity("头程运费", FirstFreight1, FirstFreight2, FirstFreight3));
        result.add(new ToolsResultEntity("后程运费", SecondFreight1, SecondFreight2, SecondFreight3));
        result.add(new ToolsResultEntity("其他杂费", Incidentals1, Incidentals2, Incidentals3));
        result.add(new ToolsResultEntity("平台佣金", Commission1, Commission1, Commission1));
        result.add(new ToolsResultEntity("资金成本", CapitalCost2, CapitalCost2, CapitalCost3));


        return result;
    }

    /**
     Type	类型(1:单品; 2:批量)
     SellingPrice1	产品售价(外币)
     SellingPrice2	产品售价(本币)
     SellingPrice3	产品售价(比例)
     Profit1	产品利润(外币)
     Profit2	产品利润(本币)
     Profit3	产品利润(比例)
     Cost1	采购成本(外币)
     Cost2	采购成本(本币)
     Cost3	采购成本(比例)
     HomeFreight1	国内运费(外币)
     HomeFreight2	国内运费(本币)
     HomeFreight3	国内运费(比例)
     FirstFreight1	头程运费(外币)
     FirstFreight2	头程运费(本币)
     FirstFreight3	头程运费(比例)
     SecondFreight1	后程运费(外币)
     SecondFreight2	后程运费(本币)
     SecondFreight3	后程运费(比例)
     Incidentals1	杂费(外币)
     Incidentals2	杂费(本币)
     Incidentals3	杂费(比例)
     Commission1	平台佣金(外币)
     Commission2	平台佣金(本币)
     Commission3	平台佣金(比例)
     */

}
