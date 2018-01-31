package com.example.sunilm.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.sunilm.weatherapp.MainActivity.SendDataToIntent;

public class HourlyUpdatesDispalyActivity extends Activity {
    ArrayList<HourlyWeather> hourlyWeathers;
    String currentLocationString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_hourly_updates_dispaly);

      hourlyWeathers = getIntent().getExtras().getParcelableArrayList(SendDataToIntent);
        ListView listView = findViewById(R.id.listView);
        TextView currentLocation = findViewById(R.id.currentLocation);

        currentLocationString ="Current Location : " +
                getIntent().getExtras().getString("currentCityState");
        if(currentLocationString!=null) {
            currentLocation.setText(currentLocationString);
        }
        WeatherAdapter weatherAdapter = new WeatherAdapter(this,R.layout.adapterlayout_123, hourlyWeathers);
        listView.setAdapter(weatherAdapter);
        weatherAdapter.setNotifyOnChange(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("demo","view clicked"+i);

                Intent intent =new Intent(HourlyUpdatesDispalyActivity.this,DetailedActivity.class);
                intent.putExtra("deatiledInformation", hourlyWeathers.get(i));
               intent.putExtra("currentCityState",currentLocationString);

                startActivity(intent);


            }
        });



    }
}
