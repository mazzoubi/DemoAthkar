package com.islamic.demoathkar;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;

public class AlarmSeter extends AppCompatActivity {

    Switch Fajr,Zuhr,Asr,Maghrib,Isha;


    PendingIntent FazrpendingIntent,ZuhrpendingIntent,AsrpendingIntent,MaghribpendingIntent,IshapendingIntent;
    AlarmManager alarmManager;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_seter);



        Fajr = findViewById(R.id.Fajr);
        Zuhr = findViewById(R.id.Zuhr);
        Asr =  findViewById(R.id.Asr);
        Maghrib = findViewById(R.id.Maghrib);
        Isha = findViewById(R.id.Isha);


        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


        sharedPreferences = getSharedPreferences(getString(R.string.app_name),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();



        boolean fazar = sharedPreferences.getBoolean("fazar",false);
        boolean zuhr = sharedPreferences.getBoolean("Zuhr",false);
        boolean asr = sharedPreferences.getBoolean("Asr",false);
        boolean maghrib = sharedPreferences.getBoolean("Maghrib",false);
        boolean isha = sharedPreferences.getBoolean("Isha",false);





        Fajr.setChecked(fazar);
        Zuhr.setChecked(zuhr);
        Asr.setChecked(asr);
        Maghrib.setChecked(maghrib);
        Isha.setChecked(isha);



        Intent intent = new Intent(this, AlarmReceiver.class);
        FazrpendingIntent = PendingIntent.getBroadcast(AlarmSeter.this, 0, intent, 0);
        ZuhrpendingIntent = PendingIntent.getBroadcast(AlarmSeter.this, 1, intent, 0);
        AsrpendingIntent = PendingIntent.getBroadcast(AlarmSeter.this, 2, intent, 0);
        MaghribpendingIntent = PendingIntent.getBroadcast(AlarmSeter.this, 3, intent, 0);
        IshapendingIntent = PendingIntent.getBroadcast(AlarmSeter.this, 4, intent, 0);



        fazar();
        johr();
        asr();
        maghrib();
        isha();







        Fajr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Fajr.setChecked(b);
                editor.putBoolean("fazar",b) ;
                editor.apply();

                fazar();

                if (Fajr.isChecked()){
                    Toast.makeText(AlarmSeter.this, "ALARM ON", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AlarmSeter.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                }



            }
        });




        Zuhr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Zuhr.setChecked(isChecked);
                editor.putBoolean("Zuhr",isChecked);
                editor.apply();

                johr();

                if (Zuhr.isChecked()){
                    Toast.makeText(AlarmSeter.this, "ALARM ON", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AlarmSeter.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                }




            }

        });

        Asr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Asr.setChecked(isChecked);
                editor.putBoolean("Asr",isChecked);
                editor.apply();

                asr();

                if (Asr.isChecked()){
                    Toast.makeText(AlarmSeter.this, "ALARM ON", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AlarmSeter.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                }



            }

        });

        Maghrib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Maghrib.setChecked(isChecked);
                editor.putBoolean("Maghrib",isChecked);
                editor.apply();

                maghrib();

                if (Maghrib.isChecked()){
                    Toast.makeText(AlarmSeter.this, "ALARM ON", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AlarmSeter.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                }




            }

        });

        Isha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Isha.setChecked(isChecked);
                editor.putBoolean("Isha",isChecked);
                editor.apply();

                isha();

                if (Isha.isChecked()){
                    Toast.makeText(AlarmSeter.this, "ALARM ON", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AlarmSeter.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
                }


            }

        });













    }




    public void fazar() {

        if (Fajr.isChecked()) {
            long time;
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, 05);
            calendar.set(Calendar.MINUTE, 10);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                // setting time as AM and PM
                if (Calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, FazrpendingIntent);

        } else {
            alarmManager.cancel(FazrpendingIntent);

            try {
                if (AlarmReceiver.MP != null) {
                    if (AlarmReceiver.MP .isPlaying())
                        AlarmReceiver.MP .stop();
                    AlarmReceiver.MP .release();
                    AlarmReceiver.MP  = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }

    public void johr() {
        if (Zuhr.isChecked()) {
            long time;
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, 11);
            calendar.set(Calendar.MINUTE, 45);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                // setting time as AM and PM
                if (Calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, ZuhrpendingIntent);

        } else {
            alarmManager.cancel(ZuhrpendingIntent);

            try {
                if (AlarmReceiver.MP != null) {
                    if (AlarmReceiver.MP .isPlaying())
                        AlarmReceiver.MP .stop();
                    AlarmReceiver.MP .release();
                    AlarmReceiver.MP  = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }

    public void asr() {
        if (Asr.isChecked()) {
            long time;
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, 14);
            calendar.set(Calendar.MINUTE, 30);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                // setting time as AM and PM
                if (Calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, AsrpendingIntent);

        } else {
            alarmManager.cancel(AsrpendingIntent);

            try {
                if (AlarmReceiver.MP != null) {
                    if (AlarmReceiver.MP .isPlaying())
                        AlarmReceiver.MP .stop();
                    AlarmReceiver.MP .release();
                    AlarmReceiver.MP  = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }

    public void maghrib() {
        if (Maghrib.isChecked()) {
            long time;
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, 16);
            calendar.set(Calendar.MINUTE, 50);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                // setting time as AM and PM
                if (Calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, MaghribpendingIntent);

        } else {
            alarmManager.cancel(MaghribpendingIntent);

            try {
                if (AlarmReceiver.MP != null) {
                    if (AlarmReceiver.MP .isPlaying())
                        AlarmReceiver.MP .stop();
                    AlarmReceiver.MP .release();
                    AlarmReceiver.MP  = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }

    public void isha() {
        if (Isha.isChecked()) {
            long time;
            Calendar calendar = Calendar.getInstance();

            calendar.set(Calendar.HOUR_OF_DAY, 18);
            calendar.set(Calendar.MINUTE, 15);

            time = (calendar.getTimeInMillis() - (calendar.getTimeInMillis() % 60000));
            if (System.currentTimeMillis() > time) {
                // setting time as AM and PM
                if (Calendar.AM_PM == 0)
                    time = time + (1000 * 60 * 60 * 12);
                else
                    time = time + (1000 * 60 * 60 * 24);
            }

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, IshapendingIntent);

        } else {
            alarmManager.cancel(IshapendingIntent);

            try {
                if (AlarmReceiver.MP != null) {
                    if (AlarmReceiver.MP .isPlaying())
                        AlarmReceiver.MP .stop();
                    AlarmReceiver.MP .release();
                    AlarmReceiver.MP  = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }



    }






}