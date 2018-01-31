package com.example.sunilm.weatherapp;

import android.os.AsyncTask;
import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sunilm on 1/29/2018.
 */

public class AyncProcess extends AsyncTask<String,Integer,ArrayList<HourlyWeather>> {

    final static int Result_Message = 0x00;
    Handler handler;

    public AyncProcess(Handler handler) {
        this.handler = handler;
    }

    @Override
    protected ArrayList<HourlyWeather> doInBackground(String... strings) {

        try {
            URL url = new URL("http://api.wunderground.com/api/C63708a51c4cff8d/hourly/q/Tx/houston.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            // Log.d("demo","i did not got here");
            httpURLConnection.connect();
            int statusCode = httpURLConnection.getResponseCode();
            if(statusCode== HttpURLConnection.HTTP_OK)
            {
                 Log.d("demo","i got here");
                BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                while(line!=null)
                {
                    sb.append(line);
                    line= br.readLine();
                }
                Log.d("demo","i got string "+sb.toString());
                return WeatherUtil.JsoonParserClasee.xyz(sb.toString());
            }
            else
            {
                return null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<HourlyWeather> hourlyWeathers) {
        Log.d("demo", "onPostExecute: entered ");
        Log.d("demo", "onPostExecute: entered "+hourlyWeathers);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("result_key",hourlyWeathers);
        Message msg = new Message();
        msg.what = Result_Message;
        msg.setData(bundle);
        handler.sendMessage(msg);


        super.onPostExecute(hourlyWeathers);
    }
}
