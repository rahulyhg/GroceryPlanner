package com.iamchuckss.groceryplanner.home;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import com.iamchuckss.groceryplanner.R;
import com.iamchuckss.groceryplanner.models.Ingredient;
import com.iamchuckss.groceryplanner.models.Recipe;
import com.iamchuckss.groceryplanner.utils.BottomNavigationViewHelper;
import com.iamchuckss.groceryplanner.utils.MainActivityRecyclerViewAdapter;
import com.iamchuckss.groceryplanner.utils.PlanActivityRecyclerViewAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUM = 0;

    // vars
    private Context mContext = MainActivity.this;
    private ArrayList<Ingredient> mIngredientsList = new ArrayList<>();

    // widgets
    private ImageView mOptionButton;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOptionButton = findViewById(R.id.option);
        mRecyclerView = findViewById(R.id.recyclerView);

        setupBottomNavigationView();
        initOptionButton();
        initRecyclerView();
    }

    private void initRecyclerView() {
        initIngredientsList();

        MainActivityRecyclerViewAdapter adapter = new MainActivityRecyclerViewAdapter(mContext, mIngredientsList);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void initIngredientsList() {
        Log.d(TAG, "populateIngredientList: preparing recipes.");

        // TODO: get list of ingredients from database

        mIngredientsList.add(new Ingredient("Curry Powder"));
        mIngredientsList.add(new Ingredient("Cumin Powder"));
        mIngredientsList.add(new Ingredient("Coriander"));
        mIngredientsList.add(new Ingredient("Mustard Seeds"));
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
                getMenuInflater().inflate(R.menu.main_option_menu, popup.getMenu());
                popup.show();
            }
        });
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
