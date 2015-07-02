package com.tiger_miao.niceweather.activity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.inject.Inject;
import com.tiger_miao.niceweather.R;
import com.tiger_miao.niceweather.model.IChooseAreaActivityViewModel;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by tiger_miao on 15-7-1.
 */
@ContentView(R.layout.choose_area)
public class ChooseAreaActivity extends RoboActivity {
    @InjectView(R.id.title_text) private TextView titleText;
    @InjectView(R.id.list_view) private ListView listView;

    @Inject
    private IChooseAreaActivityViewModel viewModel;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, viewModel.getDataList());
        listView.setAdapter(adapter);
    }
}
