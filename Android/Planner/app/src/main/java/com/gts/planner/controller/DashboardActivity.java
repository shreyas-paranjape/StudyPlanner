package com.gts.planner.controller;

import android.content.Intent;
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

import com.gts.planner.R;

public class DashboardActivity extends AppCompatActivity {

    private boolean isFabMenuOpen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rvDayEvents = (RecyclerView) findViewById(R.id.rvDayEvents);
        rvDayEvents.setLayoutManager(new LinearLayoutManager(this));
        findViewById(R.id.fabShowMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFabMenuOpen)
                    collapseFabMenu();
                else
                    expandFabMenu();
            }
        });
        findViewById(R.id.fabAddTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTaskActivity = new Intent(DashboardActivity.this, AddTaskActivity.class);
                startActivityForResult(addTaskActivity, 101);
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
        findViewById(R.id.fabAddTask).setClickable(true);
        isFabMenuOpen = true;


    }

    private void collapseFabMenu() {
        ViewCompat.animate(findViewById(R.id.fabShowMenu))
                .rotation(0.0F).withLayer().setDuration(300).setInterpolator(
                new OvershootInterpolator(10.0F)).start();
        Animation fabCloseAnimation = AnimationUtils.loadAnimation(this, R.anim.fab_close);
        findViewById(R.id.taskContainer).startAnimation(fabCloseAnimation);
        findViewById(R.id.fabAddTask).setClickable(false);
        isFabMenuOpen = false;
    }
}
