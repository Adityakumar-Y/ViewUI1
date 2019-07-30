package com.example.viewui1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.viewui1.R;

public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base,null);
        FrameLayout activityContainer = (FrameLayout) layout.findViewById(R.id.activity_container);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);
        super.setContentView(layout);

        toolbar = findViewById(R.id.toolBar);

        if(useToolbar()) {
            setSupportActionBar(toolbar);
            setTitle(titleName());
        }else {
            toolbar.setVisibility(View.GONE);
        }


    }

    protected Boolean useToolbar() {
        return true;
    }

    protected String titleName(){
        return "Title Activity";
    }

}
