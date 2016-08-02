
package com.garytokman.g_tokman_lab1;

/*  Gary Tokman
    JAV1 - MDV3810*/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.garytokman.g_tokman_lab1.model.Calculator;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private TextView mInputText;
    private Button[] mButtons = new Button[16];
    private Calculator mCalculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set button ids
        for (int button = 0; button < mButtons.length; button++) {

            // Create id
            String buttonId = "button_" + button;
            // Get resource id
            int resourceId = getResources().getIdentifier(buttonId, "id", "com.garytokman.g_tokman_lab1");

            // Set id and listener on each button
            mButtons[button] = (Button) findViewById(resourceId);
            mButtons[button].setOnClickListener(this);
        }

        mInputText = (TextView) findViewById(R.id.input_textView);
    }

    // Override Onclick and check the id for each button
    @Override
    public void onClick(View view) {
        // Check view.getId against UI ids
        switch (view.getId()) {
            case R.id.button_0:
                mInputText.setText("0");
                break;
            case R.id.button_1:
                mInputText.setText("1");
                break;
            case R.id.button_2:
                mInputText.setText("2");
                break;
            case R.id.button_3:
                mInputText.setText("3");
                break;
            case R.id.button_4:
                mInputText.setText("4");
                break;
            case R.id.button_5:
                mInputText.setText("5");
                break;
            case R.id.button_6:
                mInputText.setText("6");
                break;
            case R.id.button_7:
                mInputText.setText("7");
                break;
            case R.id.button_8:
                mInputText.setText("8");
                break;
            case R.id.button_9:
                mInputText.setText("9");
                break;
            case R.id.button_10:
                // Clear
                mInputText.setText(String.valueOf(mCalculator.getClear()));
                break;
            case R.id.button_11:
                // Equals
                mInputText.setText("=");
                break;
            case R.id.button_12:
                // Add
                mInputText.setText("+");
                break;
            case R.id.button_13:
                // Subtract
                mInputText.setText("-");
                break;
            case R.id.button_14:
                // Multiply
                mInputText.setText("*");
                break;
            case R.id.button_15:
                // Divide
                mInputText.setText("/");
                break;
            default:
                Log.e(TAG, "Button not pressed");
        }
    }

}
