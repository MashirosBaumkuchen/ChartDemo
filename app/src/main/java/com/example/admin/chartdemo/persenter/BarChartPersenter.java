package com.example.admin.chartdemo.persenter;

import android.content.Context;

import com.example.admin.chartdemo.contract.BarChartContract;
import com.example.admin.chartdemo.model.DataModel;
import com.github.mikephil.charting.data.BarData;

/**
 * Created by biao.ma on 2017/8/14.
 */

public class BarChartPersenter implements BarChartContract.Persenter, DataModel.CallBack {
    private BarChartContract.View view;

    public BarChartPersenter(BarChartContract.View view) {
        this.view = view;
        view.setPersenter(this);
    }

    @Override
    public void loadChartData(Context context) {
        new DataModel(this).getBarChartData();
    }

    @Override
    public void onSuccess(BarData data) {
        view.loadChart(data);
    }

    @Override
    public void onFail(String msg) {

    }
}
