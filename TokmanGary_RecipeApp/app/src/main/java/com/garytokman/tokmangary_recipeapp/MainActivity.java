package com.garytokman.tokmangary_recipeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.garytokman.tokmangary_recipeapp.model.APIClient;

public class MainActivity extends AppCompatActivity implements APIClient.LoadRecipeDelegate {

    private static final String TAG = "Main Activity";
    private APIClient mAPIClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String apiKey = "e90f84b2f7eb65ee00614181b1e12fde";
        String url = "http://food2fork.com/api/search?key=e90f84b2f7eb65ee00614181b1e12fde";
        mAPIClient = new APIClient(this);
        mAPIClient.execute(url);
    }

    @Override
    public void getJsonData(String json) {
        Log.d(TAG, "getJsonData() called with: " + "json = [" + json + "]");
    }
}
