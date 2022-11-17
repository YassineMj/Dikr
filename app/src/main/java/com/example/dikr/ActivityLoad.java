package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ActivityLoad extends AppCompatActivity {

    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityload);

                Runnable runnable=new Runnable() {
                    @Override
                    public void run() {
                        run_activity();
                    }
                };
                handler.postDelayed(runnable,2*1000);
    }
    public  void run_activity(){
        Intent intent=new Intent(this,ActivityLogin.class);
        startActivity(intent);
        finish();
    }
}