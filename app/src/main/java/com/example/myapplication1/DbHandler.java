package com.example.myapplication1;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper{

    private static final String DB_name = "seniorsemschema";

    private static final Integer DB_version = 1;


    public DbHandler(@Nullable Context context) {
        super(context, DB_name, null, DB_version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE drinks ( " +
                         "strDrink text, strAlcoholic text,  strDrink text, strAlcoholic text, " +
                         "`strCategory` text,  `strDrinkThumb` text,  `strCategory` text,  `strDrinkThumb` text, " +
                         "`strGlass` text,  `strIngredients` text, `strInstructions` text,  `strGlass` text,  `strIngredients` text, `strInstructions`" +
                       ")";

        db.execSQL(query);











             
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldv, int newv) {

    }
}
