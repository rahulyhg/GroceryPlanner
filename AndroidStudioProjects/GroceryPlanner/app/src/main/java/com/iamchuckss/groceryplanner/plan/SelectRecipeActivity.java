package com.iamchuckss.groceryplanner.plan;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iamchuckss.groceryplanner.R;
import com.iamchuckss.groceryplanner.models.Ingredient;
import com.iamchuckss.groceryplanner.models.Recipe;
import com.iamchuckss.groceryplanner.utils.Days;
import com.iamchuckss.groceryplanner.utils.SelectRecipeRecyclerViewAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class SelectRecipeActivity extends AppCompatActivity {

    private static final String TAG = "SelectRecipeActivity";

    // vars
    ArrayList<Recipe> mRecipeList = new ArrayList<>();
    ArrayList<Recipe> mSelectedRecipeList = new ArrayList<>();
    int currentDay;

    Context mContext = SelectRecipeActivity.this;

    // widgets
    RecyclerView recyclerView;
    ImageView mBackButton;
    ImageView mDoneButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started.");

        setContentView(R.layout.activity_select_recipe);

        // retrieve currentDay
        Intent intent = getIntent();
        currentDay = intent.getIntExtra("currentDay", 10);
        // TODO: retrieve selectedRecipesList

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mBackButton = (ImageView) findViewById(R.id.backArrow);
        mDoneButton = (ImageView) findViewById(R.id.done_button);

        initBackButton();
        initDoneButton();
        populateRecipeList();
    }

    private void populateRecipeList() {
        Log.d(TAG, "populateRecipeList: populating recipe list");
        // TODO: get list of recipes from database
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient("recipe1", "Cumin"));
//        ingredientList.add(new Ingredient("Curry"));

        mRecipeList.add(new Recipe("Curry", "www.curry.com", ingredientList));
        mRecipeList.add(new Recipe("Curry1", "www.curry.com", ingredientList));
        mRecipeList.add(new Recipe("Curry2", "www.curry.com", ingredientList));
        mRecipeList.add(new Recipe("Curry3", "www.curry.com", ingredientList));
        mRecipeList.add(new Recipe("Curry4", "www.curry.com", new ArrayList<Ingredient>()));
        mRecipeList.add(new Recipe("Curry5", "www.curry.com", ingredientList));

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        SelectRecipeRecyclerViewAdapter adapter = new SelectRecipeRecyclerViewAdapter(
                mRecipeList, mContext);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    /**
     * Return to previous activity.
     */
    private void initBackButton() {
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Confirm unsaved changes
                finish();
            }
        });
    }

    /**
     * Return list of selected ingredients to previous activity on button click
     */
    private void initDoneButton() {
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // fetch ingredients with quantity
                for(int i = 0; i < mRecipeList.size(); i++) {
                    if(isRecipeSelected(i)) {
                        mSelectedRecipeList.add(mRecipeList.get(i));
                    }
                }
                Log.d(TAG, "onClick: mSelectedIngredientList: " + mSelectedRecipeList.toString());

                // return result if valid
                if(mSelectedRecipeList.size() != 0) {
                    Intent intent = new Intent();
                    intent.putExtra("currentDay", currentDay);
                    intent.putExtra("selectedRecipes", (Serializable) mSelectedRecipeList);
                    setResult(RESULT_OK, intent);
                }

                finish();
            }
        });
    }

    /**
     * Check if a recipe is selected
     * @param position
     * @return
     */
    private boolean isRecipeSelected(int position) {

        return mRecipeList.get(position).isChecked();
    }

}
