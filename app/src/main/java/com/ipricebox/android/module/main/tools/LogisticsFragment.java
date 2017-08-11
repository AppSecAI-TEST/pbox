package com.ipricebox.android.module.main.tools;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseFragment;
import com.ipricebox.android.common.ui.adapter.CommonAdapter;
import com.ipricebox.android.common.ui.adapter.ViewHolder;
import com.ipricebox.android.common.util.ToastUtils;
import com.ipricebox.android.dao.ConfigDao;
import com.ipricebox.android.entities.out.ToolsCBLROutEntity;
import com.ipricebox.android.entities.out.ToolsCountrysOutEntity;
import com.ipricebox.android.entities.out.ToolsEMSOutEntity;
import com.ipricebox.android.entities.out.ToolsEYBOutEntity;
import com.ipricebox.android.entities.out.ToolsGHDBOutEntity;
import com.ipricebox.android.entities.out.ToolsGHXBOutEntity;
import com.ipricebox.android.entities.out.ToolsHGZXOutEntity;
import com.ipricebox.android.entities.out.ToolsHWCOutEntity;
import com.ipricebox.android.entities.out.ToolsPZHSOutEntity;
import com.ipricebox.android.entities.out.ToolsTYOutEntity;
import com.ipricebox.android.entities.out.ToolsWLZZOutEntity;
import com.ipricebox.android.entities.out.ToolsYFGSOutEntity;
import com.ipricebox.android.entities.out.UserOutEntity;

import butterknife.BindView;

public class LogisticsFragment extends BaseFragment implements ToolsContract.View ,AdapterView.OnItemClickListener{

    private static final String LOGISTICS_TYPE = "logistics_type";

    private int mType;

    private ToosPresenter mPresenter;

    Adapter mAdapter;
    @BindView(R.id.list_view)
    ListView mListView;
    @BindView(R.id.et_search)
    EditText mEtSearch;


    public static LogisticsFragment newInstance(int type) {
        LogisticsFragment fragment = new LogisticsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(LOGISTICS_TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected View getContentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_logistics, container, false);
    }

    @Override
    protected void initPreparation() {
        mType = getArguments().getInt(LOGISTICS_TYPE);
        mPresenter = new ToosPresenter(this);
    }

    @Override
    protected void initUI() {
        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);
        mEtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    reqToolsWLZZ();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    private void reqToolsWLZZ() {
        UserOutEntity user = ConfigDao.getInstance().getUser();
        String userid = user != null ? user.UserID : null;
        if (mType == 0) {
            // 追踪
            String num = mEtSearch.getText().toString();
            mPresenter.reqToolsWLZZ(userid, num);
        }
    }


    @Override
    public void onClick(View v) {

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
        ToastUtils.showLongToast(getActivity(), msg);
    }

    @Override
    public void onRespToolsTY(ToolsTYOutEntity data) {
    }

    @Override
    public void onRespToolsEYB(ToolsEYBOutEntity data) {
    }

    @Override
    public void onRespToolsGHXB(ToolsGHXBOutEntity data) {
    }

    @Override
    public void onRespToolsGHDB(ToolsGHDBOutEntity data) {

    }

    @Override
    public void onRespToolsEMS(ToolsEMSOutEntity data) {

    }

    @Override
    public void onRespToolsHWC(ToolsHWCOutEntity data) {

    }

    @Override
    public void onRespToolsCountry(ToolsCountrysOutEntity data) {

    }

    @Override
    public void onRespToolsCBLR(ToolsCBLROutEntity data) {

    }

    @Override
    public void onRespToolsPZHS(ToolsPZHSOutEntity data) {

    }

    @Override
    public void onRespToolsHGZX(ToolsHGZXOutEntity data) {

    }

    @Override
    public void onRespToolsYFGS(ToolsYFGSOutEntity data) {

    }


    @Override
    public void onRespToolsWLZZ(ToolsWLZZOutEntity data) {

        mAdapter.setExpress(data.ExpressInfo);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToolsWLZZOutEntity.ExpressItem express = mAdapter.getItem(position) ;
    }

    class Adapter extends CommonAdapter<ToolsWLZZOutEntity.ExpressItem> {

        ToolsWLZZOutEntity.ExpressEntity express;

        public Adapter() {
            super(getActivity(), R.layout.layout_logistics_tools_item);
        }


        public void setExpress(ToolsWLZZOutEntity.ExpressEntity express){
            this.express = express ;

            mAdapter.setListData(express.data);
        }

        @Override
        public void convert(final ViewHolder holder, final ToolsWLZZOutEntity.ExpressItem item) {
            int positon = holder.getPosition();
            holder.setVisible(R.id.ll_logistic_item, positon == 0);
            holder.setVisible(R.id.line_sep, positon == 0);

            holder.setText(R.id.com, express.com);
            holder.setText(R.id.nu, express.nu);
            holder.setBackgroundRes(R.id.stat,getStatRes(express.state));

            holder.setText(R.id.tv_context, item.context);
            holder.setText(R.id.tv_time, item.time);
        }

        private int getStatRes(int state){
            // 运输中
            if(state == 0){
                return R.drawable.icon_logistics_trans ;
            }
            // 派送中
            if(state == 5){
                return R.drawable.icon_logistics_delivery ;
            }
            return R.drawable.icon_logistics_trans ;
        }
    }

}

