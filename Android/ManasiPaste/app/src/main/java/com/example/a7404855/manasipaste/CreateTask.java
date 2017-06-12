package com.example.a7404855.manasipaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;


public class CreateTask extends AppCompatActivity {
    private Task task;

    //private List<Task> task1= MainActivity.tasks;

    private Random random = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        //get the task name from user

        final EditText etTitle = (EditText) findViewById(R.id.editText);

        Button save = (Button) findViewById(R.id.button);
        task = (Task) getIntent().getSerializableExtra("TASK");
        if (task != null)
            etTitle.setText(task.getTitle());
        else {
            task = new Task();
            task.setId(random.nextLong());
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = etTitle.getText().toString();
                task.setTitle(taskName);
                Intent intent = getIntent();
                intent.putExtra("TASK", task);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }
}
