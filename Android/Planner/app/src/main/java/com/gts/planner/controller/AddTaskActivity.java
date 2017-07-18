package com.gts.planner.controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.gts.planner.App;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gts.planner.App;
import com.gts.planner.R;
import com.gts.planner.infra.DatePicker;
import com.gts.planner.model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity {


    private Task NewTask = new Task();
    private static long count = 1;
    private Button save_button;
    private EditText title;
    private EditText due_date;
    private EditText description;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        title = (EditText) findViewById(R.id.task_name);
        description = (EditText) findViewById(R.id.desc_task);
        due_date = (EditText) findViewById(R.id.due_date_task);
        due_date.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent date_picker = new Intent(AddTaskActivity.this,DatePicker.class);
                        startActivity(date_picker);
                    }
                }
        );
        date = DateConverter(due_date.getText().toString());
        save_button = (Button) findViewById(R.id.save_task);
        save_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewTask.setTitle(title.getText().toString());
                        NewTask.setDescription(description.getText().toString());

                        SQLiteDatabase database = ((App)getApplication()).getDatabase();
                        database.insert("task",null,NewTask.toValues());

                        NewTask.setDueDate(date.getTime());

                        finish();
                    }
                }
        );
    }
<<<<<<< HEAD
=======

>>>>>>> b9e049f5233fc44ddaba9431676ea3b92c8068ed

    private Date DateConverter(String date_string)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }
<<<<<<< HEAD
=======

>>>>>>> b9e049f5233fc44ddaba9431676ea3b92c8068ed
}
