package com.ipricebox.android.module.login;

import android.content.Context;
import android.widget.EditText;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.util.ToastUtils;
import com.ipricebox.android.dao.ConfigDao;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.module.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginContract.View {


    private LoginContract.Presenter mPresenter;

    @BindView(R.id.et_phone)
    EditText mEtPhone;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;

    @Override
    protected void initPreparation() {
        mPresenter = new LoginPresenter(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_login);
    }

    @Override
    protected void initUI() {

        //setTranslucentStatus(R.color.colorWhite, 0);

    }


    @OnClick(R.id.btn_login)
    public void onClickLogin() {
        String phone = mEtPhone.getText().toString();
        String password = mEtPwd.getText().toString();
        mPresenter.reqLogin(phone, password);
    }

    @OnClick(R.id.tv_register)
    public void onClickRegister() {
        startAnimActivity(RegisterActivity.class);
    }


    @OnClick(R.id.tv_guest)
    public void onClickGuest() {
        startAnimActivity(MainActivity.class);
        finish();
    }

    @OnClick(R.id.tv_forget)
    public void onClickForget() {
        startAnimActivity(ForgetPwdStep1Activity.class);
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

    }

    @Override
    public void onRespLogin(UserOutEntity data) {
        ConfigDao.getInstance().setUser(data);
        ToastUtils.showLongToast(mContext, "登录成功");
        startAnimActivity(MainActivity.class);
        finish();
    }

    @Override
    public void onRespRegister(UserOutEntity data) {

    }

}
