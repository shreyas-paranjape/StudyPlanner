package com.example.a7404855.manasipaste;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static List<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

        ListView listview = (ListView) findViewById(R.id.ListView);

        ListAdapter adapter = new TaskAdapter(this, tasks);
        listview.setAdapter(adapter);
        Button addbutton =(Button) findViewById(R.id.add);
        addbutton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.add:
                Intent in = new Intent(this, CreateTask.class);
                startActivity(in);
                break;
            default:
                break;
        }

    }



}
