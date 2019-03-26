package com.example.lpdimandroid.bean.api;


import java.util.ArrayList;
import java.util.List;


public class ClubByLeague {

    private List<Club> teams;

    public ClubByLeague() { setTeams(new ArrayList<Club>());}

    public List<Club> getTeams() {
        return teams;
    }

    public void setTeams(List<Club> teams) {
        this.teams = teams;
    }
}
