package com.islamic.demoathkar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Tasbih extends AppCompatActivity {

    int count=0;
    TextView tv_tasbih;
    ImageView img_tasbihBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        tv_tasbih = findViewById(R.id.tv_tasbih);
        img_tasbihBtn = findViewById(R.id.img_tasbihBtn);




        PushDownAnim.setPushDownAnimTo(img_tasbihBtn)
        .setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick( View view ){
                count++;
                tv_tasbih.setText(Integer.toString(count));
                Vibrator vibe = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);

            }

        } );





    }
}