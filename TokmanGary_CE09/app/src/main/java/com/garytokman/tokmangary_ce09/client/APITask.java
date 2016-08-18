package com.garytokman.tokmangary_ce09.client;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gtokman1 on 8/18/16.
 */
public class APITask extends AsyncTask<String, Integer, String> {

    // Interface to pass data to main/ update ui
    public interface LoadUIWithData {
        public void getJsonData(String json) throws JSONException;
    }

    // Fields
    private Context mContext;
    private LoadUIWithData mLoadUIWithData;
    private ProgressDialog mProgressDialog;

    public APITask(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Progress
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setMessage("Loading....");
        mProgressDialog.show();

        // Set the delegate
        if (mContext instanceof LoadUIWithData) {
            mLoadUIWithData = (LoadUIWithData) mContext;
        } else {
            throw new IllegalArgumentException("Could not set the delegate for interface");
        }
    }

    @Override
    protected String doInBackground(String... strings) {

        try {
            // Get URL
            URL url = new URL(strings[0]);
            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Apache Commons to connect
            try {
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                String data = IOUtils.toString(inputStream);
                inputStream.close();
                return data;
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        mProgressDialog.hide();

        // Send data to main
        try {
            mLoadUIWithData.getJsonData(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
