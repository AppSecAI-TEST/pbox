package com.ldroid.pbox.module.main.tools;

import com.ldroid.pbox.common.mvp.BasePresenter;
import com.ldroid.pbox.common.mvp.BaseView;
import com.ldroid.pbox.entities.out.ToolsCBLROutEntity;
import com.ldroid.pbox.entities.out.ToolsCountrysOutEntity;
import com.ldroid.pbox.entities.out.ToolsEMSOutEntity;
import com.ldroid.pbox.entities.out.ToolsEYBOutEntity;
import com.ldroid.pbox.entities.out.ToolsGHDBOutEntity;
import com.ldroid.pbox.entities.out.ToolsGHXBOutEntity;
import com.ldroid.pbox.entities.out.ToolsHGZXOutEntity;
import com.ldroid.pbox.entities.out.ToolsHWCOutEntity;
import com.ldroid.pbox.entities.out.ToolsPZHSOutEntity;
import com.ldroid.pbox.entities.out.ToolsTYOutEntity;
import com.ldroid.pbox.entities.out.ToolsWLZZOutEntity;
import com.ldroid.pbox.entities.out.ToolsYFGSOutEntity;

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
}