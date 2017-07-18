package com.gts.planner.controller;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gts.planner.App;
import com.gts.planner.R;
import com.gts.planner.model.Exam;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddExamActivity extends AppCompatActivity {

    private Exam NewExam = new Exam();
    private Button save ;
    private EditText exam_name;
    private EditText exam_date;
    private EditText exam_desc;
    private EditText exam_time;
    private Date ExamDate;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);

        exam_name = (EditText) findViewById(R.id.exam_name);
        exam_date= (EditText) findViewById(R.id.due_date);
        exam_desc = (EditText) findViewById(R.id.desc_exam);
        exam_time =(EditText) findViewById(R.id.due_time);
        ExamDate = DateConverter(exam_date.getText().toString());
        save = (Button) findViewById(R.id.save_exam);
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        NewExam.setPaper(exam_name.getText().toString());
                        NewExam.setsDate(ExamDate.getTime());
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date convertedDate = new Date();
        try {
            convertedDate = dateFormat.parse(date_string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return convertedDate;
    }

}
