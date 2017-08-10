/**
 *
 */
package com.ldroid.pbox.common.ui;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.callback.SimpleCallback;
import com.ldroid.pbox.dao.ConfigDao;
import com.ldroid.pbox.entities.out.UserOutEntity;
import com.ldroid.pbox.module.login.LoginActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements OnClickListener {

    private ProgressDialog mProgressDialog ;

    public BaseFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPreparation();
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

    protected abstract void initPreparation();

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


    public void checkLogin(SimpleCallback callback) {
        UserOutEntity user = ConfigDao.getInstance().getUser();
        if (user == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("现在登录?");
            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startAnimActivity(LoginActivity.class);
                    getActivity().finish();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(true);
            dialog.show();
        } else {
            if (callback != null) {
                callback.onCallback(null);
            }
        }
    }


    public void register(Object subscriber) {
        if (!EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().register(subscriber);
        }
    }

    public void post(Object... event) {
        for (Object e : event) {
            EventBus.getDefault().post(e);
        }
    }

    public void unregister(Object subscriber) {
        if (EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().unregister(subscriber);
        }
    }



    public void showProgressDialog(String msg){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(getActivity());
        }
        msg = TextUtils.isEmpty(msg) ? "请稍等..." : msg ;
        mProgressDialog.setMessage(msg);
        mProgressDialog.show();
    }

    public void dismissPorgressDialog(){
        if(mProgressDialog != null){
            mProgressDialog.dismiss(); ;
        }
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


    public void initTopBarForRight(String titleName, String rightName, Drawable rdrawable) {
        TextView title = (TextView) findViewById(R.id.tv_main_title);
        title.setText(titleName);

        TextView tVRight = (TextView) findViewById(R.id.tv_title_bar_right);
        tVRight.setVisibility(rdrawable == null ? View.VISIBLE : View.INVISIBLE);
        tVRight.setText(rightName);

        ImageView iVRight = (ImageView) findViewById(R.id.iv_title_bar_right);
        iVRight.setVisibility(rdrawable != null ? View.VISIBLE : View.INVISIBLE);
        if (rdrawable != null)
            iVRight.setBackgroundDrawable(rdrawable);

        findViewById(R.id.rl_title_bar_left).setVisibility(View.INVISIBLE);
        findViewById(R.id.rl_title_bar_right).setVisibility(View.VISIBLE);
        findViewById(R.id.rl_title_bar_right).setOnClickListener(this);

    }

}
