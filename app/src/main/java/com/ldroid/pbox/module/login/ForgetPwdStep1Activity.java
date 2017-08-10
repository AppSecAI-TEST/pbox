package com.ldroid.pbox.module.login;

import android.content.Intent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.dao.ConfigDao;
import com.ldroid.pbox.entities.out.UserOutEntity;
import com.ldroid.pbox.module.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.ldroid.pbox.module.login.ForgetPwdStep2Activity.EXTRA_PWD_PHONE;

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
