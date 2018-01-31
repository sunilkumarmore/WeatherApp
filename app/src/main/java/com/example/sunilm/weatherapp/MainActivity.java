package com.example.sunilm.weatherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static com.example.sunilm.weatherapp.AyncProcess.Result_Message;

public class MainActivity extends Activity {
    ArrayList<HourlyWeather> hourlyUpdates;
    Handler handler;
    String valueinCity;
    TextView currentCity;
    String ValueInState;
    TextView currentState;
    static final String SendDataToIntent ="fromMainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          currentCity = findViewById(R.id.cityid);
          currentState = findViewById(R.id.stateId);


        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {

                if(message.what ==Result_Message)
                {
if(message.getData().containsKey("result_key"))
{
   hourlyUpdates = message.getData().getParcelableArrayList("result_key");
    Intent intent = new Intent(MainActivity.this,HourlyUpdatesDispalyActivity.class);
    intent.putExtra(SendDataToIntent,hourlyUpdates);
    intent.putExtra("currentCityState",valueinCity+","+ValueInState);
   // intent.putExtra("currentState",ValueInState);
    startActivity(intent);

}
                }
                return false;
            }
        });



        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueinCity= currentCity.getText().toString();
                ValueInState= currentState.getText().toString();
                new AyncProcess(handler).execute("s");
                Log.d("demo","button clicked"+hourlyUpdates);
            }
        });
    }
}
