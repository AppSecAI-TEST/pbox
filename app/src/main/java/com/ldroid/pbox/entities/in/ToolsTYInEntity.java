package com.ldroid.pbox.entities.in;

import com.google.gson.annotations.Expose;
import com.ldroid.pbox.common.entities.InputEntity;

import java.util.Map;

public class ToolsTYInEntity extends InputEntity {


    @Expose
    public String userid;
    @Expose
    public String productname;
    @Expose
    public String countryname;
    @Expose
    public String profitmargin;

    @Expose
    public String price;
    @Expose
    public String amount;
    @Expose
    public String grossfreight1;
    @Expose
    public String grossfreight2;
    @Expose
    public String incidentals;
    @Expose
    public String exchangerate1;
    @Expose
    public String exchangerate2;

    public ToolsTYInEntity(String userid, String productname, String countryname, String profitmargin, String price, String amount, String grossfreight1, String grossfreight2, String incidentals, String exchangerate1, String exchangerate2) {
        this.userid = userid;
        this.productname = productname;
        this.countryname = countryname;
        this.profitmargin = profitmargin;
        this.price = price;
        this.amount = amount;
        this.grossfreight1 = grossfreight1;
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
        params.put("profitmargin", profitmargin);
        params.put("price", price);
        params.put("amount", amount);
        params.put("grossfreight1", grossfreight1);
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
     * userid	int	是	用户ID
     productname	string	是	产品名称
     countryname	string	是	国家
     profitmargin	decimal	是	利润率
     price	decimal	是	采购单价
     amount	decimal	是	采购数量
     grossfreight1	decimal	是	国内运费
     grossfreight2	decimal	是	国外运费
     incidentals	decimal	是	杂费
     exchangerate1	decimal	是	平台费率
     exchangerate2	decimal	是	外币汇率
     */
}
