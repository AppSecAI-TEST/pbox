package com.ipricebox.android.entities.in;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class ToolsHWCInEntity extends InputEntity {


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
    public String weight;
    @Expose
    public String turnaroundtime;
    @Expose
    public String exchangerate2;
    @Expose
    public String grossfreight1;
    @Expose
    public String firstfreight;
    @Expose
    public String secondfreight;
    @Expose
    public String incidentals;
    @Expose
    public String exchangerate1;
    @Expose
    public String financingcosrate;


    public ToolsHWCInEntity(String userid, String productname, String countryname, String profitmargin, String price, String amount, String weight, String turnaroundtime, String exchangerate2, String grossfreight1, String firstfreight, String secondfreight, String incidentals, String exchangerate1, String financingcosrate) {
        this.userid = userid;
        this.productname = productname;
        this.countryname = countryname;
        this.profitmargin = profitmargin;
        this.price = price;
        this.amount = amount;
        this.weight = weight;
        this.turnaroundtime = turnaroundtime;
        this.exchangerate2 = exchangerate2;
        this.grossfreight1 = grossfreight1;
        this.firstfreight = firstfreight;
        this.secondfreight = secondfreight;
        this.incidentals = incidentals;
        this.exchangerate1 = exchangerate1;
        this.financingcosrate = financingcosrate;
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
        params.put("weight", weight);
        params.put("turnaroundtime", turnaroundtime);
        params.put("exchangerate2", exchangerate2);
        params.put("grossfreight1", grossfreight1);
        params.put("firstfreight", firstfreight);
        params.put("secondfreight", secondfreight);
        params.put("incidentals", incidentals);
        params.put("exchangerate1", exchangerate1);
        params.put("financingcosrate", financingcosrate);

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
     profitmargin	decimal	是	利润率
     price	decimal	是	采购单价
     amount	decimal	是	采购数量
     weight	decimal	是	单品重量
     turnaroundtime	decimal	是	周转时间（天）
     exchangerate2	decimal	是	外币汇率
     grossfreight1	decimal	是	国内运费
     firstfreight	decimal	是	头程运费
     secondfreight	decimal	是	后程运费
     incidentals	decimal	是	其他杂费
     exchangerate1	decimal	是	平台费率
     financingcosrate	decimal	是	资金成本年利率
     */
}
