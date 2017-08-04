 package com.gts.planner.controller;
import android.app.DialogFragment;
import android.content.DialogInterface;
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
import com.gts.planner.infra.DayPicker;
import com.gts.planner.infra.TimePicker;
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

public class AddCourseActivity extends AppCompatActivity implements TimePicker.TimeSelectListener,
        DayPicker.DayPickerListener {

    private Course NewCourse = new Course(); // creating a new class of objects for a new course.
    private static long count = 1; // Meant to serve as the id but can be deleted if already
                                    // accounted for.
    private Button save_button; // button that transfers input ot Database
    private EditText title; // Title of the Course
    private Button day; // Due day of the task
    private Button sTime; //Start time of the course
    private Button eTime; //End time of the course
    private EditText desc; // Notes pertaining to the task
    private EditText prof; // course professor name
    private EditText location; // course location
    private Date CourseStartTime = new Date(); // variable that sstores the start time data
    private Date CourseEndTime = new Date(); // variable that stores the end tme data
    int passcode; // the passcode that controls the created <code>if<code> statements pertaining to
                  // the required process

    private Bundle args = new Bundle(); // a heap created to store data to be passed into the dialogs

    private ArrayList mSelectedDays = new ArrayList(); // variable created to store the data of the
                                                       // days the courses are on

    private SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());

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
                    }
                });


        sTime = (Button) findViewById(R.id.sTime_course);
        sTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePicker tPicker = new TimePicker();
                        args.putString("sel_time", timeFormat.format(CourseStartTime));
                        tPicker.setArguments(args);
                        tPicker.show(getFragmentManager(), "time_picker");
                        passcode = 1;
                    }
                }
        );

        eTime = (Button) findViewById(R.id.eTime_course);
        eTime.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePicker tPicker = new TimePicker();
                        args.putString("sel_time", timeFormat.format(CourseEndTime));
                        tPicker.setArguments(args);
                        tPicker.show(getFragmentManager(), "time_picker");
                        passcode = 2;
                    }
                }
        );
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

    /*
    This method converts the the codes present in the <var>data<var> <code>ArrayList<code> to
    its corresponding string value.

    The way this method works is pretty simple. The day-code <code>0<code> stands for Monday and
    follows along till <code>4<code> denotes Friday. Each individual <code>if<code> statement
    compares if the respective day-code is present in the <var>data<var> <code>ArrayList<code> and
    as if present, returns a value greater than 0, else -1. The string fragment is the concatenated
    with a ', ' and the next fragment. The final string that is returned is the entire string minus
    the last 2 characters, namely the ', ' present at the end of the last string fragment.
     */
    private String DayCodeConverter(ArrayList days) {

        String temp_string = "";

        if (days.indexOf(0) >= 0)
            temp_string = temp_string + "Monday" + ", ";
        if (days.indexOf(1) >= 0)
            temp_string = temp_string + "Tuesday" + ", ";
        if (days.indexOf(2) >= 0)
            temp_string = temp_string + "Wednesday" + ", ";
        if (days.indexOf(3) >= 0)
            temp_string = temp_string + "Thursday" + ", ";
        if (days.indexOf(4) >= 0)
            temp_string = temp_string + "Friday" + ", ";

        try {
            return temp_string.substring(0, temp_string.length() - 2);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }

    }

    // This is the interface that communicates with the <class>TimePicker<class> dialog
    @Override
    public void onTimeSet(android.widget.TimePicker view, int hour, int minute) {
        final Calendar c = Calendar.getInstance();

        if(passcode == 1)
            c.setTime(CourseStartTime);
        else if(passcode == 2)
            c.setTime(CourseEndTime);

        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);

        if(passcode == 1)
        {
            CourseStartTime = c.getTime();
            sTime.setText(timeFormat.format(CourseStartTime));
        }
        else if (passcode == 2)
        {
            CourseEndTime = c.getTime();
            eTime.setText(timeFormat.format(CourseEndTime));

        }
    }

    // Interface that communicates with the <class>DayPicker<class> dialog
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        try {
            args.getBundle("data");
            mSelectedDays = args.getStringArrayList("days");
            passcode = 3;
        } catch (NullPointerException e) {
            mSelectedDays = new ArrayList();
        }
        if(passcode == 3)
            day.setText(DayCodeConverter(mSelectedDays));
    }
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
    }
}


