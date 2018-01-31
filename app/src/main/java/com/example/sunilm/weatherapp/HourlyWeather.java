package com.example.sunilm.weatherapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sunilm on 1/26/2018.
 */

public class HourlyWeather implements Parcelable {

    String time;
    String temperature;
    String dewpoint;
    String clouds;
    String iconUrl;
    String windSpeed;
    String windDirection;
    String climateType;
    String humidity;
    String feelsLike;
    String pressure;

    public HourlyWeather() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDewpoint() {
        return dewpoint;
    }

    public void setDewpoint(String dewpoint) {
        this.dewpoint = dewpoint;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    @Override
    public String toString() {
        return "HourlyWeather{" +
                "time='" + time + '\'' +
                ", temperature='" + temperature + '\'' +
                ", dewpoint='" + dewpoint + '\'' +
                ", clouds='" + clouds + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", windDirection='" + windDirection + '\'' +
                ", climateType='" + climateType + '\'' +
                ", humidity='" + humidity + '\'' +
                ", feelsLike='" + feelsLike + '\'' +
                ", pressure='" + pressure + '\'' +
                '}';
    }

    public String getClimateType() {
        return climateType;
    }

    public void setClimateType(String climateType) {
        this.climateType = climateType;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
 /*     String time;
        String temperature;
        String dewpoint;
        String clouds;
        String iconUrl; String windSpeed;
        String windDirection;
        String climateType;
        String humidity;
        String feelsLike;
        String pressure;*/
        parcel.writeString(time);
        parcel.writeString(temperature);
        parcel.writeString(dewpoint);
        parcel.writeString(clouds);
        parcel.writeString(iconUrl);
        parcel.writeString(windSpeed);
        parcel.writeString(windDirection);
        parcel.writeString(climateType);
        parcel.writeString(humidity);
        parcel.writeString(feelsLike);
        parcel.writeString(pressure);




    }


    public static final Parcelable.Creator<HourlyWeather> CREATOR
            = new Parcelable.Creator<HourlyWeather>() {
        public HourlyWeather createFromParcel(Parcel in) {
            return new HourlyWeather(in);
        }

        public HourlyWeather[] newArray(int size) {
            return new HourlyWeather[size];
        }
    };

    public HourlyWeather(Parcel in) {
   /*     String time;
        String temperature;
        String dewpoint;
        String clouds;
        String iconUrl; String windSpeed;
        String windDirection;
        String climateType;
        String humidity;
        String feelsLike;
        String pressure;*/
       this.time = in.readString();
         this.temperature= in.readString();
        this.dewpoint= in.readString();
        this.clouds= in.readString();
        this.iconUrl= in.readString();
        this. windSpeed= in.readString();
        this. windDirection= in.readString();
        this. climateType= in.readString();
        this. humidity= in.readString();
        this. feelsLike= in.readString();
        this. pressure= in.readString();
    }
}
