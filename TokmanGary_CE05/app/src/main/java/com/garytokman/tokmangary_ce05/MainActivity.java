package com.garytokman.tokmangary_ce05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Fields
    private EditText mEditText;
    private Button mSubmitButton;
    private TextView mCollectionSizeText;
    private TextView mAvgNameLength;
    private TextView mMedianNameLength;
    private NumberPicker mNumberPicker;
    private Button mSelectButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                break;
            case R.id.selectButton:
                break;
            default:
                break;
        }
    }
}
