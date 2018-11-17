package com.iamchuckss.groceryplanner.library;

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
import com.iamchuckss.groceryplanner.utils.RecipeFragmentRecyclerViewAdapter;

import java.util.ArrayList;

public class RecipeFragment extends Fragment {
    private static final String TAG = "RecipeFragment";

    // vars
    private ArrayList<String> mRecipeTitles = new ArrayList<>();
    private ArrayList<String> mRecipeDetails1 = new ArrayList<>();
    private ArrayList<String> mRecipeDetails2 = new ArrayList<>();

    // widgets
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe, container, false);
        Log.d(TAG, "onCreateView: started.");

        recyclerView = view.findViewById(R.id.recyclerView);

        initRecipes();

        return view;
    }

    private void initRecipes() {
        Log.d(TAG, "initRecipes: preparing recipes.");

        mRecipeTitles.add("Curry");
        mRecipeDetails1.add("Chinese Curry");
        mRecipeDetails2.add("Delicious Chinese Curry");

        mRecipeTitles.add("Curry1");
        mRecipeDetails1.add("Indian Curry");
        mRecipeDetails2.add("Delicious Indian Curry");

        mRecipeTitles.add("Curry2");
        mRecipeDetails1.add("Chicken Tikka Masala Curry");
        mRecipeDetails2.add("Delicious Chicken Tikka Masala Curry");

        mRecipeTitles.add("Curry3");
        mRecipeDetails1.add("Chicken Korma Curry");
        mRecipeDetails2.add("Delicious Chicken Korma Curry");

        mRecipeTitles.add("Curry4");
        mRecipeDetails1.add("Rendang Curry");
        mRecipeDetails2.add("Delicious Rendang Curry");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        RecipeFragmentRecyclerViewAdapter adapter = new RecipeFragmentRecyclerViewAdapter(getActivity()
                , mRecipeTitles, mRecipeDetails1, mRecipeDetails2);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
