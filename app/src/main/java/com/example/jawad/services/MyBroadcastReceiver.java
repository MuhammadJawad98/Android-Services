package com.example.jawad.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
if(intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
    Intent serviceIntent = new  Intent(context,ForgroundService.class);
    context.startForegroundService(serviceIntent);
}
    }
}
