package com.islamic.demoathkar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.thekhaeng.pushdownanim.PushDownAnim;
import java.util.ArrayList;
import java.util.HashMap;

public class Surah extends AppCompatActivity {


    ImageView back;
    ListView listViewDetail;
    HashMap<String,String> hashMap;
    ArrayList<HashMap<String,String>> arrayList= new ArrayList<>();

    public static String myTopic = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        back = findViewById(R.id.back);
        listViewDetail = findViewById(R.id.listViewDetail);


        if (myTopic.equals("morning_dua")){
            morning();
        }else if (myTopic.equals("night_dua")){
            night();
        }else if (myTopic.equals("morning")){
            morning();
           
        }else if (myTopic.equals("evening")){
            evening();
           
        }else if (myTopic.equals("mosque")){
            mosque();
           
        }else if (myTopic.equals("wake_up")){
            wake_up();
           
        }else if (myTopic.equals("sleep")){
            sleep();
           
        }else if (myTopic.equals("salat")){
            salat();
           
        }else if (myTopic.equals("")){
            morning();

        }



        back.setOnClickListener(view -> {
            Surah.super.onBackPressed();
        });





        MyDetailAdapter myDetailAdapter = new MyDetailAdapter();
        listViewDetail.setAdapter(myDetailAdapter);


    }

    private void salat() {
        arrayList = new ArrayList<>();

        hashMap=new HashMap<>();
        hashMap.put("details","وَقَالَ رَبُّكُمُ ادْعُونِي أَسْتَجِبْ لَكُمْ");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","لَا إِلَهَ إِلَّا اللهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ، وَهُوَ عَلَى كُلِّ شَيءٍ قًدِيرٌ اَللَّهُمَّ لَا مَانِعَ لِمَا أَعْطَيتَ، وَلَا مُعْطِيَ لِمَا مَنَعْتَ، وَلَا يَنْفَعُ ذَا الْجَدِّ مِنْكَ الْجَدُّ");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهُمَّ أَنْتَ السَّلاَمُ وَمِنْكَ السَّلاَمُ، تَبَارَكْتَ يَا ذَا الْجَلاَلِ وَالإِكْرَامِ");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهُـمَّ أَعِـنِّي عَلـَى ذِكْـرِكَ وَشُكْـرِكَ وَحُسْـنِ عِبَـادَتِـكَ");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","يَا مُقَلِّبَ الْقُلُوبِ ثَبِّتْ قَلْبِي عَلَى دِينِكَ");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهُمَّ إنِّي أَعُوذُ بِكَ مِن عَذَابِ جَهَنَّمَ، وَمِنْ عَذَابِ القَبْرِ، وَمِنْ فِتْنَةِ المَحْيَا وَالْمَمَاتِ، وَمِنْ شَرِّ فِتْنَةِ المَسِيحِ الدَّجَّالِ");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهُمَّ إِنِّي ظَلَمْتُ نَفْسِي ظُلْمًا كَثِيرًا وَلاَ يَغْفِرُ الذُّنُوبَ إِلاَّ أَنْتَ فَاغْفِرْ لِي مَغْفِرَةً مِنْ عِنْدِكَ وَارْحَمْنِي إِنَّكَ أَنْتَ الْغَفُورُ الرَّحِيمُ");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","رَّبِّ ارْحَمْهُمَا كَمَا رَبَّيَانِي صَغِيرًا");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","رَبَّنَآ ءَاتِنَا فِى ٱلدُّنْيَا حَسَنَةًۭ وَفِى ٱلْأخِرَةِ حَسَنَةًۭ وَقِنَا عَذَابَ ٱلنَّارِ");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","رَبَّنَا آتِنَا فِي الدُّنْيَا حَسَنَةً وَفِي الآخِرَةِ حَسَنَةً وَقِنَا عَذَابَ النَّارِ");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","رَبَّنَا اغْفِرْ لِي وَلِوَالِدَيَّ وَلِلْمُؤْمِنِينَ يَوْمَ يَقُومُ الْحِسَابُ");
        arrayList.add(hashMap);



    }

    private void sleep() {

        arrayList = new ArrayList<>();

        hashMap=new HashMap<>();
        hashMap.put("details","بِاسْمِكَ رَبِّي وَضَعْتُ جَنْبِي، وَبِكَ أَرْفَعُهُ، فَإِنْ أَمْسَكْتَ نَفْسِي فَارْحَمْهَا، وَإِنْ أَرْسَلْتَهَا فَاحْفَظْهَا، بِمَا تَحْفَظُ بِهِ عِبَادَكَ الصَّالِحِينَ");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهمَّ إِنَّكَ خَلَقْتَ نَفْسِي وَأَنْتَ تَوَفَّاهَا لَكَ مَمَاتُهَا وَمَحْيَاهَا، إِنْ أَحْيَيْتَهَا فَاحْفَظْهَا، وَإِنْ أَمَتَّهَا فَاغْفِرْ لَهَا. اللَّهمَّ إِنِّي أَسْأَلُكَ العَافِيَةَ.\n" +
                "\n" +
                "Al-Muslim 4:2083");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهمَّ إِنَّكَ خَلَقْتَ نَفْسِي وَأَنْتَ تَوَفَّاهَا لَكَ مَمَاتُهَا وَمَحْيَاهَا، إِنْ أَحْيَيْتَهَا فَاحْفَظْهَا، وَإِنْ أَمَتَّهَا فَاغْفِرْ لَهَا. اللَّهمَّ إِنِّي أَسْأَلُكَ العَافِيَةَ.\n" +
                "\n" +
                "Al-Muslim 4:2083");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهمَّ إِنَّكَ خَلَقْتَ نَفْسِي وَأَنْتَ تَوَفَّاهَا لَكَ مَمَاتُهَا وَمَحْيَاهَا، إِنْ أَحْيَيْتَهَا فَاحْفَظْهَا، وَإِنْ أَمَتَّهَا فَاغْفِرْ لَهَا. اللَّهمَّ إِنِّي أَسْأَلُكَ العَافِيَةَ.\n" +
                "\n" +
                "Allahumma innaka khalaqta nafsee wa-anta tawaffaha, laka mamatuha wamahyaha in ahyaytaha fahfathha, wa-in amattaha faghfir laha. Allahumma innee as-alukal-AAafiyah.\n" +
                "\n" +
                "O Allah, verily You have created my soul and You shall take its life, to You belongs its life and death. If You should keep my soul alive then protect it, and if You should take its life then forgive it. O Allah, I ask You to grant me good health.’\n" +
                "\n" +
                "Al-Muslim 4:2083");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهمَّ إِنَّكَ خَلَقْتَ نَفْسِي وَأَنْتَ تَوَفَّاهَا لَكَ مَمَاتُهَا وَمَحْيَاهَا، إِنْ أَحْيَيْتَهَا فَاحْفَظْهَا، وَإِنْ أَمَتَّهَا فَاغْفِرْ لَهَا. اللَّهمَّ إِنِّي أَسْأَلُكَ العَافِيَةَ.\n" +
                "\n" +
                "Allahumma innaka khalaqta nafsee wa-anta tawaffaha, laka mamatuha wamahyaha in ahyaytaha fahfathha, wa-in amattaha faghfir laha. Allahumma innee as-alukal-AAafiyah.\n" +
                "\n" +
                "O Allah, verily You have created my soul and You shall take its life, to You belongs its life and death. If You should keep my soul alive then protect it, and if You should take its life then forgive it. O Allah, I ask You to grant me good health.’\n" +
                "\n" +
                "Al-Muslim 4:2083\n");
        arrayList.add(hashMap);

    }

    private void wake_up() {
        arrayList = new ArrayList<>();

        hashMap=new HashMap<>();
        hashMap.put("details","اَلْحَمْدُ لِلَّهِ الَّذِي عَافَانِي فِي جَسَدِي، وَرَدَّ عَلَيَّ رُوحِي، وَأَذِنَ لِي بِذِكْرِهِ.\n" +
                "\n" +
                "Alhamdu lillahil-lathee AAafanee fee jasadee waradda AAalayya roohee wa-athina lee bithikrih.\n" +
                "\n" +
                "All praise is for Allah who restored to me my health and returned my soul and has allowed me to remember Him.\n" +
                "\n" +
                "At-Tirmidhi 5:473\n"
              );
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اَلْحَمْدُ لِلَّهِ الَّذِي عَافَانِي فِي جَسَدِي، وَرَدَّ عَلَيَّ رُوحِي، وَأَذِنَ لِي بِذِكْرِهِ.\n" +
                "\n" +
                "Alhamdu lillahil-lathee AAafanee fee jasadee waradda AAalayya roohee wa-athina lee bithikrih.\n" +
                "\n" +
                "All praise is for Allah who restored to me my health and returned my soul and has allowed me to remember Him.\n" +
                "\n" +
                "At-Tirmidhi 5:473\n");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اَلْحَمْدُ لِلَّهِ الَّذِي عَافَانِي فِي جَسَدِي، وَرَدَّ عَلَيَّ رُوحِي، وَأَذِنَ لِي بِذِكْرِهِ.\n" +
                "\n" +
                "Alhamdu lillahil-lathee AAafanee fee jasadee waradda AAalayya roohee wa-athina lee bithikrih.\n" +
                "\n" +
                "All praise is for Allah who restored to me my health and returned my soul and has allowed me to remember Him.\n" +
                "\n" +
                "At-Tirmidhi 5:473\n");
        arrayList.add(hashMap);

    }

    private void mosque() {
        arrayList = new ArrayList<>();

        hashMap=new HashMap<>();
        hashMap.put("details","أَعوذُ بِاللّهِ العَظِيـمِ، وَبِوَجْهِـهِ الكَرِيـمِ وَسُلْطـَانِه القَدِيـمِ، مِنَ الشَّيْـطَانِ الرَّجِـيمِ، [ بِسْـمِ اللّهِ وَالصَّلَاةُ ] [وَالسَّلامُ عَلَى رَسُولِ اللّهِ]، اَللَّهُـمَّ افْتَـحْ لِي أَبْوَابَ رَحْمَتـِكَ.\n" +
                "\n" +
                "aAAoothu billahil-AAatheem wabiwajhihil-kareem wasultanihil-qadeem minash-shaytanir-rajeem, [bismil-lah, wassalatu] [wassalamu AAala rasoolil-lah] , allahumma iftah lee abwaba rahmatik.\n" +
                "\n" +
                "I take refuge with Allah, The Supreme and with His Noble Face, and His eternal authority from the accursed devil. In the name of Allah, and prayers and peace be upon the Messenger of Allah. O Allah, open the gates of Your mercy for me.\n" +
                "\n" +
                "Abu Dawud: 4591\n");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللّهُـمَّ اجْعَـلْ في قَلْبـي نورا ، وَفي لِسـاني نورا، وَاجْعَـلْ في سَمْعي نورا، وَاجْعَـلْ في بَصَري نورا، وَاجْعَـلْ مِنْ خَلْفي نورا، وَمِنْ أَمامـي نورا، وَاجْعَـلْ مِنْ فَوْقـي نورا ، وَمِن تَحْتـي نورا .اللّهُـمَّ أَعْطِنـي نورا.\n" +
                "\n" +
                "Allahumma ijAAal fee qalbee noora, wafee lisanee noora, wajAAal fee samAAee noora,wajAAal fee basaree noora, wajAAal min khalfee noora, wamin amamee noora ,wajAAal min fawqee noora, wamin tahtee noora, allahumma aAAtinee noora.\n" +
                "\n" +
                "O Allah, place within my heart light, and upon my tongue light, and within my ears light, and within my eyes light, and place behind me light and in front of me light and above me light and beneath me light. O Allah, bestow upon me light.\n" +
                "\n" +
                "Muslim: 1:526,529-530, Al-Bukhari 11:116\n");
        arrayList.add(hashMap);


    }

    private void evening() {
        arrayList = new ArrayList<>();

        hashMap=new HashMap<>();
        hashMap.put("details","اَمْسَيْنَا وَاَمْسَ الْمُلْكُ لِلَّهِ وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِيْ هَذَا اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوْذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا اللَّيْلَةِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوْذُ بِكَ مِنَ الْكَسَلِ، وَسُوءِ الْكِبَرِ، رَبِّ أَعُوْذُ بِكَ مِنْ عَذَابٍ فِيْ النَّارِ وَعَذَابٍ فِيْ الْقَبْرِ.\n" +
                "\n" +
                "Amsayna wa-amsal-mulku lillah walhamdu lillah la ilaha illal-lah, wahdahu la shareeka lah, lahul-mulku walahul-hamd, wahuwa AAala kulli shayin qadeer, rabbi as-aluka khayra ma fee hathihil-laylah, wakhayra ma baAAdaha, wa-aAAoothu bika min sharri hathihil-laylah, washarri ma baAAdaha, rabbi aAAoothu bika minal-kasal, wasoo-il kibar, rabbi aAAoothu bika min AAathabin fin-nar, waAAathabin fil-qabr.\n" +
                "\n" +
                "We have reached the evening and at this very time unto Allah belongs all sovereignty, and all praise is for Allah. None has the right to be worshipped except Allah, alone, without partner, to Him belongs all sovereignty and praise and He is over all things omnipotent. My Lord, I ask You for the good of this night and the good of what follows it and I take refuge in You from the evil of this night and the evil of what follows it. My Lord, I take refuge in You from laziness and senility. My Lord, I take refuge in You from torment in the Fire and punishment in the grave.\n" +
                "\n" +
                "Muslim 4:2088\n");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اَمْسَيْنَا وَاَمْسَ الْمُلْكُ لِلَّهِ وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِيْ هَذَا اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوْذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا اللَّيْلَةِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوْذُ بِكَ مِنَ الْكَسَلِ، وَسُوءِ الْكِبَرِ، رَبِّ أَعُوْذُ بِكَ مِنْ عَذَابٍ فِيْ النَّارِ وَعَذَابٍ فِيْ الْقَبْرِ.\n" +
                "\n" +
                "Amsayna wa-amsal-mulku lillah walhamdu lillah la ilaha illal-lah, wahdahu la shareeka lah, lahul-mulku walahul-hamd, wahuwa AAala kulli shayin qadeer, rabbi as-aluka khayra ma fee hathihil-laylah, wakhayra ma baAAdaha, wa-aAAoothu bika min sharri hathihil-laylah, washarri ma baAAdaha, rabbi aAAoothu bika minal-kasal, wasoo-il kibar, rabbi aAAoothu bika min AAathabin fin-nar, waAAathabin fil-qabr.\n" +
                "\n" +
                "We have reached the evening and at this very time unto Allah belongs all sovereignty, and all praise is for Allah. None has the right to be worshipped except Allah, alone, without partner, to Him belongs all sovereignty and praise and He is over all things omnipotent. My Lord, I ask You for the good of this night and the good of what follows it and I take refuge in You from the evil of this night and the evil of what follows it. My Lord, I take refuge in You from laziness and senility. My Lord, I take refuge in You from torment in the Fire and punishment in the grave.\n" +
                "\n" +
                "Muslim 4:2088\n");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","اَمْسَيْنَا وَاَمْسَ الْمُلْكُ لِلَّهِ وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِيْ هَذَا اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوْذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا اللَّيْلَةِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوْذُ بِكَ مِنَ الْكَسَلِ، وَسُوءِ الْكِبَرِ، رَبِّ أَعُوْذُ بِكَ مِنْ عَذَابٍ فِيْ النَّارِ وَعَذَابٍ فِيْ الْقَبْرِ.\n" +
                "\n" +
                "Amsayna wa-amsal-mulku lillah walhamdu lillah la ilaha illal-lah, wahdahu la shareeka lah, lahul-mulku walahul-hamd, wahuwa AAala kulli shayin qadeer, rabbi as-aluka khayra ma fee hathihil-laylah, wakhayra ma baAAdaha, wa-aAAoothu bika min sharri hathihil-laylah, washarri ma baAAdaha, rabbi aAAoothu bika minal-kasal, wasoo-il kibar, rabbi aAAoothu bika min AAathabin fin-nar, waAAathabin fil-qabr.\n" +
                "\n" +
                "We have reached the evening and at this very time unto Allah belongs all sovereignty, and all praise is for Allah. None has the right to be worshipped except Allah, alone, without partner, to Him belongs all sovereignty and praise and He is over all things omnipotent. My Lord, I ask You for the good of this night and the good of what follows it and I take refuge in You from the evil of this night and the evil of what follows it. My Lord, I take refuge in You from laziness and senility. My Lord, I take refuge in You from torment in the Fire and punishment in the grave.\n" +
                "\n" +
                "Muslim 4:2088\n");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اَمْسَيْنَا وَاَمْسَ الْمُلْكُ لِلَّهِ وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِيْ هَذَا اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوْذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا اللَّيْلَةِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوْذُ بِكَ مِنَ الْكَسَلِ، وَسُوءِ الْكِبَرِ، رَبِّ أَعُوْذُ بِكَ مِنْ عَذَابٍ فِيْ النَّارِ وَعَذَابٍ فِيْ الْقَبْرِ.\n" +
                "\n" +
                "Amsayna wa-amsal-mulku lillah walhamdu lillah la ilaha illal-lah, wahdahu la shareeka lah, lahul-mulku walahul-hamd, wahuwa AAala kulli shayin qadeer, rabbi as-aluka khayra ma fee hathihil-laylah, wakhayra ma baAAdaha, wa-aAAoothu bika min sharri hathihil-laylah, washarri ma baAAdaha, rabbi aAAoothu bika minal-kasal, wasoo-il kibar, rabbi aAAoothu bika min AAathabin fin-nar, waAAathabin fil-qabr.\n" +
                "\n" +
                "We have reached the evening and at this very time unto Allah belongs all sovereignty, and all praise is for Allah. None has the right to be worshipped except Allah, alone, without partner, to Him belongs all sovereignty and praise and He is over all things omnipotent. My Lord, I ask You for the good of this night and the good of what follows it and I take refuge in You from the evil of this night and the evil of what follows it. My Lord, I take refuge in You from laziness and senility. My Lord, I take refuge in You from torment in the Fire and punishment in the grave.\n" +
                "\n" +
                "Muslim 4:2088\n");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اَمْسَيْنَا وَاَمْسَ الْمُلْكُ لِلَّهِ وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِيْ هَذَا اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوْذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا اللَّيْلَةِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوْذُ بِكَ مِنَ الْكَسَلِ، وَسُوءِ الْكِبَرِ، رَبِّ أَعُوْذُ بِكَ مِنْ عَذَابٍ فِيْ النَّارِ وَعَذَابٍ فِيْ الْقَبْرِ.\n" +
                "\n" +
                "Amsayna wa-amsal-mulku lillah walhamdu lillah la ilaha illal-lah, wahdahu la shareeka lah, lahul-mulku walahul-hamd, wahuwa AAala kulli shayin qadeer, rabbi as-aluka khayra ma fee hathihil-laylah, wakhayra ma baAAdaha, wa-aAAoothu bika min sharri hathihil-laylah, washarri ma baAAdaha, rabbi aAAoothu bika minal-kasal, wasoo-il kibar, rabbi aAAoothu bika min AAathabin fin-nar, waAAathabin fil-qabr.\n" +
                "\n" +
                "We have reached the evening and at this very time unto Allah belongs all sovereignty, and all praise is for Allah. None has the right to be worshipped except Allah, alone, without partner, to Him belongs all sovereignty and praise and He is over all things omnipotent. My Lord, I ask You for the good of this night and the good of what follows it and I take refuge in You from the evil of this night and the evil of what follows it. My Lord, I take refuge in You from laziness and senility. My Lord, I take refuge in You from torment in the Fire and punishment in the grave.\n" +
                "\n" +
                "Muslim 4:2088\n");
        arrayList.add(hashMap);


        hashMap=new HashMap<>();
        hashMap.put("details","اَمْسَيْنَا وَاَمْسَ الْمُلْكُ لِلَّهِ وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِيْ هَذَا اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوْذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا اللَّيْلَةِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوْذُ بِكَ مِنَ الْكَسَلِ، وَسُوءِ الْكِبَرِ، رَبِّ أَعُوْذُ بِكَ مِنْ عَذَابٍ فِيْ النَّارِ وَعَذَابٍ فِيْ الْقَبْرِ.\n" +
                "\n" +
                "Amsayna wa-amsal-mulku lillah walhamdu lillah la ilaha illal-lah, wahdahu la shareeka lah, lahul-mulku walahul-hamd, wahuwa AAala kulli shayin qadeer, rabbi as-aluka khayra ma fee hathihil-laylah, wakhayra ma baAAdaha, wa-aAAoothu bika min sharri hathihil-laylah, washarri ma baAAdaha, rabbi aAAoothu bika minal-kasal, wasoo-il kibar, rabbi aAAoothu bika min AAathabin fin-nar, waAAathabin fil-qabr.\n" +
                "\n" +
                "We have reached the evening and at this very time unto Allah belongs all sovereignty, and all praise is for Allah. None has the right to be worshipped except Allah, alone, without partner, to Him belongs all sovereignty and praise and He is over all things omnipotent. My Lord, I ask You for the good of this night and the good of what follows it and I take refuge in You from the evil of this night and the evil of what follows it. My Lord, I take refuge in You from laziness and senility. My Lord, I take refuge in You from torment in the Fire and punishment in the grave.\n" +
                "\n" +
                "Muslim 4:2088\n");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اَمْسَيْنَا وَاَمْسَ الْمُلْكُ لِلَّهِ وَالْحَمْدُ لِلَّهِ، لَا إِلَهَ إِلَّّا اللَّهُ وَحْدَهُ لَا شَرِيكَ لَهُ، لَهُ الْمُلْكُ وَلَهُ الْحَمْدُ وَهُوَ عَلَى كُلِّ شَيْءٍ قَدِيرٌ، رَبِّ أَسْأَلُكَ خَيْرَ مَا فِيْ هَذَا اللَّيْلَةِ وَخَيْرَ مَا بَعْدَهُ، وَأَعُوْذُ بِكَ مِنْ شَرِّ مَا فِي هَذَا اللَّيْلَةِ وَشَرِّ مَا بَعْدَهُ، رَبِّ أَعُوْذُ بِكَ مِنَ الْكَسَلِ، وَسُوءِ الْكِبَرِ، رَبِّ أَعُوْذُ بِكَ مِنْ عَذَابٍ فِيْ النَّارِ وَعَذَابٍ فِيْ الْقَبْرِ.\n" +
                "\n" +
                "Amsayna wa-amsal-mulku lillah walhamdu lillah la ilaha illal-lah, wahdahu la shareeka lah, lahul-mulku walahul-hamd, wahuwa AAala kulli shayin qadeer, rabbi as-aluka khayra ma fee hathihil-laylah, wakhayra ma baAAdaha, wa-aAAoothu bika min sharri hathihil-laylah, washarri ma baAAdaha, rabbi aAAoothu bika minal-kasal, wasoo-il kibar, rabbi aAAoothu bika min AAathabin fin-nar, waAAathabin fil-qabr.\n" +
                "\n" +
                "We have reached the evening and at this very time unto Allah belongs all sovereignty, and all praise is for Allah. None has the right to be worshipped except Allah, alone, without partner, to Him belongs all sovereignty and praise and He is over all things omnipotent. My Lord, I ask You for the good of this night and the good of what follows it and I take refuge in You from the evil of this night and the evil of what follows it. My Lord, I take refuge in You from laziness and senility. My Lord, I take refuge in You from torment in the Fire and punishment in the grave.\n" +
                "\n" +
                "Muslim 4:2088\n");
        arrayList.add(hashMap);
    }


    public class MyDetailAdapter extends BaseAdapter {


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
            View v =inflater.inflate(R.layout.item_surah,viewGroup,false);


            TextView descText = v.findViewById(R.id.descText);
            LinearLayout copy = v.findViewById(R.id.Lay_copy);
            LinearLayout share = v.findViewById(R.id.Lay_share);



            descText.setText(arrayList.get(i).get("details"));



            PushDownAnim.setPushDownAnimTo(copy)
                    .setOnClickListener( new View.OnClickListener(){
                        @Override
                        public void onClick( View view ){
                            String details = arrayList.get(i).get("details");

                            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                            ClipData clip = ClipData.newPlainText("Copy", details);
                            clipboard.setPrimaryClip(clip);

                            Toast.makeText(getApplicationContext(),"Copied!!!!!!!",Toast.LENGTH_SHORT).show();

                        }

                    } );

            PushDownAnim.setPushDownAnimTo(share)
                    .setOnClickListener( new View.OnClickListener(){
                        @Override
                        public void onClick( View view ){

                            String details = arrayList.get(i).get("details");

                            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                            sharingIntent.setType("text/plain");
                            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, details);
                            startActivity(Intent.createChooser(sharingIntent, "Share via"));

                        }

                    } );



















            return v;
        }
    }


    private void morning(){
        arrayList = new ArrayList<>();


        hashMap=new HashMap<>();
        hashMap.put("details","أَصْبَـحْـنا وَأَصْبَـحْ المُـلكُ للَّهِ رَبِّ العـالَمـين ، اللّهُـمَّ إِنِّـي أسْـأَلُـكَ خَـيْرَ هـذا الـيَوْم ، فَـتْحَهُ ، وَنَصْـرَهُ ، وَنـورَهُ وَبَـرَكَتَـهُ ، وَهُـداهُ ، وَأَعـوذُ بِـكَ مِـنْ شَـرِّ ما فـيهِ وَشَـرِّ ما بَعْـدَه");


        arrayList.add(hashMap); hashMap=new HashMap<>();
        hashMap.put("details","اللّهُـمَّ بِكَ أَصْـبَحْنا وَبِكَ أَمْسَـينا ، وَبِكَ نَحْـيا وَبِكَ نَمُـوتُ وَإِلَـيْكَ المَصِيْر");
        arrayList.add(hashMap);

        arrayList.add(hashMap); hashMap=new HashMap<>();
        hashMap.put("details","الْحَمْدُ لِلَّهِ الَّذِي أَقَالَنَا يَوْمَنَا هَذَا وَلَمْ يُهْلِكْنَا بِذُنُوبِنَا (مُسْلِمْ)");
        arrayList.add(hashMap);

        arrayList.add(hashMap); hashMap=new HashMap<>();
        hashMap.put("details","أَمْسَيْنَا وَأَمْسَى الْمُلْكُ لِلَّهِ رَبِّ الْعَالَمِينَ اللَّهُمَّ إِنِّي أَسْأَلُكَ خَيْرَ هَذِهِ اللَّيْلَةَ فَتْحَهَا وَنَصْرَهَا وَنُورَهَا وَبَرَكَتَهَا وَهُدَاهَا وَأَعُوذُ بِكَ مِنْ شَرِّ مَا فِيهَا وَشَرِّ مَا بَعْدَهَا");
        arrayList.add(hashMap);

        arrayList.add(hashMap); hashMap=new HashMap<>();
        hashMap.put("details","اللَّهُمَّ بِكَ أَمْسَيْنَا وَبِكَ أَصْبَحْنَا وَبِكَ نَحْيَا وَبِكَ نَمُوتُ وَإِلَيْكَ النُّشُورُ");
        arrayList.add(hashMap);








    }

    private void night() {

        arrayList = new ArrayList<>();

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهمَّ إِنَّكَ خَلَقْتَ نَفْسِي وَأَنْتَ تَوَفَّاهَا لَكَ مَمَاتُهَا وَمَحْيَاهَا، إِنْ أَحْيَيْتَهَا فَاحْفَظْهَا، وَإِنْ أَمَتَّهَا فَاغْفِرْ لَهَا. اللَّهمَّ إِنِّي أَسْأَلُكَ العَافِيَةَ.");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهُمَّ قِنِي عَذَابَكَ يَوْمَ تَبْعَثُ عِبَادَكَ.");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهُمَّ بِاسْـمِكَ أَمُوتُ وَأَحْيَا");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اَلْحَمْدُ للهِ الَّذِي أَطْعَمَنَا وَسَقَانَا، وَكَفَانَا، وَآوَانَا، فَكَمْ مِمَّنْ لا كَافِيَ لَه ُُ وَلا مُؤْوِي.");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهمَّ عَالِمَ الغَيْبِ وَالشَّهَادَةِ فَاطِرَ السَّمَاوَاتِ وَالأَرْضِ رَبَّ كُلِّ شَيء ٍ وَمَلِيْكَهُ، أَشْهَدُ أَنْ لا إِلَهََ إِلاَّ أَنْتَ، أَعُوْذُ بِكَ مِنْ شَرِّ نَفْسِي، وَمِنْ شَرِّ الشَّيْطَانِ وَشِرْكِهِ، وَأَنْ أَقْتَرِفَ عَلَى نَفْسِي سُوْءاً أَوْ أَجُرَّهُ~ُ إِلَى مُسْلِم.");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهُمَّ أَسْلَمْتُ نَفْسِي إِلَيْكَ، وَفَوَّضْتُ أَمْرِي إِلَيْكَ، وَوَجَّهْتُ وَجْهِي إِلَيْكَ، وَأَلْجَأْتُ ظَهْرِي إِلَيْكَ، رَغْبَةً وَرَهْبَةً إِلَيْكَ، لَا مَلْجَأَ وَلّا مَنْجَا مِنْكَ إِلَّا إِلَيْكَ، آمَنْتُ بِكِتَابِكَ وَبِنَبِيِّكَ الَّذِي أَرْسَلْتَ.");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللهُ لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ لَا تَأْخُذُهُ سِنَةٌ وَلَا نَوْمٌ لَهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الْأَرْضِ مَنْ ذَا الَّذِي يَشْفَعُ عِنْدَهُ إِلَّا بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلَا يُحِيطُونَ بِشَيْءٍ مِنْ عِلْمِهِ إِلَّا بِمَا شَاءَ وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالْأَرْضَ وَلَا يَئُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","بِاسْمِكَ رَبِّي وَضَعْتُ جَنْبِي، وَبِكَ أَرْفَعُهُ، فَإِنْ أَمْسَكْتَ نَفْسِي فَارْحَمْهَا، وَإِنْ أَرْسَلْتَهَا فَاحْفَظْهَا، بِمَا تَحْفَظُ بِهِ عِبَادَكَ الصَّالِحِينَ");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","اللَّهمَّ إِنَّكَ خَلَقْتَ نَفْسِي وَأَنْتَ تَوَفَّاهَا لَكَ مَمَاتُهَا وَمَحْيَاهَا، إِنْ أَحْيَيْتَهَا فَاحْفَظْهَا، وَإِنْ أَمَتَّهَا فَاغْفِرْ لَهَا. اللَّهمَّ إِنِّي أَسْأَلُكَ العَافِيَةَ");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","أَسْتَغْفِرُ اللهَ الَّذِي لَا إِلَهَ إِلَّا هُوَ الْحَيُّ الْقَيُّومُ وَأَتُوبُ إِلَيْهِ");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","“سُبْحَانَ اللهِ، والْحَمْدُ للهِ، وَاللهُ أَكْبَرُ”");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("details","لَا إِلَهَ إِلَّا اللهُ الْوَاحِدُ اْقَهَّارُ، رَبُّ السَّمَاوَاتِ وَالْأَرْضِ وَمَا بَيْنَهُمَا الْعَزِيزُ الْغَفَّارُ");
        arrayList.add(hashMap);


    }

}