package com.example.a7404855.manasipaste;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

class TaskAdapter extends ArrayAdapter<Task> {

    private List<Task> tasks;


    TaskAdapter(Context context, List<Task> tasks) {
        super(context,R.layout.activity_main);
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") View customView = inflater.inflate(R.layout.item_task, parent, false);

        final Task item = tasks.get(position);
        final TextView taskname = (TextView) customView.findViewById(R.id.textView);
        Button edit = (Button) customView.findViewById(R.id.edit1);

        taskname.setText(item.getTitle());
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), CreateTask.class);
                intent.putExtra("TASK", item);
                ((Activity)getContext()).startActivityForResult(intent,998);
            }
        });
        return customView;

    }

    @Override
    public int getCount() {
        return tasks.size();
    }

}
