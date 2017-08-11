package com.ipricebox.android.module.main.tools;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
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

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

import static com.ipricebox.android.module.main.tools.CountryListActivity.EXTRA_COUNTRY_TYPE;


public class PostalSmallToolsActivity extends BaseActivity implements ToolsContract.View{

    private ToosPresenter mPresenter;

    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;

    @BindView(R.id.productname)
    EditText productname ;
    @BindView(R.id.countryname)
    TextView countryname ;
    @BindView(R.id.profitmargin) EditText profitmargin ;
    @BindView(R.id.cost) EditText cost ;
    @BindView(R.id.weight) EditText weight ;
    @BindView(R.id.discount) EditText discount ;
    @BindView(R.id.incidentals) EditText incidentals ;
    @BindView(R.id.exchangerate1) EditText exchangerate1 ;
    @BindView(R.id.exchangerate2) EditText exchangerate2 ;




    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCountryChanged(CountryListActivity.CountryEvent event) {
        countryname.setText(event.name);
    }


    @Override
    protected void initPreparation() {
        mPresenter = new ToosPresenter(this);
        register(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_postal_small_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForBoth("中国邮政小包", null, getResources().getDrawable(R.drawable.icon_common_back),
                "计算", null);

        findViewById(R.id.tv_head_key).setVisibility(View.INVISIBLE);

        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

    }

    @Override
    protected void initListener() {

    }

    @OnClick(R.id.countryname)
    public void onClickCountry() {
        startAnimActivity(new Intent(mContext, CountryListActivity.class)
                .putExtra(EXTRA_COUNTRY_TYPE, ToolsContract.CountryType.SMALL));
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_title_bar_right:
                reqToolsGHXB();
                break;
        }
    }


    private void reqToolsGHXB() {
        UserOutEntity user = ConfigDao.getInstance().getUser();
        String userid = user != null ? user.UserID : null;
        String productname = this.productname.getText().toString();
        String countryname = this.countryname.getText().toString();
        String profitmargin = this.profitmargin.getText().toString();
        String cost = this.cost.getText().toString();
        String weight = this.weight.getText().toString();
        String discount = this.discount.getText().toString();
        String incidentals = this.incidentals.getText().toString();
        String exchangerate1 = this.exchangerate1.getText().toString();
        String exchangerate2 = this.exchangerate2.getText().toString();
        mPresenter.reqToolsGHXB(userid, productname, countryname, profitmargin,
                cost, weight, discount, incidentals, exchangerate1, exchangerate2);
    }

    @Override
    protected void initData() {

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
        mAdapter.setListData(data.generateList());
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

    }


    class Adapter extends CommonAdapter<ToolsResultEntity> {

        public Adapter() {
            super(PostalSmallToolsActivity.this, R.layout.layout_common_tools_item);
        }

        @Override
        public void convert(ViewHolder holder, ToolsResultEntity item) {
            holder.setText(R.id.tv_head_key, item.key);
            holder.setText(R.id.tv_foreign, item.getValue1());
            holder.setText(R.id.tv_china, item.getValue2());
            holder.setText(R.id.tv_ratio, item.getValue3());

            int color = getResources().getColor(R.color.colorText);
            holder.setTextColor(R.id.tv_foreign, color);
            holder.setTextColor(R.id.tv_china, color);
            holder.setTextColor(R.id.tv_ratio, color);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregister(this);
    }
}
