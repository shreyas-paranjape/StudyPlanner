package com.gts.planner.controller;

<<<<<<< HEAD
=======

import android.database.sqlite.SQLiteDatabase;

import android.content.Intent;
>>>>>>> 96d4257a7c6915293b732ec15880f7009a6e494f
import android.database.sqlite.SQLiteDatabase;


import com.gts.planner.App;
<<<<<<< HEAD

=======
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
>>>>>>> 96d4257a7c6915293b732ec15880f7009a6e494f
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
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity implements DatePicker.DateSelectListener {


    private Task NewTask =  new Task();
    private static long count = 1;
    private Button save_button;
    private EditText title;
    private Button due_date;
    private EditText description;
    private Date date = new Date();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        title = (EditText) findViewById(R.id.task_name);
        description = (EditText) findViewById(R.id.desc_task);
        due_date = (Button) findViewById(R.id.due_date_task);
        due_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker picker = new DatePicker();
                Bundle args = new Bundle();
                args.putString("sel_date",formatter.format(date));
                picker.setArguments(args);
                picker.show(getFragmentManager(),"date_picker");
            }
        });
        date = DateConverter(due_date.getText().toString());
        save_button = (Button) findViewById(R.id.save_task);
        save_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewTask.setTitle(title.getText().toString());
                        NewTask.setDescription(description.getText().toString());

<<<<<<< HEAD
                        SQLiteDatabase database = ((App) getApplication()).getDatabase();
                        database.insert("task", null, NewTask.toValues());

=======
                        SQLiteDatabase database = ((App)getApplication()).getDatabase();
                        database.insert("task",null,NewTask.toValues());
                        //converts the date object into epoch
>>>>>>> 5ed38bc4ea99ef86d6ae21159881ee89e01fbdb3
                        NewTask.setDueDate(date.getTime());
                        System.out.println(NewTask.toString());
                        finish();
                    }
                }
        );
    }
<<<<<<< HEAD


    private Date DateConverter(String date_string) {
=======
//converts the displayed sring in to date object
    private Date DateConverter(String date_string)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
>>>>>>> 5ed38bc4ea99ef86d6ae21159881ee89e01fbdb3
        Date convertedDate = new Date();
        try {
            convertedDate = formatter.parse(date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

<<<<<<< HEAD
    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = c.getTime();
        due_date.setText(formatter.format(date));
    }
}
=======
}
>>>>>>> 5ed38bc4ea99ef86d6ae21159881ee89e01fbdb3
