package com.garytokman.tokmangary_assignment1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.garytokman.tokmangary_assignment1.model.Person;
import com.garytokman.tokmangary_assignment1.model.Students;

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

        // Listener
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                handleSelectedPerson(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void handleSelectedPerson(int selectedIndex) {
        Log.d(TAG, "handleSelectedPerson() called with: " + "selectedIndex = [" + selectedIndex + "]");

        Person person = Students.getStudents().get(selectedIndex);
        // Set UI
        mProfileImage.setImageResource(person.getProfileImage());
        mName.setText(person.getName());
        mAge.setText("Age: " + person.getAge());

    }
}
