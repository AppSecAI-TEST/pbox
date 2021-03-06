/**
 *
 */
package com.ipricebox.android.common.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.callback.SimpleCallback;
import com.ipricebox.android.common.ui.lib.SystemBarTintManager;
import com.ipricebox.android.dao.ConfigDao;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.module.login.LoginActivity;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    public Context mContext;
    private ProgressDialog mProgressDialog ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        initPreparation();
        setContentView();
        ButterKnife.bind(this) ;
        initUI();
        initListener();
        initData();
    }

    protected abstract void initPreparation();
    protected abstract void setContentView();
    protected abstract void initUI();
    protected abstract void initListener();
    protected abstract void initData();
    public void startAnimActivity(Intent intent) {
        startActivity(intent);
    }
    public void startAnimActivity(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }





    @SuppressLint("InlinedApi")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void setTranslucentStatus(int color,int drawable) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            if(color != 0){
                window.setStatusBarColor(getResources().getColor(color));
            }else{
            }
            ViewGroup contentView = ((ViewGroup) findViewById(android.R.id.content));
            View childAt = contentView.getChildAt(0);
            if (childAt != null) {
                childAt.setFitsSystemWindows(true);
            }
        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);

            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            if(color != 0){
                tintManager.setStatusBarTintColor(getResources().getColor(color)) ;
            }else{
                tintManager.setStatusBarTintResource(drawable);
            }
            // 设置系统栏需要的内偏移
            View root = findViewById(R.id.root);
            if (root != null) {
                SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
                root.setPadding(0, config.getPixelInsetTop(false), config.getPixelInsetRight(),
                        config.getPixelInsetBottom());
            }
        }
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
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


    public void checkLogin(SimpleCallback callback) {
        UserOutEntity user = ConfigDao.getInstance().getUser();
        if (user == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("现在登录?");
            builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startAnimActivity(LoginActivity.class);
                    finish();
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

    public void initTopBarForBoth(String titleName, String leftName, Drawable leftDrawable,
                                  String rightName, Drawable rightDrawable) {
        TextView title = (TextView) findViewById(R.id.tv_main_title);
        title.setText(titleName);

        TextView tVLeft = (TextView) findViewById(R.id.tv_title_bar_left);
        tVLeft.setVisibility(leftDrawable == null ? View.VISIBLE : View.INVISIBLE);
        tVLeft.setText(leftName);

        ImageView iVLeft = (ImageView) findViewById(R.id.iv_title_bar_left);
        iVLeft.setVisibility(leftDrawable != null ? View.VISIBLE : View.INVISIBLE);
        if (leftDrawable != null)
            iVLeft.setBackgroundDrawable(leftDrawable);

        TextView tVRight = (TextView) findViewById(R.id.tv_title_bar_right);
        tVRight.setVisibility(rightDrawable == null ? View.VISIBLE : View.INVISIBLE);
        tVRight.setText(rightName);

        ImageView iVRight = (ImageView) findViewById(R.id.iv_title_bar_right);
        iVRight.setVisibility(rightDrawable != null ? View.VISIBLE : View.INVISIBLE);
        if (rightDrawable != null)
            iVRight.setBackgroundDrawable(rightDrawable);

        findViewById(R.id.rl_title_bar_left).setVisibility(View.VISIBLE);
        findViewById(R.id.rl_title_bar_right).setVisibility(View.VISIBLE);
        findViewById(R.id.rl_title_bar_left).setOnClickListener(this);
        findViewById(R.id.rl_title_bar_right).setOnClickListener(this);
    }


    public void showProgressDialog(String msg){
        if(mProgressDialog == null){
            mProgressDialog = new ProgressDialog(this);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_title_bar_left:
                finish();
                break;

            default:
                break;
        }
    }

}
