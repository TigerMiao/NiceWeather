package com.tiger_miao.niceweather.activity;

import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.tiger_miao.niceweather.R;
import com.tiger_miao.niceweather.model.City;
import com.tiger_miao.niceweather.model.County;
import com.tiger_miao.niceweather.model.IAreaDao;
import com.tiger_miao.niceweather.model.Province;

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
        onData(allOf(is(instanceOf(String.class)), is("山东"))).perform(click());
        onView(withId(R.id.title_text)).check(matches(withText("山东")));

        onData(is("山西")).perform(click());
        onView(withId(R.id.title_text)).check(matches(withText("山西")));
    }

    public static class MyTestAreaDao implements IAreaDao {

        @Override
        public List<Province> loadAllProvinecs() {
            Province shandong = new Province();
            shandong.setId(1);
            shandong.setProvinceName("山东");
            shandong.setProvinceCode("0001");

            Province shanxi = new Province();
            shanxi.setId(2);
            shanxi.setProvinceName("山西");
            shanxi.setProvinceCode("0002");

            Province hebei = new Province();
            hebei.setId(3);
            hebei.setProvinceName("河北");
            hebei.setProvinceCode("0003");

            Province henan = new Province();
            henan.setId(4);
            henan.setProvinceName("河南");
            henan.setProvinceCode("0004");

            List<Province> provinceList = new ArrayList<>();
            provinceList.add(shandong);
            provinceList.add(shanxi);
            provinceList.add(hebei);
            provinceList.add(henan);

            return provinceList;
        }

        @Override
        public List<City> loadAllCities() {
            return null;
        }

        @Override
        public List<County> loadAllCounties() {
            return null;
        }
    }

}
