package com.example.dikr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AyahAdapter extends ArrayAdapter {
    List<Ayah> data;

    public AyahAdapter(@NonNull Context context, int resource, @NonNull List<Ayah> objects) {
        super(context, resource, objects);
        data=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Ayah ayah=data.get(position);
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        convertView=layoutInflater.inflate(R.layout.itemayahs,null,false);

        TextView txtV_numAyah=(TextView) convertView.findViewById(R.id.txtV_numAya);
        TextView txtV_ayahArabic=(TextView) convertView.findViewById(R.id.txtV_ayaArabic);
        TextView txtV_juz=(TextView) convertView.findViewById(R.id.txtV_juz);
        TextView txtV_manzil=(TextView) convertView.findViewById(R.id.txtV_manzil);
        TextView txtV_page=(TextView) convertView.findViewById(R.id.txtV_page);
        TextView txtV_ruku=(TextView) convertView.findViewById(R.id.txtV_ruku);
        TextView txtV_hizb=(TextView) convertView.findViewById(R.id.txtV_hizb);


        txtV_numAyah.setText(Integer.toString(ayah.numAyah));
        txtV_ayahArabic.setText(ayah.textAyah);
        txtV_juz.setText(Integer.toString(ayah.juz));
        txtV_manzil.setText(Integer.toString(ayah.manzil));
        txtV_page.setText(Integer.toString(ayah.page));
        txtV_ruku.setText(Integer.toString(ayah.ruku));
        txtV_hizb.setText(Integer.toString(ayah.hizb));

        return convertView;
    }


}
