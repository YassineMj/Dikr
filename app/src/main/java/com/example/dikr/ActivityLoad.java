package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

public class ActivityLoad extends AppCompatActivity{

    Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ///ADKAR///
        Intent intent = new Intent(ActivityLoad.this, AlarmReceiver.class);

        // PendingIntent
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                ActivityLoad.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        Calendar startTime = Calendar.getInstance();
        startTime.set(Calendar.HOUR_OF_DAY, 21);
        startTime.set(Calendar.MINUTE, 17);
        startTime.set(Calendar.SECOND, 0);
        long alarmStartTime = startTime.getTimeInMillis();

        // Set Alarm
        alarmManager.set(AlarmManager.RTC_WAKEUP, alarmStartTime,pendingIntent);
        Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();


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