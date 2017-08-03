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
    public void onClickCommon(){
        startAnimActivity(CommonToolsActivity.class);
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
