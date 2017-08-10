package com.ldroid.pbox.entities.out;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;

/**
 * Created by xianglong.liang on 2017/7/31.
 */
public class ToolsWLZZOutEntity {


    @Expose public ExpressEntity ExpressInfo ;


    public class ExpressEntity{
        @Expose public String com ;
        @Expose public String nu ;
        @Expose public int state ;
        @Expose public ArrayList<ExpressItem> data ;
    }

    public class ExpressItem{
        @Expose public String time ;
        @Expose public String ftime ;
        @Expose public String context ;

    }

    /**
     * ExpressInfo": {
     "message": "ok",
     "nu": "447564970851",
     "ischeck": "0",
     "condition": "00",
     "com": "zhongtong",
     "status": "200",
     "state": "0",
     "data": [
     {
     "time": "2017-07-28 21:59:22",
     "ftime": "2017-07-28 21:59:22",
     "context": "[衡阳中转] [衡阳市] 快件离开 [衡阳中转]已发往[杭州中转部]"
     },
     {
     "time": "2017-07-28 21:58:50",
     "ftime": "2017-07-28 21:58:50",
     "context": "[衡阳中转] [衡阳市] 快件到达 [衡阳中转]"
     },
     {
     "time": "2017-07-28 19:26:51",
     "ftime": "2017-07-28 19:26:51",
     "context": "[耒阳] [衡阳市] 快件离开 [耒阳]已发往[衡阳中转]"
     },
     {
     "time": "2017-07-28 18:44:23",
     "ftime": "2017-07-28 18:44:23",
     "context": "[耒阳] [衡阳市] [耒阳]的兵已收件 电话:18163880535"
     }
     ]
     }
     */



}
