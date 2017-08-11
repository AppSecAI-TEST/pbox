package com.ipricebox.android.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.ipricebox.android.R;
import com.ipricebox.android.common.ui.BaseActivity;


public class BasePopupWindow extends PopupWindow {


    public OnPopupWindowItemSelectedListener mListener;
    public Context mContext;

    public View mContentView;

    /**
     *
     */
    public BasePopupWindow(Context ctx, int layout) {
        super(ctx);
        this.mContext = ctx;
        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContentView = inflater.inflate(layout, null);
        setContentView(mContentView);
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setAnimationStyle(R.style.popwin_anim_style);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        setBackgroundDrawable(dw);
        initUI();

    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        BaseActivity act = (BaseActivity) mContext;
        WindowManager.LayoutParams lp = act.getWindow().getAttributes();
        lp.alpha = bgAlpha; // 0.0-1.0
        act.getWindow().setAttributes(lp);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.widget.PopupWindow#showAtLocation(android.view.View, int,
     * int, int)
     */
    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        backgroundAlpha(0.7f);
        super.showAtLocation(parent, gravity, x, y);
    }

    /*
     * (non-Javadoc)
     *
     * @see android.widget.PopupWindow#dismiss()
     */
    @Override
    public void dismiss() {
        backgroundAlpha(1f);
        super.dismiss();
    }

    public void showFromBottom(View parent) {
        showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    public void initUI() {
    }


    public void setListener(OnPopupWindowItemSelectedListener l) {
        this.mListener = l;
    }

    public interface OnPopupWindowItemSelectedListener {
        void onItemSelected(Object... obj);
    }

}
