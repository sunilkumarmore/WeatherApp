package com.example.sunilm.weatherapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by sunilm on 1/26/2018.
 */

public class WeatherUtil {
   // InputStream in;
static public class  JsoonParserClasee {

      static public ArrayList<HourlyWeather> xyz(String in) throws JSONException {
           ArrayList<HourlyWeather> returnList = new ArrayList<>();
//JSONArray jsonArray = new JSONArray();
           JSONObject root = new JSONObject(in);
           // JSONObject xyz = new JSONObject("hourly_forecast");
           JSONArray arr = root.getJSONArray("hourly_forecast");

           for (int i = 0; i < arr.length() - 1; i++) {
               JSONObject v = arr.getJSONObject(i);

               HourlyWeather hourlyWeather = new HourlyWeather();
               hourlyWeather.setTime(v.getJSONObject("FCTTIME").getString("civil"));
               hourlyWeather.setTemperature(v.getJSONObject("temp").getString("english"));
               hourlyWeather.setDewpoint(v.getJSONObject("dewpoint").getString("english"));
               hourlyWeather.setClouds(v.getString("condition"));
               hourlyWeather.setIconUrl(v.getString("icon_url"));
               hourlyWeather.setWindSpeed(v.getJSONObject("wspd").getString("english"));
               //degrees
               hourlyWeather.setWindDirection(v.getJSONObject("wdir").getString("degrees")+ "\u2109" +v.getJSONObject("wdir").getString("dir"));
               hourlyWeather.setClimateType(v.getString("wx"));
               hourlyWeather.setHumidity(v.getString("humidity"));
               hourlyWeather.setFeelsLike(v.getJSONObject("feelslike").getString("english"));
               hourlyWeather.setPressure( v.getJSONObject("mslp").getString("metric"));
           //v.getJSONObject("mslp").getString("english");
               // hourlyWeather.setTime(v.getString("temp"));

               returnList.add(hourlyWeather);


           }
           return returnList;
       }
   }





}
