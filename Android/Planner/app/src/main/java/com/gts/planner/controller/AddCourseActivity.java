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
import android.widget.TimePicker;

import com.gts.planner.App;
import com.gts.planner.R;
import com.gts.planner.infra.DatePicker;
import com.gts.planner.infra.DayPicker;
import com.gts.planner.model.Course;
import com.gts.planner.model.Task;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//assuming one class per day only

public class AddCourseActivity extends AppCompatActivity  {

    private Course NewCourse = new Course(); // creating a new class of objects for a new course.
    private static long count = 1; // Meant to serve as the id but can be deleted if already
                                    // accounted for.
    private Button save_button; // button that transfers input ot Database
    private EditText title; // Title of the Course
    private Button day; // Due day of the task
    private TimePicker sTime; //Start time of the course
    private Button eTime; //End time of the course
    private EditText desc; // Notes pertaining to the task
    private EditText prof; // course professor name
    private EditText location; // course location
    private Date CourseDayTime; // variable that stores the day-time data of a course

    private Bundle args = new Bundle();

    private ArrayList mSelectedDays = new ArrayList();

    private SimpleDateFormat formatter_time = new SimpleDateFormat("hh:mm aa", Locale.getDefault());

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
        day.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DayPicker day_picker = new DayPicker();
                        args.putStringArrayList("days", mSelectedDays);
                        day_picker.setArguments(args);
                        day_picker.show(getFragmentManager(), "dayPicker");
                        try {
                            mSelectedDays = args.getStringArrayList("days");
                        }catch (NullPointerException e){
                            mSelectedDays = new ArrayList();
                        }
                    }
                }
        );

<<<<<<< HEAD

        sTime = (TimePicker) findViewById(R.id.sTime_course);
        Integer hour, minutes;
        if (Build.VERSION.SDK_INT >= 23 ) {
            hour = sTime.getHour();
            minutes = sTime.getMinute();
        } else {
            hour = sTime.getCurrentHour();
            minutes = sTime.getCurrentMinute();
        }
        final Time time = new Time(hour, minutes, 0);
=======
        System.out.println(mSelectedDays);
        sTime = (Button) findViewById(R.id.sTime_course);
>>>>>>> a7ae90e06a4e3720ba43f730378d44fd3b83ef75
        eTime = (Button) findViewById(R.id.eTime_course);
        save_button = (Button) findViewById(R.id.save_course);
        save_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewCourse.setTitle(title.getText().toString());
                        NewCourse.setDesc(desc.getText().toString());
                        NewCourse.setProf(prof.getText().toString());
                        NewCourse.setLocation(location.getText().toString());
                        SQLiteDatabase database = ((App) getApplication()).getDatabase();

                        //converts the date object into epoch format(getTime function)
                        NewCourse.setDay(mSelectedDays.toString());
                        NewCourse.setsTime(time.getTime());

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


    }

