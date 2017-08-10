package com.ldroid.pbox.module.main.tools;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
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
import com.ldroid.pbox.widget.BasePopupWindow;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;

import static com.ldroid.pbox.module.main.tools.CountryListActivity.EXTRA_COUNTRY_TYPE;


public class FeeToolsActivity extends BaseActivity implements ToolsContract.View{


    @BindView(R.id.channeltype)
    TextView channeltype;
    @BindView(R.id.root)
    View mRoot;

    private FeeToolsPopupWindow mPopWindow;


    private ToosPresenter mPresenter;


    @BindView(R.id.countryname) TextView countryname ;
    @BindView(R.id.weight) EditText weight ;
    @BindView(R.id.discount) EditText discount ;

    @BindView(R.id.Calculation1) TextView Calculation1 ;
    @BindView(R.id.Calculation2) TextView Calculation2 ;

    @BindView(R.id.ll_Calculation1) View Cal1Layout ;
    @BindView(R.id.ll_Calculation2) View Cal2Layout ;



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onCountryChanged(CountryListActivity.CountryEvent event) {
        countryname.setText(event.name);
    }



    @Override
    protected void initPreparation() {
        mPresenter = new ToosPresenter(this) ;
        register(this);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_fee_tools);
    }

    @Override
    protected void initUI() {
        setTranslucentStatus(0, R.drawable.bg_status_bar);

        initTopBarForLeft("运费估算", null, getResources().getDrawable(R.drawable.icon_common_back));

        mPopWindow = new FeeToolsPopupWindow(this);
        mPopWindow.setListener(new BasePopupWindow.OnPopupWindowItemSelectedListener() {
            @Override
            public void onItemSelected(Object... obj) {
                channeltype.setText(String.valueOf(obj[0]));
                channeltype.setTag(obj[1]);
            }
        });
    }


    @OnClick(R.id.countryname)
    public void onClickCountry() {
        startAnimActivity(new Intent(mContext, CountryListActivity.class)
                .putExtra(EXTRA_COUNTRY_TYPE,Integer.parseInt(channeltype.getTag().toString())));
    }



    @OnClick(R.id.channeltype)
    public void onClickEdit() {
        mPopWindow.showFromBottom(mRoot);
    }

    @OnClick(R.id.btn_search)
    public void onClickSearch(){
        UserOutEntity user = ConfigDao.getInstance().getUser();
        String userid = user != null ? user.UserID : null;
        String channeltype = this.channeltype.getTag().toString();
        String countryname = this.countryname.getText().toString();
        String weight = this.weight.getText().toString();
        String discount = this.discount.getText().toString();
        mPresenter.reqToolsYFGS(userid, channeltype, countryname, weight, discount);
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
        ToastUtils.showLongToast(mContext,msg);
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
        Calculation1.setText("运费：" + data.Calculation1 + "本币");
        Calculation2.setText("抛重：" + data.Calculation2 + "本币");

        Cal1Layout.setVisibility(TextUtils.isEmpty(data.Calculation1) || Double.parseDouble
                (data.Calculation1) == 0 ? View.GONE : View.VISIBLE);
        Cal2Layout.setVisibility(TextUtils.isEmpty(data.Calculation2) || Double.parseDouble
                (data.Calculation2) == 0 ? View.GONE :
                View
                .VISIBLE);
    }

    @Override
    public void onRespToolsWLZZ(ToolsWLZZOutEntity data) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregister(this);
    }

}
