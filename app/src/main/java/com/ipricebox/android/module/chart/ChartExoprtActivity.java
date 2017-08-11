package com.ipricebox.android.module.chart;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;

import butterknife.OnClick;

public class ChartExoprtActivity extends BaseActivity {


    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_chart_export);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
        initTopBarForLeft("导出数据", null, getResources().getDrawable(R.drawable.icon_common_back));

    }


    @OnClick(R.id.btn_export)
    public void onClickExport() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
