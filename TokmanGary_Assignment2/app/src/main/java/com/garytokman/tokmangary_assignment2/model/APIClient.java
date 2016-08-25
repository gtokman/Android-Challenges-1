package com.garytokman.tokmangary_assignment2.model;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by gtokman1 on 8/24/16.
 */
public class APIClient extends AsyncTask<String, Integer, String> {

    public interface LoadAPIData {
        public void getJsonData(String json) throws JSONException;
    }

    private Context mContext;
    private LoadAPIData delegate;
    private ProgressDialog mProgressDialog;

    public APIClient(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Init
        if (mContext instanceof LoadAPIData) {
            delegate = (LoadAPIData) mContext;
        } else {
            throw new IllegalArgumentException("Delegate not initialized!");
        }

        // Progress
        // Create a loading dialog
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setMessage("Loading....");
        mProgressDialog.show();
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
            assert connection != null;
            connection.disconnect();
        }

        return data;
    }

    @Override
    protected void onPostExecute(String json) {
        super.onPostExecute(json);

        // Stop progress
        mProgressDialog.hide();

        // Notify delegate
        try {
            delegate.getJsonData(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
