package com.ipricebox.android.module.main.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
import com.ipricebox.android.common.ui.adapter.CommonAdapter;
import com.ipricebox.android.common.ui.adapter.ViewHolder;
import com.ipricebox.android.common.util.ListUtils;
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

import java.util.ArrayList;

import butterknife.BindView;


public class CountryListActivity extends BaseActivity implements ToolsContract.View, AdapterView.OnItemClickListener {


    public static final String EXTRA_COUNTRY_TYPE = "extra_country_type";


    private ToosPresenter mPresenter;

    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;

    private int mType;


    @BindView(R.id.et_search)
    EditText mEtSearch;

    private ArrayList<ToolsCountrysOutEntity.CountrysEntity> mResultList ;

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

        mEtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterCountry();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    private void filterCountry(){
        String filter = mEtSearch.getText().toString() ;
        ArrayList<ToolsCountrysOutEntity.CountrysEntity> searchList = new ArrayList<>();

        if (!ListUtils.isEmpty(mResultList)) {
            for (ToolsCountrysOutEntity.CountrysEntity c : mResultList) {
                if (!TextUtils.isEmpty(filter)) {
                    if (c.CountryName.contains(filter)) {
                        searchList.add(c);
                    }
                } else {
                    searchList.add(c);
                }
            }
        }
        mAdapter.setListData(searchList);
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
        mResultList = data.Countrys;
        filterCountry();

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
