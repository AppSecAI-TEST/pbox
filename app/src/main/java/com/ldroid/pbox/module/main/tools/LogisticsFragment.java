package com.ldroid.pbox.module.main.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseFragment;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;

public class LogisticsFragment extends BaseFragment {


    Adapter mAdapter;
    @BindView(R.id.list_view)
    ListView mListView;

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_logistics, container, false);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initUI() {
        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

        ArrayList data = new ArrayList();

        for (int i = 0; i < 10; i++) {
            data.add(new ToolsResultEntity());
        }
        mAdapter.setListData(data);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    class Adapter extends CommonAdapter<ToolsResultEntity> {

        public Adapter() {
            super(getActivity(), R.layout.layout_logistics_tools_item);
        }

        @Override
        public void convert(ViewHolder holder, ToolsResultEntity item) {

        }


    }
}
