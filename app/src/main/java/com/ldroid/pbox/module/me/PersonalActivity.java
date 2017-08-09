package com.ldroid.pbox.module.me;

import android.view.View;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.ui.lib.pop.BottomMenuDialog;
import com.ldroid.pbox.dao.ConfigDao;
import com.ldroid.pbox.entities.out.UserOutEntity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class PersonalActivity extends BaseActivity {


    @BindView(R.id.tv_nickname)
    TextView mTvNickName;
    @BindView(R.id.tv_phone)
    TextView mTvPhone;
    @BindView(R.id.tv_id)
    TextView mTvId;

    @Override
    protected void initPreparation() {
        register(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNickNameChanged(ModifyNickNameActivity.NickNameEvent event) {
        mTvNickName.setText(event.nickname);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPhoneChanged(ModifyPhoneActivity.PhoneEvent event) {
        mTvPhone.setText(event.phone);
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


        if (user != null) {
            mTvNickName.setText(user.NickName);
            mTvPhone.setText(user.Phone.replaceAll("(\\d{3})\\d{6}(\\d{2})","$1******$2"));
            mTvId.setText(user.UserCode);
        }
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregister(this);
    }
}
