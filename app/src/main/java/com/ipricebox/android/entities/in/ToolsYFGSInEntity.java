package com.ipricebox.android.entities.in;

import android.text.TextUtils;

import com.google.gson.annotations.Expose;
import com.ipricebox.android.common.entities.InputEntity;

import java.util.Map;

public class ToolsYFGSInEntity extends InputEntity {


    @Expose
    public String userid;
    @Expose
    public String channeltype;
    @Expose
    public String countryname;
    @Expose
    public String weight;
    @Expose
    public String discount;

    public ToolsYFGSInEntity(String userid, String channeltype, String countryname, String weight, String discount) {
        this.userid = userid;
        this.channeltype = channeltype;
        this.countryname = countryname;
        this.weight = weight;
        this.discount = discount;
    }

    @Override
    public Boolean checkInput() {
        if(TextUtils.isEmpty(channeltype) || TextUtils.isEmpty(countryname) ||
                TextUtils.isEmpty(weight) ||
                TextUtils.isEmpty(discount)
                ){
            errors.add("请补全输入信息");
            return false ;
        }
        return true;
    }

    @Override
    public Map<String, String> getParams() {
        Map<String, String> params = super.getParams();
        params.put("userid", userid);
        params.put("channeltype", channeltype);
        params.put("countryname", countryname);
        params.put("weight", weight);
        params.put("discount", discount);

        return params;
    }


    /**
     userid	int	是	用户ID
     channeltype	int	是	渠道（2:E邮宝 3:小包 4:大包 5:EMS）
     countryname	string	是	国家
     weight	decimal	是	重量
     discount	decimal	是	运费折扣
     */
}
