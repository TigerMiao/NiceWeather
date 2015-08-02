package com.tiger_miao.niceweather.model;

import java.util.List;

/**
 * Created by tiger_miao on 15-7-2.
 */
public interface IChooseAreaActivityViewModel {
    int TYPE_PROVINCE = 0;
    int TYPE_CITY = 1;
    int TYPE_COUNTY = 2;

    List<String> getDataList();

    void setAreaType(int areaType);
}
