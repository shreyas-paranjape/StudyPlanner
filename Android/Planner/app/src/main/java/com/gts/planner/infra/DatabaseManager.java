package com.gts.planner.infra;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseManager extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "planner.db";
    public DatabaseManager(Context context, String s) {
        super(context, DATABASE_NAME, null, 1);
    }


}
