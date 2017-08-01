package com.ldroid.pbox.widget.calendar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.ldroid.pbox.R;
import com.ldroid.pbox.common.util.DensityUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CalendarLayout extends LinearLayout implements View.OnClickListener, AdapterView.OnItemClickListener {


    private GestureDetector mDetector;
    private CalendarAdapter mAdapter;
    private ViewFlipper mFlipper;
    private GridView mGridView;
    private int mJumpMonth;
    private int mJumpYear;

    private int mYear;
    private int mMonth;
    private int mDay;
    private String mDate;
    private TextView mTvTitle;

    private Animation mLeftInAnim;
    private Animation mLeftOutAnim;
    private Animation mRightInAnim;
    private Animation mRightOutAnim;


    public CalendarLayout(Context context) {
        super(context);
        initView(context);
    }

    public CalendarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CalendarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        initDefaultDate();

        mLeftInAnim = AnimationUtils.loadAnimation(getContext(), R.anim.push_left_in);
        mLeftOutAnim = AnimationUtils.loadAnimation(getContext(), R.anim.push_left_out);

        mRightInAnim = AnimationUtils.loadAnimation(getContext(), R.anim.push_right_in);
        mRightOutAnim = AnimationUtils.loadAnimation(getContext(), R.anim.push_right_out);


        LayoutInflater mInflater = LayoutInflater.from(context);
        View root = mInflater.inflate(R.layout.layout_calendar, null);


        mTvTitle = (TextView) root.findViewById(R.id.currentMonth);

        mDetector = new GestureDetector(context, new MyGestureListener());
        mFlipper = (ViewFlipper) root.findViewById(R.id.flipper);
        mFlipper.removeAllViews();
        mAdapter = new CalendarAdapter(context, getResources(), mJumpMonth, mJumpYear, mYear, mMonth,
                mDay);
        generateGridView();
        mGridView.setAdapter(mAdapter);
        mFlipper.addView(mGridView, 0);
        setTitleText();

        root.findViewById(R.id.nextMonth).setOnClickListener(this);
        root.findViewById(R.id.prevMonth).setOnClickListener(this);

        addView(root);

    }

    private void initDefaultDate() {
        mDate = new SimpleDateFormat("yyyy-M-d").format(new Date());
        mYear = Integer.parseInt(mDate.split("-")[0]);
        mMonth = Integer.parseInt(mDate.split("-")[1]);
        mDay = Integer.parseInt(mDate.split("-")[2]);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > 120) {
                next();
                return true;
            } else if (e1.getX() - e2.getX() < -120) {
                previous();
                return true;
            }
            return false;
        }
    }


    private void next() {
        generateGridView();
        mJumpMonth++;
        mAdapter = new CalendarAdapter(getContext(), getContext().getResources(), mJumpMonth, mJumpYear, mYear, mMonth,
                mDay);
        mGridView.setAdapter(mAdapter);
        setTitleText();
        mFlipper.addView(mGridView, 1);
        mFlipper.setInAnimation(mLeftInAnim);
        mFlipper.setOutAnimation(mLeftOutAnim);
        mFlipper.showNext();
        mFlipper.removeViewAt(0);
    }


    private void previous() {
        generateGridView();
        mJumpMonth--;
        mAdapter = new CalendarAdapter(getContext(), getResources(), mJumpMonth, mJumpYear, mYear,
                mMonth,
                mDay);
        mGridView.setAdapter(mAdapter);
        setTitleText();
        mFlipper.addView(mGridView, 1);

        mFlipper.setInAnimation(mRightInAnim);
        mFlipper.setOutAnimation(mRightOutAnim);
        mFlipper.showPrevious();
        mFlipper.removeViewAt(0);
    }


    public void setTitleText() {
        StringBuffer textDate = new StringBuffer();
        textDate.append(mAdapter.getShowYear()).append("年").append(mAdapter.getShowMonth()).append("月");
        mTvTitle.setText(textDate);
    }

    private void generateGridView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                AbsListView.LayoutParams.MATCH_PARENT);

        mGridView = new GridView(getContext());
        mGridView.setNumColumns(7);
        mGridView.setColumnWidth(DensityUtils.dp2px(getContext(), 55));
        mGridView.setGravity(Gravity.CENTER);
        mGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        mGridView.setHorizontalSpacing(DensityUtils.dp2px(getContext(), 7));
        mGridView.setVerticalSpacing(DensityUtils.dp2px(getContext(), 7));
        mGridView.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                return mDetector.onTouchEvent(event);
            }
        });

        mGridView.setOnItemClickListener(this);
        mGridView.setLayoutParams(params);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextMonth:
                next();
                break;
            case R.id.prevMonth:
                previous();
                break;
        }
    }

}
