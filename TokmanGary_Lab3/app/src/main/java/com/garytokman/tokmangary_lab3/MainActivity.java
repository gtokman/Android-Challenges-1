package com.garytokman.tokmangary_lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.garytokman.tokmangary_lab3.model.Story;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String USER_STORY = "USER_STORY";
    // Fields
    private EditText mNameEditText;
    private EditText mStoryEditText;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButton;
    private Button mSubmitButton;
    private Story mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init UI
        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mStoryEditText = (EditText) findViewById(R.id.storyEditText);
        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mSubmitButton.setOnClickListener(this);
    }

    private void selectAnImage() {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                // Get the radio button
                mRadioButton = (RadioButton) findViewById(i);

                if (mRadioButton.isChecked()) {
                    String selectedImage = mRadioButton.getText().toString();
                    mRadioButton.getText().toString();
                    mStory.setImage(selectedImage);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.submitButton) {

           if  (checkEmptyFields(mNameEditText) && checkEmptyFields(mStoryEditText)) {
               Toast.makeText(MainActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
           } else {
            // Create intent
            // Pass data to new view
               this.selectAnImage();
               mStory = new Story(mNameEditText.getText().toString(), mStoryEditText.getText().toString());

               Intent intent = new Intent();
               intent.putExtra(USER_STORY, mStory);
               startActivity(intent);
           }
        }
    }

    private boolean checkEmptyFields(EditText editText) {
        return editText.getText().toString().equals("");
    }
}
