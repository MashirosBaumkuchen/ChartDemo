package com.example.admin.chartdemo.formater;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.DecimalFormat;

/**
 * Created by biao.ma on 2017/8/14.
 */

public class DecimaFromat implements IAxisValueFormatter {
    private DecimalFormat mFormat;

    public DecimaFromat() {
        mFormat = new DecimalFormat("###,###,###,##0.0");
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        return mFormat.format(value) + " %";
    }

}
