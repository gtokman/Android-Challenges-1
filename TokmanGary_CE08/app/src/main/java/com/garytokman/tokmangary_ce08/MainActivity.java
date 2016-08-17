package com.garytokman.tokmangary_ce08;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.garytokman.tokmangary_ce08.model.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Timer.UpdateTimer {


    private static final String TAG = "MainActivity";
    static public EditText mMinutesTextField;
    static public EditText mSecondsTextField;
    private Button mStartTimerButton;
    private Button mStopTimerButton;
    private Timer mTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mMinutesTextField = (EditText) findViewById(R.id.minutes_editText);
        mSecondsTextField = (EditText) findViewById(R.id.seconds_editText);
        mStartTimerButton = (Button) findViewById(R.id.start_button);
        mStartTimerButton.setOnClickListener(this);
        mStopTimerButton = (Button) findViewById(R.id.stop_button);
        mStopTimerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button:
                Log.d(TAG, "onClick: start button");
                hideKeyBoard();

                if ((!checkFields(mMinutesTextField) && !checkFields(mSecondsTextField)) || !checkFields(mSecondsTextField) ) {
                    // Do something
                    String minutesText = mMinutesTextField.getText().toString();
                    String secondsText = mSecondsTextField.getText().toString();
                    if (minutesText.equals("")) {
                        minutesText = "00";
                    }
                    long minutes = Long.parseLong(minutesText);
                    long seconds = Long.parseLong(secondsText);

                    mTimer = new Timer(this, minutes, seconds);
                    mTimer.execute((minutes * 60000) + (seconds * 1000));
                } else {
                    Toast.makeText(MainActivity.this, R.string.check_fields_error, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.stop_button:

                mTimer.cancel(true);
                updateEditText("", "");
                alertUser("Alert", "You canceled the timer").show();
                Log.d(TAG, "onClick: stop button");
                break;
            default:
                break;
        }
    }

    private void updateEditText(String minText, String secText) {
        mMinutesTextField.setText(minText);
        mSecondsTextField.setText(secText);
    }

    private boolean checkFields(EditText editText) {
        Log.d(TAG, "checkFields() called with: " + "editText = [" + editText + "]");
        return editText.getText().toString().trim().equals("") || editText.getText().toString().trim().equals("0");
    }

    private AlertDialog.Builder alertUser(String title, String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something
            }
        });

        return alert;
    }

    private void hideKeyBoard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        if(inputMethodManager.isAcceptingText()) { // verify if the soft keyboard is open
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }


    @Override
    public void getCurrentTime(long minutes, long seconds) {
        updateEditText(String.valueOf(minutes), String.valueOf(seconds));

        if (minutes == 0 && seconds == 0) {
            alertUser("Alert", "Time has expired").show();
        }
    }
}
