package com.example.dikr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SurahAdapter extends ArrayAdapter {
    List<Surah> data;

    public SurahAdapter(@NonNull Context context, int resource, @NonNull List<Surah> objects) {
        super(context, resource, objects);
        data=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Surah surah=data.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView=layoutInflater.inflate(R.layout.itemsurah,null,false);

        TextView txtV_nameSurahEnglish=(TextView) convertView.findViewById(R.id.txtV_nameSurahEnglish);
        TextView txtV_nameSurahArab=(TextView) convertView.findViewById(R.id.txtV_nameSurahArab);
        TextView txtV_numSurah=(TextView) convertView.findViewById(R.id.txtV_numSurah);
        TextView txtV_typeSurah=(TextView) convertView.findViewById(R.id.txtV_typeSurah);
        TextView txtV_ayahs=(TextView) convertView.findViewById(R.id.txtV_Ayahs);

        txtV_numSurah.setText(Integer.toString(surah.numSurah));
        txtV_nameSurahEnglish.setText(surah.nameEnghlishSurah);
        txtV_nameSurahArab.setText(surah.nameArabSurah);
        txtV_typeSurah.setText(surah.typeSurah);
        txtV_ayahs.setText(Integer.toString(surah.ayahs));

        return convertView;
    }


}
