package com.tiger_miao.niceweather.activity;

import android.app.Application;
import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.mock.MockApplication;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;
import com.tiger_miao.niceweather.R;
import com.tiger_miao.niceweather.model.IChooseAreaActivityViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;

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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.when;

/**
 * Created by tiger_miao on 15-7-4.
 */
//@RunWith(AndroidJUnit4.class)
public class ChooseAreaActivityTest extends ActivityInstrumentationTestCase2<ChooseAreaActivity> {

    public ChooseAreaActivityTest() {

        super(ChooseAreaActivity.class);

    }
//    public Application application = mock(Application.class, RETURNS_DEEP_STUBS);
//    protected Context context = mock(RoboActivity.class, RETURNS_DEEP_STUBS);

//    @Rule
//    public ActivityTestRule<ChooseAreaActivity> mActivityRule =
//            new ActivityTestRule<>(ChooseAreaActivity.class);

//    @Inject
//    protected IChooseAreaActivityViewModel viewModel;

    @Before
    public void setUp() {
        Application app = (Application) getInstrumentation().getTargetContext().getApplicationContext();
//        MockitoAnnotations.initMocks(this);
//        Application application = new MockApplication();

//        when(context.getApplicationContext()).thenReturn(application);
//        when(application.getApplicationContext()).thenReturn(application);
//
//        RoboGuice.overrideApplicationInjector(application, new MyTestModule());
//        RoboGuice.getInjector(application).injectMembers(this);

//        Module overridedModule = Modules.override(new roboguiceModule()).with(new MyTestModule());
//        Application app = (Application) getInstrumentation().getTargetContext().getApplicationContext();
//        Injector injector = Guice.createInjector(new MyTestModule());
//        injector.injectMembers(getActivity());
        RoboGuice.overrideApplicationInjector(app, RoboGuice.newDefaultRoboModule(app), Modules.override(new roboguiceModule()).with(new MyTestModule()));

        getActivity();
//        IChooseAreaActivityViewModel viewModel = injector.getInstance(IChooseAreaActivityViewModel.class);

    }

    @After
    public void tearDown() {
        RoboGuice.Util.reset();
    }

    @Test
    public void testClickOnItem() {
        onData(allOf(is(instanceOf(String.class)), is("北京"))).perform(click());
        onView(withId(R.id.title_text)).check(matches(withText("北京")));

        onData(is("天津")).perform(click());
        onView(withId(R.id.title_text)).check(matches(withText("天津")));
    }

    public class MyTestModule extends AbstractModule {

        @Override
        protected void configure() {
            bind(IChooseAreaActivityViewModel.class).to(MyTestViewModel.class);
        }
    }
}
