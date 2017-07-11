package com.gts.sqlitetutorial;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LaunchActivity extends AppCompatActivity {

    private SQLiteDatabase database;

    private RecyclerView rvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        rvTasks = (RecyclerView) findViewById(R.id.rvTasks);
        rvTasks.setBackgroundColor(
                ContextCompat.getColor(this, android.R.color.darker_gray)
        );
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        new InitTask().execute();
    }


    private class InitTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            deleteDatabase("app.db");
            SQLiteOpenHelper helper = new DatabaseManager(
                    getApplication(), "app.db"
            );
            database = helper.getWritableDatabase();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            rvTasks.setAdapter(new TaskAdapter(database));
        }
    }

}
