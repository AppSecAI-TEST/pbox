/**
 *
 */
package com.ldroid.pbox.common.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldroid.pbox.R;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements OnClickListener {


    public BaseFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPresenter();
        initUI();
        initListener();
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = getContentView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        return view;

    }

    protected abstract View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    protected abstract void initPresenter();

    protected abstract void initUI();

    protected abstract void initListener();

    protected abstract void initData();


    public View findViewById(int paramInt) {
        return getView().findViewById(paramInt);
    }


    public void startAnimActivity(Intent intent) {
        startActivity(intent);
    }

    public void startAnimActivity(Class<?> cla) {
        startActivity(new Intent(getActivity(), cla));
    }


    public void initTopBarForOnlyTitle(String titleName) {
        TextView title = (TextView) findViewById(R.id.tv_main_title);
        title.setText(titleName);
        findViewById(R.id.rl_title_bar_left).setVisibility(View.GONE);
        findViewById(R.id.rl_title_bar_right).setVisibility(View.GONE);
    }

    public void initTopBarForLeft(String titleName, String leftName, Drawable leftDrawable) {
        TextView title = (TextView) findViewById(R.id.tv_main_title);
        title.setText(titleName);

        TextView tVLeft = (TextView) findViewById(R.id.tv_title_bar_left);
        tVLeft.setVisibility(leftDrawable == null ? View.VISIBLE : View.INVISIBLE);
        tVLeft.setText(leftName);

        ImageView iVLeft = (ImageView) findViewById(R.id.iv_title_bar_left);
        iVLeft.setVisibility(leftDrawable != null ? View.VISIBLE : View.INVISIBLE);
        if (leftDrawable != null)
            iVLeft.setBackgroundDrawable(leftDrawable);

        findViewById(R.id.rl_title_bar_left).setVisibility(View.VISIBLE);
        findViewById(R.id.rl_title_bar_left).setOnClickListener(this);
        findViewById(R.id.rl_title_bar_right).setVisibility(View.INVISIBLE);
    }

}
