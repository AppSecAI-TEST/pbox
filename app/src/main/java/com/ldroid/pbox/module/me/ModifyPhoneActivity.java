package com.ldroid.pbox.module.me;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.util.ToastUtils;
import com.ldroid.pbox.dao.ConfigDao;
import com.ldroid.pbox.entities.out.UserOutEntity;
import com.ldroid.pbox.entities.out.UserWidgetsOutEntity;
import com.ldroid.pbox.module.login.RegisterActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ModifyPhoneActivity extends BaseActivity implements UserContract.View {

    private UserPresenter mPresenter;

    @BindView(R.id.et_old_phone)
    EditText mEtOldPhone;
    @BindView(R.id.et_new_phone)
    EditText mEtNewPhone;
    @BindView(R.id.et_verify_code)
    EditText mEtCode;

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
        mPresenter = new UserPresenter(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_modify_phone);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
        initTopBarForLeft("更改手机号", null, getResources().getDrawable(R.drawable.icon_common_back));

        mCountDownTimer = new VerifyDownTimer(60000, 1000);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn_sms)
    public void onClickSms() {
        reqSendSms();
    }


    private void reqSendSms() {
        String phone = mEtNewPhone.getText().toString();
        mPresenter.reqSmsCode(phone);
        mCountDownTimer.start();
        mBtnVerify.setEnabled(false);

    }


    @OnClick(R.id.btn_ok)
    public void onClickChange() {
        reqChangePhone();
    }

    private void reqChangePhone() {
        String userid = ConfigDao.getInstance().getUser().UserID;
        String oldphone = mEtOldPhone.getText().toString();
        String phone = mEtNewPhone.getText().toString();
        String code = mEtCode.getText().toString();
        mPresenter.reqChangePhone(userid, oldphone, phone, code);
    }

    @Override
    public Context getContext() {
        return null;
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
    public void onRespUserWidgets(UserWidgetsOutEntity data) {
    }

    @Override
    public void onRespNickName() {
    }

    @Override
    public void onRespPhone() {
        String phone = mEtNewPhone.getText().toString();
        UserOutEntity user = ConfigDao.getInstance().getUser();
        user.Phone = phone;
        ConfigDao.getInstance().setUser(user);

        post(new PhoneEvent(phone));
        ToastUtils.showLongToast(mContext, "手机号码修改成功");
        finish();
    }

    @Override
    public void onRespSmsCode(String phone) {
        ToastUtils.showLongToast(mContext, "验证码下发成功，请注意查收");
    }


    @Override
    protected void onDestroy() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
        super.onDestroy();
    }

    public class PhoneEvent {
        public String phone;

        public PhoneEvent(String phone) {
            this.phone = phone;
        }
    }
}
