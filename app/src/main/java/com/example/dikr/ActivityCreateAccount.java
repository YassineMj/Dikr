package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class ActivityCreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Button btn_save=findViewById(R.id.btn_save);
        CountryCodePicker ccp=findViewById(R.id.ccp);
        EditText txt_first=findViewById(R.id.txt_first);
        EditText txt_last=findViewById(R.id.txt_last);
        EditText txt_acc_email=findViewById(R.id.txt_acc_email);
        EditText txt_acc_password=findViewById(R.id.txt_acc_password);
        EditText txt_phone_number=findViewById(R.id.txt_phone_number);
        EditText txt_password_confirmation=findViewById(R.id.txt_password_confirmation);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_first.getText().toString().equals("") || txt_last.getText().toString().equals("") || txt_acc_email.getText().toString().equals("")
                   || txt_acc_password.getText().toString().equals("") || txt_password_confirmation.getText().toString().equals("") || txt_phone_number.getText().toString().equals("") ){

                    Toast.makeText(ActivityCreateAccount.this,
                            "Veuillez remplir tous les champs obligatoires", Toast.LENGTH_LONG).show();
                }
                else {
                    if(txt_acc_password.getText().toString().equals(txt_password_confirmation.getText().toString())!=true){
                        Toast.makeText(ActivityCreateAccount.this,
                                "Erreur de validation de mot de passe", Toast.LENGTH_LONG).show();
                    }
                    else{

                        String fullPhoneNumber=(ccp.getSelectedCountryCode().toString()+txt_phone_number.getText().toString());
                        Toast.makeText(ActivityCreateAccount.this,
                                "compte créé avec succes", Toast.LENGTH_LONG).show();


                        Toast.makeText(ActivityCreateAccount.this,
                                "full phone number : "+fullPhoneNumber, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}