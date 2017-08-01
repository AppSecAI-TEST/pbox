package com.ldroid.pbox.widget.calendar;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.ui.BaseActivity;
import com.ldroid.pbox.common.util.DensityUtils;


public class CalendarActivity extends BaseActivity {

    private GestureDetector mDetector;
    private CalendarAdapter mAdapter;
    private ViewFlipper mFlipper;
    private GridView mGridView;
    private int jumpMonth = 0; // 每次滑动，增加或减去一个月,默认为0（即显示当前月）
    private int jumpYear = 0; // 滑动跨越一年，则增加或者减去一年,默认为0(即当前年)
    private int mYear = 0;
    private int mMonth = 0;
    private int mDay = 0;
    private String currentDate = "";
    private int gvFlag = 0;
    private TextView currentMonth;


    @Override
    protected void initPreparation() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        currentDate = sdf.format(date); // 当期日期
        mYear = Integer.parseInt(currentDate.split("-")[0]);
        mMonth = Integer.parseInt(currentDate.split("-")[1]);
        mDay = Integer.parseInt(currentDate.split("-")[2]);
    }

    @Override
    protected void setContentView() {
        setContentView(R.layout.ac_calendar);
    }

    @Override
    protected void initUI() {
        currentMonth = (TextView) findViewById(R.id.currentMonth);

        mDetector = new GestureDetector(this, new MyGestureListener());
        mFlipper = (ViewFlipper) findViewById(R.id.flipper);
        mFlipper.removeAllViews();
        mAdapter = new CalendarAdapter(this, getResources(), jumpMonth, jumpYear, mYear, mMonth,
                mDay);
        addGridView();
        mGridView.setAdapter(mAdapter);
        mFlipper.addView(mGridView, 0);
        addTextToTopTextView(currentMonth);
    }

    @Override
    protected void initListener() {
        findViewById(R.id.prevMonth).setOnClickListener(this);
        findViewById(R.id.nextMonth).setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    private class MyGestureListener extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            int gvFlag = 0; // 每次添加gridview到viewflipper中时给的标记
            if (e1.getX() - e2.getX() > 120) {
                // 像左滑动
                enterNextMonth(gvFlag);
                return true;
            } else if (e1.getX() - e2.getX() < -120) {
                // 向右滑动
                enterPrevMonth(gvFlag);
                return true;
            }
            return false;
        }
    }

    /**
     * 移动到下一个月
     *
     * @param gvFlag
     */
    private void enterNextMonth(int gvFlag) {
        addGridView(); // 添加一个gridView
        jumpMonth++; // 下一个月

        mAdapter = new CalendarAdapter(this, this.getResources(), jumpMonth, jumpYear, mYear, mMonth,
                mDay);
        mGridView.setAdapter(mAdapter);
        addTextToTopTextView(currentMonth); // 移动到下一月后，将当月显示在头标题中
        gvFlag++;
        mFlipper.addView(mGridView, gvFlag);
        mFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_in));
        mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_left_out));
        mFlipper.showNext();
        mFlipper.removeViewAt(0);
    }

    /**
     * 移动到上一个月
     *
     * @param gvFlag
     */
    private void enterPrevMonth(int gvFlag) {
        addGridView(); // 添加一个gridView
        jumpMonth--; // 上一个月

        mAdapter = new CalendarAdapter(this, this.getResources(), jumpMonth, jumpYear, mYear, mMonth,
                mDay);
        mGridView.setAdapter(mAdapter);
        gvFlag++;
        addTextToTopTextView(currentMonth); // 移动到上一月后，将当月显示在头标题中
        mFlipper.addView(mGridView, gvFlag);

        mFlipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_in));
        mFlipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_right_out));
        mFlipper.showPrevious();
        mFlipper.removeViewAt(0);
    }

    /**
     * 添加头部的年份 闰哪月等信息
     *
     * @param view
     */
    public void addTextToTopTextView(TextView view) {
        StringBuffer textDate = new StringBuffer();
        textDate.append(mAdapter.getShowYear()).append("年").append(mAdapter.getShowMonth()).append("月")
                .append("\t");
        view.setText(textDate);
    }

    private void addGridView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);

        mGridView = new GridView(this);
        mGridView.setNumColumns(7);
        mGridView.setColumnWidth(DensityUtils.dp2px(this, 55));
        mGridView.setGravity(Gravity.CENTER);
        mGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        mGridView.setHorizontalSpacing(DensityUtils.dp2px(this, 7));
        mGridView.setVerticalSpacing(DensityUtils.dp2px(this, 7));
        mGridView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return CalendarActivity.this.mDetector.onTouchEvent(event);
            }
        });

        mGridView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                // 点击任何一个item，得到这个item的日期(排除点击的是周日到周六(点击不响应))
                int startPosition = mAdapter.getStartPositon();
                int endPosition = mAdapter.getEndPosition();
                if (startPosition <= position + 7 && position <= endPosition - 7) {
                    mAdapter.updateCheckedDay(position);
                    String scheduleDay = mAdapter.getDateByClickItem(position);
                    String scheduleYear = mAdapter.getShowYear();
                    String scheduleMonth = mAdapter.getShowMonth();
                }
            }
        });
        mGridView.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextMonth: // 下一个月
                enterNextMonth(gvFlag);
                break;
            case R.id.prevMonth: // 上一个月
                enterPrevMonth(gvFlag);
                break;
            default:
                break;
        }
    }

}