package com.example.admin.chartdemo.contract;

/**
 * Created by biao.ma on 2017/8/14.
 */

public interface MultipleBarChartContract {
    interface View{
        void setPersenter(MultipleBarChartContract.Persenter persenter);
    }
    interface Persenter{

    }
}
