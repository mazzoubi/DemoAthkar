package com.islamic.demoathkar.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import com.islamic.demoathkar.FloatingService;
import com.islamic.demoathkar.MainActivity;
import com.islamic.demoathkar.RoundFloatingService;

public class RoundFloatAlarmReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

                //context.startService(new Intent(context, RoundFloatingService.class));
                context.startService(new Intent(context, FloatingService.class));


    }
}
