package com.iamchuckss.groceryplanner.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iamchuckss.groceryplanner.R;
import com.iamchuckss.groceryplanner.models.Ingredient;
import com.iamchuckss.groceryplanner.models.Recipe;
import com.iamchuckss.groceryplanner.utils.RecipeFragmentRecyclerViewAdapter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecipeFragment extends Fragment {
    private static final String TAG = "RecipeFragment";

    // vars
    private ArrayList<Recipe> mRecipeList = new ArrayList<>();

    Context mContext = getActivity();

    // widgets
    RecyclerView recyclerView;
    CircleImageView addRecipeButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        Log.d(TAG, "onCreateView: started.");

        mContext = getActivity();
        recyclerView = view.findViewById(R.id.recyclerView);
        addRecipeButton = (CircleImageView) view.findViewById(R.id.btnAddRecipe);

        initAddRecipeButton();
        initRecipes();

        return view;
    }

    private void initRecipes() {
        Log.d(TAG, "initRecipes: preparing recipes.");

        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient("Cumin"));
        ingredientList.add(new Ingredient("Curry"));

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

        RecipeFragmentRecyclerViewAdapter adapter = new RecipeFragmentRecyclerViewAdapter(mRecipeList, mContext);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void initAddRecipeButton() {
        addRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigating to AddRecipeActivity.");
                Intent intent = new Intent(mContext, AddRecipeActivity.class);
                startActivity(intent);
            }
        });
    }
}
