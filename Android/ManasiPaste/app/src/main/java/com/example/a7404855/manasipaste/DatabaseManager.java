package com.example.a7404855.manasipaste;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseManager extends SQLiteAssetHelper{
    private static final String DATABASE_NAME = "studyplanner.db";
    private static final int DATABSE_VERSION =1;

    public DatabaseManager(Context context, String name) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION );
    }

}
