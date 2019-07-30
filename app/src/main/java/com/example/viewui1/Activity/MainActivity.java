package com.example.viewui1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.viewui1.Adapters.CountryAdapter;
import com.example.viewui1.Model.CountryItem;
import com.example.viewui1.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements View.OnClickListener, View.OnTouchListener {

    private ArrayList<CountryItem> countryList;
    private CountryAdapter mAdapter;
    private TextView tvHeading;
    private Button btnSend;
    private ProgressDialog progressBar;
    private ImageButton imgBtnBold;
    private Spinner spinnerList;
    private EditText etName, etEmail;
    private CoordinatorLayout coordinatorLayout;
    private int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initList();
        setAdapter();
        setHeaderFont();

    }

    private void setHeaderFont() {
        Typeface face = ResourcesCompat.getFont(this, R.font.dancingscript);
        tvHeading.setTypeface(face);
    }

    private void setAdapter() {
        mAdapter = new CountryAdapter(this, countryList);
        spinnerList.setAdapter(mAdapter);
    }

    private void init() {
        etName = (EditText) findViewById(R.id.editText);
        etEmail = (EditText) findViewById(R.id.etEmail);
        spinnerList = (Spinner) findViewById(R.id.spinner);
        btnSend = (Button) findViewById(R.id.button);
        tvHeading = (TextView) findViewById(R.id.textView);
        imgBtnBold = (ImageButton) findViewById(R.id.btnBold);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        imgBtnBold.setOnClickListener(this);
        btnSend.setOnClickListener(this);
        etEmail.setOnTouchListener(this);
    }

    private void initList() {
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("India", R.drawable.india));
        countryList.add(new CountryItem("Australia", R.drawable.aus));
        countryList.add(new CountryItem("U.S.A", R.drawable.usa));
        countryList.add(new CountryItem("China", R.drawable.china));
        countryList.add(new CountryItem("Africa", R.drawable.africa));
    }


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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBold:
                makeBold();
                break;
            case R.id.button:
                customSnackbar();
                break;
        }
    }

    private void customSnackbar() {
        final Snackbar snackbar = Snackbar.make(coordinatorLayout, "Click Next !!", Snackbar.LENGTH_LONG);
        View view = snackbar.getView();
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        params.gravity = Gravity.TOP;
        view.setLayoutParams(params);
        TextView tv = (TextView) view.findViewById(com.google.android.material.R.id.snackbar_text);
        tv.setTextColor(Color.BLUE);
        snackbar.setAction("Next", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, TestActivity.class);
                startActivity(i);
            }
        });
        snackbar.setActionTextColor(Color.YELLOW);
        view.setBackgroundColor(Color.GRAY);
        snackbar.show();
    }

    private void makeBold() {
        String s = etName.getText().toString();
        if (flag == 0) {
            s = "<b>" + s + "</b>";
            etName.setText(Html.fromHtml(s));
            flag = 1;
        } else if (flag == 1) {
            etName.setText(Html.fromHtml(s));
            flag = 0;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP) {
            /*Log.d("RawX", event.getRawX()+"");
            Log.d("Email getRight", etEmail.getRight()+"");
            Log.d("Drawable width", etEmail.getCompoundDrawables()[2].getBounds().width()+"");*/
            if(event.getRawX() >= (etEmail.getRight() - etEmail.getCompoundDrawables()[2].getBounds().width())) {
                etEmail.setText("");
                return true;
            }
        }
        return false;
    }

    @Override
    protected String titleName() {
        return "Register Activity";
    }
}
