package com.ldroid.pbox.module.me;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;

public class ModifyPhoneActivity extends BaseActivity {


    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_modify_phone);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
        initTopBarForLeft("更改手机号", null, getResources().getDrawable(R.drawable.icon_common_back));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

}
