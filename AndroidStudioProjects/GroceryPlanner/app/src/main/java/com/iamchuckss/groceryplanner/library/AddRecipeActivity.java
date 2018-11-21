package com.iamchuckss.groceryplanner.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.iamchuckss.groceryplanner.R;

public class AddRecipeActivity extends AppCompatActivity {

    private static final String TAG = "AddRecipeActivity";

    Context mContext = AddRecipeActivity.this;
    
    // constants
    private static final int SELECT_INGREDIENTS_REQUEST_CODE = 10;

    // vars
    EditText mRecipeName;
    EditText mRecipeDescription;
    EditText mRecipeWebsite;
    ListView mIngredientsList;
    ImageView mAddIngredientButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: started.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        mRecipeName = (EditText) findViewById(R.id.recipe_name);
        mRecipeDescription = (EditText) findViewById(R.id.recipe_description);
        mRecipeWebsite = (EditText) findViewById(R.id.recipe_website);
        mIngredientsList = (ListView) findViewById(R.id.ingredientsList);
        mAddIngredientButton = (ImageView) findViewById(R.id.add_ingredient_button);

        initAddIngredientButton();
    }

    private void initIngredientsList() {

        // on click ingredientsList
            // intent start SelectIngredientsActivity
            // match saved data to new data
    }

    private void initAddIngredientButton() {

        mAddIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to SelectIngredientsActivity");
                // TODO: change to startActivityForResult
                Intent intent = new Intent(mContext, SelectIngredientsActivity.class);
                startActivityForResult(intent, SELECT_INGREDIENTS_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if(requestCode == SELECT_INGREDIENTS_REQUEST_CODE) {
            Log.d(TAG, "onActivityResult: done selecting ingredients ");
            if(resultCode == RESULT_OK) {
                Log.d(TAG, "onActivityResult: result is valid");
                // adapt ingredients onto mIngredientsList
            }
        }
    }
}
