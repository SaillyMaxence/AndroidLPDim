package com.example.lpdimandroid.bean.api;

import java.util.ArrayList;
import java.util.List;

public class SearchMatch {
    private List<Match> events;

    public SearchMatch(){ setEvents(new ArrayList<Match>());}

    public List<Match> getEvents(){return events;}

    public void setEvents(List<Match> events) { this.events = events; }

}
