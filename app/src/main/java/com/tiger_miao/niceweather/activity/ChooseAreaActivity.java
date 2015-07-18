package com.tiger_miao.niceweather.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.inject.Inject;
import com.tiger_miao.niceweather.R;
import com.tiger_miao.niceweather.model.IChooseAreaActivityViewModel;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.RoboGuice;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.WindowFeature;


/**
 * Created by tiger_miao on 15-7-1.
 */
@WindowFeature(Window.FEATURE_NO_TITLE)
@EActivity(R.layout.choose_area)
@RoboGuice
public class ChooseAreaActivity extends Activity{
    @ViewById(R.id.title_text)
    TextView titleText;
    @ViewById(R.id.list_view)
    ListView listView;

    @Inject
    public IChooseAreaActivityViewModel viewModel;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, viewModel.getDataList());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                titleText.setText(viewModel.getDataList().get(i));
            }
        });
    }
}
