package com.example.sunilm.weatherapp;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sunilm on 1/29/2018.
 */

 public  class WeatherAdapter extends ArrayAdapter<HourlyWeather>{
    Context context;
    int resource;
ArrayList<HourlyWeather> hourlyWeathers;

    public WeatherAdapter(HourlyUpdatesDispalyActivity context,int resource, ArrayList<HourlyWeather> hourlyWeathers) {
        super(context, R.layout.adapterlayout_123,hourlyWeathers);
        this.context = context;
        this.resource = resource;
        this.hourlyWeathers = hourlyWeathers;
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView ==null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.time = (TextView) convertView.findViewById(R.id.adapter_temperature);
            viewHolder.temperature =(TextView) convertView.findViewById(R.id.Adapter_time);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView2);

            convertView.setTag(viewHolder);

        }
        HourlyWeather h =  hourlyWeathers.get(position);

        viewHolder= (ViewHolder) convertView.getTag();
      ImageView imageView = viewHolder.imageView;
        TextView time = viewHolder.time;
        TextView temperature =viewHolder.temperature;
        imageView.setVisibility(View.VISIBLE);
        Picasso.with(context).load(h.getIconUrl()).into(imageView);
        time.setText(h.getTime());
        temperature.setText(h.getTemperature()+"\u2109");

        return convertView;
    }
    static class ViewHolder
    {
TextView time;
        TextView temperature;
        ImageView imageView;
    }
}
