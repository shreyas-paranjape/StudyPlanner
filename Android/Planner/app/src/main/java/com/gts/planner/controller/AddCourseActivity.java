 package com.gts.planner.controller;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import com.gts.planner.model.Course;
import com.gts.planner.model.Task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//assuming one class per day only

public class AddCourseActivity extends AppCompatActivity implements DatePicker.DateSelectListener {

    private Course NewCourse =  new Course(); // creating a new class of objects for a new course.
    private static long count = 1; // Meant to serve as the id but can be deleted if already
    // accounted for.
    private Button save_button; // button that transfers input ot Database
    private EditText title; // Title of the Course
    private Button day; // Due day of the task
    private Date sTime; //Start time of the course
    private Button eTime; //End time of the course
    private EditText desc; // Notes pertaining to the task
    private EditText prof; // course professor name
    private EditText location; // course location

    private Date date = new Date(); // Creating a date class

    /* Date Formatter
       Changeable to MM/dd/yyyy to suit the American Standard
    */
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        // Casting necessary variables
        title = (EditText) findViewById(R.id.course_name);
        desc = (EditText) findViewById(R.id.desc_course);
        prof = (EditText) findViewById(R.id.prof_course);
        location = (EditText) findViewById(R.id.location_course);
        day = (Button) findViewById(R.id.day_course);
        sTime = (Button) findViewById(R.id.sTime_course);
        eTime = (Button) findViewById(R.id.eTime_course);
        save_button = (Button) findViewById(R.id.save_task);

        /* Listener for the date selection button. Brings up the date Selector Dialog
           *referenced from DatePicker.java class */
         day.setOnClickListener(new View.OnClickListener() {
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
        date = DateConverter(sTime.toString());


        /* Setting a listener for the save button which will transfer input to database
        on clicking it */
       save_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewCourse.setTitle(title.getText().toString());
                        NewCourse.setDesc(desc.getText().toString());
                        NewCourse.setProf(prof.getText().toString());
                        NewCourse.setLocation(location.getText().toString());
                        SQLiteDatabase database = ((App)getApplication()).getDatabase();

                        //converts the date object into epoch format(getTime function)
                        NewCourse.setDay(date.getTime());

                        database.insert("task",null,NewCourse.toValues());

                        //converts the date object into epoch
                        // NewTask.setDueDate(date);
                        //NewTask.setDueDate(date.getTime());

                        System.out.println(NewCourse.toString());
                        setResult(RESULT_OK);

                        //converts the date object into epoch format(getTime function)
                        finish();
                    }
                }
        );
    }

    private Date DateConverter(String date_string)
    {
        Date convertedDate = new Date();
        try {
            convertedDate = formatter.parse(date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = c.getTime();
        day.setText(formatter.format(date));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hour, int minute){
        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        date = c.getTime();
        sTime.setText(timeFormat.format(date));
    }
}
