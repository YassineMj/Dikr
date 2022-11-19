package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class ActivityMenu extends AppCompatActivity {

    private MeowBottomNavigation bnv_Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymenu);

        bnv_Main = findViewById(R.id.bar_menu);
        bnv_Main.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        bnv_Main.add(new MeowBottomNavigation.Model(2,R.drawable.ic_quran));
        bnv_Main.add(new MeowBottomNavigation.Model(3,R.drawable.mosque));
        bnv_Main.add(new MeowBottomNavigation.Model(4,R.drawable.ic_manageaccounts));
        bnv_Main.add(new MeowBottomNavigation.Model(5,R.drawable.share));

        bnv_Main.show(1,true);

        replace(new HomeFragment());

        bnv_Main.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new HomeFragment());
                        break;

                    case 2:
                        replace(new MosqueFragment());
                        break;

                    case 3:
                        replace(new QuranFragment());
                        break;

                    case 4:
                        replace(new ProfileFragment());
                        break;

                    case 5:
                        replace(new ShareFragment());
                        break;


                }
                return null;
            }
        });}
    private void replace(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame,fragment);
        transaction.commit();
    }
}
