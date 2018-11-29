package com.iamchuckss.groceryplanner.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iamchuckss.groceryplanner.R;
import com.iamchuckss.groceryplanner.models.Recipe;
import com.iamchuckss.groceryplanner.plan.SelectRecipeActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PlanActivityRecyclerViewAdapter extends RecyclerView.Adapter<PlanActivityRecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "PlanActivityRecyclerVie";

    private static final int SELECT_RECIPE_REQUEST_CODE = 11;

    private Context mContext;
    private Activity mActivity;
    private TreeMap<Integer, ArrayList<Recipe>> mRecipeList;

    public PlanActivityRecyclerViewAdapter(Context mContext, Activity mActivity, TreeMap<Integer, ArrayList<Recipe>> mRecipeList) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mRecipeList = mRecipeList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        // widgets
        RelativeLayout mParentLayout;
        TextView mDayTitle;
        ListView mRecipeList;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mParentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
            mDayTitle = (TextView) itemView.findViewById(R.id.day_title);
            mRecipeList = (ListView) itemView.findViewById(R.id.recipe_list);
        }

        public void updateRecipeList(ArrayList<Recipe> recipeList) {
            Log.d(TAG, "updateRecipeList: refresh listview");

            ListAdapter recipeListAdapter = new ArrayAdapter<Recipe>(mContext, android.R.layout.simple_list_item_1,
                    recipeList);

            mRecipeList.setAdapter(recipeListAdapter);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem_plan, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: A new item is added to the list.");

        // obtain day and list of selected recipes from map
        int day = getTreeMapKeyFromIndex(i);
        ArrayList<Recipe> selectedRecipes = mRecipeList.get(day);

        viewHolder.mDayTitle.setText(Days.getString(day));
        viewHolder.updateRecipeList(selectedRecipes);

        viewHolder.mParentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + Days.getString(getTreeMapKeyFromIndex(i)));

                // start select recipes activity
                // TODO: consider if selectedRecipes is not empty -> send data over intent
                Intent intent = new Intent(mContext, SelectRecipeActivity.class);
                mActivity.startActivityForResult(intent, SELECT_RECIPE_REQUEST_CODE);

                Log.d(TAG, "onClick: navigating to SelectRecipeActivity");
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    private int getTreeMapKeyFromIndex(int i) {
        return (int) mRecipeList.keySet().toArray()[i];
    }
}
