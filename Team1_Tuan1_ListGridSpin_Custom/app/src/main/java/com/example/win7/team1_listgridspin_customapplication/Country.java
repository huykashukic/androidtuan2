package com.example.win7.team1_listgridspin_customapplication;

import java.util.Objects;

public class Country {
    private String nameCountry;
    private int img_id;

    public String getNameCountry() {
        return nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public Country(String nameCountry, int img_id) {
        this.nameCountry = nameCountry;
        this.img_id = img_id;
    }

    public Country() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(nameCountry, country.nameCountry);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nameCountry);
    }
}
