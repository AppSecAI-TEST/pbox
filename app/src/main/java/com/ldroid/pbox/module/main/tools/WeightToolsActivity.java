package com.ldroid.pbox.module.main.tools;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;


public class WeightToolsActivity extends BaseActivity {




    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_weight_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForLeft("抛重换算", null, getResources().getDrawable(R.drawable.icon_common_back));


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }



}
