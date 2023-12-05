package com.islamic.demoathkar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;


public class AlarmReceiver extends BroadcastReceiver {

   public static MediaPlayer MP;
    @Override
    public void onReceive(Context context, Intent intent) {

        MP = MediaPlayer.create(context,R.raw.azan2);
        MP.setLooping(false);
        MP.start();

        Toast.makeText(context, "SALAT ALARM", Toast.LENGTH_LONG).show();
    }


}