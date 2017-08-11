package com.ipricebox.android.module.login;

import android.content.Intent;
import android.widget.EditText;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.ipricebox.android.module.login.ForgetPwdStep2Activity.EXTRA_PWD_PHONE;

public class ForgetPwdStep1Activity extends BaseActivity {


    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_forget_pwd_1);
    }

    @Override
    protected void initUI() {
        initTopBarForLeft("忘记密码",null,getResources().getDrawable(R.drawable.icon_common_back));

    }

    @OnClick(R.id.btn_next)
    public void onClickNext() {

        String phone = mEtPhone.getText().toString();

        startAnimActivity(new Intent(mContext, ForgetPwdStep2Activity.class)
                .putExtra(EXTRA_PWD_PHONE, phone)
        );
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
