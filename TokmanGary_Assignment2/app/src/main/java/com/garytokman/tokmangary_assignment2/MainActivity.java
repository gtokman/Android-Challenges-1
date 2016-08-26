package com.garytokman.tokmangary_assignment2;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.garytokman.tokmangary_assignment2.model.APIClient;
import com.garytokman.tokmangary_assignment2.model.Photo;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements APIClient.LoadAPIData {

    // Fields
    private static final String TAG = "MainActivity";
    private EditText mSearchEditText;
    private Button mSearchButton;
    private ListView mListView;
    private ImageView mImageView;
    private TextView mAuthorTextView;
    private TextView mLikesTextView;
    private APIClient mAPIClient;
    private List<Photo> mPhotoList;

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
            mLikesTextView = (TextView) findViewById(R.id.likes_text_view);
            mPhotoList = new ArrayList<>();

            // Listeners
            mSearchButton.setOnClickListener(buttonClickListener);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.d(TAG, "onItemClick: touch");
                    handleSelectedPhoto(i);
                }
            });

        } else {
            // Portrait placeholder
            ImageView placeHolder = (ImageView) findViewById(R.id.placeholder_image_view);
            placeHolder.setImageResource(R.drawable.error);
        }
    }

    View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Get text // Pass the URL to Async task
            String userSearch = mSearchEditText.getText().toString().toLowerCase().trim();

            if (userSearch.isEmpty() || !isNetworkOn()) {
                // Toast
                Toast.makeText(MainActivity.this, "Please enter a valid photo name or check network", Toast.LENGTH_SHORT).show();
            } else {
                hideKeyBoard();
                mSearchEditText.getText().clear();
                mPhotoList.clear();
                mAPIClient = new APIClient(MainActivity.this);
                String clientId = "da097c2e80660d684a125567880617a6418021c604cc84264ecfaa151169e91b";
                String url = "https://api.unsplash.com/photos/search?client_id=" + clientId + "&query=" + userSearch;
                mAPIClient.execute(url);
            }
        }
    };

    private void handleSelectedPhoto(int position) {

        // Get selected item
        Photo selectedPhoto = mPhotoList.get(position);

        // Update UI
        mAuthorTextView.setText("Taken by: " + selectedPhoto.getName());
        mLikesTextView.setText("Number of likes: " + selectedPhoto.getLikes());
        Picasso.with(this).load(selectedPhoto.getImageUrlSmall())
                .placeholder(R.drawable.loading).error(R.drawable.error).into(mImageView);
    }

    @Override
    public void getJsonData(String json) throws JSONException {
        Log.d(TAG, "getJsonData() called with: " + "json = [" + json + "]");

        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {

            int likes = jsonArray.getJSONObject(i).getInt("likes");
            String name = jsonArray.getJSONObject(i).getJSONObject("user").getString("name");
            String imageUrlSmall = jsonArray.getJSONObject(i).getJSONObject("urls").getString("small");


            Log.d(TAG, "getJsonData() returned: " + "name: "
                    + name + " imageUrlSmall: " + imageUrlSmall + " likes: " + likes);

            // Add to model
            mPhotoList.add(new Photo(likes, name, imageUrlSmall));
        }
        if (mPhotoList.isEmpty()) {
            mImageView.setImageResource(R.drawable.error);
            Toast.makeText(MainActivity.this, "Could not find that image, try something else", Toast.LENGTH_LONG).show();
        } else {
            updateUI();
        }
    }

    private void updateUI() {
        ArrayAdapter<Photo> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mPhotoList);
        mListView.setAdapter(arrayAdapter);
        handleSelectedPhoto(0);
    }

    private void hideKeyBoard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        if (inputMethodManager.isAcceptingText()) { // verify if the soft keyboard is open
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private boolean isNetworkOn() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isNetworkOn = false;

        if (networkInfo != null && networkInfo.isConnected()) {
            isNetworkOn = true;
        }
        return isNetworkOn;
    }
}
