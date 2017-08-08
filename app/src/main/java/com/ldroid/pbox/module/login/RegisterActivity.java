package com.ldroid.pbox.module.login;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.util.ToastUtils;
import com.ldroid.pbox.dao.ConfigDao;
import com.ldroid.pbox.entities.out.UserOutEntity;
import com.ldroid.pbox.module.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements LoginContract.View {


    private LoginContract.Presenter mPresenter;

    @BindView(R.id.btn_sms)
    Button mBtnVerify;

    @BindView(R.id.et_phone)
    EditText mEtPhoen;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_code)
    EditText mEtCode;


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
        mPresenter = new LoginPresenter(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_regist);
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

    @OnClick(R.id.btn_register)
    public void onClickRegister() {
        String phone = mEtPhoen.getText().toString();
        String nickname = mEtName.getText().toString();
        String code = mEtCode.getText().toString();
        mPresenter.reqRegister(nickname, phone, code);

    }


    private void reqSendSms() {
        String phone = mEtPhoen.getText().toString();
        mPresenter.reqSmsCode(phone);
        mCountDownTimer.start();
        mBtnVerify.setEnabled(false);

    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLoading(String msg) {
        showProgressDialog(msg);
    }

    @Override
    public void dismissLoading() {
        dismissPorgressDialog();
    }

    @Override
    public void onError(String msg) {
        ToastUtils.showLongToast(mContext, msg);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onRespSmsCode(String phone) {
        ToastUtils.showLongToast(mContext, "验证码下发成功，请注意查收");
    }

    @Override
    public void onRespLogin() {

    }

    @Override
    public void onRespRegister(UserOutEntity data) {
        ConfigDao.getInstance().setUser(data);
        ToastUtils.showLongToast(mContext, "注册成功");
        startAnimActivity(MainActivity.class);
    }

    @Override
    protected void onDestroy() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        super.onDestroy();
    }
}
