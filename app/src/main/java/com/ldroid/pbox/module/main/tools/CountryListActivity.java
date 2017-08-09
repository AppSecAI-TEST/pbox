package com.ldroid.pbox.module.main.tools;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.ui.adapter.CommonAdapter;
import com.ldroid.pbox.common.ui.adapter.ViewHolder;
import com.ldroid.pbox.common.util.ToastUtils;
import com.ldroid.pbox.dao.ConfigDao;
import com.ldroid.pbox.entities.out.ToolsCBLROutEntity;
import com.ldroid.pbox.entities.out.ToolsCountrysOutEntity;
import com.ldroid.pbox.entities.out.ToolsEMSOutEntity;
import com.ldroid.pbox.entities.out.ToolsEYBOutEntity;
import com.ldroid.pbox.entities.out.ToolsGHDBOutEntity;
import com.ldroid.pbox.entities.out.ToolsGHXBOutEntity;
import com.ldroid.pbox.entities.out.ToolsHGZXOutEntity;
import com.ldroid.pbox.entities.out.ToolsHWCOutEntity;
import com.ldroid.pbox.entities.out.ToolsPZHSOutEntity;
import com.ldroid.pbox.entities.out.ToolsTYOutEntity;
import com.ldroid.pbox.entities.out.ToolsWLZZOutEntity;
import com.ldroid.pbox.entities.out.ToolsYFGSOutEntity;
import com.ldroid.pbox.entities.out.UserOutEntity;

import java.util.ArrayList;

import butterknife.BindView;


public class CountryListActivity extends BaseActivity implements ToolsContract.View, AdapterView.OnItemClickListener {


    public static final String EXTRA_COUNTRY_TYPE = "extra_country_type";


    private ToosPresenter mPresenter;

    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;

    private int mType;

    @Override
    protected void initPreparation() {
        mPresenter = new ToosPresenter(this);

        mType = getIntent().getIntExtra(EXTRA_COUNTRY_TYPE, 0);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_country);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForLeft("请选择国家", null, getResources().getDrawable(R.drawable.icon_common_back));

        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

    }

    @Override
    protected void initListener() {
        mListView.setOnItemClickListener(this);
    }


    @Override
    protected void initData() {
        UserOutEntity user = ConfigDao.getInstance().getUser();
        String userid = user != null ? user.UserID : null;
        String type = String.valueOf(mType);
        mPresenter.reqToolsCountrys(userid, type);
    }

    @Override
    public Context getContext() {
        return this;
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
        mAdapter.setListData(data.Countrys);
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

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ToolsCountrysOutEntity.CountrysEntity country = mAdapter.getItem(position);
        post(new CountryEvent(country.CountryName));
        finish();
    }

    class Adapter extends CommonAdapter<ToolsCountrysOutEntity.CountrysEntity> {

        public Adapter() {
            super(CountryListActivity.this, R.layout.layout_country_item);
        }

        @Override
        public void convert(ViewHolder holder, ToolsCountrysOutEntity.CountrysEntity item) {
            holder.setText(R.id.tv_country, item.CountryName);

        }
    }

    public class CountryEvent {
        public String name;

        public CountryEvent(String name) {
            this.name = name;
        }
    }


}
