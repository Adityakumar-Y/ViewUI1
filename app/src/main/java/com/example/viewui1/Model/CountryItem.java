package com.example.viewui1.Model;

public class CountryItem {
    private  String CountryName;
    private  int FlagImage;

    public CountryItem(String CountryName, int FlagImage) {
        this.CountryName = CountryName;
        this.FlagImage = FlagImage;
    }

    public String getCountryName() {
        return CountryName;
    }

    public int getFlagImage() {
        return FlagImage;
    }
}
