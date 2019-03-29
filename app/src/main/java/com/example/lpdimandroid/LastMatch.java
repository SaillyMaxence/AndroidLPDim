package com.example.lpdimandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.lpdimandroid.bean.api.LastMatchPlayed;
import com.example.lpdimandroid.bean.api.Match;
import com.example.lpdimandroid.bean.api.SearchLastMatch;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LastMatch extends AppCompatActivity {

    public static final String EXTRA_LEAGUE_ID = "EXTRA_LEAGUE_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_match);

        Intent myIntent = getIntent();
        int leagueId = myIntent.getIntExtra(LastMatch.EXTRA_LEAGUE_ID, -1);
        OkHttpClient client = new OkHttpClient();
        LinearLayout myLayout = findViewById(R.id.lastMatchesList);

        final Request request = new Request.Builder()
                .url("https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id="+leagueId)
                .build();
    client.newCall(request).enqueue(new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.e("Error","Impossible de récuperer les derniers matchs", e);

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            final Gson gson = new Gson();
            final String r = response.body().string();
            final SearchLastMatch lastMatch = gson.fromJson(r,SearchLastMatch.class);
            LinearLayout myLinearLayout = findViewById(R.id.lastMatchesList);
            for (final LastMatchPlayed event : lastMatch.getEvents()) {
                final TextView eventTV = new TextView(LastMatch.this);
                eventTV.setText(event.getStrHomeTeam()+" "+event.getIntHomeScore()+"  -  "+ event.getIntAwayScore()+" "+event.getStrAwayTeam());

                LastMatch.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myLayout.addView(eventTV);
                    }
                });


            }


        }
    });

    }
}
