package com.ldroid.pbox.module.main.tools;

import android.view.View;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.widget.BasePopupWindow;

import butterknife.BindView;
import butterknife.OnClick;


public class FeeToolsActivity extends BaseActivity {


    @BindView(R.id.tv_edit_channel)
    TextView mTvChannel;
    @BindView(R.id.root)
    View mRoot;

    private FeeToolsPopupWindow mPopWindow;


    @Override
    protected void initPreparation() {

    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_fee_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForLeft("运费估算", null, getResources().getDrawable(R.drawable.icon_common_back));

        mPopWindow = new FeeToolsPopupWindow(this);
        mPopWindow.setListener(new BasePopupWindow.OnPopupWindowItemSelectedListener() {
            @Override
            public void onItemSelected(Object... obj) {
                mTvChannel.setText(String.valueOf(obj[0]));
                mTvChannel.setTag(obj[1]);
            }
        });
    }


    @OnClick(R.id.tv_edit_channel)
    public void onClickEdit() {
        mPopWindow.showFromBottom(mRoot);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


}
