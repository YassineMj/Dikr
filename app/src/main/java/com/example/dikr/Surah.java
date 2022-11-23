package com.example.dikr;

public class Surah {

    public int numSurah;
    public int ayahs;
    public String nameArabSurah;
    public String nameEnghlishSurah;
    public String typeSurah;



    public Surah(int num,int ayahs,String nameArabSurah,String nameEnghlishSurah,String typeSurah){
        this.numSurah=num;
        this.ayahs=ayahs;
        this.nameArabSurah=nameArabSurah;
        this.nameEnghlishSurah=nameEnghlishSurah;
        this.typeSurah=typeSurah;
    }
}