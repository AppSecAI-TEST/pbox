package com.ipricebox.android.module.main.tools;

import com.ipricebox.android.common.mvp.BasePresenter;
import com.ipricebox.android.common.mvp.BaseView;
import com.ipricebox.android.entities.out.ToolsCBLROutEntity;
import com.ipricebox.android.entities.out.ToolsCountrysOutEntity;
import com.ipricebox.android.entities.out.ToolsEMSOutEntity;
import com.ipricebox.android.entities.out.ToolsEYBOutEntity;
import com.ipricebox.android.entities.out.ToolsGHDBOutEntity;
import com.ipricebox.android.entities.out.ToolsGHXBOutEntity;
import com.ipricebox.android.entities.out.ToolsHGZXOutEntity;
import com.ipricebox.android.entities.out.ToolsHWCOutEntity;
import com.ipricebox.android.entities.out.ToolsPZHSOutEntity;
import com.ipricebox.android.entities.out.ToolsTYOutEntity;
import com.ipricebox.android.entities.out.ToolsWLZZOutEntity;
import com.ipricebox.android.entities.out.ToolsYFGSOutEntity;

public interface ToolsContract {

    interface View extends BaseView {
        void onRespToolsTY(ToolsTYOutEntity data);

        void onRespToolsEYB(ToolsEYBOutEntity data);

        void onRespToolsGHXB(ToolsGHXBOutEntity data);

        void onRespToolsGHDB(ToolsGHDBOutEntity data);

        void onRespToolsEMS(ToolsEMSOutEntity data);

        void onRespToolsHWC(ToolsHWCOutEntity data);

        void onRespToolsCountry(ToolsCountrysOutEntity data);

        void onRespToolsCBLR(ToolsCBLROutEntity data);

        void onRespToolsPZHS(ToolsPZHSOutEntity data);

        void onRespToolsHGZX(ToolsHGZXOutEntity data);

        void onRespToolsYFGS(ToolsYFGSOutEntity data);

        void onRespToolsWLZZ(ToolsWLZZOutEntity data);
    }

    interface Presenter extends BasePresenter {



    }

    /**
     * 类型(2:E邮宝 3:小包 4:大包 5:EMS)
     */
     interface CountryType{
        int EYB = 2;
        int SMALL = 3;
        int BIG = 4;
        int EMS = 5;
    }
}