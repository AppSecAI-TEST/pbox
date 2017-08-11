package com.ipricebox.android.module.me;

import android.view.View;
import android.widget.EditText;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.util.ToastUtils;

import butterknife.BindView;

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
