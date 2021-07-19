package com.mintedtech.deviceidlookup;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SplashActivity extends AppCompatActivity
{
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate (savedInstanceState);
        AppCompatDelegate.setDefaultNightMode (Build.VERSION.SDK_INT < 28
                                               ? AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
                                               : AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        Intent intent = new Intent(getApplicationContext (), MainActivity.class);
        startActivity(intent);
        finish();
    }
}