package com.iamchuckss.groceryplanner.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iamchuckss.groceryplanner.R;

import java.util.ArrayList;

public class RecipeFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecipeFragmentRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecipeFragmentRvAdapter";

    private ArrayList<String> mRecipeTitles = new ArrayList<>();
    private ArrayList<String> mRecipeDetails1 = new ArrayList<>();
    private ArrayList<String> mRecipeDetails2 = new ArrayList<>();
    private Context mContext;

    public RecipeFragmentRecyclerViewAdapter(Context mContext, ArrayList<String> mRecipeTitles, ArrayList<String> mRecipeDetails1, ArrayList<String> mRecipeDetails2) {
        this.mRecipeTitles = mRecipeTitles;
        this.mRecipeDetails1 = mRecipeDetails1;
        this.mRecipeDetails2 = mRecipeDetails2;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        // widgets
        RelativeLayout parentLayout;
        TextView recipeTitle, recipeDetails1, recipeDetails2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
            recipeTitle = (TextView) itemView.findViewById(R.id.recipe_title);
            recipeDetails1 = (TextView) itemView.findViewById(R.id.recipe_details1);
            recipeDetails2 = (TextView) itemView.findViewById(R.id.recipe_details2);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem_recipe, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: A new item is added to the list.");

        viewHolder.recipeTitle.setText(mRecipeTitles.get(i));
        viewHolder.recipeDetails1.setText(mRecipeDetails1.get(i));
        viewHolder.recipeDetails2.setText(mRecipeDetails2.get(i));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mRecipeTitles.get(i));

                Toast.makeText(mContext, mRecipeTitles.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecipeTitles.size();
    }
}
