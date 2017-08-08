/**
 *
 */
package com.ldroid.pbox.interactor;

import com.google.gson.reflect.TypeToken;
import com.ldroid.pbox.common.entities.BaseEntity;
import com.ldroid.pbox.common.entities.OutputDataEntity;
import com.ldroid.pbox.common.entities.OutputEntity;
import com.ldroid.pbox.common.mvp.BaseInteractor;
import com.ldroid.pbox.common.net.ActionConstants;
import com.ldroid.pbox.common.net.ResponseListener;
import com.ldroid.pbox.entities.in.LoginInEntity;
import com.ldroid.pbox.entities.in.RegisterInEntity;
import com.ldroid.pbox.entities.in.SmsCodeInEntity;
import com.ldroid.pbox.entities.in.UserAvatarInEntity;
import com.ldroid.pbox.entities.in.UserNickNameInEntity;
import com.ldroid.pbox.entities.in.UserPhoneInEntity;
import com.ldroid.pbox.entities.in.UserWidgetsInEntity;
import com.ldroid.pbox.entities.out.SmsOutEntity;
import com.ldroid.pbox.entities.out.UserOutEntity;
import com.ldroid.pbox.entities.out.UserWidgetsOutEntity;

public class UserInteractor extends BaseInteractor {

    private static final String TAG = "UserInteractor";

    public void reqWidgets(UserWidgetsInEntity in,
                           ResponseListener<OutputDataEntity<UserWidgetsOutEntity>> listener) {
        in.setMethod(ActionConstants.WIDGETS);
        performRequest(in, listener, new TypeToken<OutputDataEntity<UserWidgetsOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqChangeNickName(UserNickNameInEntity in,
                                  ResponseListener<OutputEntity> listener) {
        in.setMethod(ActionConstants.CHANGE_NICKNAME);
        performRequest(in, listener, new TypeToken<OutputEntity>() {
        }.getType(), TAG);

    }

    public void reqChangePhone(UserPhoneInEntity in,
                               ResponseListener<OutputEntity> listener) {
        in.setMethod(ActionConstants.CHANGE_PHONE);
        performRequest(in, listener, new TypeToken<OutputEntity>() {
        }.getType(), TAG);

    }

    public void reqChangeAvatar(UserAvatarInEntity in,
                                ResponseListener<OutputEntity> listener) {
        in.setMethod(ActionConstants.CHANGE_AVATAR);
        performRequest(in, listener, new TypeToken<OutputEntity>() {
        }.getType(), TAG);

    }

}
