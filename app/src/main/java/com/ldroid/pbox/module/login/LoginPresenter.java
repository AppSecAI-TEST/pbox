/**
 *
 */
package com.ldroid.pbox.module.login;

import android.support.annotation.NonNull;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.entities.OutputDataEntity;
import com.ldroid.pbox.common.lib.volley.VolleyError;
import com.ldroid.pbox.common.net.ResponseListener;
import com.ldroid.pbox.entities.in.LoginInEntity;
import com.ldroid.pbox.entities.in.RegisterInEntity;
import com.ldroid.pbox.entities.in.SmsCodeInEntity;
import com.ldroid.pbox.entities.out.SmsOutEntity;
import com.ldroid.pbox.entities.out.UserOutEntity;
import com.ldroid.pbox.interactor.LoginInteractor;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private LoginInteractor mInteractor;

    /**
     *
     */
    public LoginPresenter(@NonNull LoginContract.View view) {
        this.mView = view;
        mInteractor = new LoginInteractor();
    }


    @Override
    public void reqSmsCode(@NonNull String phone) {
        final SmsCodeInEntity in = new SmsCodeInEntity(phone);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqSmsCode(in, new ResponseListener<OutputDataEntity<SmsOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<SmsOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespSmsCode(response.data.phone);
                    } else {
                        mView.onError(response.getErrorMsg());
                    }
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                mView.dismissLoading();
                mView.onError(error.toString());
            }
        });

    }


    @Override
    public void reqRegister(@NonNull String nickname, @NonNull String phone, @NonNull String
            code, @NonNull String password) {
        final RegisterInEntity in = new RegisterInEntity(nickname, phone, code, password);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqRegister(in, new ResponseListener<OutputDataEntity<UserOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<UserOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespRegister(response.data);
                    } else {
                        mView.onError(response.getErrorMsg());
                    }
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                mView.dismissLoading();
                mView.onError(error.toString());
            }
        });

    }

    @Override
    public void reqLogin(@NonNull String phone, @NonNull String password) {
        final LoginInEntity in = new LoginInEntity(phone, password);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqLogin(in, new ResponseListener<OutputDataEntity<UserOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<UserOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespLogin(response.data);
                    } else {
                        mView.onError(response.getErrorMsg());
                    }
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                mView.dismissLoading();
                mView.onError(error.toString());
            }
        });

    }

}
