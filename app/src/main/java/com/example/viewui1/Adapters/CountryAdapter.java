package com.example.viewui1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.viewui1.Model.CountryItem;
import com.example.viewui1.R;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<CountryItem> {
    public CountryAdapter(Context context, ArrayList<CountryItem> countryList) {
        super(context, 0, (List) countryList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private  View initView(int positon, View convertView, ViewGroup parent){
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.country_spinner_row, parent, false);
        }
        ImageView imageViewFlag = convertView.findViewById(R.id.image_view);
        TextView textViewName = convertView.findViewById(R.id.text_view_name);

        CountryItem currentItem = getItem(positon);

        if (currentItem != null) {
            imageViewFlag.setImageResource(currentItem.getFlagImage());
            textViewName.setText(currentItem.getCountryName());
        }

        return convertView;
    }
}
