package com.example.mapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class DisplayMessageActivity extends AppCompatActivity {

    private Context mContext;

    public DisplayMessageActivity(Context context) {
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mContext = getApplicationContext();

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        Geocoder coder = new Geocoder(this);
        List<Address> address;

        //1600 Amphitheatre Parkway, Mountain View, CA

        try {
            address = coder.getFromLocationName(message, 1);

            //if (address == null) {
                TextView textView = new TextView(this);
                textView.setTextSize(40);
                textView.setText(message);

                setContentView(textView);
            //} else {
//                Address location = address.get(0);
//                double lat = location.getLatitude();
//                double lng = location.getLongitude();
//
//                TextView textView = new TextView(this);
//                textView.setTextSize(40);
//                textView.setText(lat + "," + lng);
//
//                setContentView(textView);
//                //return lat + "," + lng;
//            }
        } catch (Exception e) {
            return;
        }
    }
}
