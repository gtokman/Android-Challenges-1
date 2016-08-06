package com.garytokman.tokmangary_lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_lab3.model.Story;

public class StoryActivity extends AppCompatActivity {

    // Fields
    private Story mStory;
    private ImageView mImageView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // Get intent
        Intent intent = getIntent();
        mStory = intent.getParcelableExtra(MainActivity.USER_STORY);

        // Init UI
        mImageView = (ImageView) findViewById(R.id.imageView);
        mTextView = (TextView) findViewById(R.id.storyText);

        // Set up
        setupUI();
    }

    private void setupUI() {
        // Set story
        mTextView.setText(mStory.toString());

        // Set image
        switch (mStory.getImage()) {
            case "First":
                mImageView.setImageResource(R.drawable.first);
                break;
            case "Second":
                mImageView.setImageResource(R.drawable.second);
                break;
            case "Third":
                mImageView.setImageResource(R.drawable.third);
                break;
            default:
                System.out.println("No image set");
                mImageView.setImageResource(R.drawable.first);
                break;
        }
    }
}
