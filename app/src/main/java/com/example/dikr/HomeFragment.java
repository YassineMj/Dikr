package com.example.dikr;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    Button btn_search;
    EditText txt_city;

    TextView txtV_fajr;
    TextView txtV_duhr;
    TextView txtV_asr;
    TextView txtV_maghrib;
    TextView txtV_isha;
    TextView txtV_date;
    TextView txtV_country;
    TextView txtV_state;
    TextView txtV_nameCity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void loadData() {
        String city=txt_city.getText().toString();
        String url="https://muslimsalat.com/"+city+".json?key=1c3e0059dbfff9bbc17e4e5f98c45dfc";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String status_code= null;
                try {
                    status_code = response.getString("status_code");

                    if(status_code.equals("1"))
                    {
                        JSONArray items= response.getJSONArray("items");
                        JSONObject o= items.getJSONObject(0);


                        txtV_fajr.setText(o.getString("fajr"));
                        txtV_duhr.setText(o.getString("dhuhr"));
                        txtV_asr.setText(o.getString("asr"));
                        txtV_maghrib.setText(o.getString("maghrib"));
                        txtV_isha.setText(o.getString("isha"));
                        txtV_date.setText(o.getString("date_for"));

                        txtV_country.setText(response.getString("country"));
                        txtV_state.setText(response.getString("state"));
                        txtV_nameCity.setText(response.getString("query"));


                    }
                    else {
                        txtV_fajr.setText(null);
                        txtV_duhr.setText(null);
                        txtV_asr.setText(null);
                        txtV_maghrib.setText(null);
                        txtV_isha.setText(null);
                        txtV_date.setText(null);

                        txtV_country.setText(null);
                        txtV_state.setText(null);
                        txtV_nameCity.setText(null);


                        Toast.makeText(getContext(),
                                "nom de ville introuvable !!", Toast.LENGTH_LONG).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),
                        "error connection", Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        btn_search = v.findViewById(R.id.btn_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_city = v.findViewById(R.id.txt_city);
                txtV_fajr = v.findViewById(R.id.txtV_fajr);
                txtV_duhr = v.findViewById(R.id.txtV_duhr);
                txtV_asr = v.findViewById(R.id.txtV_asr);
                txtV_maghrib = v.findViewById(R.id.txtV_maghrib);
                txtV_isha = v.findViewById(R.id.txtV_isha);
                txtV_date = v.findViewById(R.id.txtV_date);
                txtV_country = v.findViewById(R.id.txtV_country);
                txtV_state = v.findViewById(R.id.txtV_state);
                txtV_nameCity=v.findViewById(R.id.txtV_nameCity);

                if (txt_city.getText().equals(null)) {
                    Toast.makeText(getContext(),
                            "insere la ville !! ", Toast.LENGTH_LONG).show();
                } else {
                    loadData();
                }

            }
        });
        return v;
    }
}