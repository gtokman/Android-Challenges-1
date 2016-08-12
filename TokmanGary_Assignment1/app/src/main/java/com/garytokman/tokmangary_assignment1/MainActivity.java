package com.garytokman.tokmangary_assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Spinner mSpinner;
    private TextView mName;
    private TextView mAge;
    private ImageView mProfileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mSpinner = (Spinner) findViewById(R.id.personSpinner);
        mName = (TextView) findViewById(R.id.nameLabel);
        mAge = (TextView) findViewById(R.id.ageLabel);
        mProfileImage = (ImageView) findViewById(R.id.profileImage);

        mSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                handleSelectedPerson(i);
            }
        });
    }

    private void handleSelectedPerson(int selectedIndex) {
        Log.d(TAG, "handleSelectedPerson() called with: " + "selectedIndex = [" + selectedIndex + "]");

        switch (selectedIndex) {
            case 0:
                break;
            default:
                break;
        }
    }
}
