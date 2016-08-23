package com.garytokman.tokmangary_recipeapp.model;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by gtokman1 on 8/23/16.
 */
public class APIClient extends AsyncTask<String, Integer, String> {

    public interface LoadRecipeDelegate {
        public void getJsonData(String json);
    }

    private Context mContext;
    private LoadRecipeDelegate mRecipeDelegate;

    public APIClient(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Init delegate
        if (mContext instanceof LoadRecipeDelegate) {
            mRecipeDelegate = (LoadRecipeDelegate) mContext;
        } else {
            throw new IllegalArgumentException("Could not init delegate");
        }
        // Create a loading dialog
    }

    @Override
    protected String doInBackground(String... strings) {

        HttpURLConnection connection = null;
        String data = null;
        // Get json on background
        try {
            // Get url
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();

            // Apache commons
            connection.connect();
            InputStream inputStream = connection.getInputStream();

            // Get data
            data = IOUtils.toString(inputStream);
            inputStream.close();

            return data;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

        return data;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);

        // Notifiy delegate
        mRecipeDelegate.getJsonData(data);
    }
}
