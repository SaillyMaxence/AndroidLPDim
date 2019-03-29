package com.example.lpdimandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lpdimandroid.bean.api.Player;
import com.example.lpdimandroid.bean.api.SearchPlayer;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PlayerActivity extends AppCompatActivity {

    public static final String EXTRA_CLUB_ID = "EXTRA_CLUB_ID";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Intent myIntent = getIntent();
        String clubId = myIntent.getStringExtra(PlayerActivity.EXTRA_CLUB_ID);

        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder()
                .url("https://www.thesportsdb.com/api/v1/json/1/lookup_all_players.php?id="+clubId)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error","Impossible de récuperer les joueurs",e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Gson gson = new Gson();
                final String r = response.body().string();
                final SearchPlayer players = gson.fromJson(r, SearchPlayer.class);
                LinearLayout myLayoutElement = findViewById(R.id.playerByTeam);
                for (Player p : players.getPlayer()) {
                    final TextView playerTeam = new TextView(PlayerActivity.this);
                    playerTeam.setText(p.getStrPlayer());

                    PlayerActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            myLayoutElement.addView(playerTeam);
                        }
                    });
                }

            }
        });

    }
}
