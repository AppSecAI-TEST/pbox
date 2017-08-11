package com.ipricebox.android.module.login;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.util.ToastUtils;
import com.ipricebox.android.dao.ConfigDao;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.module.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPwdStep2Activity extends BaseActivity implements LoginContract.View {


    public static final String EXTRA_PWD_PHONE = "extra_pwd_phone";

    private String mPhone;

    private LoginContract.Presenter mPresenter;


    @BindView(R.id.tv_phone)
    TextView mTvPhone;

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
        mPresenter = new LoginPresenter(this);
        mPhone = getIntent().getStringExtra(EXTRA_PWD_PHONE);
        mCountDownTimer = new VerifyDownTimer(60000, 1000);

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_forget_pwd_2);
    }

    @Override
    protected void initUI() {

        initTopBarForLeft("重置密码", null, getResources().getDrawable(R.drawable.icon_common_back));

        mTvPhone.setText(mPhone);

    }


    @OnClick(R.id.btn_next)
    public void onClickNext() {

    }

    @OnClick(R.id.btn_sms)
    public void onClickSms() {
        reqSendSms();
    }

    private void reqSendSms() {
        String phone = mPhone;
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showLongToast(mContext, "请输入电话号码");
            return;
        }
        mPresenter.reqSmsCode(phone);
        mCountDownTimer.start();
        mBtnVerify.setEnabled(false);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

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
    public void onRespSmsCode(String phone) {
        ToastUtils.showLongToast(mContext, "验证码下发成功，请注意查收");
    }

    @Override
    public void onRespLogin(UserOutEntity data) {

    }

    @Override
    public void onRespRegister(UserOutEntity data) {
        ConfigDao.getInstance().setUser(data);
        ToastUtils.showLongToast(mContext, "注册成功");
        startAnimActivity(MainActivity.class);
        finish();
    }

    @Override
    protected void onDestroy() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        super.onDestroy();
    }
}
