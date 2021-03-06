package com.ipricebox.android.module.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.ipricebox.android.R;
import com.ipricebox.android.common.callback.SimpleCallback;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.util.ToastUtils;
import com.ipricebox.android.module.main.fragment.ChartFragment;
import com.ipricebox.android.module.main.fragment.MainFragment;
import com.ipricebox.android.module.main.fragment.MeFragment;


public class MainActivity extends BaseActivity implements MainContract.View {


    private MainPresenter mPresenter;

    private Fragment mMainFragment;
    private Fragment mChartFragment;
    private Fragment mMeFragment;
    private Fragment[] mFragmentList;
    private View[] mTabs;
    private int mIndex;
    private int mCurrentTabIndex;

    private static final long QUIT_DUR = 3000;
    private long mQuitTime = 0;


    @Override
    protected void initPreparation() {
        mPresenter = new MainPresenter(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_main);
    }

    @Override
    protected void initUI() {

        setTranslucentStatus(0,R.drawable.bg_status_bar);
        mTabs = new View[3];
        mTabs[0] = findViewById(R.id.tab_main_main);
        mTabs[1] = findViewById(R.id.tab_main_chart);
        mTabs[2] = findViewById(R.id.tab_main_me);
        mTabs[0].setSelected(true);

        initTab();

    }

    private void initTab() {
        mMainFragment = new MainFragment();
        mChartFragment = new ChartFragment();
        mMeFragment = new MeFragment();
        mFragmentList = new Fragment[]{mMainFragment, mChartFragment, mMeFragment};
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mMainFragment).show(mMainFragment).commit();
    }

    public void onClickNavigator(final int index) {
        if(index == 1 || index == 2){
            checkLogin(new SimpleCallback() {
                @Override
                public void onCallback(Object data) {
                    setTab(index);
                }
            });
        }else{
            setTab(index);
        }

    }

    private void setTab(int index){
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
            onClickNavigator(Integer.parseInt(String.valueOf(v.getTag())));
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

    @Override
    public void onRespLogin() {

    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onBackPressed() {
        if (!isNeedQuit()) {
            return;
        }
        super.onBackPressed();
    }

    private boolean isNeedQuit() {
        if (System.currentTimeMillis() - mQuitTime < QUIT_DUR) {
            return true;
        } else {
            mQuitTime = System.currentTimeMillis();
            ToastUtils.showShortToast(mContext, "再按一次退出程序", true);
            return false;
        }
    }
}
