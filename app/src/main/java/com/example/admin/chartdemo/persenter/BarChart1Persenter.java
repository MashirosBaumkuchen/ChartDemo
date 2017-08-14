package com.example.admin.chartdemo.persenter;

import com.example.admin.chartdemo.contract.AnotherBarChartContract;
import com.example.admin.chartdemo.model.DataModel;
import com.github.mikephil.charting.data.BarData;

/**
 * Created by biao.ma on 2017/8/14.
 */

public class BarChart1Persenter implements AnotherBarChartContract.Persenter, DataModel.CallBack {
    private AnotherBarChartContract.View view;

    public BarChart1Persenter(AnotherBarChartContract.View view) {
        this.view = view;
        view.setPersenter(this);
    }

    @Override
    public void loadChartData() {
        new DataModel(this).getBarChart1Data();
    }

    @Override
    public void onSuccess(BarData data) {
        view.loadChart(data);
    }

    @Override
    public void onFail(String msg) {

    }
}
