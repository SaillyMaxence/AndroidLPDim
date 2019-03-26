package com.example.lpdimandroid;

import android.content.Intent;
import android.service.autofill.FieldClassification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lpdimandroid.bean.api.Match;
import com.example.lpdimandroid.bean.api.SearchMatch;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class dayMatch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_match);

        Intent myIntent = getIntent();
      //  int leagueId = Integer.parseInt(myIntent.getStringExtra("leagueId"));
        String leagueName = myIntent.getStringExtra("leagueName");
        OkHttpClient client = new OkHttpClient();
        LinearLayout myLayout = findViewById(R.id.matchOfTheDay);

        Date myDate = new Date();
        String myDateFormat = new SimpleDateFormat("yyyy-MM-dd").format(myDate);


        final Request request = new Request.Builder()
                .url("https://www.thesportsdb.com/api/v1/json/1/eventsday.php?d="+myDateFormat+"&s=Soccer&l="+leagueName+"")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error","Impossible de recuperer les match du jour",e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final Gson gson = new Gson();
                final String r = response.body().string();
                final SearchMatch match = gson.fromJson(r,SearchMatch.class);
                if(match.getEvents() == null){
                    TextView matchOfTheDay = new TextView(dayMatch.this);
                    matchOfTheDay.setText("Pas de match aujourd'hui");

                    dayMatch.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            myLayout.addView(matchOfTheDay);
                        }
                    });
                }else{
                    for(final Match event : match.getEvents()){
                        final String nameLeague = event.getStrEvent();

                        TextView matchOfTheDay = new TextView(dayMatch.this);
                        matchOfTheDay.setText(event.getStrEvent());


                        dayMatch.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                myLayout.addView(matchOfTheDay);
                            }
                        });

                    }
                }
            }
        });





    }
}
