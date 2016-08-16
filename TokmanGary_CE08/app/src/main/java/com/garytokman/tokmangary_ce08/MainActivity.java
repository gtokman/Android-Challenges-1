package com.garytokman.tokmangary_ce08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mMinutesTextField;
    private EditText mSecondsTextField;
    private Button mStartTimerButton;
    private Button mStoptimerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mMinutesTextField = (EditText) findViewById(R.id.minutes_editText);
        mSecondsTextField = (EditText) findViewById(R.id.seconds_editText);
        mStartTimerButton = (Button) findViewById(R.id.start_button);
        mStoptimerButton = (Button) findViewById(R.id.stop_button);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start_button:
                break;
            case R.id.stop_button:
                break;
            default:
                break;
        }
    }
}
