package com.islamic.demoathkar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thekhaeng.pushdownanim.PushDownAnim;


public class SettingsFragment extends Fragment {

    CardView morning,evening,mosque,wake_up,sleep,salat;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview = inflater.inflate(R.layout.fragment_settings, container, false);


        morning = myview.findViewById(R.id.morning);
        evening = myview.findViewById(R.id.evening);
        mosque = myview.findViewById(R.id.mosque);
        wake_up = myview.findViewById(R.id.wake_up);
        sleep = myview.findViewById(R.id.sleep);
        salat = myview.findViewById(R.id.salat);




        PushDownAnim.setPushDownAnimTo(morning)
                .setOnClickListener(view -> {
                    Surah.myTopic = "morning";
                    startActivity(new Intent(getActivity(),Surah.class));


                });


        PushDownAnim.setPushDownAnimTo(evening)
                .setOnClickListener(view -> {
                    Surah.myTopic = "evening";
                    startActivity(new Intent(getActivity(),Surah.class));
                });

        PushDownAnim.setPushDownAnimTo(mosque)
                .setOnClickListener(view -> {
                    Surah.myTopic = "mosque";
                    startActivity(new Intent(getActivity(),Surah.class));

                });

        PushDownAnim.setPushDownAnimTo(wake_up)
                .setOnClickListener(view -> {
                    Surah.myTopic = "wake_up";
                    startActivity(new Intent(getActivity(),Surah.class));


                });

        PushDownAnim.setPushDownAnimTo(sleep)
                .setOnClickListener(view -> {
                    Surah.myTopic = "sleep";
                    startActivity(new Intent(getActivity(),Surah.class));


                });

        PushDownAnim.setPushDownAnimTo(salat)
                .setOnClickListener(view -> {
                    Surah.myTopic = "salat";
                    startActivity(new Intent(getActivity(),Surah.class));

                });









        return myview;
    }
}