package com.example.viewui1.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.viewui1.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ToolBarActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Menu menu;
    private FloatingActionButton fabAdd, fabShare;
    private AppBarLayout appBarLayout;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_demo);

        init();
        setSupportActionBar(toolbar);

        addFabMenu();



    }

    private void addFabMenu() {
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) { // i => Vertical Offset
                if(scrollRange == -1){
                    scrollRange = appBarLayout.getTotalScrollRange();
                    Log.d("ScrollRange", scrollRange+"");
                    Log.d("Value i : ", i+"");
                }
                if(scrollRange + i == 0){
                    isShow = true;
                    Log.d("ScrollRange", scrollRange+"");
                    Log.d("Value i : ", i+"");
                    Log.d("Hello","Show");
                    showOption(R.id.actionFab);
                    showOption(R.id.actionShare);
                }
                else if(isShow){
                    isShow = false;
                    Log.d("ScrollRange", scrollRange+"");
                    Log.d("Value i : ", i+"");
                    Log.d("Hello","Hide");
                    hideOption(R.id.actionFab);
                    hideOption(R.id.actionShare);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_items, menu);
        hideOption(R.id.actionFab);
        hideOption(R.id.actionShare);
        return true;
    }

    private void hideOption(int id) {
        item = menu.findItem(id);
        item.setVisible(false);
    }

    private void showOption(int id) {
        item = menu.findItem(id);
        item.setVisible(true);
    }

    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        fabShare = (FloatingActionButton) findViewById(R.id.fabShare);
        appBarLayout = (AppBarLayout) findViewById(R.id.appBar);
    }
}
