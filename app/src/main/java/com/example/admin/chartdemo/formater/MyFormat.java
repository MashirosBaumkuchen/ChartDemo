package com.example.admin.chartdemo.formater;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

/**
 * Created by biao.ma on 2017/8/14.
 */

public class MyFormat implements IAxisValueFormatter {
    protected String[] mMonths = new String[]{
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mMonths[(int) value];
    }
}
