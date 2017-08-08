package com.ldroid.pbox.module.login;

import android.support.annotation.NonNull;

import com.ldroid.pbox.common.mvp.BasePresenter;
import com.ldroid.pbox.common.mvp.BaseView;
import com.ldroid.pbox.entities.out.UserOutEntity;

public interface LoginContract {

    interface View extends BaseView {
        void onRespSmsCode(String phone);
        void onRespLogin();
        void onRespRegister(UserOutEntity data);
//        void onRespLogin(UserOutEntity data);
    }

    interface Presenter extends BasePresenter {

        void reqLogin(@NonNull String phone, @NonNull String pwd);

        void reqSmsCode(@NonNull String phone);

        void reqRegister(@NonNull String nickname, @NonNull String phone, @NonNull String code,
                         @NonNull String password);

    }
}
