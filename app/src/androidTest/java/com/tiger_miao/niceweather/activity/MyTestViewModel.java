package com.tiger_miao.niceweather.activity;

import com.tiger_miao.niceweather.model.IChooseAreaActivityViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiger on 15-7-7.
 */
public class MyTestViewModel implements IChooseAreaActivityViewModel {
    @Override
    public List<String> getDataList() {
        List<String> dataList = new ArrayList<>();

        dataList.add("北京");
        dataList.add("天津");
        dataList.add("上海");
        dataList.add("成都");

        return dataList;
    }
}
