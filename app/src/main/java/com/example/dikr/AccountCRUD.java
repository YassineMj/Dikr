package com.example.dikr;

import android.content.ContentValues;
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

    public boolean updateAccount(String first , String last , String email , String phone , String password,int id){
        try{
            SQLiteDatabase db=SqlDb.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("first",first);
            values.put("last",last);
            values.put("email",email);
            values.put("phone",phone);
            values.put("password",password);

            db.update("account",values,"_id = "+id,null);

            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static String[] infoAccount = new String[6];
    public boolean selectAccount(String email , String password){

        SQLiteDatabase db =SqlDb.getReadableDatabase();
        Cursor cursor =db.rawQuery("select * from account where email = '"+email+"' and password ='"+password+"'",null);

        if (cursor.getCount()==1){
            cursor.moveToFirst();
            infoAccount[0]=cursor.getString(1);
            infoAccount[1]=cursor.getString(2);
            infoAccount[2]=cursor.getString(3);
            infoAccount[3]=cursor.getString(4);
            infoAccount[4]=cursor.getString(5);
            infoAccount[5]=cursor.getString(0);
            return true;
        }
        return false;
    }

    public String[] getInfoAccount(){
        return infoAccount;
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
