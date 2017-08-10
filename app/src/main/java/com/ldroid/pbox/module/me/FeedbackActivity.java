package com.ldroid.pbox.module.me;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.ui.lib.pop.BottomMenuDialog;
import com.ldroid.pbox.common.util.ToastUtils;
import com.ldroid.pbox.dao.ConfigDao;
import com.ldroid.pbox.entities.out.UserOutEntity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

public class FeedbackActivity extends BaseActivity {


    @BindView(R.id.et_feedback)
    EditText mEtFeedback;

    @Override
    protected void initPreparation() {
    }


    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_feedback);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);
        initTopBarForBoth("用户反馈", null, getResources().getDrawable(R.drawable.icon_common_back),
                "提交", null);


    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_title_bar_right:
                ToastUtils.showLongToast(mContext, "反馈成功");
                finish();
                break;
        }
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


}
