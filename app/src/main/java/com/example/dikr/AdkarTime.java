package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AdkarTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adkar_time);

        ImageView img1=findViewById(R.id.img_sabah);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(AdkarTime.this,activitysabah.class);
                startActivity(intent1);
            }
        });
        ImageView img2=findViewById(R.id.img_masaa);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(AdkarTime.this,activitymasaa.class);
                startActivity(intent2);
            }
        });
        ImageView img3=findViewById(R.id.img_nawm);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(AdkarTime.this,activitynawm.class);
                startActivity(intent3);
            }
        });
        ImageView img4=findViewById(R.id.img_salah);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(AdkarTime.this,activitysalah.class);
                startActivity(intent4);
            }
        });
        ImageView img5=findViewById(R.id.img_tasbih);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6=new Intent(AdkarTime.this,activitytasbih.class);
                startActivity(intent6);
            }
        });
        ImageView img6=findViewById(R.id.img_masjid);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(AdkarTime.this,activitymasjid.class);
                startActivity(intent5);
            }
        });
    }
}