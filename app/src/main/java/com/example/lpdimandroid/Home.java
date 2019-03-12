package com.example.lpdimandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

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

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        OkHttpClient client = new OkHttpClient();
        LinearLayout myLayout = findViewById(R.id.leagues);
        final Request request = new Request.Builder()
                .url("https://www.thesportsdb.com/api/v1/json/1/search_all_leagues.php?s=Soccer")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Impossible de recuperer les leagues");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Gson gson = new Gson();
                final Reader r = response.body().charStream();
                final SearchLeagues leagues = gson.fromJson(r, SearchLeagues.class);


                for (final League league : leagues.getCountrys()) {
                    final String idLeague = league.getIdLeague();
                    if (league.getStrDivision().equals("0")) {
                        Button myButton = new Button(Home.this);
                        myButton.setText(league.getStrLeague());

                        Home.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myLayout.addView(myButton);
                            }
                        });
                    }
                }

            }
        });
    }
}
