package com.garytokman.tokmangary_lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_lab3.model.Story;

public class StoryActivity extends AppCompatActivity {

    private static final String USER_STORY = "USER_STORY";
    private Story mStory;
    private ImageView mImageView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = new Intent();
        mStory = intent.getParcelableExtra(USER_STORY);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mTextView = (TextView) findViewById(R.id.storyText);

        // Set up
        setupUI();
    }

    private void setupUI() {

    }
}
