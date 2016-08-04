package com.garytokman.tokmangary_ce02;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.garytokman.tokmangary_ce02.model.GuessNumber;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mEditText1;
    private EditText mEditText2;
    private EditText mEditText3;
    private EditText mEditText4;
    private Button mGuessButton;
    private GuessNumber mGuessNumber;
    private int[] mWinningNumbers = new int[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init class
        mGuessNumber = new GuessNumber();

        // Find UI elements
        mEditText1 = (EditText) findViewById(R.id.editText_1);
        mEditText2 = (EditText) findViewById(R.id.editText_2);
        mEditText3 = (EditText) findViewById(R.id.editText_3);
        mEditText4 = (EditText) findViewById(R.id.editText_4);
        mGuessButton = (Button) findViewById(R.id.buttonGuess);
        mGuessButton.setOnClickListener(this);

        // OnCreate gen 4 random ints
        for (int i = 0; i < mWinningNumbers.length; i++) {
            mWinningNumbers[i] = mGuessNumber.getRandomNumber();
            System.out.println(mWinningNumbers[i]);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonGuess) {

            // Get user values
            int firstField = Integer.parseInt(mEditText1.getText().toString());
            int secondField = Integer.parseInt(mEditText2.getText().toString());
            int thirdField = Integer.parseInt(mEditText3.getText().toString());
            int fourthField = Integer.parseInt(mEditText4.getText().toString());

            // Call a method to check the users values vs the winning numbers
            checker(mEditText1, firstField, 0);
            checker(mEditText2, secondField, 1);
            checker(mEditText3, thirdField, 2);
            checker(mEditText4, fourthField, 3);
        }
    }

    private void checker(EditText editText, int userNumber, int index) {
        if (userNumber == mWinningNumbers[index]) {
            editText.setBackgroundColor(Color.GREEN);
        } else if (userNumber < mWinningNumbers[index]) {
            editText.setBackgroundColor(Color.BLUE);
        } else {
            editText.setBackgroundColor(Color.RED);
        }
    }

    private void showAlert(String message, String title) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something
            }
        }).show();
    }

    private void showSnackBar() {
        Snackbar snackbar;
    }
}
