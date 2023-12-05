package com.islamic.demoathkar;
import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.islamic.demoathkar.alarm.MessageAlarmReceiver;
import com.islamic.demoathkar.alarm.RoundFloatAlarmReceiver;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    HomeFragment homeFragment = new HomeFragment();
    MessageFragment messageFragment = new MessageFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    ProfileFragment profileFragment = new ProfileFragment();


    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;


    public static int count ;
    public static boolean status;
    public static  int classCount;
    public static  int roundCount;

    public static String text[]={
            "سبحان الله",
            "الحمد لله",
            "الله اكبر",
            "استغفرالله",
            "الحمد لله",
            "سبحان الله"

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottomNav);
        bottomNav.setItemIconTintList(null);



        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();


        permission();


        try {
            if (AlarmReceiver.MP != null) {
                if (AlarmReceiver.MP.isPlaying())
                    AlarmReceiver.MP.stop();
                AlarmReceiver.MP.release();
                AlarmReceiver.MP  = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            if (MessageAlarmReceiver.MEDIA != null) {
                if (MessageAlarmReceiver.MEDIA.isPlaying())
                    MessageAlarmReceiver.MEDIA.stop();
                MessageAlarmReceiver.MEDIA.release();
                MessageAlarmReceiver.MEDIA  = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();


        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,homeFragment).commit();
                        return true;

                    case R.id.quran:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,settingsFragment).commit();
                        startService(new Intent(MainActivity.this, FloatingService.class));
                        return true;

                    case R.id.alarm:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,messageFragment).commit();
                        return true;


                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,profileFragment).commit();
                        return true;

                }



                return false;
            }
        });





//        long triggerTime = System.currentTimeMillis()+(10*1000);
//
//
//        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//        Intent intent = new Intent(MainActivity.this, RoundFloatAlarmReceiver.class);
//
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,500,intent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);
//        }else {
//            alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);
//
//        }


    }




    private void permission(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 0);
            }
        }

/**
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String packageName = getApplicationContext().getPackageName();
            PowerManager pm = (PowerManager) getApplicationContext().getSystemService(Context.POWER_SERVICE);
            if (!pm.isIgnoringBatteryOptimizations(packageName)) {
                Intent intent = new Intent();
                intent.setAction(android.provider.Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
                intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                intent.setData(Uri.parse("package:" + packageName));
                startActivity(intent);
            }
        }

      **/

    }





}