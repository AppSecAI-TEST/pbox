package com.ldroid.pbox.widget;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.TextView;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;


public class SubscribeDialog extends AppCompatDialog {

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
        originalText.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);


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
