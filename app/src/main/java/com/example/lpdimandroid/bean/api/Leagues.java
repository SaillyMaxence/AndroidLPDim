package com.example.lpdimandroid.bean.api;

import java.util.ArrayList;
import java.util.List;

public class Leagues {
    private List<League> leagues;

    public Leagues() {
        setLeagues(new ArrayList<League>());
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }
}
