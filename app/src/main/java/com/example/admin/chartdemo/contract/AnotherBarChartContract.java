package com.example.admin.chartdemo.contract;

import com.github.mikephil.charting.data.BarData;

/**
 * Created by biao.ma on 2017/8/14.
 */

public interface AnotherBarChartContract {
    interface View {
        void setPersenter(AnotherBarChartContract.Persenter persenter);

        void loadChart(BarData data);
    }

    interface Persenter {
        void loadChartData();
    }
}
