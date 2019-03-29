package com.example.lpdimandroid.bean.api;



import java.util.ArrayList;
import java.util.List;

public class SearchLastMatch {
    private List<LastMatchPlayed> events;

    public SearchLastMatch(){
        setEvents(new ArrayList<LastMatchPlayed>());
    }
    public List<LastMatchPlayed> getEvents(){ return events;}
    public void setEvents(List<LastMatchPlayed> events){ this.events = events;}
}
