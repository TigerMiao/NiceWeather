package com.tiger_miao.niceweather.activity;

import com.google.inject.AbstractModule;
import com.tiger_miao.niceweather.model.IAreaDao;

/**
 * Created by tiger on 15-7-7.
 */
public class MyTestGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IAreaDao.class).to(ChooseAreaActivityTest.MyTestAreaDao.class);
    }
}
