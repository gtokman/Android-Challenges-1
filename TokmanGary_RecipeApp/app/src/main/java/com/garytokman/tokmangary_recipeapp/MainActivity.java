package com.garytokman.tokmangary_recipeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.garytokman.tokmangary_recipeapp.model.APIClient;
import com.garytokman.tokmangary_recipeapp.model.Recipe;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements APIClient.LoadRecipeDelegate, View.OnClickListener {

    private static final String TAG = "Main Activity";
    private APIClient mAPIClient;
    private List<Recipe> mRecipes;
    private LinearLayout mSecondScreen;
    private LinearLayout mFirstScreen;
    private LinearLayout mThirdScreen;
    private ListView mCateforyList;
    private ListView mInputList;
    private ImageView mImageView;
    private TextView mRecipeTitle;
    private TextView mRecipePub;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mSearchButton;
    private EditText mRecipeInput;
    private List<Recipe> mSearchRecipeList;
    private boolean isSearching = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        mRecipes = new ArrayList<>();
        mSearchRecipeList = new ArrayList<>();
        mFirstScreen = (LinearLayout) findViewById(R.id.firstScreen);
        mSecondScreen = (LinearLayout) findViewById(R.id.secondScreen);
        mThirdScreen = (LinearLayout) findViewById(R.id.thirdScreen);
        mCateforyList = (ListView) findViewById(R.id.categoryListView);
        mInputList = (ListView) findViewById(R.id.inputList);
        mImageView = (ImageView) findViewById(R.id.recipeImage);
        mRecipeTitle = (TextView) findViewById(R.id.recipeName);
        mRecipePub = (TextView) findViewById(R.id.recipePublisher);
        mRecipeInput = (EditText) findViewById(R.id.recipeInput);
        mButton1 = (Button) findViewById(R.id.buttonOne);
        mButton2 = (Button) findViewById(R.id.buttonTwo);
        mButton3 = (Button) findViewById(R.id.buttonThree);
        mSearchButton = (Button) findViewById(R.id.searchButton);
        mSearchButton.setOnClickListener(this);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);


        String apiKey = "e90f84b2f7eb65ee00614181b1e12fde";
        String url = "http://food2fork.com/api/search?key=e90f84b2f7eb65ee00614181b1e12fde";
        mAPIClient = new APIClient(this);
        mAPIClient.execute(url);
    }

    @Override
    public void getJsonData(String json) throws JSONException {
//        Log.d(TAG, "getJsonData() called with: " + "json = [" + json + "]");

        // Parse json
        JSONObject jsonObject = new JSONObject(json);
        JSONArray recipesObject = jsonObject.getJSONArray("recipes");

        for (int i = 0; i < recipesObject.length(); i++) {
            String image = recipesObject.getJSONObject(i).getString("image_url");
            String title = recipesObject.getJSONObject(i).getString("title");
            String publisher = recipesObject.getJSONObject(i).getString("publisher");
            Log.d(TAG, "getJsonData: " + "title:" + title + " pub: " + publisher + " " + " image: " + image);

            mRecipes.add(new Recipe(image, title, publisher));

            if (isSearching) {
                Log.d(TAG, "getJsonData: Searching");
                mSearchRecipeList.add(new Recipe(image, title, publisher));
                setupSearchUI();
            }
        }
        setupUI();
    }

    private void setupSearchUI() {
        ArrayAdapter<Recipe> arrayAdapter = new ArrayAdapter<Recipe>(this, android.R.layout.simple_list_item_1, mSearchRecipeList);
        mInputList.setAdapter(arrayAdapter);
    }

    private void setupUI() {
        mAPIClient.cancel(true);
        for (int i = 0; i < mRecipes.size(); i++) {
            Picasso.with(this).load(mRecipes.get(i).getRecipeImage()).into(mImageView);
            mRecipeTitle.setText(mRecipes.get(i).getRecipeTitle());
            mRecipePub.setText(mRecipes.get(i).getRecipePublisher());
        }

        ArrayAdapter<Recipe> arrayAdapter = new ArrayAdapter<Recipe>(this, android.R.layout.simple_list_item_1, mRecipes);
        mCateforyList.setAdapter(arrayAdapter);
    }

    private void setScreenVisible(int v1, int v2, int v3) {
        mFirstScreen.setVisibility(v1);
        mSecondScreen.setVisibility(v2);
        mThirdScreen.setVisibility(v3);
    }

    private void searchUserInput() {

        String inputText = mRecipeInput.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(MainActivity.this, "Enter a valid recipe name", Toast.LENGTH_SHORT).show();
        } else {
            mAPIClient.cancel(true);
            String searchUrl = "http://food2fork.com/api/search?key=e90f84b2f7eb65ee00614181b1e12fde" + "&" + "q" + inputText;
            APIClient apiClient = new APIClient(this);
            apiClient.execute(searchUrl);
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonOne:
                Log.d(TAG, "onClick: button 1");
                setScreenVisible(View.VISIBLE, View.GONE, View.GONE);
                Log.d(TAG, "onClick: button 2");
                break;
            case R.id.buttonTwo:
                setScreenVisible(View.GONE, View.VISIBLE, View.GONE);
                setupUI();
                Log.d(TAG, "onClick: button 3`");
                break;
            case R.id.buttonThree:
                setScreenVisible(View.GONE, View.GONE, View.VISIBLE);

                break;
            case R.id.searchButton:
                searchUserInput();
                isSearching = true;
                break;
            default:
                break;
        }
    }
}
