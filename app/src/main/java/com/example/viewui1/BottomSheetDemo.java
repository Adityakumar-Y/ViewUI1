package com.example.viewui1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.Arrays;
import java.util.List;

public class BottomSheetDemo extends AppCompatActivity {

    private LinearLayout llBottomSheet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet_demo);

        llBottomSheet = findViewById(R.id.bottomSheet);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(llBottomSheet);

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


        setAutoCompleteList();
    }

    private void setAutoCompleteList() {
        int layoutItemId = android.R.layout.simple_dropdown_item_1line;
        String[] country = getResources().getStringArray(R.array.country_arrays);
        List<String> countryList = Arrays.asList(country);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, layoutItemId, countryList);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoView);
        autoCompleteTextView.setAdapter(adapter);
    }
}
