package com.example.dikr;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MosqueFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MosqueFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MosqueFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MosqueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MosqueFragment newInstance(String param1, String param2) {
        MosqueFragment fragment = new MosqueFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_mosque, container, false);

        ImageView img1=v.findViewById(R.id.img_sabah);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getContext(),activitysabah.class);
                startActivity(intent1);
            }
        });
        ImageView img2=v.findViewById(R.id.img_masaa);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(getContext(),activitymasaa.class);
                startActivity(intent2);
            }
        });
        ImageView img3=v.findViewById(R.id.img_nawm);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(getContext(),activitynawm.class);
                startActivity(intent3);
            }
        });
        ImageView img4=v.findViewById(R.id.img_salah);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(getContext(),activitysalah.class);
                startActivity(intent4);
            }
        });
        ImageView img5=v.findViewById(R.id.img_tasbih);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6=new Intent(getContext(),activitytasbih.class);
                startActivity(intent6);
            }
        });
        ImageView img6=v.findViewById(R.id.img_masjid);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(getContext(),activitymasjid.class);
                startActivity(intent5);
            }
        });

        return v;
    }
}