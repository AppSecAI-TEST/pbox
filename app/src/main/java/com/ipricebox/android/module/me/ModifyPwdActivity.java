package com.ipricebox.android.module.me;

import android.content.Context;
import android.widget.EditText;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.util.ToastUtils;
import com.ipricebox.android.entities.out.UserWidgetsOutEntity;

import butterknife.BindView;
import butterknife.OnClick;

public class ModifyPwdActivity extends BaseActivity implements UserContract.View {

    private UserPresenter mPresenter;

    @BindView(R.id.old_pwd)
    EditText mEtOld;
    @BindView(R.id.new_pwd)
    EditText mEtNew;
    @BindView(R.id.conf_pwd)
    EditText mEtConf;


    @Override
    protected void initPreparation() {
        mPresenter = new UserPresenter(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_modify_pwd);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
        initTopBarForLeft("修改密码", null, getResources().getDrawable(R.drawable.icon_common_back));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick(R.id.btn_ok)
    public void onClickChange() {
        String oldpwd = mEtOld.getText().toString();
        String newpwd = mEtNew.getText().toString();
        String confpwd = mEtConf.getText().toString();

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
    public void onRespUserWidgets(UserWidgetsOutEntity data) {
    }

    @Override
    public void onRespNickName() {
    }

    @Override
    public void onRespPhone() {
    }

    @Override
    public void onRespSmsCode(String phone) {
    }

}
