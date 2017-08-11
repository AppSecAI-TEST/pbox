package com.ipricebox.android.entities.in;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class ToolsGHDBInEntity extends InputEntity {


    @Expose
    public String userid;
    @Expose
    public String productname;
    @Expose
    public String countryname;
    @Expose
    public String profitmargin;
    @Expose
    public String cost;
    @Expose
    public String weight;
    @Expose
    public String discount;
    @Expose
    public String incidentals;
    @Expose
    public String exchangerate1;
    @Expose
    public String exchangerate2;


    public ToolsGHDBInEntity(String userid, String productname, String countryname, String profitmargin, String cost, String weight, String discount, String incidentals, String exchangerate1, String exchangerate2) {
        this.userid = userid;
        this.productname = productname;
        this.countryname = countryname;
        this.profitmargin = profitmargin;
        this.cost = cost;
        this.weight = weight;
        this.discount = discount;
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
        params.put("cost", cost);
        params.put("weight", weight);
        params.put("discount", discount);
        params.put("incidentals", incidentals);
        params.put("exchangerate1", exchangerate1);
        params.put("exchangerate2", exchangerate2);

        return params;
    }
    @Override
    public Boolean checkInput() {
        if(TextUtils.isEmpty(productname) || TextUtils.isEmpty(countryname) ||
                TextUtils.isEmpty(profitmargin) ||
                TextUtils.isEmpty(cost) ||
                TextUtils.isEmpty(weight) ||
                TextUtils.isEmpty(discount) ||
                TextUtils.isEmpty(incidentals) ||
                TextUtils.isEmpty(exchangerate1) ||
                TextUtils.isEmpty(exchangerate2)
                ){
            errors.add("请补全输入信息");
            return false ;
        }
        return true;
    }

    /**
     userid	int	是	用户ID
     productname	string	是	产品名称
     countryname	string	是	国家
     profitmargin	decimal	是	利润率
     cost	decimal	是	采购成本
     weight	decimal	是	包装重量
     discount	decimal	是	运费折扣
     incidentals	decimal	是	其他杂费
     exchangerate1	decimal	是	平台费率
     exchangerate2	decimal	是	外币汇率
     */
}
