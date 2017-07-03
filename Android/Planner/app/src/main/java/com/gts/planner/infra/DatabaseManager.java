package com.gts.planner.infra;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseManager extends SQLiteAssetHelper {

    public DatabaseManager(Context context, String dbName) {
        super(context, dbName, null, 1);
    }
}
