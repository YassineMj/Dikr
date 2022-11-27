package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylogin);


        AccountCRUD account=new AccountCRUD(this);

        account.select();

        final Intent IntentCreateAccount=new Intent(this,ActivityCreateAccount.class);
        Intent IntentMenu = new Intent(this,ActivityMenu.class);


        EditText txt_email=findViewById(R.id.txt_email);
        EditText txt_password=findViewById(R.id.txt_password);

        TextView txt_incription=findViewById(R.id.txt_inscription);
        Button btn_login=findViewById(R.id.btn_update);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_email.getText().toString().equals("") || txt_password.getText().toString().equals("")){
                    Toast.makeText(ActivityLogin.this,
                            "please fill all required fields", Toast.LENGTH_LONG).show();
                }
                else{
                    if(Patterns.EMAIL_ADDRESS.matcher(txt_email.getText().toString()).matches() && account.selectAccount(txt_email.getText().toString(),txt_password.getText().toString())==true){
                        String[] infoAccount = account.getInfoAccount();

                        Toast.makeText(ActivityLogin.this," Validated Successfully !",Toast.LENGTH_LONG).show();
                        txt_email.setText(null);
                        txt_password.setText(null);
                        try {
                            loadQuran();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        startActivity(IntentMenu);
                    }else {
                        Toast.makeText(ActivityLogin.this," Invalid Email",Toast.LENGTH_LONG).show();
                    }}}
        });

        txt_incription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(IntentCreateAccount);
            }
        });
    }

    public void loadQuran() throws IOException {
        try {
            if(GlobalDeclaration.surahsList.size()==0)
            {
                InputStream is =getAssets().open("SurahQuranArabic.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                String json = new String(buffer);

                GlobalDeclaration.data=new JSONObject(json).getJSONObject("data");
                JSONArray surahs=GlobalDeclaration.data.getJSONArray("surahs");

                for(int i=0;i<114;i++){
                    int ayahs=surahs.getJSONObject(i).getJSONArray("ayahs").length();

                    Surah o=new Surah(Integer.parseInt(surahs.getJSONObject(i).getString("number")),
                            ayahs,
                            surahs.getJSONObject(i).getString("name"),
                            surahs.getJSONObject(i).getString("englishName"),
                            surahs.getJSONObject(i).getString("revelationType"));


                    GlobalDeclaration.surahsList.add(o);
                }
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}