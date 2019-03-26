package com.example.lpdimandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.lpdimandroid.bean.api.Club;
import com.example.lpdimandroid.bean.api.ClubByLeague;
import com.example.lpdimandroid.bean.api.League;
import com.example.lpdimandroid.bean.api.SearchLeagues;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class club extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent myIntent = getIntent();
        String nomChampionnat = myIntent.getStringExtra("leagueName");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        OkHttpClient client = new OkHttpClient();
        LinearLayout myLayout = findViewById(R.id.clubs);
        final Request request = new Request.Builder()
                .url("https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l="+nomChampionnat)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Impossible de recuperer les clubs", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Gson gson = new Gson();
                final String r = response.body().string();
                final ClubByLeague clubs = gson.fromJson(r, ClubByLeague.class);


                for (final Club club : clubs.getTeams()) {
                    final String idTeam = club.getIdTeam();

                        Button myButton = new Button(club.this);
                        myButton.setText(club.getStrTeam());
                        myButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(club.this,ClubInformation.class);
                                i.putExtra("clubId",club.getIdTeam());
                                startActivity(i);
                            }
                        });

                        club.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myLayout.addView(myButton);
                            }
                        });

                }

            }
        });
    }


}
