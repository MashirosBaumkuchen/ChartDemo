package com.example.admin.chartdemo.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.chartdemo.R;
import com.example.admin.chartdemo.contract.MultipleBarChartContract;
import com.example.admin.chartdemo.persenter.MultiplePersenter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MultipleBarChartActivity extends AppCompatActivity implements MultipleBarChartContract.View {
    private MultipleBarChartContract.Persenter persenter;
    @Bind(R.id.multiple_barchart)
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_barchart);
        ButterKnife.bind(this);
        new MultiplePersenter(this);

        initView();
        initData();
    }

    private void initView() {
        barChart.getDescription().setEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        barChart.setPinchZoom(false);
        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);

        Legend l = barChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(true);
        l.setYOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(8f);

        XAxis xl = barChart.getXAxis();
        xl.setGranularity(1f);
        xl.setCenterAxisLabels(true);
        xl.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return String.valueOf((int) value);
            }
        });

        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(false);
        leftAxis.setSpaceTop(30f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)

        barChart.getAxisRight().setEnabled(false);
    }

    private void initData() {
        float groupSpace = 0.04f;
        float barSpace = 0.02f; // x3 dataset
        float barWidth = 0.3f; // x3 dataset
        // (0.3 + 0.02) * 3 + 0.04 = 1.00 -> interval per "group"

        int startYear = 1980;
        int endYear = startYear + 5;

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();
        ArrayList<BarEntry> yVals3 = new ArrayList<BarEntry>();

        float mult = 5 * 10f;

        for (int i = startYear; i < endYear; i++) {
            float val = (float) (Math.random() * mult) + 3;
            yVals1.add(new BarEntry(i, val));
        }

        for (int i = startYear; i < endYear; i++) {
            float val = (float) (Math.random() * mult) + 3;
            yVals2.add(new BarEntry(i, val));
        }

        for (int i = startYear; i < endYear; i++) {
            float val = (float) (Math.random() * mult) + 3;
            yVals3.add(new BarEntry(i, val));
        }

        BarDataSet set1, set2, set3;

        if (barChart.getData() != null &&
                barChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) barChart.getData().getDataSetByIndex(0);
            set2 = (BarDataSet) barChart.getData().getDataSetByIndex(1);
            set3 = (BarDataSet) barChart.getData().getDataSetByIndex(2);
            set1.setValues(yVals1);
            set2.setValues(yVals2);
            set3.setValues(yVals3);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Company A");
            set1.setColor(Color.rgb(104, 241, 175));
            set2 = new BarDataSet(yVals2, "Company B");
            set2.setColor(Color.rgb(164, 228, 251));
            set3 = new BarDataSet(yVals3, "Company C");
            set3.setColor(Color.rgb(242, 247, 158));

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            dataSets.add(set2);
            dataSets.add(set3);

            BarData data = new BarData(dataSets);
            data.setValueFormatter(new LargeValueFormatter());

            barChart.setData(data);
        }

        barChart.getBarData().setBarWidth(barWidth);
        barChart.getXAxis().setAxisMinimum(startYear);
        barChart.getXAxis().setAxisMaximum(barChart.getBarData().getGroupWidth(groupSpace, barSpace) * 5 + startYear);
        barChart.groupBars(startYear, groupSpace, barSpace);
        barChart.invalidate();
    }

    @Override
    public void setPersenter(MultipleBarChartContract.Persenter persenter) {
        this.persenter = persenter;
    }
}
