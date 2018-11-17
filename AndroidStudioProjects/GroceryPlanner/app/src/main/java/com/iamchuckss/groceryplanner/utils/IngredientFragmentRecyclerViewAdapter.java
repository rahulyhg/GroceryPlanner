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

public class IngredientFragmentRecyclerViewAdapter extends RecyclerView.Adapter<IngredientFragmentRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "IngredientFragRvAdapter";

    private ArrayList<String> mIngredientTitles = new ArrayList<>();
    private Context mContext;

    public IngredientFragmentRecyclerViewAdapter(Context mContext, ArrayList<String> ingredientTitles) {
        this.mIngredientTitles = ingredientTitles;
        this.mContext = mContext;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        // widgets
        RelativeLayout parentLayout;
        TextView ingredientTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
            ingredientTitle = (TextView) itemView.findViewById(R.id.ingredient_title);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem_ingredient, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: A new item is added to the list.");

        viewHolder.ingredientTitle.setText(mIngredientTitles.get(i));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + mIngredientTitles.get(i));

                Toast.makeText(mContext, mIngredientTitles.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIngredientTitles.size();
    }
}