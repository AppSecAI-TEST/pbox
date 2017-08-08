/**
 *
 */
package com.ldroid.pbox.interactor;

import com.google.gson.reflect.TypeToken;
import com.ldroid.pbox.common.entities.OutputDataEntity;
import com.ldroid.pbox.common.entities.OutputEntity;
import com.ldroid.pbox.common.mvp.BaseInteractor;
import com.ldroid.pbox.common.net.ActionConstants;
import com.ldroid.pbox.common.net.ResponseListener;
import com.ldroid.pbox.entities.in.ToolsCBLRInEntity;
import com.ldroid.pbox.entities.in.ToolsCountrysInEntity;
import com.ldroid.pbox.entities.in.ToolsEMSInEntity;
import com.ldroid.pbox.entities.in.ToolsEYBInEntity;
import com.ldroid.pbox.entities.in.ToolsGHDBInEntity;
import com.ldroid.pbox.entities.in.ToolsGHXBInEntity;
import com.ldroid.pbox.entities.in.ToolsHGZXInEntity;
import com.ldroid.pbox.entities.in.ToolsHWCInEntity;
import com.ldroid.pbox.entities.in.ToolsPZHSInEntity;
import com.ldroid.pbox.entities.in.ToolsTYInEntity;
import com.ldroid.pbox.entities.in.ToolsWLZZInEntity;
import com.ldroid.pbox.entities.in.ToolsYFGSInEntity;
import com.ldroid.pbox.entities.in.UserAvatarInEntity;
import com.ldroid.pbox.entities.in.UserNickNameInEntity;
import com.ldroid.pbox.entities.in.UserPhoneInEntity;
import com.ldroid.pbox.entities.in.UserWidgetsInEntity;
import com.ldroid.pbox.entities.out.ToolsCBLROutEntity;
import com.ldroid.pbox.entities.out.ToolsCountrysEntity;
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
import com.ldroid.pbox.entities.out.UserWidgetsOutEntity;

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
        in.setMethod(ActionConstants.TOOLS_EMS);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsHWCOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqToolsCountrys(ToolsCountrysInEntity in,
                                 ResponseListener<OutputDataEntity<ToolsCountrysEntity>> listener) {
        in.setMethod(ActionConstants.TOOLS_COUNTRYS);
        performRequest(in, listener, new TypeToken<OutputDataEntity<ToolsCountrysEntity>>() {
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
