package com.garytokman.tokmangary_ce09.client;

import android.os.AsyncTask;

/**
 * Created by gtokman1 on 8/18/16.
 */
public class APITask extends AsyncTask<String, Integer, String> {

    public interface LoadUIWithData {
        public String getJsonData(String json);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
