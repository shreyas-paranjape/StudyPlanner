package com.example.a7404855.manasipaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Task> tasks = new ArrayList<>();
    private ArrayAdapter<Task> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

        ListView listview = (ListView) findViewById(R.id.ListView);

        adapter = new TaskAdapter(this, tasks);
        listview.setAdapter(adapter);
        Button addbutton =(Button) findViewById(R.id.add);
        addbutton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.add:
                Intent in = new Intent(this, CreateTask.class);
                startActivityForResult(in, 999);
                break;
            default:
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 999) {
            Task task = (Task)data.getSerializableExtra("TASK");
            tasks.add(task);
        } else {
            Task task = (Task)data.getSerializableExtra("TASK");
            int idx = tasks.indexOf(task);
            if(idx < tasks.size() && idx >=0) {
                Task fromList = tasks.get(idx);
                fromList.setTitle(task.getTitle());
            }
        }
        adapter.notifyDataSetChanged();
    }
}
