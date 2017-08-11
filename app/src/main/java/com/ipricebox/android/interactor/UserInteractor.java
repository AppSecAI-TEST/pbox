/**
 *
 */
package com.ipricebox.android.interactor;

import com.google.gson.reflect.TypeToken;
import com.ipricebox.android.common.entities.OutputDataEntity;
import com.ipricebox.android.common.entities.OutputEntity;
import com.ipricebox.android.common.mvp.BaseInteractor;
import com.ipricebox.android.common.net.ActionConstants;
import com.ipricebox.android.common.net.ResponseListener;
import com.ipricebox.android.entities.in.UserAvatarInEntity;
import com.ipricebox.android.entities.in.UserNickNameInEntity;
import com.ipricebox.android.entities.in.UserPhoneInEntity;
import com.ipricebox.android.entities.in.UserWidgetsInEntity;
import com.ipricebox.android.entities.out.UserWidgetsOutEntity;

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
