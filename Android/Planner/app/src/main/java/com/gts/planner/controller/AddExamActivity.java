package com.gts.planner.controller;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.gts.planner.R;
import com.gts.planner.model.Exam;

/**
 * Created by 7408588 on 7/6/2017.
 */

public class AddExamActivity extends AppCompatActivity {

    private Exam NewExam = new Exam();
    private Button save ;
    private EditText exam_name;
    private EditText exam_date;
    private EditText exam_desc;
    private EditText exam_time;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exam);

        exam_name = (EditText) findViewById(R.id.exam_name);
    }
}
