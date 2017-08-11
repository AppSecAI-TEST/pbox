package com.ipricebox.android.module.main.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.crazysunj.cardslideview.CardHandler;
import com.crazysunj.cardslideview.CardViewPager;
import com.ipricebox.android.R;
import com.ipricebox.android.common.callback.SimpleCallback;
import com.ipricebox.android.common.ui.BaseFragment;
import com.ipricebox.android.module.main.tools.CommonToolsActivity;
import com.ipricebox.android.module.main.tools.EmsToolsActivity;
import com.ipricebox.android.module.main.tools.EubToolsActivity;
import com.ipricebox.android.module.main.tools.FeeToolsActivity;
import com.ipricebox.android.module.main.tools.ForeignToolsActivity;
import com.ipricebox.android.module.main.tools.GoodsToolsActivity;
import com.ipricebox.android.module.main.tools.LogisticsToolsActivity;
import com.ipricebox.android.module.main.tools.PostalBigToolsActivity;
import com.ipricebox.android.module.main.tools.PostalSmallToolsActivity;
import com.ipricebox.android.module.main.tools.ProfitToolsActivity;
import com.ipricebox.android.module.main.tools.WeightToolsActivity;

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
    protected void initPreparation() {

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


    private void confirmClean() {

    }


    @OnClick(R.id.module_common)
    public void onClickCommon() {
        startAnimActivity(CommonToolsActivity.class);
    }

    @OnClick(R.id.module_eub)
    public void onClickEub() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(EubToolsActivity.class);
            }
        });
    }

    @OnClick(R.id.module_small)
    public void onClickSmall() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(PostalSmallToolsActivity.class);
            }
        });
    }

    @OnClick(R.id.module_big)
    public void onClickBig() {

        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(PostalBigToolsActivity.class);
            }
        });
    }

    @OnClick(R.id.module_ems)
    public void onClickEms() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(EmsToolsActivity.class);
            }
        });
    }

    @OnClick(R.id.module_foreign)
    public void onClickForeign() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(ForeignToolsActivity.class);
            }
        });
    }


    @OnClick(R.id.module_profit)
    public void onClickProfit() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(ProfitToolsActivity.class);
            }
        });
    }


    @OnClick(R.id.module_weight)
    public void onClickWeight() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(WeightToolsActivity.class);
            }
        });
    }

    @OnClick(R.id.module_goods)
    public void onClickGoods() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(GoodsToolsActivity.class);
            }
        });
    }

    @OnClick(R.id.module_logistics)
    public void onClickLogistics() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(LogisticsToolsActivity.class);
            }
        });
    }

    @OnClick(R.id.module_fee)
    public void onClickFeeTools() {
        checkLogin(new SimpleCallback() {
            @Override
            public void onCallback(Object data) {
                startAnimActivity(FeeToolsActivity.class);
            }
        });
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
