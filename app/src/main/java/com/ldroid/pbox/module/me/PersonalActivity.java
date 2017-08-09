package com.ldroid.pbox.module.me;

import android.view.View;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.ui.lib.pop.BottomMenuDialog;
import com.ldroid.pbox.dao.ConfigDao;
import com.ldroid.pbox.entities.out.UserOutEntity;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalActivity extends BaseActivity {


    @BindView(R.id.tv_nickname)
    TextView mTvNickName;

    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_personal);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
        initTopBarForLeft("个人信息", null, getResources().getDrawable(R.drawable.icon_common_back));

        UserOutEntity user = ConfigDao.getInstance().getUser();


        mTvNickName.setText(user.NickName);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.rl_avatar)
    public void onClickAvatar() {

        BottomMenuDialog dialog = new BottomMenuDialog.BottomMenuBuilder()
                .addItem("拍照", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                })
                .addItem("从相册选择", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                })
                .addItem("取消", null).build();
        dialog.show(getSupportFragmentManager());
    }

    @OnClick(R.id.rl_nickname)
    public void onClickNickName() {
        startAnimActivity(ModifyNickNameActivity.class);
    }

    @OnClick(R.id.rl_phone)
    public void onClickPhone() {
        startAnimActivity(ModifyPhoneActivity.class);
    }
}
