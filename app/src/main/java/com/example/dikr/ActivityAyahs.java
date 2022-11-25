package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ActivityAyahs extends AppCompatActivity {

    ListView listV_ayahs;
    List<Ayah> ayahsList=new ArrayList<Ayah>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayahs);

        listV_ayahs=findViewById(R.id.listV_ayahs);


        //Load ayahs
        AyahAdapter adapter=new AyahAdapter(this,R.layout.itemayahs,ayahsList);
        /*String url="https://api.alquran.cloud/v1/quran/ar.alafasy";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Bundle itemSurah=getIntent().getExtras();
                    int index = Integer.parseInt(itemSurah.get("itemSurah").toString());

                    JSONArray ayahs=response.getJSONObject("data").getJSONArray("surahs").getJSONObject(index).getJSONArray("ayahs");

                    for(int i=0;i<ayahs.length();i++){
                        Ayah a=new Ayah(i+1,
                                ayahs.getJSONObject(i).getString("audio").toString(),
                                ayahs.getJSONObject(i).getString("text").toString(),
                                Integer.parseInt(ayahs.getJSONObject(i).get("juz").toString()),
                                Integer.parseInt(ayahs.getJSONObject(i).get("manzil").toString()),
                                Integer.parseInt(ayahs.getJSONObject(i).get("page").toString()),
                                Integer.parseInt(ayahs.getJSONObject(i).get("ruku").toString()),
                                Integer.parseInt(ayahs.getJSONObject(i).get("hizbQuarter").toString()));
                        ayahsList.add(a);
                    }

                    listV_ayahs.setAdapter(adapter);

                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });



        RequestQueue requestQueue = Volley.newRequestQueue(ActivityAyahs.this);
        requestQueue.add(jsonObjectRequest);*/
        Bundle itemSurah=getIntent().getExtras();
        int index = Integer.parseInt(itemSurah.get("itemSurah").toString());

        JSONArray ayahs= null;
        try {
            ayahs = GlobalDeclaration.data.getJSONArray("surahs").getJSONObject(index).getJSONArray("ayahs");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        for(int i=0;i<ayahs.length();i++){
            Ayah a= null;
            try {
                a = new Ayah(i+1,
                        ayahs.getJSONObject(i).getString("audio").toString(),
                        ayahs.getJSONObject(i).getString("text").toString(),
                        Integer.parseInt(ayahs.getJSONObject(i).get("juz").toString()),
                        Integer.parseInt(ayahs.getJSONObject(i).get("manzil").toString()),
                        Integer.parseInt(ayahs.getJSONObject(i).get("page").toString()),
                        Integer.parseInt(ayahs.getJSONObject(i).get("ruku").toString()),
                        Integer.parseInt(ayahs.getJSONObject(i).get("hizbQuarter").toString()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ayahsList.add(a);
        }

        listV_ayahs.setAdapter(adapter);

        listV_ayahs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                audio(i);
            }
        });
    }

    public void audio(int indexAyah){
        Ayah o=ayahsList.get(indexAyah);
        String url = o.audioAyah;
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        try {
            mediaPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }
}