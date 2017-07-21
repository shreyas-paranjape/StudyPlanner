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
import com.gts.planner.model.Exam;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddExamActivity extends AppCompatActivity implements DatePicker.DateSelectListener,
        TimePicker.TimeSelectListener {

    private Exam NewExam = new Exam();
    private Button save ;
    private EditText exam_name;
    private Button exam_date;
    private EditText exam_desc;
    private Button exam_time;
    private Date ExamDateTime;
    Bundle args = new Bundle();



    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);

        exam_name = (EditText) findViewById(R.id.exam_name);
        exam_desc = (EditText) findViewById(R.id.desc_exam);
        exam_time =(Button) findViewById(R.id.due_time);
        exam_time.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePicker tPicker = new TimePicker();
                        args.putString("sel_time",timeFormat.format(ExamDateTime));
                        tPicker.setArguments(args);
                        tPicker.show(getFragmentManager(), "time_picker");
                    }
                }
        );
        exam_date= (Button) findViewById(R.id.due_date);
        exam_date.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePicker dPicker = new DatePicker();

                        // Bundle created to pass current chosen data the Dialog
                        args.putString("sel_date",dateFormat.format(ExamDateTime));
                        dPicker.setArguments(args);
                        dPicker.show(getFragmentManager(),"date_picker");
                    }
                }
        );

        ExamDateTime = DateConverter(exam_date.getText().toString());
        save = (Button) findViewById(R.id.save_exam);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewExam.setPaper(exam_name.getText().toString());
                        NewExam.setsDate(ExamDateTime.getTime());
                        NewExam.setExamDesc(exam_desc.getText().toString());
                        SQLiteDatabase database = ((App)getApplication()).getDatabase();
                        database.insert("Exam",null,NewExam.toValues());
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
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth){
       final Calendar c = Calendar.getInstance();
        c.setTime(ExamDateTime);
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        ExamDateTime = c.getTime();
        exam_date.setText(dateFormat.format(ExamDateTime));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hour, int minute){
        final Calendar c = Calendar.getInstance();
        c.setTime(ExamDateTime);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        ExamDateTime = c.getTime();
        exam_time.setText(timeFormat.format(ExamDateTime));
    }
}
