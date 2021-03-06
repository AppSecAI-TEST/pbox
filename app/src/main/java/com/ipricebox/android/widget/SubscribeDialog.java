package com.ipricebox.android.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;


public class SubscribeDialog extends AppCompatDialog {


    public static final int ONE_MONTH = 1 ;
    public static final int THREE_MONTH = 2 ;
    public static final int HALF_YEAR = 3 ;
    public static final int ONE_YEAR = 4 ;

    private BaseActivity mAct;


    public SubscribeDialog(Context context) {
        super(context, R.style.main_alert_dialog);
        mAct = (BaseActivity) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_subscribe_dialog);

        TextView originalText = (TextView) findViewById(R.id.tv_original);


        findViewById(R.id.dismiss).setOnClickListener(mItemClickListener);
    }

    View.OnClickListener mItemClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            }
            dismiss();

        }
    };


}
