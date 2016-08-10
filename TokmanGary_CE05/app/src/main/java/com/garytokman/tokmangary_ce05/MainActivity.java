package com.garytokman.tokmangary_ce05;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Fields
    private EditText mEditText;
    private Button mSubmitButton;
    private TextView mCollectionSizeText;
    private TextView mAvgNameLength;
    private TextView mMedianNameLength;
    private NumberPicker mNumberPicker;
    private Button mSelectButton;
    private List<String> mWords;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mWords = new ArrayList<>();
        index = 0;

        // Init UI
        mEditText = (EditText) findViewById(R.id.wordEditText);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mCollectionSizeText = (TextView) findViewById(R.id.collectionSizeField);
        mAvgNameLength = (TextView) findViewById(R.id.avgNameLength);
        mMedianNameLength = (TextView) findViewById(R.id.medianNameLength);
        mNumberPicker = (NumberPicker) findViewById(R.id.numberPicker);
        mSelectButton = (Button) findViewById(R.id.selectButton);


        // Buttons
        mSubmitButton.setOnClickListener(this);
        mSelectButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitButton:

                String enteredText = mEditText.getText().toString();
                System.out.println(enteredText);
                // Check if the text is valid
                if (!checkEnteredTextIsValid(enteredText)) {
                    mWords.add(enteredText);
                    // Clear edit text
                    mEditText.setText("");
                    // Update labels
                    handleUpdatingLabels();
                    // Update num picker
                    handleNumberPicker();

                } else {
                    Toast.makeText(MainActivity.this, "Not valid text, No spaces and unique words only", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.selectButton:
                System.out.println("Selected works too");
                alertUser();
                break;
            default:
                break;
        }
    }

    // TODO: Fix the number picker
    private void handleNumberPicker() {
        mNumberPicker.setMaxValue(mWords.size());
        mNumberPicker.setMinValue(1);
        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                index = i1 - 1;
                System.out.println("this is the index " + index);
            }
        });
    }

    private void alertUser() {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Alert");
        // Show the selected word and remove
        if (!mWords.isEmpty()) {
            alertDialog.setMessage("The word you want to remove is: " + mWords.get(index));
            alertDialog.setPositiveButton("Remove", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // Remove selected word
                    if (!mWords.isEmpty() && mWords.size() != 1) {
                        mWords.remove(index);
                        handleUpdatingLabels();
                        handleNumberPicker();
                    }
                }
            });

        } else {

            alertDialog.setMessage("Please enter some words");
        }

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Cancel
            }
        });

        alertDialog.show();
    }

    private void handleUpdatingLabels() {
        // Collection size
        mCollectionSizeText.setText(String.valueOf(getCollectionSize()));

        // Average Name length
        // Format number
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        mAvgNameLength.setText(decimalFormat.format(getAvgWordLength()));

        // Median name length
        mMedianNameLength.setText(decimalFormat.format(getMedianWordLength()));
//        getMedianWordLength();

    }

    private boolean checkEnteredTextIsValid(String enteredText) {

        return enteredText.trim().equals("") || mWords.contains(enteredText);
    }

    private int getCollectionSize() {
        return mWords.size();
    }

    private double getAvgWordLength() {
        double numberOfLetters = 0;

        // loop through the words
        for (String word : mWords) {
            numberOfLetters += word.toCharArray().length;
        }

        return numberOfLetters / mWords.size();
    }

    private double getMedianWordLength() {

        List<Integer> wordLengths = new ArrayList<>();

        for (String word : mWords) {
            // Add length of each word
            wordLengths.add(word.toCharArray().length);
        }

        // Sort
        Collections.sort(wordLengths);
        System.out.println(wordLengths.toString());


        double median = 0;
        int middle = wordLengths.size() / 2;

        // Cast to an array
        Object[] wordsArray = wordLengths.toArray();
        Integer firstNumber = (Integer) wordsArray[middle];

        // Cast to double
        double firstNum = firstNumber.doubleValue();

        if (wordLengths.size() % 2 == 0) {

            // One less middle number if even // Cast to double
            Integer secondNumber = (Integer) wordsArray[middle - 1];
            double secNum = secondNumber.doubleValue();

            median = (firstNum + secNum) / 2;
        } else {

            // Odd set
            median = firstNumber;
        }

        return median;
    }
}
