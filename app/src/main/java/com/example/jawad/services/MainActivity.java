package com.example.jawad.services;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent = new Intent(this,BackgroundService.class);
//        startService(intent);
        if (!foregroundServiceRunning()) {
            Intent intent = new Intent(this, ForgroundService.class);
            startForegroundService(intent);

        }
    }

    public boolean foregroundServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (ForgroundService.class.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

}