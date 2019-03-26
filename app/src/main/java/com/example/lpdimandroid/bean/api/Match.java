package com.example.lpdimandroid.bean.api;

public class Match {
    String strEvent;
    String strDate;
    String strTime;
    String strHomeTeam;
    String strAwayTeam;

    public String getStrEvent(){ return strEvent; }

    public void setStrEvent(String strEvent){ this.strEvent = strEvent ;}

    public String getStrDate() {
        return strDate;
    }

    public void setStrDate(String strDate) {
        this.strDate = strDate;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getStrHomeTeam() {
        return strHomeTeam;
    }

    public void setStrHomeTeam(String strHomeTeam) {
        this.strHomeTeam = strHomeTeam;
    }

    public String getStrAwayTeam() {
        return strAwayTeam;
    }

    public void setStrAwayTeam(String strAwayTeam) {
        this.strAwayTeam = strAwayTeam;
    }
}
