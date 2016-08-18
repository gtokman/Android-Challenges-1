package com.garytokman.tokmangary_ce09;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import com.garytokman.tokmangary_ce09.adapters.GridViewAdapter;
import com.garytokman.tokmangary_ce09.client.APITask;
import com.garytokman.tokmangary_ce09.model.Book;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements APITask.LoadUIWithData {

    private static final String TAG = "MainActivity";
    private GridView mGridView;
    private List<Book> mBooks;
    private APITask mAPITask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If User has network
        if (isNetworkOn()) {
            // Init
            mAPITask = new APITask(this);
            final String url = "https://www.googleapis.com/books/v1/volumes?q=android";
            mAPITask.execute(url);
        }

        mBooks = new ArrayList<>();
        mGridView = (GridView) findViewById(R.id.gridView);
    }

    private void updateUI() {
        // Set adapter // Update UI
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this, mBooks);
        mGridView.setAdapter(gridViewAdapter);
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

    @Override
    public void getJsonData(String json) throws JSONException {
        Log.d(TAG, "getJsonData() called with: " + "json = [" + json + "]");

        // Update UI
        JSONObject jsonObject = new JSONObject(json);
        JSONArray items = jsonObject.getJSONArray("items");

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            JSONObject volumeInfo = item.getJSONObject("volumeInfo");

            String title = volumeInfo.getString("title");
            String imageUrl = volumeInfo.getJSONObject("imageLinks").getString("thumbnail");
            Log.d(TAG, "getJsonData: title " + title + " " + imageUrl);

            // Fill object with Json data
            Book book = new Book(imageUrl, title);
            mBooks.add(book);
        }

        // Update UI
        updateUI();
    }
}
