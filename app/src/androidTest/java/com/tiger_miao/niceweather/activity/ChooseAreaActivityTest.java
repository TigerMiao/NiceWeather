package com.tiger_miao.niceweather.activity;

import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.tiger_miao.niceweather.R;
import com.tiger_miao.niceweather.model.IChooseAreaActivityViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import roboguice.RoboGuice;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by tiger_miao on 15-7-4.
 */
@RunWith(AndroidJUnit4.class)
public class ChooseAreaActivityTest extends ActivityInstrumentationTestCase2<ChooseAreaActivity> {

    public ChooseAreaActivityTest() {

        super(ChooseAreaActivity.class);

    }

    @Before
    @Override
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

        Application application = (Application) getInstrumentation().getTargetContext().getApplicationContext();

        RoboGuice.overrideApplicationInjector(application, new MyTestGuiceModule());

        getActivity();
    }

    @After
    @Override
    public void tearDown() throws Exception {
        super.tearDown();

        RoboGuice.Util.reset();
    }

    @Test
    public void testClickOnItem() {
        onData(allOf(is(instanceOf(String.class)), is("北京"))).perform(click());
        onView(withId(R.id.title_text)).check(matches(withText("北京")));

        onData(is("天津")).perform(click());
        onView(withId(R.id.title_text)).check(matches(withText("天津")));
    }

    public static class MyTestViewModel implements IChooseAreaActivityViewModel {
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

}
