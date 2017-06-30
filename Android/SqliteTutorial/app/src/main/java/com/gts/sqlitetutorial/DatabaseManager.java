package com.gts.sqlitetutorial;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


public class DatabaseManager extends SQLiteAssetHelper {

    public DatabaseManager(Context context, String name) {
        super(context, name, null, 1);
    }

}
