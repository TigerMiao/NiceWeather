package com.tiger_miao.niceweather.activity;

import com.google.inject.AbstractModule;
import com.tiger_miao.niceweather.model.ChooseAreaActivityViewModel;
import com.tiger_miao.niceweather.model.IChooseAreaActivityViewModel;

/**
 * Created by tiger_miao on 15-7-1.
 */
public class roboguiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IChooseAreaActivityViewModel.class).to(ChooseAreaActivityViewModel.class);
    }

}
