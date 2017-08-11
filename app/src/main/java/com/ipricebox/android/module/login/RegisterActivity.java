package com.ipricebox.android.module.login;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.util.ToastUtils;
import com.ipricebox.android.dao.ConfigDao;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.module.main.MainActivity;

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
    @BindView(R.id.et_pwd)
    EditText mEtPwd;

    @BindView(R.id.agreement)
    TextView mTvAgreement;


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

        //setTranslucentStatus(R.color.colorWhite, 0);

        mCountDownTimer = new VerifyDownTimer(60000, 1000);

        SpannableStringBuilder spannable = new SpannableStringBuilder("注册即表明你同意《用户协议》中的条款");
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                startAnimActivity(AgreementActivity.class);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(getResources().getColor(R.color.colorApp));
            }
        }, 8, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        mTvAgreement.setMovementMethod(LinkMovementMethod.getInstance());
        mTvAgreement.setText(spannable);

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
        String password = mEtPwd.getText().toString();
        mPresenter.reqRegister(nickname, phone, code,password);

    }


    private void reqSendSms() {
        String phone = mEtPhoen.getText().toString();

        if (TextUtils.isEmpty(phone)) {
            ToastUtils.showLongToast(mContext, "请输入电话号码");
            return;
        }

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
