package com.ldroid.pbox.module.login;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.entities.out.UserOutEntity;
import com.ldroid.pbox.module.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {





    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_login);
    }

    @Override
    protected void initUI() {

        setTranslucentStatus(R.color.colorWhite, 0);


    }


    @OnClick(R.id.btn_login)
    public void onClickLogin() {
        startAnimActivity(MainActivity.class);
        finish();
    }

    @OnClick(R.id.tv_register)
    public void onClickRegister() {
        startAnimActivity(RegisterActivity.class);
    }


    @OnClick(R.id.tv_guest)
    public void onClickGuest() {
    }



    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRespSmsCode(String phone) {

    }

    @Override
    public void onRespLogin() {

    }

    @Override
    public void onRespRegister(UserOutEntity data) {

    }

}
