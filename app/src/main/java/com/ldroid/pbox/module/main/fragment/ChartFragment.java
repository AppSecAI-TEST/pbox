package com.ldroid.pbox.module.main.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseFragment;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.MultiItemCommonAdapter;
import com.ldroid.pbox.common.ui.adapter.MultiItemTypeSupport;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;
import com.ldroid.pbox.common.ui.lib.swipemenulistview.SwipeMenu;
import com.ldroid.pbox.common.ui.lib.swipemenulistview.SwipeMenuCreator;
import com.ldroid.pbox.common.ui.lib.swipemenulistview.SwipeMenuItem;
import com.ldroid.pbox.common.ui.lib.swipemenulistview.SwipeMenuListView;
import com.ldroid.pbox.common.util.DensityUtils;
import com.ldroid.pbox.entities.out.ChartOutEntity;
import com.ldroid.pbox.module.chart.ChartExoprtActivity;
import com.ldroid.pbox.module.chart.SearchProductActivity;

import java.util.ArrayList;

import butterknife.BindView;

import com.ldroid.pbox.common.ui.lib.stickylistheaders.StickyListHeadersAdapter;
import com.ldroid.pbox.common.ui.lib.stickylistheaders.StickyListHeadersListView;

public class ChartFragment extends BaseFragment {


    @BindView(R.id.list_view)
    SwipeMenuListView mListView;
    private Adapter mAdapter;

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }

    @Override
    protected void initPreparation() {

    }

    @Override
    protected void initUI() {
        initTopBarForRight("报表", null, getResources().getDrawable(R.drawable
                .icon_common_search_white));
        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

        SwipeMenuCreator creator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                createMenu2(menu);
            }

            private void createMenu2(SwipeMenu menu) {

                SwipeMenuItem item = new SwipeMenuItem(getActivity());
                item.setBackground(new ColorDrawable(Color.rgb(0xF9, 0x3F, 0x25)));
                item.setWidth(DensityUtils.dp2px(getActivity(),90));
                item.setTitle("删除");
                item.setTitleSize(18);
                item.setTitleColor(Color.WHITE);
                menu.addMenuItem(item);

            }
        };
        mListView.setMenuCreator(creator);


        // test
        ArrayList list = new ArrayList();
        ChartOutEntity c  = new ChartOutEntity() ;
        c.header = true ;
        list.add(c);
        for (int i = 0; i < 20; i++) {
            if(i == 5){
                ChartOutEntity c1  = new ChartOutEntity() ;
                c1.header = true ;
                list.add(c1);

            }
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

    class Adapter extends MultiItemCommonAdapter<ChartOutEntity> {

        public Adapter() {
            super(getActivity(), new MultiItemTypeSupport<ChartOutEntity>() {
                @Override
                public int getLayoutId(int position, ChartOutEntity item) {
                    if(item.header){
                        return R.layout.layout_sticky_header_chart;
                    }
                    return R.layout.layout_chart_item;
                }

                @Override
                public int getViewTypeCount() {
                    return 2;
                }

                @Override
                public int getItemViewType(int postion, ChartOutEntity item) {
                    if(item.header){
                        return 0 ;
                    }
                    return 1;
                }
            });
        }

        @Override
        public void convert(ViewHolder holder, ChartOutEntity chartOutEntity) {
            switch (holder.getLayoutId()) {
                case R.layout.layout_sticky_header_chart:
                    holder.setOnClickListener(R.id.tv_export,new View
                            .OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startAnimActivity(new Intent(getActivity(), ChartExoprtActivity.class));
                        }
                    });
                    break ;
                case R.layout.layout_chart_item:
                    break ;
            }

        }

    }


}
