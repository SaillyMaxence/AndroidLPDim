package com.example.lpdimandroid.bean.api;


import java.util.ArrayList;
import java.util.List;


public class ClubByLeague {

    private List<Club> clubs;

    public ClubByLeague() { setClubs(new ArrayList<Club>());}

    public List<Club> getClubs() {return clubs;}

    public void setClubs(List<Club> clubs) {
        this.clubs = clubs;
    }

}
