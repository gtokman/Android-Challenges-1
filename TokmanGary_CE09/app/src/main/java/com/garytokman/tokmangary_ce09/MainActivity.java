package com.garytokman.tokmangary_ce09;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.garytokman.tokmangary_ce09.adapters.GridViewAdapter;
import com.garytokman.tokmangary_ce09.client.APITask;
import com.garytokman.tokmangary_ce09.model.Book;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements APITask.LoadUIWithData {

    @BindView(R.id.gridView)
    GridView mGridView;
    private List<Book> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mData = new ArrayList<>();

        // Set adapter
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this, mData);
        mGridView.setAdapter(gridViewAdapter);

    }

    @Override
    public String getJsonData(String json) {

        // Update UI
        return null;
    }
}
