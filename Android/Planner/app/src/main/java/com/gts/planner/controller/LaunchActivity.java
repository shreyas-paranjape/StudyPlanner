package com.gts.planner.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gts.planner.App;
import com.gts.planner.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        new InitTask().execute();
    }

    private class InitTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // This call ensures database created before
            // any actual usage and in background
            ((App) getApplication()).getDatabase();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent activityDashBoard = new Intent(
                    LaunchActivity.this, AgendaActivity.class
            );
            startActivity(activityDashBoard);
            finish();
        }
    }
}