package com.ldroid.pbox.module.me;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;

public class ModifyNickNameActivity extends BaseActivity {


    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_modify_name);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0,R.drawable.bg_status_bar);
        initTopBarForBoth("修改昵称",null, getResources().getDrawable(R.drawable.icon_common_back),
                "保存",null);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

}
