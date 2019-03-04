package com.example.win7.team1_listgridspin_customapplication;

import java.util.ArrayList;

public class CountryModel {

    public static String[] name = new String[]{"Việt Nam", "Indonesia", "Laos", "Thailand"};
    public static int[] img = new int[]{R.drawable.ic_flag_vietnam, R.drawable.ic_flag_indonesia, R.drawable.ic_flag_laos, R.drawable.ic_flag_thailand};
    private static ArrayList<Country> ls = null;

    public static ArrayList<Country> getListCountriesDemo() {
        if (ls == null) {
            CountryModel countryModel = new CountryModel();
            countryModel.initCountryList();
        }
        return ls;
    }

    private void initCountryList() {
        ls = new ArrayList<Country>();
        for (int i = 0; i < name.length; i++) {
            Country c = new Country(name[i], img[i]);
            ls.add(c);
        }
    }

    public static boolean addCountry(Country c) {
        if (c != null) {
            ls.add(c);
            return true;
        }
        return false;
    }

    public static boolean removeCountry(int i) {
        ls.remove(i);
        return true;
    }

    public static ArrayList<Country> updateCountry(int i, int img) {
        Country c = ls.get(i);
        c.setImg_id(img);
        return ls;
    }

    public static ArrayList<Country> getList() {
        return ls;
    }

}
