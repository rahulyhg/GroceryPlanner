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

        // set onItemClick to edit (pop-up box)
    }

    private void initAddIngredientButton() {

        mAddIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to SelectIngredientsActivity");
                Intent intent = new Intent(mContext, SelectIngredientsActivity.class);
                startActivity(intent);
            }
        });
    }
}
