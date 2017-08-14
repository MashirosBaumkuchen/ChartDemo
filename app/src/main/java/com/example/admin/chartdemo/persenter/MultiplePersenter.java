package com.example.admin.chartdemo.persenter;

import com.example.admin.chartdemo.contract.MultipleBarChartContract;
import com.example.admin.chartdemo.view.MultipleBarChartActivity;

/**
 * Created by biao.ma on 2017/8/14.
 */

public class MultiplePersenter implements MultipleBarChartContract.Persenter {
    private MultipleBarChartContract.View view;

    public MultiplePersenter(MultipleBarChartActivity multipleBarChartActivity) {
        this.view = multipleBarChartActivity;
        view.setPersenter(this);
    }
}
