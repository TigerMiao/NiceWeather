package com.tiger_miao.niceweather.model;

import java.util.List;

/**
 * Created by tiger_miao on 15-8-2.
 */
public interface IAreaDao {
    List<Province> loadAllProvinecs();
    List<City> loadAllCities();
    List<County> loadAllCounties();
}
