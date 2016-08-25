package com.garytokman.tokmangary_assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.garytokman.tokmangary_assignment2.model.APIClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements APIClient.LoadAPIData {

    private static final String TAG = "MainActivity";
    // Fields
    private EditText mSearchEditText;
    private Button mSearchButton;
    private ListView mListView;
    private ImageView mImageView;
    private TextView mAuthorTextView;
    private TextView mTitleTextView;
    private APIClient mAPIClient;
    private List mPhotoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = getResources().getConfiguration().orientation;

        // Check orientation
        if (orientation == getResources().getConfiguration().ORIENTATION_LANDSCAPE) {

            // Init
            mSearchEditText = (EditText) findViewById(R.id.search_edit_text);
            mSearchButton = (Button) findViewById(R.id.search_button);
            mListView = (ListView) findViewById(R.id.listView);
            mImageView = (ImageView) findViewById(R.id.detail_imageView);
            mAuthorTextView = (TextView) findViewById(R.id.author_text_view);
            mTitleTextView = (TextView) findViewById(R.id.title_text_view);
            mPhotoList = new ArrayList();
            mAPIClient = new APIClient(this);

            // Listeners
            mSearchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get text // Pass the URL to Async task
                    String userSearch = mSearchEditText.getText().toString();

                    if (userSearch.isEmpty()) {
                        // Toast
                        
                    }

                }
            });

            mListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    // i is the position selected
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }


    }

    @Override
    public void getJsonData(String json) {
        Log.d(TAG, "getJsonData() called with: " + "json = [" + json + "]");
    }
}
