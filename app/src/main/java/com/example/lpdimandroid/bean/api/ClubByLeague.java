package com.example.lpdimandroid.bean.api;


import java.util.ArrayList;
import java.util.List;


public class ClubByLeague {

    private List<Club> clubs;

    public SearchClubs() {
        setClubs(new ArrayList<League>());
    }

    public List<League> getCountrys() {
        return clubs;
    }

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

}
