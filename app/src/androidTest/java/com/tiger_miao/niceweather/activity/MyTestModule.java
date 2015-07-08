package com.tiger_miao.niceweather.activity;

import com.google.inject.AbstractModule;
import com.tiger_miao.niceweather.model.IChooseAreaActivityViewModel;

/**
 * Created by tiger on 15-7-7.
 */
public class MyTestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IChooseAreaActivityViewModel.class).to(MyTestViewModel.class);
    }
}
