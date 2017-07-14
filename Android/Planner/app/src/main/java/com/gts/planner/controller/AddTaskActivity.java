package com.gts.planner.controller;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gts.planner.R;
import com.gts.planner.model.Task;

import java.util.Date;

public class AddTaskActivity extends AppCompatActivity {

    private Task NewTask = new Task();
    private static long count = 1;
    private Button save_button;
    private EditText title;
    private EditText due_date;
    private EditText description;
    private Date date = new Date(epochTime);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        title = (EditText) findViewById(R.id.task_name);
        description = (EditText) findViewById(R.id.desc);
        due_date = (EditText) findViewById(R.id.due_date);
        save_button = (Button) findViewById(R.id.save);
        save_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewTask.setTitle(title.getText().toString());
                        NewTask.setDescription(description.getText().toString());
                        finish();
                    }
                }
        );
    }
}
