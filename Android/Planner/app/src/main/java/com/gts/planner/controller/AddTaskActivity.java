package com.gts.planner.controller;
<<<<<<< HEAD

<<<<<<< HEAD
=======
import android.database.sqlite.SQLiteDatabase;

import com.gts.planner.App;
import android.database.sqlite.SQLiteDatabase;

import android.annotation.TargetApi;
import android.icu.text.DateFormat;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
>>>>>>> c8a5c353eb02d81c2ec583599d0e6cbd35810795
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
=======
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import com.gts.planner.App;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
>>>>>>> 39f943f18fea2b1ba785616a09f40eac6dfbd73e
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
<<<<<<< HEAD
import java.util.Date;
import java.util.Locale;
=======
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity implements DatePicker.DateSelectListener {

    private Task NewTask =  new Task(); // creating a new class of objects for a new task.
    private static long count = 1; // Meant to serve as the id but can be deleted if already
                                    // accounted for.
    private Button save_button; // button that transfers input ot Database
    private EditText title; // Title of the Task
    private Button due_date; // Due date of the task
    private EditText description; // Notes pertaining to the task
>>>>>>> 39f943f18fea2b1ba785616a09f40eac6dfbd73e

    private Date date = new Date(); // Creating a date class

    /* Date Formatter
       Changeable to MM/dd/yyyy to suit the American Standard
    */
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

<<<<<<< HEAD

    private Task NewTask = new Task();
    private static long count = 1;
    private Button save_button;
    private EditText title;
    private EditText due_date;
    private EditText description;
    private Date date;
=======
>>>>>>> 39f943f18fea2b1ba785616a09f40eac6dfbd73e

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // Casting necessary variables
        title = (EditText) findViewById(R.id.task_name);
        description = (EditText) findViewById(R.id.desc_task);
<<<<<<< HEAD
        due_date = (EditText) findViewById(R.id.due_date_task);
        date = DateConverter(due_date.getText().toString());
        save_button = (Button) findViewById(R.id.save_task);
=======
        due_date = (Button) findViewById(R.id.due_date_task);
        save_button = (Button) findViewById(R.id.save_task);

        /* Listener for the date selection button. Brings up the date Selector Dialog
           *referenced from DatePicker.java class */
        due_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePicker picker = new DatePicker();

                // Bundle created to pass current chosen data the Dialog
                Bundle args = new Bundle();
                args.putString("sel_date",formatter.format(date));
                picker.setArguments(args);
                picker.show(getFragmentManager(),"date_picker");
            }
        });

        // Takes the text version and converts it into a 'date'
        date = DateConverter(due_date.getText().toString());

        /* Setting a listener for the save button which will transfer input to database
        on clicking it */
>>>>>>> 39f943f18fea2b1ba785616a09f40eac6dfbd73e
        save_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewTask.setTitle(title.getText().toString());
                        NewTask.setDescription(description.getText().toString());
<<<<<<< HEAD

                        SQLiteDatabase database = ((App)getApplication()).getDatabase();
                        database.insert("task",null,NewTask.toValues());

                        NewTask.setDueDate(date.getTime());

=======
                        SQLiteDatabase database = ((App)getApplication()).getDatabase();

                        //converts the date object into epoch format(getTime function)
                        NewTask.setDueDate(date.getTime());

                        database.insert("task",null,NewTask.toValues());

                        //converts the date object into epoch
                       // NewTask.setDueDate(date);
                        //NewTask.setDueDate(date.getTime());

                        System.out.println(NewTask.toString());
                        setResult(RESULT_OK);

                        //converts the date object into epoch format(getTime function)
>>>>>>> 39f943f18fea2b1ba785616a09f40eac6dfbd73e
                        finish();
                    }
                }
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Date DateConverter(String date_string)
    {
<<<<<<< HEAD
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
=======
>>>>>>> 39f943f18fea2b1ba785616a09f40eac6dfbd73e
        Date convertedDate = new Date();
        try {
            convertedDate = formatter.parse(date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

<<<<<<< HEAD
=======
    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = c.getTime();
        due_date.setText(formatter.format(date));
    }
>>>>>>> 39f943f18fea2b1ba785616a09f40eac6dfbd73e
}
