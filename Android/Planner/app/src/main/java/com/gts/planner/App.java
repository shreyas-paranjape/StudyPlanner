package com.gts.planner;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.gts.planner.infra.DatabaseManager;

public class App extends Application {

    private SQLiteDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        deleteDatabase("studyplanner.db");
    }

    public SQLiteDatabase getDatabase() {
        if (database == null) {
            database = new DatabaseManager(this, "studyplanner.db").getWritableDatabase();
        }

        return database;
    }
}
