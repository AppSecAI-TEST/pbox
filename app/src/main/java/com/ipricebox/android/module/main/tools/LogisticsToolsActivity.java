package com.ipricebox.android.module.main.tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;


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
        mTraceFragment = LogisticsFragment.newInstance(0);
        mArchiveFragment =LogisticsFragment.newInstance(1);
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
