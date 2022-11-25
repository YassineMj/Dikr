package com.example.dikr;

public class Ayah {
    public  int numAyah;
    public String audioAyah;
    public  String textAyah;
    public  String textAyahEnglish;
    public  int juz;
    public  int manzil;
    public  int page;
    public  int ruku;
    public  int hizb;
    public  boolean sajda;

    public Ayah(int numAyah, String audioAyah, String textAyah, int juz, int manzil, int page, int ruku, int hizb,String textAyahEnglish) {
        this.numAyah = numAyah;
        this.audioAyah = audioAyah;
        this.textAyah = textAyah;
        this.juz = juz;
        this.manzil = manzil;
        this.page = page;
        this.ruku = ruku;
        this.hizb = hizb;
        this.textAyahEnglish=textAyahEnglish;
    }
}
