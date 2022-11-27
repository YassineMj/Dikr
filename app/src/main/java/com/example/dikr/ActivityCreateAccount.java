package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;

public class ActivityCreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AccountCRUD acount=new AccountCRUD(this);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitycreateaccount);

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
                            "please fill all required fields", Toast.LENGTH_LONG).show();
                }
                else {
                    if(txt_acc_password.getText().toString().equals(txt_password_confirmation.getText().toString())!=true){
                        Toast.makeText(ActivityCreateAccount.this,
                                "Password validation error\n", Toast.LENGTH_LONG).show();
                    }
                    else{
                        if((!Patterns.EMAIL_ADDRESS.matcher(txt_acc_email.getText().toString()).matches())){
                            Toast.makeText(ActivityCreateAccount.this," Invalid Email",Toast.LENGTH_LONG).show();
                        }
                        else {
                            if((validationPassword(txt_acc_password.getText().toString())==false))
                            {
                                Toast.makeText(ActivityCreateAccount.this," the password must contain at least 8 characters and at most 12 characters\n ",Toast.LENGTH_LONG).show();
                            }
                            else {

                                String fullPhoneNumber=("+"+ccp.getSelectedCountryCode().toString()+txt_phone_number.getText().toString());

                                boolean ajouter=acount.insertAccount(txt_first.getText().toString(),txt_last.getText().toString(),txt_acc_email.getText().toString(),fullPhoneNumber,txt_acc_password.getText().toString());
                                if(ajouter==true){
                                    Toast.makeText(ActivityCreateAccount.this,
                                            "account successfully created\n", Toast.LENGTH_LONG).show();
                                    finish();
                                }
                                else {
                                    Toast.makeText(ActivityCreateAccount.this,
                                            "email already exists\n", Toast.LENGTH_LONG).show();
                                }

                            }

                        }

                    }
                }
            }
        });
    }

    public Boolean validationPassword(String password){
        if(password.length()<8 || password.length() > 12){
            return false;
        }
        return true;
    }
}