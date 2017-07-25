package com.gts.planner.controller;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gts.planner.infra.DatePicker;
import com.gts.planner.infra.TimePicker;
import com.gts.planner.App;
import com.gts.planner.R;
import com.gts.planner.model.Course;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;



public abstract class AddCourseActivity extends AppCompatActivity implements DayPicker.DateSelectListener,
        TimePicker.TimeSelectListener {


    private Course NewCourse = new Course();
    private Button save ;
    private EditText course_title;
    private Button course_day;
    private EditText course_prof;
    private EditText course_location;
    private Button course_time;
    private Date courseDateTime;
    Bundle args = new Bundle();



    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        course_title = (EditText) findViewById(R.id.course_title);
        course_prof = (EditText) findViewById(R.id.prof_course);
        course_time =(Button) findViewById(R.id.due_time);
        course_time.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePicker tPicker = new TimePicker();
                        args.putString("sel_time",timeFormat.format(courseDateTime));
                        tPicker.setArguments(args);
                        tPicker.show(getFragmentManager(), "time_picker");
                    }
                }
        );
        course_day= (Button) findViewById(R.id.due_date);
        course_day.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePicker dPicker = new DatePicker();

                        // Bundle created to pass current chosen data the Dialog
                        args.putString("sel_date",dateFormat.format(courseDateTime));
                        dPicker.setArguments(args);
                        dPicker.show(getFragmentManager(),"date_picker");
                    }
                }
        );

        courseDateTime = DateConverter(course_day.getText().toString());
        save = (Button) findViewById(R.id.save_course);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewCourse.setTitle(course_title.getText().toString());
                        NewCourse.setDay(courseDateTime.getTime());
                        NewCourse.setLocation(course_location.getText().toString());
                        SQLiteDatabase database = ((App)getApplication()).getDatabase();
                        database.insert("Course",null,NewCourse.toValues());
                        finish();
                    }
                }
        );

    }

    private Date DateConverter(String date_string)
    {
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

    @Override
    public void onDaySet(android.widget.DayPicker view, int day){
        final Calendar c = Calendar.getInstance();
        c.setTime(courseDateTime);
        c.set(Calendar.DAY_OF_WEEK, day);
        courseDateTime = c.getTime();
        course_day.setText(dateFormat.format(courseDateTime));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hour, int minute){
        final Calendar c = Calendar.getInstance();
        c.setTime(courseDateTime);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        courseDateTime = c.getTime();
        course_time.setText(timeFormat.format(courseDateTime));
    }
}
