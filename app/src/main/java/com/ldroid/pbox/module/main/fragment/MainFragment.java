package com.ldroid.pbox.module.main.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.crazysunj.cardslideview.CardHandler;
import com.crazysunj.cardslideview.CardViewPager;
import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseFragment;
import com.ldroid.pbox.module.main.tools.CommonToolsActivity;
import com.ldroid.pbox.module.main.tools.EmsToolsActivity;
import com.ldroid.pbox.module.main.tools.EubToolsActivity;
import com.ldroid.pbox.module.main.tools.ForeignToolsActivity;
import com.ldroid.pbox.module.main.tools.GoodsToolsActivity;
import com.ldroid.pbox.module.main.tools.LogisticsToolsActivity;
import com.ldroid.pbox.module.main.tools.PostalBigToolsActivity;
import com.ldroid.pbox.module.main.tools.PostalSmallToolsActivity;
import com.ldroid.pbox.module.main.tools.ProfitToolsActivity;
import com.ldroid.pbox.module.main.tools.WeightToolsActivity;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;

public class MainFragment extends BaseFragment {


    @BindView(R.id.card_view_pager)
    CardViewPager mCardPager;


    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initUI() {

        initTopBarForOnlyTitle("首页");

        Integer[] images = {R.drawable.bg_ad_1, R.drawable.bg_ad_2, R.drawable.bg_ad_3,};
        mCardPager.bind(getChildFragmentManager(), new MyCardHandler(), Arrays.asList(images));

    }

    public class MyCardHandler implements CardHandler<Integer> {

        @Override
        public View onBind(final Context context, final Integer data, final int position) {
            View view = View.inflate(context, R.layout.layout_card_view_item, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.image);
            imageView.setBackgroundResource(data);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            return view;
        }
    }


    @OnClick(R.id.module_common)
    public void onClickCommon() {
        startAnimActivity(CommonToolsActivity.class);
    }

    @OnClick(R.id.module_eub)
    public void onClickEub() {
        startAnimActivity(EubToolsActivity.class);
    }

    @OnClick(R.id.module_small)
    public void onClickSmall() {
        startAnimActivity(PostalSmallToolsActivity.class);
    }

    @OnClick(R.id.module_big)
    public void onClickBig() {
        startAnimActivity(PostalBigToolsActivity.class);
    }

    @OnClick(R.id.module_ems)
    public void onClickEms() {
        startAnimActivity(EmsToolsActivity.class);
    }

    @OnClick(R.id.module_foreign)
    public void onClickForeign() {
        startAnimActivity(ForeignToolsActivity.class);
    }


    @OnClick(R.id.module_profit)
    public void onClickProfit() {
        startAnimActivity(ProfitToolsActivity.class);
    }


    @OnClick(R.id.module_weight)
    public void onClickWeight() {
        startAnimActivity(WeightToolsActivity.class);
    }

    @OnClick(R.id.module_goods)
    public void onClickGoods() {
        startAnimActivity(GoodsToolsActivity.class);
    }

    @OnClick(R.id.module_logistics)
    public void onClickLogistics() {
        startAnimActivity(LogisticsToolsActivity.class);
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
}
