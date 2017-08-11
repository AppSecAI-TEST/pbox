package com.ipricebox.android.entities.in;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class ToolsCBLRInEntity extends InputEntity {


    @Expose
    public String userid;
    @Expose
    public String productname;
    @Expose
    public String countryname;
    @Expose
    public String sellingprice;
    @Expose
    public String cost;
    @Expose
    public String grossfreight2;
    @Expose
    public String incidentals;
    @Expose
    public String exchangerate1;
    @Expose
    public String exchangerate2;

    public ToolsCBLRInEntity(String userid, String productname, String countryname, String sellingprice, String cost, String grossfreight2, String incidentals, String exchangerate1, String exchangerate2) {
        this.userid = userid;
        this.productname = productname;
        this.countryname = countryname;
        this.sellingprice = sellingprice;
        this.cost = cost;
        this.grossfreight2 = grossfreight2;
        this.incidentals = incidentals;
        this.exchangerate1 = exchangerate1;
        this.exchangerate2 = exchangerate2;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("productname", productname);
        params.put("countryname", countryname);
        params.put("sellingprice", sellingprice);
        params.put("cost", cost);
        params.put("grossfreight2", grossfreight2);
        params.put("incidentals", incidentals);
        params.put("exchangerate1", exchangerate1);
        params.put("exchangerate2", exchangerate2);

        return params;
    }

    @Override
    public Boolean checkInput() {
        return true;
    }


    /**
     userid	int	是	用户ID
     productname	string	是	产品名称
     countryname	string	是	国家
     sellingprice	decimal	是	产品售价
     cost	decimal	是	采购成本
     grossfreight2	decimal	是	国外运费
     incidentals	decimal	是	其他杂费
     exchangerate1	decimal	是	平台费率
     exchangerate2	decimal	是	外币汇率
     */
}
