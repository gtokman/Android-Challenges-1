package com.garytokman.tokmangary_ce08;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.garytokman.tokmangary_ce08.model.Timer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private EditText mMinutesTextField;
    private EditText mSecondsTextField;
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

                if (!checkFields(mMinutesTextField) && !checkFields(mSecondsTextField)) {
                    // Do something
                    int minutes = Integer.parseInt(mMinutesTextField.getText().toString());
                    int seconds = Integer.parseInt(mSecondsTextField.getText().toString());

                    mTimer = new Timer(this, minutes, seconds);
                    mTimer.execute();
                } else {
                    Toast.makeText(MainActivity.this, R.string.check_fields_error, Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.stop_button:
                mTimer.cancel(true);
                alertUser("Alert", "You canceled the timer").show();
                Log.d(TAG, "onClick: stop button");
                break;
            default:
                break;
        }
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
}
