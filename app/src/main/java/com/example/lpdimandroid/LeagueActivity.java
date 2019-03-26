package com.example.lpdimandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LeagueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        // Récupération des params
        Intent myIntent = getIntent();
        int leagueId = Integer.parseInt(myIntent.getStringExtra("leagueId"));
        String leagueName = myIntent.getStringExtra("nomChampionnat");

        Button club = findViewById(R.id.club);
        club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent club = new Intent(LeagueActivity.this,club.class);
                club.putExtra("leagueId",leagueId);
                club.putExtra("leagueName",leagueName);
                startActivity(club);
            }
        });

        Button dayMatch = findViewById(R.id.dayMatch);
        dayMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Afficher les match du jour
                Intent dayMatch = new Intent(LeagueActivity.this,dayMatch.class);
                dayMatch.putExtra("leagueId",leagueId);
                dayMatch.putExtra("leagueName",leagueName);
                startActivity(dayMatch);
            }
        });

    }
}
