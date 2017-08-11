package com.ipricebox.android.module.me;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.util.ToastUtils;
import com.ipricebox.android.dao.ConfigDao;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.entities.out.UserWidgetsOutEntity;

import butterknife.BindView;

public class ModifyNickNameActivity extends BaseActivity implements UserContract.View {

    private UserPresenter mPresenter;

    @BindView(R.id.modify_name)
    EditText mEtName;

    @Override
    protected void initPreparation() {
        mPresenter = new UserPresenter(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_modify_name);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
        initTopBarForBoth("修改昵称", null, getResources().getDrawable(R.drawable.icon_common_back),
                "保存", null);

        UserOutEntity user = ConfigDao.getInstance().getUser();
        if (user != null) {
            mEtName.setText(user.NickName);
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_title_bar_right:
                reqNickName();
                break;
        }
    }

    private void reqNickName() {
        String userid = ConfigDao.getInstance().getUser().UserID;
        String nickname = mEtName.getText().toString();
        mPresenter.reqChangeNickName(userid, nickname);
    }

    @Override
    public Context getContext() {
        return null;
    }

    @Override
    public void showLoading(String msg) {
        showProgressDialog(msg);
    }

    @Override
    public void dismissLoading() {
        dismissPorgressDialog();
    }

    @Override
    public void onError(String msg) {
        ToastUtils.showLongToast(mContext, msg);

    }

    @Override
    public void onRespUserWidgets(UserWidgetsOutEntity data) {

    }

    @Override
    public void onRespNickName() {
        String nickname = mEtName.getText().toString();
        UserOutEntity user = ConfigDao.getInstance().getUser();
        user.NickName = nickname;
        ConfigDao.getInstance().setUser(user);

        post(new NickNameEvent(nickname));
        ToastUtils.showLongToast(mContext, "昵称修改成功");
        finish();

    }

    @Override
    public void onRespPhone() {

    }

    @Override
    public void onRespSmsCode(String phone) {

    }

    public class NickNameEvent {
        public String nickname;

        public NickNameEvent(String nickname) {
            this.nickname = nickname;
        }
    }
}
