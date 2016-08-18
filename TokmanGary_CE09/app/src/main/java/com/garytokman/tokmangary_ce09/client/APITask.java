package com.garytokman.tokmangary_ce09.client;

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

    public APITask(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Set the delegate
        if (mContext instanceof LoadUIWithData) {
            mLoadUIWithData = (LoadUIWithData) mContext;
        } else {
            throw new IllegalArgumentException("Could not set the delegate for interface");
        }
    }

    /*
        try {
            // Get url
            URL url = new URL(strings[0]);
            // Open connections
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try {
                // Connect
                connection.connect();
                // Serializable data
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
        }*/

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
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);

        // Send data to main
        try {
            mLoadUIWithData.getJsonData(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
