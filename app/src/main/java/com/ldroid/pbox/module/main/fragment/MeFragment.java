package com.ldroid.pbox.module.main.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseFragment;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;

public class MeFragment extends BaseFragment {


    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initUI() {
        initTopBarForOnlyTitle("我的");

        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    class Adapter extends CommonAdapter<ModuleEntity> {

        public Adapter() {
            super(getActivity(), R.layout.layout_me_item);
            init();
        }


        public void init() {
            ArrayList data = new ArrayList();
            data.add(new ModuleEntity("个人信息", R.drawable.icon_me_info));
            data.add(new ModuleEntity("订阅报表", R.drawable.icon_me_book));
            data.add(new ModuleEntity("分享给好友", R.drawable.icon_me_share));
            data.add(new ModuleEntity("清除缓存", R.drawable.icon_me_clean));
            data.add(new ModuleEntity("评价我们", R.drawable.icon_me_appraise));
            data.add(new ModuleEntity("用户反馈", R.drawable.icon_me_feedback));
            data.add(new ModuleEntity("退出登录", R.drawable.icon_me_logout));

            setListData(data);
        }

        @Override
        public void convert(ViewHolder holder, ModuleEntity module) {
            holder.setText(R.id.tv_module, module.text);
            holder.setCompoundDrawablesWithIntrinsicBounds(R.id.tv_module, module.drawable, 0, 0, 0);
        }

    }

    class ModuleEntity {
        public String text;
        public int drawable;

        public ModuleEntity(String text, int drawable) {
            this.text = text;
            this.drawable = drawable;
        }
    }

}
