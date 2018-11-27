package com.iamchuckss.groceryplanner.plan;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

import com.iamchuckss.groceryplanner.R;
import com.iamchuckss.groceryplanner.utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class PlanActivity extends AppCompatActivity{

    private static final String TAG = "PlanActivity";
    private static final int ACTIVITY_NUM = 1;

    Context mContext = PlanActivity.this;

    // widgets
    RecyclerView mRecyclerView;
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
                                // clear plan
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
