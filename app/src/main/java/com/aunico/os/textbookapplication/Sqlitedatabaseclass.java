package com.aunico.os.textbookapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Sqlitedatabaseclass extends SQLiteOpenHelper {

    public static final String Databasename="quiz_db";
    public static final String TableName="quiz_tb";

    public static final String COL_1="ID";
    public static final String COL_2="Question";
    public static final String COL_3="opt1";
    public static final String COL_4="opt2";
    public static final String COL_5="opt3";
    public static final String COL_6="opt4";

   public Sqlitedatabaseclass(Context context)
   {
       super(context,Databasename,null,1);

   }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       sqLiteDatabase.execSQL("CREATE TABLE "+TableName+"(ID INTEGER,Question TEXT,opt1 TEXT,opt2 TEXT,opt3 TEXT,opt4 TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TableName);
    }
    public boolean insertdata(String id,String Question,String opt1,String opt2,String opt3,String opt4)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,Question);
        contentValues.put(COL_3,opt1);
        contentValues.put(COL_4,opt2);
        contentValues.put(COL_5,opt3);
        contentValues.put(COL_6,opt4);
        long result=db.insert(TableName,null,contentValues);
        db.close();
        if (result==-1)
            return false;
        else
            return true;
    }

    public Cursor getalldata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("Select * from "+TableName,null);
        return res;

    }

}
