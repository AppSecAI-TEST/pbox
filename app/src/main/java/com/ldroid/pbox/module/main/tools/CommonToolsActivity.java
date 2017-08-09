package com.ldroid.pbox.module.main.tools;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

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
import butterknife.OnClick;


public class CommonToolsActivity extends BaseActivity implements ToolsContract.View {


    private ToosPresenter mPresenter;

    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;

    @BindView(R.id.product_name)
    EditText productname;
    @BindView(R.id.et_country)
    EditText countryname;
    @BindView(R.id.grossfreight1)
    EditText grossfreight1;
    @BindView(R.id.grossfreight2)
    EditText grossfreight2;
    @BindView(R.id.profitmargin)
    EditText profitmargin;
    @BindView(R.id.incidentals)
    EditText incidentals;
    @BindView(R.id.price)
    EditText price;
    @BindView(R.id.exchangerate1)
    EditText exchangerate1;
    @BindView(R.id.amount)
    EditText amount;
    @BindView(R.id.exchangerate2)
    EditText exchangerate2;

    @Override
    protected void initPreparation() {
        mPresenter = new ToosPresenter(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_common_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForBoth("通用", null, getResources().getDrawable(R.drawable.icon_common_back),
                "计算", null);

        findViewById(R.id.tv_head_key).setVisibility(View.INVISIBLE);

        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_title_bar_right:
                reqToolsTY();
                break;
        }
    }


    private void reqToolsTY() {
        UserOutEntity user = ConfigDao.getInstance().getUser();
        String userid = user != null ? user.UserID : null;
        String productname = this.productname.getText().toString();
        String countryname = this.countryname.getText().toString();
        String profitmargin = this.profitmargin.getText().toString();
        String price = this.price.getText().toString();
        String amount = this.amount.getText().toString();
        String grossfreight1 = this.grossfreight1.getText().toString();
        String grossfreight2 = this.grossfreight2.getText().toString();
        String incidentals = this.incidentals.getText().toString();
        String exchangerate1 = this.exchangerate1.getText().toString();
        String exchangerate2 = this.exchangerate2.getText().toString();
        mPresenter.reqToolsTY(userid, productname, countryname,
                profitmargin, price, amount, grossfreight1, grossfreight2, incidentals, exchangerate1, exchangerate2);
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
        mAdapter.setListData(data.generateList());
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

    }

    class Adapter extends CommonAdapter<ToolsResultEntity> {

        public Adapter() {
            super(CommonToolsActivity.this, R.layout.layout_common_tools_item);
        }

        @Override
        public void convert(ViewHolder holder, ToolsResultEntity item) {
            holder.setText(R.id.tv_head_key, item.key);
            holder.setText(R.id.tv_foreign, item.value1);
            holder.setText(R.id.tv_china, item.value2);
            holder.setText(R.id.tv_ratio, item.value3);

            int color = getResources().getColor(R.color.colorHint);
            holder.setTextColor(R.id.tv_foreign, color);
            holder.setTextColor(R.id.tv_china, color);
            holder.setTextColor(R.id.tv_ratio, color);
        }
    }


}
