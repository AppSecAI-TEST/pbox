package com.ipricebox.android.module.main.tools;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

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

import butterknife.BindView;


public class ProfitToolsActivity extends BaseActivity implements ToolsContract.View{



    private ToosPresenter mPresenter;

    @BindView(R.id.list_view)
    ListView mListView;
    private Adapter mAdapter;

    @BindView(R.id.productname)
    EditText productname ;
    @BindView(R.id.countryname) EditText countryname;
    @BindView(R.id.sellingprice) EditText sellingprice;
    @BindView(R.id.cost) EditText cost;
    @BindView(R.id.grossfreight2) EditText grossfreight2;
    @BindView(R.id.incidentals) EditText incidentals;
    @BindView(R.id.exchangerate1) EditText exchangerate1;
    @BindView(R.id.exchangerate2) EditText exchangerate2;




    @Override
    protected void initPreparation() {
        mPresenter = new ToosPresenter(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_profit_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForBoth("成本利润", null, getResources().getDrawable(R.drawable.icon_common_back),
                "计算", null);

        findViewById(R.id.tv_head_key).setVisibility(View.INVISIBLE);

        mAdapter = new Adapter();
        mListView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_title_bar_right:
                reqToolsCBLR();
                break;
        }
    }


    private void reqToolsCBLR() {
        UserOutEntity user = ConfigDao.getInstance().getUser();
        String userid = user != null ? user.UserID : null;
        String productname = this.productname.getText().toString();
        String countryname = this.countryname.getText().toString();
        String sellingprice = this.sellingprice.getText().toString();
        String cost = this.cost.getText().toString();
        String grossfreight2 = this.grossfreight2.getText().toString();
        String incidentals = this.incidentals.getText().toString();
        String exchangerate1 = this.exchangerate1.getText().toString();
        String exchangerate2 = this.exchangerate2.getText().toString();

        mPresenter.reqToolsCBLR(userid, productname, countryname,
                sellingprice, cost, grossfreight2, incidentals, exchangerate1, exchangerate2);
    }

    @Override
    protected void initListener() {
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
        mAdapter.setListData(data.generateList());

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
            super(ProfitToolsActivity.this, R.layout.layout_common_tools_item);
        }

        @Override
        public void convert(ViewHolder holder, ToolsResultEntity item) {
            holder.setText(R.id.tv_head_key, item.key);
            holder.setText(R.id.tv_foreign, item.getValue1());
            holder.setText(R.id.tv_china, item.getValue2());
            holder.setText(R.id.tv_ratio, item.getValue3());


            holder.setVisible(R.id.tv_china, !TextUtils.isEmpty(item.value2));
            holder.setVisible(R.id.tv_ratio, !TextUtils.isEmpty(item.value3));

            int color = getResources().getColor(R.color.colorText);
            holder.setTextColor(R.id.tv_foreign, color);
            holder.setTextColor(R.id.tv_china, color);
            holder.setTextColor(R.id.tv_ratio, color);
        }
    }


}
