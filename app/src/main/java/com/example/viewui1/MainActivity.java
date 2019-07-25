package com.example.viewui1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CountryItem> countryList;
    private CountryAdapter mAdapter;
    private TextView tvHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
        Spinner spinnerList = (Spinner) findViewById(R.id.spinner);
        mAdapter = new CountryAdapter(this, countryList);
        spinnerList.setAdapter(mAdapter);
        tvHeading = (TextView) findViewById(R.id.textView);
        Typeface face = ResourcesCompat.getFont(this, R.font.dancingscript);
        tvHeading.setTypeface(face);

    }

    private void initList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("India", R.drawable.india));
        countryList.add(new CountryItem("Australia", R.drawable.aus));
        countryList.add(new CountryItem("U.S.A", R.drawable.usa));
        countryList.add(new CountryItem("China", R.drawable.china));
        countryList.add(new CountryItem("Africa", R.drawable.africa));
    }

    ProgressDialog progressBar;
    public void send(View view) {
        progressBar = new ProgressDialog(this);
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setIndeterminate(true);
        progressBar.setTitle("Loading");
        progressBar.setMax(100);
        progressBar.show();

        long delayInMillis = 2000;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                progressBar.dismiss();
            }
        }, delayInMillis);

        Intent i = new Intent(MainActivity.this, ViewUI2.class);
        startActivity(i);
    }

}
