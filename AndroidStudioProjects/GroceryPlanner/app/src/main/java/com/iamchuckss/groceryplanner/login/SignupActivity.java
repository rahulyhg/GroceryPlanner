package com.iamchuckss.groceryplanner.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.iamchuckss.groceryplanner.R;

public class SignupActivity extends AppCompatActivity{

    private static final String TAG = "SignupActivity";

    Context mContext = SignupActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
}
