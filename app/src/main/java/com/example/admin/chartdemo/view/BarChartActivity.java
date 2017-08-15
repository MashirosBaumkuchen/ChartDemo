package com.example.admin.chartdemo.view;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;

import com.example.admin.chartdemo.contract.BarChartContract;
import com.example.admin.chartdemo.formater.DecimaFromat;
import com.example.admin.chartdemo.formater.MyFormat;
import com.example.admin.chartdemo.R;
import com.example.admin.chartdemo.model.DataModel;
import com.example.admin.chartdemo.persenter.BarChartPersenter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.utils.ColorTemplate;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by biao.ma on 2017/8/14.
 */

public class BarChartActivity extends AppCompatActivity implements BarChartContract.View {
    private BarChartContract.Persenter persenter;

    @Bind(R.id.bar_chart)
    BarChart barChart;

    @Bind(R.id.bar_chart_date)
    Button date;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchart);

        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        ButterKnife.bind(this);
        new BarChartPersenter(this);
        initChart();
        persenter.loadChartData(this);
    }

    private void initChart() {
        barChart.setDrawBarShadow(false);//取消柱状item背景色
        barChart.setDrawValueAboveBar(true);//在item之上显示value
        barChart.getDescription().setEnabled(false);//取消description。默认在右下角
        barChart.setDrawGridBackground(false);//取消画grid

        // barChart x轴显示内容设置
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new MyFormat());
        xAxis.setGranularity(1f); // only intervals of 1 day

        // barChart y轴显示内容
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setLabelCount(4, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setValueFormatter(new DecimaFromat());
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        barChart.getLegend().setEnabled(true);// 取消图例
        Legend legend = barChart.getLegend();
        legend.setTextColor(Color.WHITE);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        barChart.getAxisRight().setEnabled(false);// 取消右侧视图

        //TODO
        barChart.getAxisLeft().setEnabled(false);// 取消左侧视图
        barChart.getXAxis().setEnabled(false);// 取消横向视图

        barChart.setDoubleTapToZoomEnabled(false);// 取消双击方法事件
        barChart.setDragEnabled(false);// 取消拖动
        barChart.setTouchEnabled(false);// 取消触摸监听
        barChart.getXAxis().setDrawGridLines(false);// 取消绘制基于x的刻度线，即取消绘制竖线
        barChart.setFitBars(true); // 动态加载
        barChart.animateY(200);// 缩放动画duration
    }

    @Override
    public void loadChart(BarData data) {
        barChart.setData(data);
        barChart.invalidate(); // refresh
    }

    @Override
    public void setPersenter(BarChartContract.Persenter persenter) {
        this.persenter = persenter;
    }
}
