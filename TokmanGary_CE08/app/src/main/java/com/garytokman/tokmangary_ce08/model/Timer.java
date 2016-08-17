package com.garytokman.tokmangary_ce08.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by gtokman1 on 8/16/16.
 */
// Last is return type
public class Timer extends AsyncTask<Long, Void, Long> {


    public interface UpdateTimer {
        void getCurrentTime(long minutes, long seconds);
    }

    private static final String TAG = "TimerModel";
    private Context mContext;
    private long mMinutes;
    private long mSeconds;
    private long startTimeInMilliseconds;
    public UpdateTimer mUpdateTimer;
    private long mCountDownAmount;


    public Timer(Context context, long minutes, long seconds) {
        mContext = context;
        mMinutes = minutes;
        mSeconds = seconds;
    }

    public long getMinutes() {
        return mMinutes;
    }

    public long getSeconds() {
        return mSeconds;
    }

    public void setMinutes(long minutes) {
        mMinutes = minutes;
    }

    public void setSeconds(long seconds) {
        mSeconds = seconds;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        // Init interface
        if (mContext instanceof UpdateTimer) {
            mUpdateTimer = (UpdateTimer) mContext;
        } else {
            throw new IllegalArgumentException("Interface not init");
        }
        // Start the timer
        startTimeInMilliseconds = System.currentTimeMillis();

        Toast.makeText(mContext, "The timer has started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Long doInBackground(Long... longs) {

        Log.d(TAG, "doInBackground() called with: " + "longs = [" + longs[0] + "]");
        long current = System.currentTimeMillis();
        long timePassed = current - startTimeInMilliseconds;

        do {
            mCountDownAmount = longs[0] - timePassed;

            return mCountDownAmount;

        } while (mCountDownAmount > 0);

    }

    @Override
    protected void onPostExecute(Long time) {
        super.onPostExecute(time);

        Log.d(TAG, "onPostExecute: " + time);

//         add my total to current
        long secondsPassed = (time / 1000) % 60;
        long minutesPassed = (time / 60000) % 60;

        if (time != 0) {
            mUpdateTimer.getCurrentTime(minutesPassed, secondsPassed);
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        // Do something if cancelled
        Toast.makeText(mContext, "User canceled", Toast.LENGTH_SHORT).show();
    }

}