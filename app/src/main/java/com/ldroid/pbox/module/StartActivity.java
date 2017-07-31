package com.ldroid.pbox.module;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.module.login.LoginActivity;

public class StartActivity extends BaseActivity {


    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_start);
        startAnimActivity(LoginActivity.class);
    }

    @Override
    protected void initUI() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
