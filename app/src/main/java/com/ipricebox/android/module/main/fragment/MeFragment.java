package com.ipricebox.android.module.main.fragment;


import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseFragment;
import com.ipricebox.android.common.ui.adapter.CommonAdapter;
import com.ipricebox.android.common.ui.adapter.ViewHolder;
import com.ipricebox.android.common.util.ToastUtils;
import com.ipricebox.android.dao.ConfigDao;
import com.ipricebox.android.entities.out.UserOutEntity;
import com.ipricebox.android.entities.out.UserWidgetsOutEntity;
import com.ipricebox.android.module.login.LoginActivity;
import com.ipricebox.android.module.me.FeedbackActivity;
import com.ipricebox.android.module.me.ModifyNickNameActivity;
import com.ipricebox.android.module.me.PersonalActivity;
import com.ipricebox.android.module.me.UserContract;
import com.ipricebox.android.module.me.UserPresenter;
import com.ipricebox.android.widget.SubscribeDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;

public class MeFragment extends BaseFragment implements AdapterView.OnItemClickListener,
        UserContract.View{

    public static final int PERSONAL = 1;
    public static final int CHART = 2;
    public static final int SHARE = 3;
    public static final int CLEAN = 4;
    public static final int APPRAISE = 5;
    public static final int FEEDBACK = 6;
    public static final int LOGOUT = 7;

    private UserPresenter mPresenter ;


    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;
    private SubscribeDialog mSubDialog;

    @BindView(R.id.tv_name)
    TextView mTvName;


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNickNameChanged(ModifyNickNameActivity.NickNameEvent event) {
        mTvName.setText(event.nickname);
    }

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    @Override
    protected void initPreparation() {
        mPresenter = new UserPresenter(this);
        register(this);
    }

    @Override
    protected void initUI() {
        initTopBarForOnlyTitle("我的");

        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

        mSubDialog = new SubscribeDialog(getActivity());

        UserOutEntity user = ConfigDao.getInstance().getUser();
        if (user != null) {
            mTvName.setText(user.NickName);
        }
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
                confirmClean();
                break;
            case APPRAISE:
                appStore();
                break;
            case FEEDBACK:
                startAnimActivity(FeedbackActivity.class);
                break;
            case LOGOUT:
                confirmLogout();
                break;
        }
    }


    private void appStore() {
        try {
            Uri uri = Uri.parse("market://details?id=" + getActivity().getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName componentName = intent
                    .resolveActivity(getActivity().getPackageManager());
            if (componentName != null) {
                startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            ToastUtils.showShortToast(getActivity(), "无法开启应用商店!");
        }
    }


    private void confirmClean() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("确认清楚缓存?");
        builder.setNegativeButton("清除", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtils.showLongToast(getActivity(), "缓存清除成功");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    private void confirmLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("确认退出?");
        builder.setNegativeButton("退出", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                ConfigDao.getInstance().setUser(null);
                ToastUtils.showLongToast(getActivity(), "退出登录成功");
                startAnimActivity(LoginActivity.class);
                getActivity().finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onRespUserWidgets(UserWidgetsOutEntity data) {

    }

    @Override
    public void onRespNickName() {

    }

    @Override
    public void onRespPhone() {

    }

    @Override
    public void onRespSmsCode(String phone) {

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregister(this);
    }
}
