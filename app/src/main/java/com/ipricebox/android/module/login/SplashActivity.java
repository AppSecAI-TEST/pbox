package com.ipricebox.android.module.login;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.dao.ConfigDao;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.module.main.MainActivity;

public class SplashActivity extends BaseActivity {

    private View mContentView;

    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        mContentView = View.inflate(this, R.layout.ac_splash, null);
        setContentView(mContentView);
    }

    @Override
    protected void initUI() {

        setTranslucentStatus(R.color.colorWhite, 0);

       final UserOutEntity user = ConfigDao.getInstance().getUser();


        AlphaAnimation aa = new AlphaAnimation(0.3f, 1.0f);
        aa.setDuration(1000);
        mContentView.setAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (user != null) {
                    startAnimActivity(MainActivity.class);
                } else {
                    startAnimActivity(LoginActivity.class);
                }
                finish();
            }

        });

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
