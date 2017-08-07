package com.ldroid.pbox.module.main.tools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.ui.BaseFragment;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;


public class LogisticsToolsActivity extends BaseActivity {


    private Fragment mTraceFragment;
    private Fragment mArchiveFragment;

    private Fragment[] mFragmentList;
    private View[] mTabs;
    private int mIndex;
    private int mCurrentTabIndex;


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

        mTabs = new View[2];
        mTabs[0] = findViewById(R.id.layout_left);
        mTabs[1] = findViewById(R.id.layout_right);
        mTabs[0].setSelected(true);
        initTab();


    }

    private void initTab() {
        mTraceFragment = new LogisticsFragment();
        mArchiveFragment = new LogisticsFragment();
        mFragmentList = new Fragment[]{mTraceFragment, mArchiveFragment};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mTraceFragment).show(mTraceFragment).commit();
    }


    public void setTab(int index) {
        mIndex = index;
        if (mCurrentTabIndex != mIndex) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(mFragmentList[mCurrentTabIndex]);
            if (!mFragmentList[mIndex].isAdded()) {
                trx.add(R.id.fragment_container, mFragmentList[mIndex]);
            }
            trx.show(mFragmentList[mIndex]).commit();
        }
        mTabs[mCurrentTabIndex].setSelected(false);
        mTabs[mIndex].setSelected(true);
        mCurrentTabIndex = mIndex;
    }

    private View.OnClickListener mOnTabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            setTab(Integer.parseInt(String.valueOf(v.getTag())));
        }
    };

    @Override
    protected void initListener() {
        for (View v : mTabs) {
            v.setOnClickListener(mOnTabClickListener);
        }
    }

    @Override
    protected void initData() {

    }





}
