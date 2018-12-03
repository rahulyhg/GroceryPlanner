package com.iamchuckss.groceryplanner.plan;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.iamchuckss.groceryplanner.R;
import com.iamchuckss.groceryplanner.models.Recipe;
import com.iamchuckss.groceryplanner.utils.BottomNavigationViewHelper;
import com.iamchuckss.groceryplanner.utils.PlanActivityRecyclerViewAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.TreeMap;

public class PlanActivity extends AppCompatActivity{

    private static final String TAG = "PlanActivity";
    private static final int ACTIVITY_NUM = 1;
    private static final int SELECT_RECIPE_REQUEST_CODE = 11;

    // vars
    TreeMap<Integer, ArrayList<Recipe>> mRecipeList = new TreeMap<>();
    Context mContext = PlanActivity.this;

    // widgets
    RecyclerView mRecyclerView;
    PlanActivityRecyclerViewAdapter mAdapter;
    Toolbar mToolbar;
    ImageView mOptionButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        mToolbar = (Toolbar) findViewById(R.id.plan_toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mOptionButton = (ImageView) findViewById(R.id.option);

        initOptionButton();
        setupBottomNavigationView();
        initRecyclerView();

    }

    private void initRecyclerView() {
        initRecipeList();
        mAdapter = new PlanActivityRecyclerViewAdapter(mContext, this,
                mRecipeList);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void initRecipeList() {
        mRecipeList.put(0, new ArrayList<Recipe>());
        mRecipeList.put(1, new ArrayList<Recipe>());
        mRecipeList.put(2, new ArrayList<Recipe>());
        mRecipeList.put(3, new ArrayList<Recipe>());
        mRecipeList.put(4, new ArrayList<Recipe>());
        mRecipeList.put(5, new ArrayList<Recipe>());
        mRecipeList.put(6, new ArrayList<Recipe>());
    }

    private void initOptionButton() {

        mOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(mContext, v);
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.clear_plan:
                                // TODO: add clear plan function
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                getMenuInflater().inflate(R.menu.plan_option_menu, popup.getMenu());
                popup.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SELECT_RECIPE_REQUEST_CODE) {
            Log.d(TAG, "onActivityResult: done selecting ingredients ");
            if(resultCode == RESULT_OK) {
                Log.d(TAG, "onActivityResult: result is valid");

                // get which day
                int currentDay = data.getIntExtra("currentDay", 10);
                ArrayList<Recipe> selectedRecipeList = (ArrayList) (data.getSerializableExtra("selectedRecipes"));

                // get selected recipes list
                if(currentDay >= 0 && currentDay <= 6 && (selectedRecipeList != null)) {
                    mRecipeList.put(currentDay, selectedRecipeList);
                    Log.d(TAG, "onActivityResult: Selected recipes: " + selectedRecipeList.toString());

                    // adapt recipes onto mRecipeList
                    updateRecipeList(currentDay, selectedRecipeList);
                }
            }
        }
    }

    public void updateRecipeList(int pos, ArrayList<Recipe> selectedRecipes) {
        RecyclerView.ViewHolder viewHolder = mRecyclerView.findViewHolderForAdapterPosition(pos);
        View view = viewHolder.itemView;
        TextView recipeList = (TextView) view.findViewById(R.id.recipe_list);

        ArrayList<String> selectedRecipesTitles = new ArrayList<>();
        // get recipes' title from list
        for(Recipe recipe : selectedRecipes) {
            selectedRecipesTitles.add(recipe.getTitle());
        }

        recipeList.setText("");

        for(String recipeTitle : selectedRecipesTitles) {
            recipeList.append(recipeTitle);
            recipeList.append("\n");
        }
    }

    /**
     * BottomNavigationView Setup
     *
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
