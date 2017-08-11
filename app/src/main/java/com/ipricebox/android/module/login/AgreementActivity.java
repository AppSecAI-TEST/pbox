package com.ipricebox.android.module.login;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;

public class AgreementActivity extends BaseActivity {


    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_agreement);
    }

    @Override
    protected void initUI() {

        initTopBarForLeft("用户协议", null, getResources().getDrawable(R.drawable.icon_common_back));
        setTranslucentStatus(0, R.drawable.bg_status_bar);


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


}
