package com.example.icds;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.onesignal.OneSignal;

public class Confirmation extends AppCompatActivity {

    private static final String ONESIGNAL_APP_ID = "5a59df5d-f0b1-4854-8ab1-7039209dad27";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        setContentView(R.layout.activity_main);

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(getApplicationContext(), Notify.class);
               startActivity(intent);
           }

        },5000);
    }
}