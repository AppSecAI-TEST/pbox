package com.ldroid.pbox.module.main.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseFragment;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;
import com.ldroid.pbox.entities.out.ChartOutEntity;
import com.ldroid.pbox.module.chart.ChartExoprtActivity;
import com.ldroid.pbox.module.chart.SearchProductActivity;

import java.util.ArrayList;

import butterknife.BindView;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class ChartFragment extends BaseFragment {


    @BindView(R.id.list_view)
    StickyListHeadersListView mListView;
    private Adapter mAdapter;

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initUI() {
        initTopBarForRight("报表", null, getResources().getDrawable(R.drawable.icon_chart_export));
        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

        // test
        ArrayList list = new ArrayList();
        for (int i = 0; i < 20; i++) {
            list.add(new ChartOutEntity());
        }
        mAdapter.setListData(list);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_title_bar_right:
                startAnimActivity(SearchProductActivity.class);
                break;
        }
    }

    class Adapter extends CommonAdapter<ChartOutEntity> implements StickyListHeadersAdapter {

        public Adapter() {
            super(getActivity(), R.layout.layout_chart_item);
        }

        @Override
        public void convert(ViewHolder holder, ChartOutEntity chartOutEntity) {


        }

        @Override
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.layout_sticky_header_chart, parent, false);
            }

            long section = getHeaderId(position);
            TextView tv = (TextView) convertView.findViewById(R.id.title);
            tv.setText("本月" + section);

            convertView.findViewById(R.id.tv_export).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startAnimActivity(new Intent(getActivity(), ChartExoprtActivity.class));
                }
            });


            return convertView;
        }

        @Override
        public long getHeaderId(int position) {
            return position % 5;
        }
    }


}
