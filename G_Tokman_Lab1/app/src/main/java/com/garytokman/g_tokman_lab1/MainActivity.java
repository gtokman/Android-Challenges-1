
package com.garytokman.g_tokman_lab1;

/*  Gary Tokman
    JAV1 - MDV3810*/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.garytokman.g_tokman_lab1.model.Calculator;

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
        CharSequence currentText = mInputText.getText();

        switch (view.getId()) {
            case R.id.button_0:

                mInputText.setText(currentText + "0");

                break;
            case R.id.button_1:

                mInputText.setText(currentText + "1");

                break;
            case R.id.button_2:

                mInputText.setText(currentText + "2");

                break;
            case R.id.button_3:

                mInputText.setText(currentText + "3");

                break;
            case R.id.button_4:

                mInputText.setText(currentText + "4");

                break;
            case R.id.button_5:

                mInputText.setText(currentText + "5");

                break;
            case R.id.button_6:

                mInputText.setText(currentText + "6");

                break;
            case R.id.button_7:

                mInputText.setText(currentText + "7");

                break;
            case R.id.button_8:

                mInputText.setText(currentText + "8");

                break;
            case R.id.button_9:

                mInputText.setText(currentText + "9");

                break;
            case R.id.button_10:
                // Clear
                mInputText.setText(null);
                mCalculator.setFirstInt(0);
                mCalculator.setFirstInt(0);
                // Enable numbers
                shouldNumbersBeEnabled("C");

                break;
            case R.id.button_11:
                // Equals
                // set text
                mCalculator.setSecondInt(Integer.parseInt(currentText.toString()));
                // pass operator
                // Set text to null
                mCalculator.setTotal(mCalculator.getOperator(), mCalculator.getFirstInt(), mCalculator.getSecondInt());
                mInputText.setText(mCalculator.getTotal() + "");
                mCalculator.setOperator("=");

                // While operator is "=" buttons not clickable
                shouldNumbersBeEnabled("=");


                break;
            case R.id.button_12:
                // Add
                // set text
                mCalculator.setFirstInt(Integer.parseInt(currentText.toString()));
                // pass operator
                mCalculator.setOperator("+");
                // Set text to null
                mInputText.setText(null);
                // Enable numbers
                shouldNumbersBeEnabled("+");

                break;
            case R.id.button_13:
                // Subtract
                // set text
                mCalculator.setFirstInt(Integer.parseInt(currentText.toString()));
                // pass operator
                mCalculator.setOperator("-");
                // Set input text to null
                mInputText.setText(null);

                shouldNumbersBeEnabled("-");
                break;
            case R.id.button_14:
                // Multiply
                // set text
                mCalculator.setFirstInt(Integer.parseInt(currentText.toString()));
                // pass operator
                mCalculator.setOperator("*");
                // Set text to null
                mInputText.setText(null);
                // Enable numbers
                shouldNumbersBeEnabled("*");

                break;
            case R.id.button_15:
                // Divide
                // set text
                mCalculator.setFirstInt(Integer.parseInt(currentText.toString()));
                // pass operator
                mCalculator.setOperator("/");
                // Set text to null
                mInputText.setText(null);
                // Enable numbers
                shouldNumbersBeEnabled("/");

                break;
            default:
                Log.e(TAG, "Button not pressed");
        }

    }

    private void shouldNumbersBeEnabled(String operator) {
        if (operator.equals("=")) {

            // Disable numbers
            for (int i = 0; i < 10; i++) {

                mButtons[i].setEnabled(false);
            }

        } else {
            // Enable numbers
            for (int i = 0; i < 10; i++) {

                mButtons[i].setEnabled(true);
            }
        }
    }
}
