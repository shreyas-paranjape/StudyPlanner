package com.list.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7405148 on 6/1/2017.
 */

public class MainActivity extends Activity {

    private ListView lvTodo;
    private TodoListAdapter adapter;
    private List<Todo> mTodoList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvTodo = (ListView) findViewById(R.id.listview);

        mTodoList = new ArrayList<>();
        //Add sample data for the list
        //We can get data from DB, webservice here
        mTodoList.add(new Todo("Work", "Fomento Office Panaji, Goa",
                "Develop android App", "10: 30 am MF"));
        mTodoList.add(new Todo("Meeting", "My Office, Mountain View CA",
                "Develop android App", "10: 30 am MF"));
        mTodoList.add(new Todo("Homework", "SDSM&T Classroom building, Rapid City SD",
                "Linear Algebra", "10: 30 am MF"));
        mTodoList.add(new Todo("Work", "Fomento Office Panaji, Goa",
                "Develop android App", "10: 30 am MF"));
        mTodoList.add(new Todo("Meeting", "My Office, Mountain View CA",
                "Develop android App", "10: 30 am MF"));
        mTodoList.add(new Todo("Homework", "SDSM&T Classroom building, Rapid City SD",
                "Linear Algebra", "10: 30 am MF"));
        mTodoList.add(new Todo("Work", "Fomento Office Panaji, Goa",
                "Develop android App", "10: 30 am MF"));
        mTodoList.add(new Todo("Meeting", "My Office, Mountain View CA",
                "Develop android App", "10: 30 am MF"));
        mTodoList.add(new Todo("Homework", "SDSM&T Classroom building, Rapid City SD",
                "Linear Algebra", "10: 30 am MF"));


        //init the adapter
        adapter = new TodoListAdapter(getApplicationContext(), mTodoList);
        lvTodo.setAdapter(adapter);

        //handle clicks
        lvTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Do something
                //Ex: Display msg with task name from view.getTag
                Toast.makeText(getApplicationContext(), "Task: " + view.getTag(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
