package com.iamchuckss.groceryplanner.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iamchuckss.groceryplanner.R;
import com.iamchuckss.groceryplanner.utils.IngredientFragmentRecyclerViewAdapter;
import com.iamchuckss.groceryplanner.utils.RecipeFragmentRecyclerViewAdapter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class IngredientFragment extends Fragment {
    private static final String TAG = "IngredientFragment";

    // vars
    private ArrayList<String> mIngredientTitles = new ArrayList<>();

    Context mContext;

    // widgets
    RecyclerView recyclerView;
    CircleImageView addIngredientButton;

    IngredientFragmentRecyclerViewAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredient, container, false);
        Log.d(TAG, "onCreateView: started.");

        mContext = getActivity();
        recyclerView = view.findViewById(R.id.recyclerView);
        addIngredientButton = (CircleImageView) view.findViewById(R.id.btnAddIngredient);

        initAddIngredientButton();
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

        mAdapter = new IngredientFragmentRecyclerViewAdapter(
                mContext, mIngredientTitles);

        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void initAddIngredientButton() {
        addIngredientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: starting AddIngredientDialog");
                initAddIngredientDialog();
            }
        });
    }

    private void initAddIngredientDialog() {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(mContext);
        View mView = getLayoutInflater().inflate(R.layout.dialog_add_ingredient, null);

        final EditText mIngredientTitle = (EditText) mView.findViewById(R.id.ingredient_title);
        Button mCancelButton = (Button) mView.findViewById(R.id.btn_cancel);
        Button mDoneButton = (Button) mView.findViewById(R.id.btn_done);

        mBuilder.setView(mView);
        final AlertDialog dialog = mBuilder.create();
        dialog.show();

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userInput = mIngredientTitle.getText().toString();

                // set inputQuantity to input
                if(!(userInput == null) && !userInput.equals("") && !userInput.equals(" ")) {

                    mIngredientTitles.add(userInput);
                    // TODO: add new ingredient to database
                    mAdapter.notifyItemInserted(mIngredientTitles.size() - 1);
                }

                dialog.dismiss();
            }
        });
    }


}
