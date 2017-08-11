package com.ipricebox.android.module.main.tools;

import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;
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
import butterknife.OnClick;


public class WeightToolsActivity extends BaseActivity implements  ToolsContract.View{

    private ToosPresenter mPresenter;


    @BindView(R.id.length) EditText length ;
    @BindView(R.id.width) EditText width ;
    @BindView(R.id.height) EditText height ;
    @BindView(R.id.countingbase) EditText countingbase ;
    @BindView(R.id.result) TextView result ;


    @Override
    protected void initPreparation() {
        mPresenter = new ToosPresenter(this) ;
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_weight_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForLeft("抛重换算", null, getResources().getDrawable(R.drawable.icon_common_back));


    }


    @OnClick(R.id.btn_search)
    public void onClickSearch(){
        UserOutEntity user = ConfigDao.getInstance().getUser();
        String userid = user != null ? user.UserID : null;
        String length = this.length.getText().toString();
        String width = this.width.getText().toString();
        String height = this.height.getText().toString();
        String countingbase = this.countingbase.getText().toString();
        mPresenter.reqToolsPZHS(userid, length, width, height, countingbase);
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
        ToastUtils.showCustomToast(mContext,msg);
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
        result.setText("抛重：" + data.Calculation + "KG");
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
}
