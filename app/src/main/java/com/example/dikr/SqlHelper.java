package com.example.dikr;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqlHelper extends SQLiteOpenHelper {

    public SqlHelper(@Nullable Context context) {
        super(context, "DikrBD", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creatio d'une table
        db.execSQL("create table account (_id integer primary key AUTOINCREMENT , first varchar(20) , last varchar(20) , email varchar(20) UNIQUE , phone varchar(20) , password varchar(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table account");
        onCreate(db);
    }
}