package com.example.dikr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    EditText txt_first;
    EditText txt_last;
    EditText txt_email;
    EditText txt_phone;
    EditText txt_password;
    Button btn_update;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        String[] infoAccount= AccountCRUD.infoAccount;

        txt_first=v.findViewById(R.id.txt_firstUpdate);
        txt_last=v.findViewById(R.id.txt_lastUpdate);
        txt_email=v.findViewById(R.id.txt_emailUpdate);
        txt_phone=v.findViewById(R.id.txt_phoneUpdate);
        txt_password=v.findViewById(R.id.txt_passwordUpdate);

        txt_first.setText(infoAccount[0].toString());
        txt_last.setText(infoAccount[1].toString());
        txt_email.setText(infoAccount[2].toString());
        txt_phone.setText(infoAccount[3].toString());
        txt_password.setText(infoAccount[4].toString());


        btn_update=v.findViewById(R.id.btn_update);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_first.getText().toString().equals("") || txt_last.getText().toString().equals("") || txt_email.getText().toString().equals("")
                   || txt_password.getText().toString().equals("")) {

                    Toast.makeText(getContext(),
                            "Veuillez remplir tous les champs obligatoires", Toast.LENGTH_LONG).show();
                }
                else {
                    AccountCRUD accountUpdate=new AccountCRUD(getContext());

                    if(txt_password.length()<8 || txt_password.length()>12){
                        Toast.makeText(getContext()," le mot de passe doit contenir au moins 8 caractères et au maximum 12 caractères ",Toast.LENGTH_LONG).show();
                    }
                    else {
                        if (accountUpdate.updateAccount(txt_first.getText().toString(),txt_last.getText().toString(),txt_email.getText().toString(),txt_phone.getText().toString(),txt_password.getText().toString(),Integer.parseInt(infoAccount[5]))==true && Patterns.EMAIL_ADDRESS.matcher(txt_email.getText().toString()).matches() ){
                            Toast.makeText(getContext(), "succes", Toast.LENGTH_LONG).show();
                            getActivity().finish();
                        }
                        else {
                            Toast.makeText(getContext()," Invalid Email",Toast.LENGTH_LONG).show();
                        }
                    }

                }
            }
        });
        return v;
    }
}