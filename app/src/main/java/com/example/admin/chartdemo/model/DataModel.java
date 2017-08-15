package com.example.admin.chartdemo.model;

import android.graphics.Color;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by biao.ma on 2017/8/14.
 */

public class DataModel {
    public static final int[] COLORS = {
            Color.rgb(94, 94, 94), Color.rgb(94, 94, 94)};

    private CallBack callBack;

    public DataModel(CallBack callBack) {
        this.callBack = callBack;
    }

    public void getBarChartData() {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 20f));
        entries.add(new BarEntry(4f, 40f));
        entries.add(new BarEntry(5f, 10f));
        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        set.setColors(DataModel.COLORS);
        BarData data = new BarData(set);
        data.setBarWidth(0.15f); // set custom bar width
        callBack.onSuccess(data);
    }

    public void getBarChart1Data() {
        ArrayList<BarEntry> yVals1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            float mult = (5);
            float val = (float) (Math.random() * mult) + mult / 3;
            if (i % 3 != 1)
                val = val * (i % 3 - 1);
            yVals1.add(new BarEntry(i, val));
        }
        BarDataSet set1 = new BarDataSet(yVals1, "Data Set");
        set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set1.setDrawValues(false);
        ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        BarData data = new BarData(dataSets);
        callBack.onSuccess(data);
    }

    public interface CallBack {
        void onSuccess(BarData data);

        void onFail(String msg);
    }
}
