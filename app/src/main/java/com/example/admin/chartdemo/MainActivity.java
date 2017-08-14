
package com.example.admin.chartdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.chartdemo.view.BarChart1Activity;
import com.example.admin.chartdemo.view.BarChartActivity;
import com.example.admin.chartdemo.view.ListViewChartActivity;
import com.example.admin.chartdemo.view.MultipleBarChartActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.go_barchart)
    void goBarChart() {
        Intent intent = new Intent(this, BarChartActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.go_barChart1)
    void goBarChart1() {
        Intent intent = new Intent(this, BarChart1Activity.class);
        startActivity(intent);
    }

    @OnClick(R.id.go_multiple_barchart)
    void goMultiple() {
        Intent intent = new Intent(this, MultipleBarChartActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.go_listview_barchart)
    void goListView() {
        Intent intent = new Intent(this, ListViewChartActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

}
