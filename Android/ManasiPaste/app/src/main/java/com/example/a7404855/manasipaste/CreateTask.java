package com.example.a7404855.manasipaste;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


public class CreateTask extends AppCompatActivity implements View.OnClickListener {
    private List<Task> task1= MainActivity.tasks;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        //get the task name from user

        Button save =(Button) findViewById(R.id.button);
        save.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {

        switch (v.getId()) {
            case R.id.button:
                EditText task =(EditText)findViewById(R.id.editText);
                String taskName= task.getText().toString();
                Task newTask = new Task();
                newTask.setTitle(taskName);
                task1.add(newTask);

                Intent out = new Intent(this, MainActivity.class);
                startActivity(out);
        }

    }


}
