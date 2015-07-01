package com.tiger_miao.niceweather.com.tiger_miao.niceweather.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.tiger_miao.niceweather.R;

import java.util.ArrayList;
import java.util.List;

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

    private ArrayAdapter<String> adapter;
    private List<String> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
        listView.setAdapter(adapter);
    }
}
