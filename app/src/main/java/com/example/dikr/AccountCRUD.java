package com.example.dikr;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class AccountCRUD {

    SqlHelper SqlDb;

    public AccountCRUD(Context context){
        SqlDb=new SqlHelper(context);
    }

    //insert
    public boolean insertAccount(String first , String last , String email , String phone , String password){
        try{
            SQLiteDatabase db=SqlDb.getWritableDatabase();
            db.execSQL("insert into account(first,last,email,phone,password) values (\""+first+"\",\""+last+"\",\""+email+"\",\""+phone+"\",\""+password+"\")");
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean selectAccount(String email , String password){
        SQLiteDatabase db =SqlDb.getReadableDatabase();
        Cursor cursor =db.rawQuery("select * from account where email = '"+email+"' and password ='"+password+"'",null);

        if (cursor.getCount()==1){
            cursor.moveToFirst();
            return true;
        }
        return false;
    }

    public void select(){
        SQLiteDatabase db =SqlDb.getReadableDatabase();
        Cursor cursor =db.rawQuery("select * from account",null);

        if (cursor.getCount()>0){
            for(int i=0;i<cursor.getCount();i++){
                cursor.moveToNext();
                System.out.println(cursor.getString(1)+" : "+cursor.getString(2)+" : "+cursor.getString(3)+" : "+cursor.getString(4)+" : "+cursor.getString(5)+" : ");
            }

        }
    }
}
