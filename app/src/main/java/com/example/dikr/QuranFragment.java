package com.example.dikr;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.AlarmClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuranFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuranFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuranFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment quranFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuranFragment newInstance(String param1, String param2) {
        QuranFragment fragment = new QuranFragment();
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

    ListView listV_surahs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_quran, container, false);

        listV_surahs=v.findViewById(R.id.listV_surahs);
        //Load Quran
        SurahAdapter adapter=new SurahAdapter(getContext(),R.layout.itemsurah,GlobalDeclaration.surahsList);

        //
        String url="https://api.alquran.cloud/v1/quran/ar.alafasy";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        if(GlobalDeclaration.surahsList.size()==0)
                        {
                            GlobalDeclaration.data=response.getJSONObject("data");
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
                            listV_surahs.setAdapter(adapter);
                        }else {
                            listV_surahs.setAdapter(adapter);
                        }


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
            //


            //ItemClick
            listV_surahs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intentAyahs=new Intent(getContext(), ActivityAyahs.class);
                    intentAyahs.putExtra("itemSurah",i);
                    startActivity(intentAyahs);
                }
            });

            RequestQueue requestQueue = Volley.newRequestQueue(getContext());
            requestQueue.add(jsonObjectRequest);
            Toast.makeText(getContext(),
                    "Load ...", Toast.LENGTH_LONG).show();
        return v;
    }
}