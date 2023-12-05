package com.islamic.demoathkar.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.islamic.demoathkar.FloatingViewService;
import com.islamic.demoathkar.MainActivity;
import com.islamic.demoathkar.R;

import java.util.Random;

public class MessageAlarmReceiver extends BroadcastReceiver {

    public static MediaPlayer MEDIA;

    @Override
    public void onReceive(Context context, Intent intent) {


        Toast.makeText(context, ""+ MainActivity.classCount, Toast.LENGTH_SHORT).show();
        Random random = new Random();
        int intRandom = random.nextInt((5 - 1)+1) + 1;

        FloatingViewService.message = MainActivity.text[intRandom];

        if (FloatingViewService.message.contains("سبحان الله")){
            MEDIA = MediaPlayer.create(context, R.raw.subhan_allah);
            MEDIA.setLooping(false);
            MEDIA.start();
        }else if (FloatingViewService.message.contains("الحمد لله")){
            MEDIA = MediaPlayer.create(context, R.raw.alhamdulillah);
            MEDIA.setLooping(false);
            MEDIA.start();
        }else if (FloatingViewService.message.contains("الله اكبر")){
            MEDIA = MediaPlayer.create(context, R.raw.allahuakbar);
            MEDIA.setLooping(false);
            MEDIA.start();
        }


        context.startService(new Intent(context,FloatingViewService.class));

    }
}
