package com.ldroid.pbox.module.main.tools;

import android.view.View;
import android.widget.ListView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;


public class LogisticsToolsActivity extends BaseActivity {


    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;

    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_logistics_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    class Adapter extends CommonAdapter<ToolsResultEntity> {

        public Adapter() {
            super(LogisticsToolsActivity.this, R.layout.layout_common_tools_item);
        }

        @Override
        public void convert(ViewHolder holder, ToolsResultEntity item) {

        }
    }


}
