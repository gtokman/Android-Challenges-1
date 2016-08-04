package com.garytokman.tokmangary_ce02;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    private int mNumberOfGuesses = 4;
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
        generateFourRandomNumbers();
    }

    private void generateFourRandomNumbers() {
        for (int i = 0; i < mWinningNumbers.length; i++) {
            mWinningNumbers[i] = mGuessNumber.getRandomNumber();
            System.out.printf("The winning numbers are %s:", mWinningNumbers[i]);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonGuess) {

            // Hide keyboard
            hideKeyboard();

            // Get user values
            String textInput1 = mEditText1.getText().toString();
            String textInput2 = mEditText2.getText().toString();
            String textInput3 = mEditText3.getText().toString();
            String textInput4 = mEditText4.getText().toString();
            String snackMessage = "No blank texts, enter 4 numbers";

            if (checkEmptyEditText(textInput1)) {
                showSnackBar(snackMessage);
            } else {
                int firstField = Integer.parseInt(textInput1);
                checker(mEditText1, firstField, 0);
            }

            if (checkEmptyEditText(textInput2)) {
                showSnackBar(snackMessage);
            } else {
                int secondField = Integer.parseInt(textInput2);
                checker(mEditText2, secondField, 1);
            }

            if (checkEmptyEditText(textInput3)) {
                showSnackBar(snackMessage);
            } else {
                int thirdField = Integer.parseInt(textInput3);
                checker(mEditText3, thirdField, 2);

            }

            if (checkEmptyEditText(textInput4)) {
                showSnackBar(snackMessage);
            } else {

                int fourthField = Integer.parseInt(textInput4);
                checker(mEditText4, fourthField, 3);
            }
        }

    }

    private void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        // Check keyboard
        if(inputMethodManager.isAcceptingText()) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private boolean checkEmptyEditText(String text) {
        return text.equals("");
    }

    private void checker(EditText editText, int userNumber, int index) {
        if (userNumber == mWinningNumbers[index]) {
            editText.setBackgroundColor(Color.GREEN);
        } else if (userNumber < mWinningNumbers[index]) {
            editText.setBackgroundColor(Color.BLUE);
            mNumberOfGuesses--;
        } else {
            editText.setBackgroundColor(Color.RED);
            mNumberOfGuesses--;
        }

        checkNumberOfGuesses();
    }

    private void checkNumberOfGuesses() {
        if (mNumberOfGuesses == 0) {
            showAlert("You Lost!", "Sorry try again, 4 new numbers are being generated!");
            generateFourRandomNumbers();
            mNumberOfGuesses = 0;
        } else {
            showSnackBar("You have" + mNumberOfGuesses + " left!");
        }
    }

    private void showAlert(String title, String message) {

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

    private void showSnackBar(String message) {
        View view = this.findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do something
            }
        }).show();
    }
}
