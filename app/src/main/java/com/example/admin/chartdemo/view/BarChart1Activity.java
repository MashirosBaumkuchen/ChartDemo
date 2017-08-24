package com.example.admin.chartdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.chartdemo.contract.AnotherBarChartContract;
import com.example.admin.chartdemo.R;
import com.example.admin.chartdemo.persenter.BarChart1Persenter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BarChart1Activity extends AppCompatActivity implements AnotherBarChartContract.View {
    private AnotherBarChartContract.Persenter persenter;

    @Bind(R.id.bar_chart1)
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart1);
        ButterKnife.bind(this);
        new BarChart1Persenter(this);
        initView();
        persenter.loadChartData();
    }

    private void initView() {
        barChart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        barChart.setMaxVisibleValueCount(60);
        // scaling can now only be done on x- and y-axis separately
        barChart.setPinchZoom(false);
        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        barChart.getAxisLeft().setDrawGridLines(false);
        // add a nice and smooth animation
        barChart.animateY(200);
        barChart.getLegend().setEnabled(false);
    }

    @Override
    public void setPersenter(AnotherBarChartContract.Persenter persenter) {
        this.persenter = persenter;
    }

    @Override
    public void loadChart(BarData data) {
        data.setBarWidth(1f);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.invalidate();
    }
}
