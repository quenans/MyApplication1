package com.example.myapplication1;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DbHandler extends SQLiteOpenHelper{

    private static final String DB_name = "seniorsemschema.db";
    private static final String col_strDrink = "strDrink";
    private static final String col_strAlcoholic = "strAlcoholic";
    private static final String col_strCategories = "strCategories";
    private static final String col_strGlass = "strGlass";
    private static final String col_fullString = "fullString";
    private static final String col_strInstructions = "strInstructions";
    private static final Integer DB_version = 1;

    private static final String Table_Name = "drinks";

    public DbHandler(@Nullable Context context) {

        super(context, DB_name, null, DB_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE drinks ( " +
                         "strDrink text, strAlcoholic text, " +
                         "  `strCategories` text, " +
                         "`strGlass` text,  `fullString` text, `strInstructions` text" +
                       ")";

        db.execSQL(query);






    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldv, int newv) {

    }

    public void insertData(String path) throws IOException {

        File csvFile = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(csvFile));

        String line;
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            ContentValues values = new ContentValues();
            values.put(col_strDrink, data[0]);
            values.put(col_strAlcoholic, data[1]);
            values.put(col_strCategories, data[2]);
            values.put(col_strGlass, data[3]);
            values.put(col_fullString, data[4]);
            values.put(col_strInstructions, data[5]);
            db.insert(Table_Name, null, values);
        }

        db.setTransactionSuccessful();
        db.endTransaction();





        }
}
