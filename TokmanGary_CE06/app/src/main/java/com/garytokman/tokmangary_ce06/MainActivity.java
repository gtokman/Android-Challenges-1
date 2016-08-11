package com.garytokman.tokmangary_ce06;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.garytokman.tokmangary_ce06.adapter.PersonAdapter;
import com.garytokman.tokmangary_ce06.model.People;
import com.garytokman.tokmangary_ce06.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ListView mListView;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        Spinner typeOfView = (Spinner) findViewById(R.id.typeOfViewSpinner);
        Spinner typeOfAdapter = (Spinner) findViewById(R.id.typeOfAdapter);
        mListView = (ListView) findViewById(R.id.listView);
        mGridView = (GridView) findViewById(R.id.gridView);

        // Listeners
        typeOfView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // On selected
                handleViewChange(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        typeOfAdapter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // On selected
                handleAdapterChange(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // List listeners
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showAlert(i);
            }
        });

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showAlert(i);
            }
        });
    }

    private void showAlert(int position) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        Person person = People.getPeople().get(position);
        alert.setTitle(person.getFirstName() + " " + person.getLastName());
        alert.setMessage(person.getBirthday());
        alert.setIcon(person.getPicture());
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do something
            }
        }).show();
    }

    private void handleAdapterChange(int selectedIndex) {
        Log.d(TAG, "handleAdapterChange() called with: " + "selectedIndex = [" + selectedIndex + "]");
        switch (selectedIndex) {
            case 0:
                // Array Adapter
                ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, People.getPeople());
                mListView.setAdapter(arrayAdapter);
                mGridView.setAdapter(arrayAdapter);
                break;
            case 1:
                // Simple Adapter
                List<Map<String, String>> data = getSimpleAdapterData();
                String[] items = {"person"};
                int[] to = {android.R.id.text1};

                SimpleAdapter simpleAdapter = new SimpleAdapter(this, data, android.R.layout.simple_list_item_1, items, to);
                mListView.setAdapter(simpleAdapter);
                mGridView.setAdapter(simpleAdapter);
                break;
            case 2:
                // Base Adapter
                PersonAdapter personAdapter = new PersonAdapter(this, People.getPeople());
                mListView.setAdapter(personAdapter);
                mGridView.setAdapter(personAdapter);
            default:
                break;
        }
    }

    private void handleViewChange(int selectedIndex) {
        Log.d(TAG, "handleViewchange() called with: " + "selectedIndex = [" + selectedIndex + "]");
        switch (selectedIndex) {
            case 0:
                // List View
                mGridView.setVisibility(View.GONE);
                mListView.setVisibility(View.VISIBLE);
                break;
            case 1:
                // GridView
                mListView.setVisibility(View.GONE);
                mGridView.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    private List<Map<String, String>> getSimpleAdapterData() {

        List<Map<String, String>> data = new ArrayList<>();

        for (int i = 0; i < People.getPeople().size(); i++) {
            // Create map
            Map<String, String> map = new HashMap<>();
            // Get static people
            List<Person> people = People.getPeople();
            // Iterate and add to list
            map.put("person", people.get(i) + "\n" + people.get(i).getBirthday() + "");
            data.add(map);
        }

        Log.d(TAG, "getSimpleAdapterData() returned: " + data);
        return data;
    }

}
