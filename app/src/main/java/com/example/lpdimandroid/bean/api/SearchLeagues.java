package com.example.lpdimandroid.bean.api;

import java.util.ArrayList;
import java.util.List;

public class SearchLeagues {
    private List<League> countrys;

    public SearchLeagues() {
        setCountrys(new ArrayList<League>());
    }

    public List<League> getCountrys() {
        return countrys;
    }

    public void setCountrys(List<League> countrys) {
        this.countrys = countrys;
    }
}
