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
import com.iamchuckss.groceryplanner.utils.IngredientFragmentRecyclerViewAdapter;
import com.iamchuckss.groceryplanner.utils.RecipeFragmentRecyclerViewAdapter;

import java.util.ArrayList;

public class IngredientFragment extends Fragment {
    private static final String TAG = "IngredientFragment";

    // vars
    private ArrayList<String> mIngredientTitles = new ArrayList<>();

    // widgets
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredient, container, false);
        Log.d(TAG, "onCreateView: started.");

        recyclerView = view.findViewById(R.id.recyclerView);

        initIngredients();

        return view;
    }

    private void initIngredients() {
        Log.d(TAG, "initIngredients: preparing recipes.");

        mIngredientTitles.add("Curry Powder");

        mIngredientTitles.add("Coriander Powder");

        mIngredientTitles.add("Cumin Powder");

        mIngredientTitles.add("Mustard seeds");

        mIngredientTitles.add("Garam Masala");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        IngredientFragmentRecyclerViewAdapter adapter = new IngredientFragmentRecyclerViewAdapter(
                getActivity(), mIngredientTitles);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }
}
