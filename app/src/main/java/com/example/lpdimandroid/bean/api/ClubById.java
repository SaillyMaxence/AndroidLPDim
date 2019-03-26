package com.example.lpdimandroid.bean.api;


import java.util.ArrayList;
import java.util.List;

public class ClubById {

    private List<Club> teams;

    public ClubById() { setTeams(new ArrayList<Club>());}

    public List<Club> getTeams() {
        return teams;
    }

    public void setTeams(List<Club> teams) {
        this.teams = teams;}
}
