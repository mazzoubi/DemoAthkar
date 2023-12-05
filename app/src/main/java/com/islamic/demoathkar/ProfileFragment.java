package com.islamic.demoathkar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thekhaeng.pushdownanim.PushDownAnim;


public class ProfileFragment extends Fragment {

    CardView google,twitter,fb,donate;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_profile, container, false);



        google = myView.findViewById(R.id.google);
        twitter = myView.findViewById(R.id.twitter);
        fb = myView.findViewById(R.id.fb);
        donate = myView.findViewById(R.id.donate);

        PushDownAnim.setPushDownAnimTo(google)
                .setOnClickListener(view -> {

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
                    startActivity(browserIntent);


                });

        PushDownAnim.setPushDownAnimTo(twitter)
                .setOnClickListener(view -> {

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/"));
                    startActivity(browserIntent);


                });

        PushDownAnim.setPushDownAnimTo(fb)
                .setOnClickListener(view -> {

                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/"));
                    startActivity(browserIntent);


                });

        PushDownAnim.setPushDownAnimTo(donate)
                .setOnClickListener(view -> {




                });









        return myView;
    }
}