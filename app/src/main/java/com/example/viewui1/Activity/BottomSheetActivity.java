package com.example.viewui1.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.viewui1.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.Arrays;
import java.util.List;

public class BottomSheetActivity extends AppCompatActivity{

    private LinearLayout llBottomSheet;
    private ChipGroup chipGroup;
    private BottomSheetBehavior bottomSheetBehavior;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_demo);

        init();
        drawBottomSheet();
        setAutoCompleteList();
    }

    private void drawBottomSheet() {
        bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                switch(i){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.d("BottomSheet", "Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.d("BottomSheet", "Dragging");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.d("BottomSheet", "Expanded");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.d("BottomSheet", "Hidden");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.d("BottomSheet", "Setting");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }

    private void init() {
        llBottomSheet = findViewById(R.id.bottomSheet);
        autoCompleteTextView = findViewById(R.id.autoView);
        chipGroup = findViewById(R.id.chipGroup);
    }

    private void setAutoCompleteList() {
        int layoutItemId = android.R.layout.simple_dropdown_item_1line;
        String[] country = getResources().getStringArray(R.array.country_arrays);
        List<String> countryList = Arrays.asList(country);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layoutItemId, countryList);


        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Chip chip = new Chip(BottomSheetActivity.this);
                String str = adapter.getItem(i);
                chip.setText(str);
                chip.setTextColor(Color.RED);
                chip.setChipCornerRadius(16f);
                chip.setChipIcon(getResources().getDrawable(R.drawable.ic_flag_24dp));
                chip.setCloseIconVisible(true);
                chip.setOnCloseIconClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Chip chipItem = (Chip) view;
                        chipGroup.removeView(chipItem);
                    }
                });
                chipGroup.addView(chip);
            }
        });
    }
}
