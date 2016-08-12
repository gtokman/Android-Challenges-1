package com.garytokman.tokmangary_assignment1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mSpinner = (Spinner) findViewById(R.id.personSpinner);
        mName = (TextView) findViewById(R.id.nameLabel);
        mAge = (TextView) findViewById(R.id.ageLabel);
        mProfileImage = (ImageView) findViewById(R.id.profileImage);
        mListView = (ListView) findViewById(R.id.listView);

        // Check orientation
        int orientation = getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.i(TAG, "onCreate: portrait");

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
        } else {
            Log.i(TAG, "onCreate: landscape");
            // Set List
            ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Students.getStudents());
            mListView.setAdapter(arrayAdapter);
            handleSelectedPerson(0);
            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    handleSelectedPerson(i);
                }
            });
        }
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
