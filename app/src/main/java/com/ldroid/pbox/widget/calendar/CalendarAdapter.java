package com.ldroid.pbox.widget.calendar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ldroid.pbox.R;


@SuppressLint("SimpleDateFormat")
public class CalendarAdapter extends BaseAdapter {


    private boolean isLeapyear = false; // 是否为闰年
    private int daysOfMonth = 0; // 某月的天数
    private int dayOfWeek = 0; // 具体某一天是星期几
    private int lastDaysOfMonth = 0; // 上一个月的总天数
    private Context context;
    private static final int DAY_SIZE = 42 ;
    private ArrayList<CalendarEntity> mDayList = new ArrayList<>(DAY_SIZE) ;
    private String currentYear = "";

    private SpecialCalendar mSepCalendar;
    private String currentMonth = "";

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d", Locale.getDefault());

    private String showYear = ""; // 用于在头部显示的年份
    private String showMonth = ""; // 用于在头部显示的月份
    // 系统当前时间
    private String sysDate = "";
    private String sys_year = "";
    private String sys_month = "";
    private String sys_day = "";

    public CalendarAdapter() {
        Date date = new Date();
        sysDate = sdf.format(date); // 当期日期
        sys_year = sysDate.split("-")[0];
        sys_month = sysDate.split("-")[1];
        sys_day = sysDate.split("-")[2];

    }

    public CalendarAdapter(Context context, Resources rs, int jumpMonth, int jumpYear, int year_c,
                           int month_c, int day_c) {
        this();
        this.context = context;
        mSepCalendar = new SpecialCalendar();

        int stepYear = year_c + jumpYear;
        int stepMonth = month_c + jumpMonth;
        if (stepMonth > 0) {
            // 往下一个月滑动
            if (stepMonth % 12 == 0) {
                stepYear = year_c + stepMonth / 12 - 1;
                stepMonth = 12;
            } else {
                stepYear = year_c + stepMonth / 12;
                stepMonth = stepMonth % 12;
            }
        } else {
            // 往上一个月滑动
            stepYear = year_c - 1 + stepMonth / 12;
            stepMonth = stepMonth % 12 + 12;
            if (stepMonth % 12 == 0) {

            }
        }

        currentYear = String.valueOf(stepYear); // 得到当前的年份
        currentMonth = String.valueOf(stepMonth); // 得到本月
        // （jumpMonth为滑动的次数，每滑动一次就增加一月或减一月）

        getCalendar(Integer.parseInt(currentYear), Integer.parseInt(currentMonth));

    }

    public CalendarAdapter(Context context, Resources rs, int year, int month, int day) {
        this();
        this.context = context;
        mSepCalendar = new SpecialCalendar();
        currentYear = String.valueOf(year);// 得到跳转到的年份
        currentMonth = String.valueOf(month); // 得到跳转到的月份
        getCalendar(Integer.parseInt(currentYear), Integer.parseInt(currentMonth));
    }

    @Override
    public int getCount() {
        return mDayList == null ? 0 : mDayList.size();
    }

    @Override
    public Object getItem(int position) {
        return (mDayList == null || mDayList.isEmpty()) ? null : mDayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_calendar_item, null);
        }

        CalendarEntity entity = (CalendarEntity) getItem(position);
        TextView textView = (TextView) convertView.findViewById(R.id.tvtext);
        String d = entity.day;
        SpannableString sp = new SpannableString(d);
        sp.setSpan(new RelativeSizeSpan(1f), 0, d.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(sp);

        // 当月
        if (position < daysOfMonth + dayOfWeek && position >= dayOfWeek) {
            textView.setTextColor(!entity.checked ? context.getResources().getColor(R.color.colorText)
                    : Color.WHITE);
        }else{
            textView.setTextColor(context.getResources().getColor(R.color.colorHint));
        }
        textView.setBackgroundResource(entity.checked ? R.drawable.bg_date_picker_day : 0);

        return convertView;
    }

    // 得到某年的某月的天数且这月的第一天是星期几
    public void getCalendar(int year, int month) {
        isLeapyear = mSepCalendar.isLeapYear(year); // 是否为闰年
        daysOfMonth = mSepCalendar.getDaysOfMonth(isLeapyear, month); // 某月的总天数
        dayOfWeek = mSepCalendar.getWeekdayOfMonth(year, month); // 某月第一天为星期几
        lastDaysOfMonth = mSepCalendar.getDaysOfMonth(isLeapyear, month - 1); // 上一个月的总天数
        getweek(year, month);
    }

    // 将一个月中的每一天的值添加入数组dayNuber中
    private void getweek(int year, int month) {
        mDayList.clear();
        int j = 1;
        // 得到当前月的所有日程日期(这些日期需要标记)
        for (int i = 0; i < DAY_SIZE; i++) {
            String calendar ;
            if (i < dayOfWeek) {
                // 前一个月
                int temp = lastDaysOfMonth - dayOfWeek + 1;
                calendar = String.valueOf(temp + i) ;
            } else if (i < daysOfMonth + dayOfWeek) {
                // 本月
                calendar = String.valueOf( i - dayOfWeek + 1) ;
                setShowYear(String.valueOf(year));
                setShowMonth(String.valueOf(month));
            } else {
                // 下一个月
                calendar = String.valueOf(j ) ;
                j++;
            }
            mDayList.add(new CalendarEntity(calendar,false));
        }

    }

    public void updateCheckedDay(int position){
       CalendarEntity entity = (CalendarEntity) getItem(position);
        if(entity != null){
            entity.checked = !entity.checked ;
            notifyDataSetChanged();
        }
    }


    /**
     * 点击每一个item时返回item中的日期
     *
     * @param position
     * @return
     */
    public String getDateByClickItem(int position) {
        return getItem(position) != null ? CalendarEntity.class.cast(getItem(position)).day : null;
    }

    /**
     * 在点击gridView时，得到这个月中第一天的位置
     *
     * @return
     */
    public int getStartPositon() {
        return dayOfWeek + 7;
    }

    /**
     * 在点击gridView时，得到这个月中最后一天的位置
     *
     * @return
     */
    public int getEndPosition() {
        return (dayOfWeek + daysOfMonth + 7) - 1;
    }

    public String getShowYear() {
        return showYear;
    }

    public void setShowYear(String showYear) {
        this.showYear = showYear;
    }

    public String getShowMonth() {
        return showMonth;
    }

    public void setShowMonth(String showMonth) {
        this.showMonth = showMonth;
    }

    public class CalendarEntity{
        public String day ;
        public boolean checked ;

        public CalendarEntity(String day, boolean checked) {
            this.day = day;
            this.checked = checked;
        }
    }

}
