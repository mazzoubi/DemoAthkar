package com.islamic.demoathkar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context ct;
    Activity activity = (Activity) ct;
    ArrayList<HashMap<String,String>> arrayList;

    String vdo_id = "";
    YouTubePlayer.OnInitializedListener onInitializedListener;
    YouTubePlayer tubePlayer;
    int previousPosition;

    String titleText;



    public MyAdapter(Context ct, ArrayList<HashMap<String,String>> arrayList) {
        this.ct = ct;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
       View myView = inflater.inflate(R.layout.item_player,parent,false);


        return new MyViewHolder(myView);
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String link = arrayList.get(position).get("link");

        String TitleLink = "https://www.youtube.com/oembed?url="+link+"&format=json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET,TitleLink,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        try {
                            JSONObject object = new JSONObject(response);
                            String Stitle = object.getString("title");
                            holder.title.setText(Stitle);



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(ct);
        queue.add(stringRequest);





        String video_id = "";

        if (link.contains("v=")){

            video_id = link.split("v=") [1];
        }

        Picasso.get().load("https://i.ytimg.com/vi/"+video_id+"/hqdefault.jpg").into(holder.imageView);








        holder.videoItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Player.LayPlayer.setVisibility(View.VISIBLE);
                int pos = holder.getAdapterPosition();
                previousPosition = pos;
                String mlink = arrayList.get(pos).get("link");


                String MytitleLink = "https://www.youtube.com/oembed?url="+mlink+"&format=json";

                StringRequest stringRequest = new StringRequest(Request.Method.GET,MytitleLink,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {


                                try {
                                    JSONObject object = new JSONObject(response);
                                    titleText = object.getString("title");
                                    Player.titleText.setText(titleText);



                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                RequestQueue queue = Volley.newRequestQueue(ct);
                queue.add(stringRequest);





                if (mlink.contains("v=")){
                    vdo_id = mlink.split("v=") [1];
                }

                Player.youTubePlayerView.setVisibility(View.VISIBLE);


                if(isAppInstalled("com.google.android.youtube")){
                    //init Youtube Player View

                    if(tubePlayer!=null){
                        Player.youTubePlayerView.setVisibility(View.INVISIBLE);
                        Player.progressBar2.setVisibility(View.VISIBLE);
                        tubePlayer.loadVideo(vdo_id);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Player.youTubePlayerView.setVisibility(View.VISIBLE);
                                Player.progressBar2.setVisibility(View.GONE);
                                tubePlayer.loadVideo(vdo_id);
                                tubePlayer.play();

                            }
                        },1000);


                    }else{

                        onInitializedListener = new YouTubePlayer.OnInitializedListener() {

                            @Override
                            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                                tubePlayer = youTubePlayer;
                                tubePlayer.loadVideo(vdo_id);

                            }

                            @Override
                            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                            }


                        };

                    }


                    Player.youTubePlayerView.initialize("AIzaSyC0SyoEK2dXPoUtNSx0Uq99-uMCBkY7dWk", onInitializedListener);






                }else{
                    showYoutubeInsallDialog();
                }







            }
        });





    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView title;
        ImageView imageView;
        LinearLayout linearLay,videoItem;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.itemTitle);
            imageView = itemView.findViewById(R.id.itemImage);
            linearLay = itemView.findViewById(R.id.linearLay);
            videoItem = itemView.findViewById(R.id.videoItem);



        }


    }






    protected boolean isAppInstalled(String packageName) {
        Intent mIntent = ct.getPackageManager().getLaunchIntentForPackage(packageName);
        if (mIntent != null) {
            return true;
        }
        else {
            return false;
        }
    }

    private void openStoreIntent(String app_package){
        String url="";
        Intent storeintent=null;
        try {
            url = "market://details?id="+app_package;
            storeintent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            ct.startActivity(storeintent);
        } catch ( final Exception e ) {
            url = "https://play.google.com/store/apps/details?id="+app_package;
            storeintent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            storeintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            ct.startActivity(storeintent);
        }

    }

    private void showYoutubeInsallDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(ct.getApplicationContext()).create();
        alertDialog.setTitle("Install Youtube App");
        alertDialog.setMessage(ct.getString(R.string.app_name)+" will not work if you don't have youtube official app installed on your device");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Install NOW",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.dismiss();
                        openStoreIntent("com.google.android.youtube");
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Exit App",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //Exit App
                        if(Build.VERSION.SDK_INT>=16 && Build.VERSION.SDK_INT<21){
                            ActivityCompat.finishAffinity(activity);
                        } else if(Build.VERSION.SDK_INT>=21){
                            activity.finishAndRemoveTask();
                        }

                    }
                });

        alertDialog.setCancelable(false);
        alertDialog.show();
    }





}
