package com.iamchuckss.groceryplanner.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.iamchuckss.groceryplanner.R;

public class AddIngredientActivity extends AppCompatActivity {

    private static final String TAG = "AddIngredientActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ingredient);
    }
}
