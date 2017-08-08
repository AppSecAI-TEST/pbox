/**
 *
 */
package com.ldroid.pbox.interactor;

import com.google.gson.reflect.TypeToken;
import com.ldroid.pbox.common.entities.OutputDataEntity;
import com.ldroid.pbox.common.mvp.BaseInteractor;
import com.ldroid.pbox.common.net.ActionConstants;
import com.ldroid.pbox.common.net.ResponseListener;
import com.ldroid.pbox.entities.in.LoginInEntity;
import com.ldroid.pbox.entities.in.RegisterInEntity;
import com.ldroid.pbox.entities.in.SmsCodeInEntity;
import com.ldroid.pbox.entities.out.UserOutEntity;
import com.ldroid.pbox.entities.out.SmsOutEntity;

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
