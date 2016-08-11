package com.garytokman.tokmangary_ce06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Spinner mTypeOfView;
    private Spinner mTypeOfAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mTypeOfView = (Spinner) findViewById(R.id.typeOfViewSpinner);
        mTypeOfAdapter = (Spinner) findViewById(R.id.typeOfAdapter);

        // Listeners
        mTypeOfView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // On selected
                handleViewChange(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mTypeOfAdapter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // On selected
                handleAdapterChange(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void handleAdapterChange(int selectedIndex) {
        Log.d(TAG, "handleAdapterChange() called with: " + "selectedIndex = [" + selectedIndex + "]");
        switch (selectedIndex) {
            case 0:
                // Array Adapter
                break;
            case 1:
                // Simple Adapter
                break;
            case 2:
                // Base Adapter
            default:
                break;
        }
    }

    private void handleViewChange(int selectedIndex) {
        Log.d(TAG, "handleViewchange() called with: " + "selectedIndex = [" + selectedIndex + "]");
        switch (selectedIndex) {
            case 0:
                // List View
                break;
            case 1:
                // GridView
                break;
            default:
                break;
        }
    }
}
