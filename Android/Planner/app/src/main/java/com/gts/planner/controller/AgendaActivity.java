package com.gts.planner.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;

import com.gts.planner.App;
import com.gts.planner.R;
import com.gts.planner.view.adapter.EventAdapter;

public class AgendaActivity extends AppCompatActivity {

    private boolean isFabMenuOpen;
    private EventAdapter adapter;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = ((App)getApplication()).getDatabase();
        setContentView(R.layout.activity_agenda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rvDayEvents = (RecyclerView) findViewById(R.id.rvDayEvents);
        rvDayEvents.setLayoutManager(new LinearLayoutManager(this));
        rvDayEvents.setAdapter(adapter = new EventAdapter(database));
        Listeners();
    }

    public void Listeners(){
        findViewById(R.id.fabShowMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFabMenuOpen)
                    collapseFabMenu();
                else
                    expandFabMenu();
            }
        });

        findViewById(R.id.taskContainer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTaskActivity = new Intent(AgendaActivity.this, AddTaskActivity.class);
                startActivityForResult(addTaskActivity, 101);
                collapseFabMenu();
            }
        });

        findViewById(R.id.examContainer).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent addExamActivity = new Intent(AgendaActivity.this, AddExamActivity.class);
                startActivityForResult(addExamActivity,102);
                collapseFabMenu();
            }
        });

        findViewById(R.id.courseContainer).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent addCourseActivity = new Intent(AgendaActivity.this, AddCourseActivity.class);
                startActivityForResult(addCourseActivity, 103);
                collapseFabMenu();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //TODO handle result
    }

    @Override
    public void onBackPressed() {
        if (isFabMenuOpen)
            collapseFabMenu();
        else
            super.onBackPressed();
    }

    private void expandFabMenu() {
        ViewCompat.animate(findViewById(R.id.fabShowMenu))
                .rotation(45.0F).withLayer().setDuration(300).setInterpolator(
                new OvershootInterpolator(10.0F)).start();
        Animation fabOpenAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_open);
        findViewById(R.id.taskContainer).startAnimation(fabOpenAnimation);
        findViewById(R.id.taskContainer).setClickable(true);
        findViewById(R.id.examContainer).startAnimation(fabOpenAnimation);
        findViewById(R.id.examContainer).setClickable(true);
        findViewById(R.id.courseContainer).startAnimation(fabOpenAnimation);
        findViewById(R.id.courseContainer).setClickable(true);
        isFabMenuOpen = true;


    }

    private void collapseFabMenu() {
        ViewCompat.animate(findViewById(R.id.fabShowMenu))
                .rotation(0.0F).withLayer().setDuration(300).setInterpolator(
                new OvershootInterpolator(10.0F)).start();
        Animation fabCloseAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        findViewById(R.id.taskContainer).startAnimation(fabCloseAnimation);
        findViewById(R.id.taskContainer).setClickable(false);
        findViewById(R.id.examContainer).startAnimation(fabCloseAnimation);
        findViewById(R.id.examContainer).setClickable(false);
        findViewById(R.id.courseContainer).startAnimation(fabCloseAnimation);
        findViewById(R.id.courseContainer).setClickable(false);
        isFabMenuOpen = false;
    }
}
