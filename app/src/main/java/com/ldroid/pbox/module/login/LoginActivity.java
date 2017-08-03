package com.ldroid.pbox.module.login;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.module.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {


    @BindView(R.id.btn_sms)
    Button mBtnVerify;


    private VerifyDownTimer mCountDownTimer;

    class VerifyDownTimer extends CountDownTimer {

        public VerifyDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            if (mBtnVerify != null) {
                mBtnVerify.setText(String.valueOf(millisUntilFinished / 1000) + "″");
            }
        }

        @Override
        public void onFinish() {
            if (mBtnVerify != null) {
                mBtnVerify.setText("获取验证码");
                mBtnVerify.setEnabled(true);
            }
        }

    }


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

        mCountDownTimer = new VerifyDownTimer(60000, 1000);

    }


    @OnClick(R.id.btn_sms)
    public void onClickSms() {
        reqSendSms();
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


    private void reqSendSms() {
        mCountDownTimer.start();
        mBtnVerify.setEnabled(false);
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
    public void onRespLogin() {

    }

    @Override
    protected void onDestroy() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        super.onDestroy();
    }
}
