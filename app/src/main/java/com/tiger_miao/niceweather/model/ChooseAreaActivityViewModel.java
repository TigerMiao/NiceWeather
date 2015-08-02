package com.tiger_miao.niceweather.model;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiger_miao on 15-7-2.
 */
public class ChooseAreaActivityViewModel implements IChooseAreaActivityViewModel {
    private int areaType;

    @Inject
    private IAreaDao areaDao;

    @Override
    public void setAreaType(int areaType) {
        this.areaType = areaType;
    }

    @Override
    public List<String> getDataList() {
        List<String> dataList = new ArrayList<>();

        switch (areaType) {
            case TYPE_PROVINCE:
                for (Province province : areaDao.loadAllProvinces()) {
                    dataList.add(province.getProvinceName());
                }
                break;

            case TYPE_CITY:
                for (City city : areaDao.loadAllCities()) {
                    dataList.add(city.getCityName());
                }
                break;

            case TYPE_COUNTY:
                for (County county : areaDao.loadAllCounties()) {
                    dataList.add(county.getCountyName());
                }
                break;
        }

        return dataList;
    }

}
