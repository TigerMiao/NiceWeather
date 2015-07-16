package com.tiger_miao.niceweather.activity;

import com.tiger_miao.niceweather.BuildConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertTrue;

/**
 * Created by tiger on 15-7-16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ChooseAreaActivityTest {

    @Test
    public void testSomething() throws Exception {
        assertTrue(Robolectric.buildActivity(ChooseAreaActivity.class).create().get() != null);
    }

}
