package com.ipricebox.android.module.login;

import android.support.annotation.NonNull;

import com.ipricebox.android.common.mvp.BasePresenter;
import com.ipricebox.android.common.mvp.BaseView;
import com.ipricebox.android.entities.out.UserOutEntity;

public interface LoginContract {

    interface View extends BaseView {
        void onRespSmsCode(String phone);
        void onRespLogin(UserOutEntity data);
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
