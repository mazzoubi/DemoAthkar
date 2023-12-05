package com.islamic.demoathkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends YouTubeBaseActivity {

    public static YouTubePlayerView youTubePlayerView;
    public static String title = "";
    public static TextView titleText;
    public static RelativeLayout LayPlayer,titleLay;
    public static ProgressBar progressBar2;
    RecyclerView recyclerView;
    LinearLayout shimmerLay;

    ArrayList<HashMap<String,String>> arrayList;
    HashMap<String,String> hashMap;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        youTubePlayerView = findViewById(R.id.ytPlayer);
        progressBar2 = findViewById(R.id.progressBar2);
        recyclerView = findViewById(R.id.recyclerView);
        titleText = findViewById(R.id.titleText);
        titleLay = findViewById(R.id.titleLay);
        LayPlayer = findViewById(R.id.LayPlayer);
        shimmerLay = findViewById(R.id.shimmerLay);
        arrayList = new ArrayList<>();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmerLay.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

            }
        },2000);


        if (title.equals("Mustafa Hosny")){
            mustafa();
        }else if (title.equals("Zakir Naik")){
            zakir();
        }else if (title.equals("Dr Mohammed Al-Arefe")){
            arefe();
        }







        MyAdapter myAdapter = new MyAdapter(Player.this,arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(Player.this));
        recyclerView.setAdapter(myAdapter);





    }

    private void arefe() {

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=a0SIQ1GAwTU");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=EJv7A6ndXCQ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=Nt8gBl9yUQk");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=m52W8PlPoOU");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=mvPVQR8Py58");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=a_XPSm4ZVkE");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=2IqBA7O0RR0");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=I05wl0FqDHA");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=a0SIQ1GAwTU");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=HN1rsbkjWFI");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=cRKO0ypf6kY");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=HcAyocHtc2Y");
        arrayList.add(hashMap);


    }


    private void mustafa(){
        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=A7c4hlOCuWE");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=_qfZFO97ddc");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=I_F5tisPfHM");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=IhBoJURJImg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=hwsWFqaymLo");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=h2SFBDwzFps");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=KkXlMfEOwKw");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=mPe6PhF_tlo");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=nNfaTA82N_8");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=oCkRZOclpRA");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=Oalxmw7vW6Y");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=uabIgYHe_xs");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=M1ngYtApxHs");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=R7p5fPq7DkE");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=dAu6S-4LxY4");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=lixSQ3t4XJ4");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=DZbWVWhbhfw");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=j6HApQ6YlDg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=Pn1pKE0pEws");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=-ZWVmfSS5CE");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=33x4YTVQEYA");
        arrayList.add(hashMap);



    }

    private void zakir(){
        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=fcSggtOr96U");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=rvcwsd3fLR8");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=7vxd_7qcUxo");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=ZzXTzD03ScA");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=mNdLTCa5-Os");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=KSwcfJhDwxg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=RT08TJfJ4P0");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=2VTQqGt-60k");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=i8slYqiua68");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=--VS6nKZjqE");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=7QvXhLZkpKo");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=Z2ZLZ2LCz4E");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=RjaIpQqK084");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=_bXnT3qN768");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=P_M_OYpMuR0");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=oc5bk2xFhio");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=bdLNKnqJu8Q");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=B6HCMlFOFao");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=tvRc6FsyTt0");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=K-aJBUq1J3c");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=5Y1r2kLDodg");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=q2BnJNZ02lQ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=cm3cgmJbv-M");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=x3MP2Kw7HoM");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("link","https://www.youtube.com/watch?v=0Ar56NH52pc");
        arrayList.add(hashMap);


    }


}