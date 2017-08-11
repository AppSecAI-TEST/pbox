/**
 *
 */
package com.ipricebox.android.interactor;

import com.google.gson.reflect.TypeToken;
import com.ipricebox.android.common.entities.OutputDataEntity;
import com.ipricebox.android.common.mvp.BaseInteractor;
import com.ipricebox.android.common.net.ActionConstants;
import com.ipricebox.android.common.net.ResponseListener;
import com.ipricebox.android.entities.in.ToolsCBLRInEntity;
import com.ipricebox.android.entities.in.ToolsCountrysInEntity;
import com.ipricebox.android.entities.in.ToolsEMSInEntity;
import com.ipricebox.android.entities.in.ToolsEYBInEntity;
import com.ipricebox.android.entities.in.ToolsGHDBInEntity;
import com.ipricebox.android.entities.in.ToolsGHXBInEntity;
import com.ipricebox.android.entities.in.ToolsHGZXInEntity;
import com.ipricebox.android.entities.in.ToolsHWCInEntity;
import com.ipricebox.android.entities.in.ToolsPZHSInEntity;
import com.ipricebox.android.entities.in.ToolsTYInEntity;
import com.ipricebox.android.entities.in.ToolsWLZZInEntity;
import com.ipricebox.android.entities.in.ToolsYFGSInEntity;
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

public class ToolsInteractor extends BaseInteractor {

    private static final String TAG = "ToolsInteractor";

    public void reqToolsTY(ToolsTYInEntity in,
                           ResponseListener<OutputDataEntity<ToolsTYOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_TY);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsTYOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsEYB(ToolsEYBInEntity in,
                            ResponseListener<OutputDataEntity<ToolsEYBOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_EYB);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsEYBOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsGHXB(ToolsGHXBInEntity in,
                             ResponseListener<OutputDataEntity<ToolsGHXBOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_GHXB);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsGHXBOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsGHDB(ToolsGHDBInEntity in,
                             ResponseListener<OutputDataEntity<ToolsGHDBOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_GHDB);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsGHDBOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsEMS(ToolsEMSInEntity in,
                            ResponseListener<OutputDataEntity<ToolsEMSOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_EMS);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsEMSOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsHWC(ToolsHWCInEntity in,
                            ResponseListener<OutputDataEntity<ToolsHWCOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_HWC);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsHWCOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsCountrys(ToolsCountrysInEntity in,
                                 ResponseListener<OutputDataEntity<ToolsCountrysOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_COUNTRYS);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsCountrysOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsCBLR(ToolsCBLRInEntity in,
                             ResponseListener<OutputDataEntity<ToolsCBLROutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_CBLR);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsCBLROutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsPZHS(ToolsPZHSInEntity in,
                             ResponseListener<OutputDataEntity<ToolsPZHSOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_PZHS);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsPZHSOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsHGZX(ToolsHGZXInEntity in,
                             ResponseListener<OutputDataEntity<ToolsHGZXOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_HGZX);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsHGZXOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsYFGS(ToolsYFGSInEntity in,
                             ResponseListener<OutputDataEntity<ToolsYFGSOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_YFGS);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsYFGSOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsWLZZ(ToolsWLZZInEntity in,
                             ResponseListener<OutputDataEntity<ToolsWLZZOutEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_WLZZ);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsWLZZOutEntity>>() {
        }.getType(), TAG);

    }

}
