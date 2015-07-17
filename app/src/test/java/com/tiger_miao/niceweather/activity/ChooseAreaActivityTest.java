package com.tiger_miao.niceweather.activity;

import android.widget.ListView;
import android.widget.TextView;

import com.google.inject.AbstractModule;
import com.tiger_miao.niceweather.BuildConfig;
import com.tiger_miao.niceweather.R;
import com.tiger_miao.niceweather.model.IChooseAreaActivityViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import roboguice.RoboGuice;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

/**
 * Created by tiger on 15-7-16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ChooseAreaActivityTest {

    private ChooseAreaActivity activity;
    private ListView listView;
    private TextView titleText;

    @Before
    public void setUp() throws Exception {
        RoboGuice.overrideApplicationInjector(RuntimeEnvironment.application, new MyTestGuiceModule());

        activity = Robolectric.buildActivity(ChooseAreaActivity.class).create().get();

        listView = (ListView) activity.findViewById(R.id.list_view);
        titleText = (TextView) activity.findViewById(R.id.title_text);
    }

    @Test
    public void testPreconditions() {
        assertNotNull(activity);
    }

    @Test
    public void testClickOnItemOne() {
        listView.performItemClick(
                listView.getAdapter().getView(0, null, null),
                0,
                listView.getAdapter().getItemId(0));

        assertEquals("北京", titleText.getText().toString());
    }

    @Test
    public void testClickOnItemThree() {
        listView.performItemClick(
                listView.getAdapter().getView(2, null, null),
                2,
                listView.getAdapter().getItemId(2));

        assertEquals("上海", titleText.getText().toString());
    }

    @After
    public void tearDown()
    {
        RoboGuice.Util.reset();
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

    public class MyTestGuiceModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(IChooseAreaActivityViewModel.class).to(MyTestViewModel.class);
        }
    }

}
