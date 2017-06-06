package com.example.a7404855.manasipaste;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class TaskAdapter extends ArrayAdapter<Task> {

    private List<Task> tasks = MainActivity.tasks ;


    TaskAdapter(Context context, List<Task> tasks) {
        super(context,R.layout.activity_main, tasks);
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") View customView = inflater.inflate(R.layout.item_task, parent, false);

        Task item = getItem(position);
        TextView taskname = (TextView) customView.findViewById(R.id.textView);
        assert item != null;
        taskname.setText(item.getTitle());
        return customView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

}
