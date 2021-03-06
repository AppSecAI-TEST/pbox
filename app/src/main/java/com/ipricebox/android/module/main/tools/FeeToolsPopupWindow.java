package com.ipricebox.android.module.main.tools;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.ipricebox.android.R;
import com.ipricebox.android.widget.BasePopupWindow;

/**
 * Created by xianglong.liang on 2017/8/7.
 */
public class FeeToolsPopupWindow extends BasePopupWindow implements View.OnClickListener {

    /**
     * @param ctx
     */
    public FeeToolsPopupWindow(Context ctx) {
        super(ctx, R.layout.layout_fee_toos_pop);


        getContentView().findViewById(R.id.tv_small).setOnClickListener(this);
        getContentView().findViewById(R.id.tv_big).setOnClickListener(this);
        getContentView().findViewById(R.id.tv_ems).setOnClickListener(this);
        getContentView().findViewById(R.id.tv_eub).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_big:
                break;
            case R.id.tv_small:
                break;
            case R.id.tv_ems:
                break;
        }
        TextView text = TextView.class.cast(v);
        if (mListener != null) {
            mListener.onItemSelected(text.getText(), text.getTag());
        }
        dismiss();
    }


}
