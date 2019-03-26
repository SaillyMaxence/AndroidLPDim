package com.example.lpdimandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lpdimandroid.bean.api.Club;
import com.example.lpdimandroid.bean.api.ClubById;
import com.example.lpdimandroid.bean.api.ClubByLeague;
import com.example.lpdimandroid.bean.api.League;
import com.example.lpdimandroid.bean.api.SearchLeagues;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

public class ClubInformations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent myIntent = getIntent();
        String clubId = myIntent.getStringExtra("clubId");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_informations);

        final Request request = new Request.Builder()
                .url("https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=133604"+clubId)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Impossible de recuperer les leagues", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Gson gson = new Gson();
                final String r = response.body().string();
                final ClubById clubs = gson.fromJson(r, ClubById.class);


                for (final Club club : clubs.getTeams()) {
                    final String idTeam = club.getIdTeam();

                    TextView nomClub = new TextView(club.this);
                    nomClub.setText(club.getStrTeam());

                }

            }
        });

    }
}
