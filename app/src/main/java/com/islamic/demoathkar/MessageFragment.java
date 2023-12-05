package com.islamic.demoathkar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;


public class MessageFragment extends Fragment {


    GridView gridView;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList= new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView =  inflater.inflate(R.layout.fragment_message, container, false);

        gridView = myView.findViewById(R.id.gridView);
        myTable();







        MyVideoAdapter myVideoAdapter = new MyVideoAdapter();
        gridView.setAdapter(myVideoAdapter);

        return myView;
    }


    public class MyVideoAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater) viewGroup.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v =inflater.inflate(R.layout.grid_item,viewGroup,false);

            CircleImageView profile_image = v.findViewById(R.id.profile_image);
            TextView titleVideoText = v.findViewById(R.id.titleVideoText);
            CardView itemCardVid = v.findViewById(R.id.itemCardVid);

            titleVideoText.setText(arrayList.get(i).get("titleText"));
            profile_image.setImageResource(Integer.parseInt(arrayList.get(i).get("image")));





            itemCardVid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String title = arrayList.get(i).get("titleText");
                    Player.title = title;
                    startActivity(new Intent(viewGroup.getContext(),Player.class));

                }
            });













            return v;
        }
    }

    private void myTable(){
        arrayList = new ArrayList<>();

        hashMap=new HashMap<>();
        hashMap.put("titleText","Mustafa Hosny");
        hashMap.put("image",String.valueOf(R.drawable.mustafa));
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("titleText","Zakir Naik");
        hashMap.put("image",String.valueOf(R.drawable.zakir_naik));
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("titleText","Dr Mohammed Al-Arefe");
        hashMap.put("image",String.valueOf(R.drawable.arefe));
        arrayList.add(hashMap);







    }


}