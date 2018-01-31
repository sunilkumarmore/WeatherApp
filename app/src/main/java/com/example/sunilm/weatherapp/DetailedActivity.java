package com.example.sunilm.weatherapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getIntent().getExtras()!=null)
        {
            HourlyWeather hourlyWeather =  getIntent().getExtras().getParcelable("deatiledInformation");

            Picasso.with(this).load(hourlyWeather.getIconUrl()).into((ImageView) findViewById(R.id.Detailed_image));
            TextView currentLocation = (TextView) findViewById(R.id.Detailedactivity_currentlocation);
          String  currentLocationString =
                    getIntent().getExtras().getString("currentCityState");
            if(currentLocationString!=null
                    ) {
                currentLocation.append(currentLocationString);
            }
            TextView cloudcover = (TextView) findViewById(R.id.Da_Cloud);
            cloudcover.append(hourlyWeather.getClimateType());

            TextView Da_temp=  (TextView) findViewById(R.id.Da_temp);
            Da_temp.append(hourlyWeather.getTemperature()+"\u2109");
            TextView Da_winds= (TextView) findViewById(R.id.Da_winds);
            Da_winds.append(hourlyWeather.getWindSpeed()+" mph,"+hourlyWeather.getWindDirection());
            TextView dewpoint=  (TextView)findViewById(R.id.Dewpoint);
            dewpoint.append(hourlyWeather.getDewpoint()+" Fahrenheit");
            TextView Humidity=  (TextView)findViewById(R.id.Humidity);
            Humidity.append(hourlyWeather.getHumidity()+"%");
            TextView Feels_like=  (TextView)findViewById(R.id.Feels_like);
            Feels_like.append(hourlyWeather.getHumidity() +"\u2109" );
            TextView max_tem=  (TextView)findViewById(R.id.max_tem);
            max_tem.append(hourlyWeather.getTemperature()+"\u2109");
            TextView min_temperature= (TextView) findViewById(R.id.min_temperature);
            min_temperature.append(hourlyWeather.getTemperature()+"\u2109");
            TextView Da_clouds= (TextView) findViewById(R.id.Da_clouds);
            Da_clouds.append(hourlyWeather.getClouds());

            TextView pressure= (TextView) findViewById(R.id.pressure);
            pressure.append(hourlyWeather.getPressure()+"hpa");



        }




    }

}
