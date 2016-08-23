package com.garytokman.tokmangary_assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Fields
    private EditText mSearchEditText;
    private Button mSearchButton;
    private ListView mListView;
    private ImageView mImageView;
    private TextView mAuthorTextView;
    private TextView mTitleTextView;
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

            // Listeners
            mSearchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Get text // Pass the URL to Async task
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
}
