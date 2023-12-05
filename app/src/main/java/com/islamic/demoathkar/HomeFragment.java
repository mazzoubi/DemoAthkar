package com.islamic.demoathkar;
import static android.content.Context.ALARM_SERVICE;
import static com.islamic.demoathkar.MainActivity.count;
import static com.islamic.demoathkar.MainActivity.editor;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Vibrator;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;
import com.islamic.demoathkar.alarm.MessageAlarmReceiver;
import com.islamic.demoathkar.alarm.RoundFloatAlarmReceiver;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;


public class HomeFragment extends Fragment {

    LinearLayout progressLay;
    LottieAnimationView refresh_anim;
    ProgressBar progressBar;
    CardView card_video,floatingActionButton;
    RelativeLayout layTasbih,morning_surah,night_dua,subhanallah,alhamdulillah,allah_akbar;


    RelativeLayout mv_off,mv_3,mv_10,mv_20;


    TextView tv_date,tv_Day,tv_month,dummy;
    TextClock textClock;
    int i = 0;

    private String status[]= {
            "لآ اِلَهَ اِلّا اللّهُ مُحَمَّدٌ رَسُوُل اللّهِ",
            "اشْهَدُ انْ لّآ اِلهَ اِلَّا اللّهُ وَحْدَه لَا شَرِيْكَ لَه، وَ اَشْهَدُ اَنَّ مُحَمَّدً اعَبْدُهوَرَسُولُه",
            "سُبْحَان الِلّه وَ الْحَمْدُ   لِلّهِ وَ لآ اِلهَ اِلّا اللّهُ، وَ اللّهُ اَكْبَرُ وَلا حَوْلَ وَلاَ قُوَّةَ  اِلَّا بِاللّهِ الْعَلِىّ الْعَظِيْم",
            "لا الهَ اِلَّا اللّهُ وَحْدَهُ لا شَرِيْكَ لَهْ، لَهُ الْمُلْكُ وَ لَهُ الْحَمْدُ يُحْى وَ يُمِيْتُ وَ هُوَحَىُّ لَّا يَمُوْتُ اَبَدًا اَبَدًا ط ذُو الْجَلَالِ وَ الْاِكْرَامِ ط بِيَدِهِ الْخَيْرُ ط وَهُوَ عَلى كُلِّ شَئ ٍ قَدِيْرٌ ط",
            "اسْتَغْفِرُ اللّهَ رَبِّىْ مِنْ كُلِّ ذَنْبٍ اَذْنَبْتُه عَمَدًا اَوْ خَطَاً سِرًّا اَوْ عَلَانِيَةً وَاَتُوْبُ اِلَيْهِ مِنْ الذَّنْبِ الَّذِىْ اَعْلَمُ وَ مِنْ الذَّنْبِ الَّذِىْ لا اَعْلَمُ اِنَّكَ اَنْتَ عَلَّامُ الغُيُوْبِ وَ سَتَّارُ الْعُيُوْبِ و َغَفَّارُ الذُّنُوْبِ وَ لا حَوْلَ وَلا قُوَّةَ اِلَّا بِاللّهِ الْعَلِىِّ العَظِيْم",
            "قُلْ هُوَ ٱللَّهُ أَحَدٌ ٱللَّهُ ٱلصَّمَدُ لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُن لَّهُۥ كُفُوًا أَحَدٌۢ",
            "إِنَّمَا الْأَعْمَالُ بِالنِّيَّاتِ وَإِنَّمَا لِكُلِّ امْرِئٍ مَا نَوَى فَمَنْ كَانَتْ هِجْرَتُهُ إِلَى اللَّهِ وَرَسُولِهِ فَهِجْرَتُهُ إِلَى اللَّهِ وَرَسُولِهِ وَمَنْ كَانَتْ هِجْرَتُهُ لِدُنْيَا يُصِيبُهَا أَوِ امْرَأَةٍ يَنْكِحُهَا فَهِجْرَتُهُ إِلَى مَا هَاجَرَ إِلَيْهِ",
            "الْإِسْلَامُ أَنْ تَشْهَدَ أَنْ لَا إِلَهَ إِلَّا اللَّهُ وَأَنَّ مُحَمَّدًا رَسُولُ اللَّهِ صَلَّى اللَّهُ عَلَيْهِ وَسَلَّمَ وَتُقِيمَ الصَّلَاةَ وَتُؤْتِيَ الزَّكَاةَ وَتَصُومَ رَمَضَانَ وَتَحُجَّ الْبَيْتَ إِنْ اسْتَطَعْتَ إِلَيْهِ سَبِيلًا",
            "الْحَلَالُ بَيِّنٌ وَالْحَرَامُ بَيِّنٌ وَبَيْنَهُمَا مُشَبَّهَاتٌ لَا يَعْلَمُهَا كَثِيرٌ مِنْ النَّاسِ فَمَنْ اتَّقَى الْمُشَبَّهَاتِ اسْتَبْرَأَ لِدِينِهِ وَعِرْضِهِ وَمَنْ وَقَعَ فِي الشُّبُهَاتِ كَرَاعٍ يَرْعَى حَوْلَ الْحِمَى يُوشِكُ أَنْ يُوَاقِعَهُ أَلَا وَإِنَّ لِكُلِّ مَلِكٍ حِمًى أَلَا إِنَّ حِمَى اللَّهِ فِي أَرْضِهِ مَحَارِمُهُ أَلَا وَإِنَّ فِي الْجَسَدِ مُضْغَةً إِذَا صَلَحَتْ صَلَحَ الْجَسَدُ كُلُّهُ وَإِذَا فَسَدَتْ فَسَدَ الْجَسَدُ كُلُّهُ أَلَا وَهِيَ الْقَلْبُ",
            "اجْعَلُوا بَيْنَكُمْ وَبَيْنَ الْحَرَامِ سُتْرَةً مِنَ الْحَلالِ مَنْ فَعَلَ ذَلِكَ اسْتَبْرَأَ لِعِرْضِهِ وَدِينِهِ وَمَنْ أَرْتَعَ فِيهِ كَانَ كَالْمُرْتِعِ إِلَى جَنْبِ الْحِمَى يُوشِكُ أَنْ يَقَعَ فِيهِ وَإِنَّ لِكُلِّ مَلِكٍ حِمًى وَإِنَّ حِمَى اللَّهِ فِي الأَرْضِ مَحَارِمُهُ",
            " أُمِرْتُ أَنْ أُقَاتِلَ النَّاسَ حَتَّى يَقُولُوا لَا إِلَهَ إِلَّا اللَّهُ فَإِذَا قَالُوا لَا إِلَهَ إِلَّا اللَّهُ عَصَمُوا مِنِّي دِمَاءَهُمْ وَأَمْوَالَهُمْ إِلَّا بِحَقِّهَا وَحِسَابُهُمْ عَلَى اللَّهِ",
            "مُرَادُهُ قِتَالُ الْمُحَارِبِينَ الَّذِينَ أَذِنَ اللَّهُ فِي قِتَالِهِمْ لَمْ يُرِدْ قِتَالَ الْمُعَاهَدِينَ الَّذِينَ أَمَرَ اللَّهُ بِوَفَاءِ عَهْدِهِمْ"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View myview = inflater.inflate(R.layout.fragment_home, container, false);

       //LinearLay
        progressLay = myview.findViewById(R.id.progressLay);

        //ProgressBar
        progressBar = myview.findViewById(R.id.progressBar);

        //Lottie
        refresh_anim = myview.findViewById(R.id.refresh_anim);

        //CardView
        floatingActionButton = myview.findViewById(R.id.floatingActionButton);
        card_video = myview.findViewById(R.id.card_video);

        //RelativeLay
        morning_surah = myview.findViewById(R.id.morning_surah);
        layTasbih = myview.findViewById(R.id.layTasbih);
        night_dua = myview.findViewById(R.id.night_dua);

        subhanallah = myview.findViewById(R.id.subhanallah);
        alhamdulillah = myview.findViewById(R.id.alhamdulillah);
        allah_akbar = myview.findViewById(R.id.allah_akbar);

        //TextView
        tv_date = myview.findViewById(R.id.tv_date);
        tv_month = myview.findViewById(R.id.tv_month);
        tv_Day = myview.findViewById(R.id.tv_Day);
        dummy = myview.findViewById(R.id.dummy);

        //TextClock
        textClock = myview.findViewById(R.id.textClock);

        //Material_Button
        mv_off = myview.findViewById(R.id.mv_off);
        mv_3 = myview.findViewById(R.id.mv_3);
        mv_10 = myview.findViewById(R.id.mv_10);
        mv_20 = myview.findViewById(R.id.mv_20);



        Date currentTime = Calendar.getInstance().getTime();
        String formatedDate = DateFormat.getDateInstance(DateFormat.FULL).format(currentTime);

        String sharedDate = MainActivity.sharedPreferences.getString("date","Friday");
        MainActivity.status = MainActivity.sharedPreferences.getBoolean("status",true);

        if (!formatedDate.equals(sharedDate)){
            MainActivity.count = 0;
            editor.putInt("count",count);
            editor.apply();
        }



        editor.putString("date",formatedDate);
        editor.apply();







        try {

            String[]splitDate = formatedDate.split(",");
            //tv_date.setText(splitDate[2]);
            tv_month.setText(splitDate[1]);
            tv_Day.setText(splitDate[0]);
            tv_date.setVisibility(View.GONE);
        }catch (Exception e){
            //tv_date.setText(formatedDate);
            //tv_date.setVisibility(View.GONE);
            //tv_month.setVisibility(View.GONE);
            //tv_Day.setVisibility(View.GONE);
        }

        textClock.setTextColor(Color.parseColor("#094D92"));



        int btnId = MainActivity.sharedPreferences.getInt("button",100);
        MainActivity.count = MainActivity.sharedPreferences.getInt("count",100);


        Toast.makeText(getActivity(), "اليوم العد "+MainActivity.count, Toast.LENGTH_SHORT).show();


        long triggerTime = System.currentTimeMillis()+(500*1000);

        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(getActivity(), MessageAlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(),430,intent,PendingIntent.FLAG_UPDATE_CURRENT);








        if (btnId ==1){
            mv_off.setBackground(getResources().getDrawable(R.drawable.btn_controlleer_background));
            mv_3.setBackgroundColor(Color.TRANSPARENT);
            mv_10.setBackgroundColor(Color.TRANSPARENT);
            mv_20.setBackgroundColor(Color.TRANSPARENT);


        }else if (btnId == 2){
            mv_3.setBackground(getResources().getDrawable(R.drawable.btn_controlleer_background));
            mv_off.setBackgroundColor(Color.TRANSPARENT);
            mv_10.setBackgroundColor(Color.TRANSPARENT);
            mv_20.setBackgroundColor(Color.TRANSPARENT);

            if (MainActivity.count < 4){

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);
                        }else {
                            alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);

                        }



            }


        }else if (btnId == 3){

            mv_10.setBackground(getResources().getDrawable(R.drawable.btn_controlleer_background));
            mv_off.setBackgroundColor(Color.TRANSPARENT);
            mv_3.setBackgroundColor(Color.TRANSPARENT);
            mv_20.setBackgroundColor(Color.TRANSPARENT);


            if (MainActivity.count < 8){

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);
                }else {
                    alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);

                }


            }


        }else if (btnId == 4){
            mv_20.setBackground(getResources().getDrawable(R.drawable.btn_controlleer_background));
            mv_off.setBackgroundColor(Color.TRANSPARENT);
            mv_3.setBackgroundColor(Color.TRANSPARENT);
            mv_10.setBackgroundColor(Color.TRANSPARENT);

            if (MainActivity.count < 20){

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);
                }else {
                    alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pendingIntent);

                }
            }



        }






        mv_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mv_off.setBackground(getResources().getDrawable(R.drawable.btn_controlleer_background));
                mv_3.setBackgroundColor(Color.TRANSPARENT);
                mv_10.setBackgroundColor(Color.TRANSPARENT);
                mv_20.setBackgroundColor(Color.TRANSPARENT);

                MainActivity.status = false;
                editor.putBoolean("status", MainActivity.status);
                editor.putInt("button",1);
                editor.apply();





            }
        });

        mv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mv_3.setBackground(getResources().getDrawable(R.drawable.btn_controlleer_background));
                mv_off.setBackgroundColor(Color.TRANSPARENT);
                mv_10.setBackgroundColor(Color.TRANSPARENT);
                mv_20.setBackgroundColor(Color.TRANSPARENT);


                MainActivity.status = true;
                editor.putBoolean("status", MainActivity.status);
                editor.putInt("button",2);
                editor.apply();




            }
        });


        mv_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mv_10.setBackground(getResources().getDrawable(R.drawable.btn_controlleer_background));
                mv_off.setBackgroundColor(Color.TRANSPARENT);
                mv_3.setBackgroundColor(Color.TRANSPARENT);
                mv_20.setBackgroundColor(Color.TRANSPARENT);

                MainActivity.status = true;
                editor.putBoolean("status", MainActivity.status);
                editor.putInt("button",3);
                editor.apply();



            }
        });

        mv_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mv_20.setBackground(getResources().getDrawable(R.drawable.btn_controlleer_background));
                mv_off.setBackgroundColor(Color.TRANSPARENT);
                mv_3.setBackgroundColor(Color.TRANSPARENT);
                mv_10.setBackgroundColor(Color.TRANSPARENT);

                MainActivity.status = true;
                editor.putBoolean("status", MainActivity.status);
                editor.putInt("button",4);
                editor.apply();


            }
        });











        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                refresh_anim.playAnimation();
                int random = new Random().nextInt((9-1)+1)+1;
                dummy.setText(status[random]);
            }
        });



        morning_surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Surah.myTopic = "morning_dua";
                startActivity(new Intent(getActivity(),Surah.class));
            }
        });


        night_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Surah.myTopic = "night_dua";
                startActivity(new Intent(getActivity(),Surah.class));
            }
        });








        layTasbih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getActivity(),Tasbih.class));

            }
        });



        card_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), AlarmSeter.class));
            }
        });




        PushDownAnim.setPushDownAnimTo(subhanallah)
                .setOnClickListener(view -> {
                    i = i+10;
                    progressBar.setProgress(i);

                    Vibrator vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);

                    if (i>=100){
                        progressBar.setProgress(0);
                        i=0;
                        Toast.makeText(getActivity(), "Progress Full", Toast.LENGTH_SHORT).show();

                    }

                });

        PushDownAnim.setPushDownAnimTo(alhamdulillah)
                .setOnClickListener(view -> {
                    i = i+10;
                    progressBar.setProgress(i);

                    Vibrator vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);

                    if (i>=100){
                        progressBar.setProgress(0);
                        i=0;
                        Toast.makeText(getActivity(), "Progress Full", Toast.LENGTH_SHORT).show();

                    }

                });

        PushDownAnim.setPushDownAnimTo(allah_akbar)
                .setOnClickListener(view -> {
                    i = i+10;
                    progressBar.setProgress(i);

                    Vibrator vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vibe.vibrate(100);

                    if (i>=100){
                        progressBar.setProgress(0);
                        i=0;
                        Toast.makeText(getActivity(), "Progress Full", Toast.LENGTH_SHORT).show();

                    }

                });







        return myview;
    }






}