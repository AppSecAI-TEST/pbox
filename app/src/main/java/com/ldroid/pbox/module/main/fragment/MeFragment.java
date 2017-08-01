package com.ldroid.pbox.module.main.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseFragment;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;
import com.ldroid.pbox.module.me.PersonalActivity;
import com.ldroid.pbox.widget.SubscribeDialog;

import java.util.ArrayList;

import butterknife.BindView;

public class MeFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    public static final int PERSONAL = 1;
    public static final int CHART = 2;
    public static final int SHARE = 3;
    public static final int CLEAN = 4;
    public static final int APPRAISE = 5;
    public static final int FEEDBACK = 6;
    public static final int LOGOUT = 7;


    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;
    private SubscribeDialog mSubDialog ;

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

        mSubDialog = new SubscribeDialog(getActivity()) ;
    }

    @Override
    protected void initListener() {
        mListView.setOnItemClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ModuleEntity module = mAdapter.getItem(position);
        switch (module.module) {
            case PERSONAL:
                startAnimActivity(PersonalActivity.class);
                break;
            case CHART:
                mSubDialog.show();
                break;
            case SHARE:
                break;
            case CLEAN:
                break;
            case APPRAISE:
                break;
            case FEEDBACK:
                break;
            case LOGOUT:
                break;
        }
    }

    class Adapter extends CommonAdapter<ModuleEntity> {


        public Adapter() {
            super(getActivity(), R.layout.layout_me_item);
            init();
        }


        public void init() {
            ArrayList data = new ArrayList();
            data.add(new ModuleEntity(PERSONAL, "个人信息", R.drawable.icon_me_info));
            data.add(new ModuleEntity(CHART, "订阅报表", R.drawable.icon_me_book));
            data.add(new ModuleEntity(SHARE, "分享给好友", R.drawable.icon_me_share));
            data.add(new ModuleEntity(CLEAN, "清除缓存", R.drawable.icon_me_clean));
            data.add(new ModuleEntity(APPRAISE, "评价我们", R.drawable.icon_me_appraise));
            data.add(new ModuleEntity(FEEDBACK, "用户反馈", R.drawable.icon_me_feedback));
            data.add(new ModuleEntity(LOGOUT, "退出登录", R.drawable.icon_me_logout));

            setListData(data);
        }

        @Override
        public void convert(ViewHolder holder, ModuleEntity module) {
            holder.setText(R.id.tv_module, module.text);
            holder.setCompoundDrawablesWithIntrinsicBounds(R.id.tv_module, module.drawable, 0, 0, 0);
        }

    }

    class ModuleEntity {
        public int module;
        public String text;
        public int drawable;

        public ModuleEntity(int module, String text, int drawable) {
            this.module = module;
            this.text = text;
            this.drawable = drawable;
        }
    }

}
