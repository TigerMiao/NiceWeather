package com.tiger_miao.niceweather.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiger_miao on 15-8-2.
 */
public class AreaDao implements IAreaDao {
    @Override
    public List<Province> loadAllProvinces() {
        List<Province> provinceList = new ArrayList<>();

        return provinceList;
    }

    @Override
    public List<City> loadAllCities() {
        List<City> cityList = new ArrayList<>();
        return cityList;
    }

    @Override
    public List<County> loadAllCounties() {
        List<County> countyList = new ArrayList<>();
        return countyList;
    }
}
