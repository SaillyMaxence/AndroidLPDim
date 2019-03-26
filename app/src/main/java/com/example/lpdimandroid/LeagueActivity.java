package com.example.lpdimandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LeagueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

        Button club = findViewById(R.id.club);

        club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // club de la league
            }
        });

        Button dayMatch = findViewById(R.id.dayMatch);
        dayMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Afficher les match du jour
            }
        });

    }
}
