package com.iamchuckss.groceryplanner.library;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iamchuckss.groceryplanner.R;
import com.iamchuckss.groceryplanner.models.Ingredient;
import com.iamchuckss.groceryplanner.utils.IngredientFragmentRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectIngredientsActivity extends AppCompatActivity {

    private static final String TAG = "SelectIngredientsActivi";

    // vars
    ArrayList<Ingredient> mIngredientList = new ArrayList<>();

    Context mContext = SelectIngredientsActivity.this;

    // widgets
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: started.");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initIngredients();
    }

    private void initIngredients() {
        Log.d(TAG, "initIngredients: preparing recipes.");

        mIngredientList.add(new Ingredient("Curry Powder", 0));
        mIngredientList.add(new Ingredient("Cumin Powder", 0));
        mIngredientList.add(new Ingredient("Coriander", 0));
        mIngredientList.add(new Ingredient("Mustard Seeds", 0));

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");

        SelectIngredientRvAdapter adapter = new SelectIngredientRvAdapter(
                mContext, mIngredientList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
    }

    /**
     * Custom adapter for displaying an array of ingredients.
     **/
    private class SelectIngredientRvAdapter extends RecyclerView.Adapter<SelectIngredientRvAdapter.ViewHolder> {

        private static final String TAG = "SelectIngredientRvAdptr";

        private ArrayList<Ingredient> mIngredientList = new ArrayList<>();
        private Context mContext;

        public SelectIngredientRvAdapter(Context mContext, ArrayList<Ingredient> ingredientList) {
            this.mIngredientList = ingredientList;
            this.mContext = mContext;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            // widgets
            RelativeLayout parentLayout;
            TextView ingredientTitle;
            EditText ingredientQuantity;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                parentLayout = (RelativeLayout) itemView.findViewById(R.id.parent_layout);
                ingredientTitle = (TextView) itemView.findViewById(R.id.ingredient_title);
                ingredientQuantity = (EditText) itemView.findViewById(R.id.ingredient_quantity);
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem_add_recipe_ingredient, viewGroup, false);
            SelectIngredientRvAdapter.ViewHolder holder = new SelectIngredientRvAdapter.ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
            Log.d(TAG, "onBindViewHolder: A new item is added to the list.");

            viewHolder.ingredientTitle.setText(mIngredientList.get(i).getTitle());
            viewHolder.ingredientQuantity.setText(mIngredientList.get(i).getQuantity());

            viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onClick: clicked on: " + mIngredientList.get(i).getTitle());

                    Toast.makeText(mContext, mIngredientList.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mIngredientList.size();
        }
    }
}
