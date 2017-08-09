/**
 *
 */
package com.ldroid.pbox.module.me;

import android.support.annotation.NonNull;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.entities.OutputDataEntity;
import com.ldroid.pbox.common.entities.OutputEntity;
import com.ldroid.pbox.common.lib.volley.VolleyError;
import com.ldroid.pbox.common.net.ResponseListener;
import com.ldroid.pbox.entities.in.SmsCodeInEntity;
import com.ldroid.pbox.entities.in.UserNickNameInEntity;
import com.ldroid.pbox.entities.in.UserPhoneInEntity;
import com.ldroid.pbox.entities.in.UserWidgetsInEntity;
import com.ldroid.pbox.entities.out.SmsOutEntity;
import com.ldroid.pbox.entities.out.UserWidgetsOutEntity;
import com.ldroid.pbox.interactor.LoginInteractor;
import com.ldroid.pbox.interactor.UserInteractor;

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View mView;
    private UserInteractor mInteractor;
    private LoginInteractor mLoginInteractor ;

    /**
     *
     */
    public UserPresenter(@NonNull UserContract.View view) {
        this.mView = view;
        mInteractor = new UserInteractor();
        mLoginInteractor = new LoginInteractor();
    }

    public void reqWidgets(String userid, String actiontype, String widgetstype, String price, String starttime, String endtime) {
        final UserWidgetsInEntity in = new UserWidgetsInEntity(userid, actiontype, widgetstype, price, starttime, endtime);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqWidgets(in, new ResponseListener<OutputDataEntity<UserWidgetsOutEntity>>() {

            @Override
            public void onResponse(OutputDataEntity<UserWidgetsOutEntity> response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespUserWidgets(response.data);
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

    public void reqChangeNickName(String userid, String nickname) {
        final UserNickNameInEntity in = new UserNickNameInEntity(userid, nickname);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqChangeNickName(in, new ResponseListener<OutputEntity>() {

            @Override
            public void onResponse(OutputEntity response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespNickName();
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


    public void reqChangePhone(String userid, String oldphone, String phone, String code) {
        final UserPhoneInEntity in = new UserPhoneInEntity(userid, oldphone, phone, code);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mInteractor.reqChangePhone(in, new ResponseListener<OutputEntity>() {

            @Override
            public void onResponse(OutputEntity response) {
                mView.dismissLoading();
                if (response == null) {
                    mView.onError(mView.getContext().getString(R.string.common_net_error));
                } else {
                    if (Code.SUCCESS.equals(response.code)) {
                        mView.onRespPhone();
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

    public void reqSmsCode(@NonNull String phone) {
        final SmsCodeInEntity in = new SmsCodeInEntity(phone);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading(null);
        mLoginInteractor.reqSmsCode(in, new ResponseListener<OutputDataEntity<SmsOutEntity>>() {

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

}
