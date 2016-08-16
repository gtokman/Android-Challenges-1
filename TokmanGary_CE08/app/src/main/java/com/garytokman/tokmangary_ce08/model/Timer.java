package com.garytokman.tokmangary_ce08.model;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by gtokman1 on 8/16/16.
 */
public class Timer extends AsyncTask<Integer, Integer, Void>  {

    private static final String TAG = "TimerModel";
    private Context mContext;
    private int mMinutes;
    private int mSeconds;

    public Timer(Context context, int minutes, int seconds) {
        mContext = context;
        mMinutes = minutes;
        mSeconds = seconds;
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        // Runs in the background
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        // Update UI
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        // Do something if cancelled
    }
}
