/**
 *
 */
package com.ipricebox.android.interactor;

import com.google.gson.reflect.TypeToken;
import com.ipricebox.android.common.entities.OutputDataEntity;
import com.ipricebox.android.common.mvp.BaseInteractor;
import com.ipricebox.android.common.net.ActionConstants;
import com.ipricebox.android.common.net.ResponseListener;
import com.ipricebox.android.entities.in.LoginInEntity;
import com.ipricebox.android.entities.in.RegisterInEntity;
import com.ipricebox.android.entities.in.SmsCodeInEntity;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.entities.out.SmsOutEntity;

public class LoginInteractor extends BaseInteractor {

    private static final String TAG = "LoginInteractor";

    public void reqSmsCode(SmsCodeInEntity in,
                           ResponseListener<OutputDataEntity<SmsOutEntity>> listener) {
        in.setMethod(ActionConstants.SMS_CODE);
        performRequest(in, listener, new TypeToken<OutputDataEntity<SmsOutEntity>>() {
        }.getType(), TAG);

    }

    public void reqRegister(RegisterInEntity in,
                            ResponseListener<OutputDataEntity<UserOutEntity>> listener) {
        in.setMethod(ActionConstants.REGISTER);
        performRequest(in, listener, new TypeToken<OutputDataEntity<UserOutEntity>>() {
        }.getType(), TAG);

    }


    public void reqLogin(LoginInEntity in,
                         ResponseListener<OutputDataEntity<UserOutEntity>> listener) {
        in.setMethod(ActionConstants.LOGIN);
        performRequest(in, listener, new TypeToken<OutputDataEntity<UserOutEntity>>() {
        }.getType(), TAG);

    }

}
