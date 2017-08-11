package com.ipricebox.android.module.me;

import android.view.View;
import android.widget.EditText;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.util.ToastUtils;

import butterknife.BindView;

public class AboutActivity extends BaseActivity {


    @Override
    protected void initPreparation() {
    }


    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_about);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
        initTopBarForLeft("关于我们", null, getResources().getDrawable(R.drawable.icon_common_back));


    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


}
