package com.example.viewui1.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.viewui1.R;
import com.google.android.material.snackbar.Snackbar;

public class TestActivity extends BaseActivity implements View.OnClickListener {

    private Button btnSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        init();
        popDialog();
    }

    private void popDialog() {

        new AlertDialog.Builder(this, R.style.CustomDialogAnimation)
                .setTitle("Welcome User")
                .setMessage("Press Ok to continue")
                .setPositiveButton("OK", null)
                .show();

    }


    private void init() {
        btnSlide = findViewById(R.id.button2);

        btnSlide.setOnClickListener(this);
    }

    public void customSnackBar(View view) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        // Create Snackbar
        Snackbar snackbar = Snackbar.make(this.findViewById(android.R.id.content), "", Snackbar.LENGTH_LONG);

        // Get Snackbar's Layout View
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        layout.setPadding(0, 0, 0, 0);

        // Hide text
        TextView textView = (TextView) layout.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setVisibility(View.INVISIBLE);

        // Inflate Custom View
        View snackView = getLayoutInflater().inflate(R.layout.customsnackbar, null);

        TextView tvUndo = (TextView) snackView.findViewById(R.id.tvUndo);
        TextView tvDelete = (TextView) snackView.findViewById(R.id.tvDelete);

        tvUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TestActivity", "Undo Selected !!");
            }
        });

        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TestActivity", "Delete Selected !! ");
            }
        });

        layout.addView(snackView, params);
        snackbar.show();
    }

    @Override
    protected Boolean useToolbar() {
        return false;
    }

    @Override
    protected String titleName() {
        return "Material Activity";
    }

    @Override
    public void onClick(View view) {
        Intent i = new Intent(this, AnimationActivity.class);
        startActivity(i);
    }
}
