package com.tiger_miao.niceweather.activity;

import android.app.Application;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.tiger_miao.niceweather.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import roboguice.RoboGuice;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
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
public class ChooseAreaActivityTest {

    @Rule
    public ActivityTestRule<ChooseAreaActivity> mActivityRule =
            new ActivityTestRule<>(ChooseAreaActivity.class);

    @Before
    public void setUp() {
        Application app = (Application) getInstrumentation().getTargetContext().getApplicationContext();
        RoboGuice.overrideApplicationInjector(app, new MyTestModule());
    }

    @Test
    public void testClickOnItem() {
        onData(allOf(is(instanceOf(String.class)), is("山东"))).perform(click());
        onView(withId(R.id.title_text)).check(matches(withText("山东")));

        onData(is("新疆")).perform(click());
        onView(withId(R.id.title_text)).check(matches(withText("新疆")));
    }

}
