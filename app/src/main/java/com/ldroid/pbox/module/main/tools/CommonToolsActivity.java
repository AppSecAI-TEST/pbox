package com.ldroid.pbox.module.main.tools;

import android.view.View;
import android.widget.ListView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;


public class CommonToolsActivity extends BaseActivity {


    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;

    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_common_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForBoth("通用", null, getResources().getDrawable(R.drawable.icon_common_back),
                "计算", null);

        findViewById(R.id.tv_head_key).setVisibility(View.INVISIBLE);

        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

        // test
        ArrayList data = new ArrayList();
        data.add(new CommonToolsResultEntity("产品售价", "453", "453", "100.00%"));
        data.add(new CommonToolsResultEntity("产品利润", "222", "453", "100.00%"));
        data.add(new CommonToolsResultEntity("采购成本", "555", "223", "16.00%"));
        data.add(new CommonToolsResultEntity("国内运费", "244", "453", "100.00%"));
        data.add(new CommonToolsResultEntity("国外运费", "445", "223", "15.00%"));
        data.add(new CommonToolsResultEntity("杂        费", "223", "445", "22.00%"));
        data.add(new CommonToolsResultEntity("平台佣金", "1256", "1256", "15.00%"));

        mAdapter.setListData(data);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    class Adapter extends CommonAdapter<CommonToolsResultEntity> {

        public Adapter() {
            super(CommonToolsActivity.this, R.layout.layout_common_tools_item);
        }

        @Override
        public void convert(ViewHolder holder, CommonToolsResultEntity item) {
            holder.setText(R.id.tv_head_key, item.key);
            holder.setText(R.id.tv_foreign, item.value1);
            holder.setText(R.id.tv_china, item.value2);
            holder.setText(R.id.tv_ratio, item.value3);

            int color = getResources().getColor(R.color.colorHint);
            holder.setTextColor(R.id.tv_foreign, color);
            holder.setTextColor(R.id.tv_china, color);
            holder.setTextColor(R.id.tv_ratio, color);
        }
    }


}
