package com.example.lpdimandroid.bean.api;

import java.util.ArrayList;
import java.util.List;

public class SearchPlayer {
    private List<Player> player;


    public SearchPlayer(){ setPlayer(new ArrayList<Player>());}


    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }
}
