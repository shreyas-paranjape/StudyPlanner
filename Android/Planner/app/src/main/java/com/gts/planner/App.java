package com.gts.planner;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.gts.planner.infra.DatabaseManager;

public class App extends Application {

    private SQLiteDatabase database;

    public SQLiteDatabase getDatabase() {
        if (database == null) {
            database = new DatabaseManager(this, "planner.db").getWritableDatabase();
        }

        return database;
    }
}
