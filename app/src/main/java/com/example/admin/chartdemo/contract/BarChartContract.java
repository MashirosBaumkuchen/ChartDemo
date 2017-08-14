package com.example.admin.chartdemo.contract;

import android.content.Context;

import com.github.mikephil.charting.data.BarData;

/**
 * Created by biao.ma on 2017/8/14.
 */

public interface BarChartContract {
    interface View {
        void setPersenter(BarChartContract.Persenter persenter);
        void loadChart(BarData data);
    }

    interface Persenter {
        void loadChartData(Context context);
    }
}
