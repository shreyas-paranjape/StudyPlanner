package com.list.listview;

import android.app.ActivityManager;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 7405148 on 6/1/2017.
 */

public class TodoListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Todo> mTodo;

    //constructor


    public TodoListAdapter(Context mContext, List<Todo> mTodo) {
        this.mContext = mContext;
        this.mTodo = mTodo;
    }

    @Override
    public int getCount() {
        return mTodo.size();
    }

    @Override
    public Object getItem(int position) {
        return mTodo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.schedule, null);
        TextView TaskName = (TextView) v.findViewById(R.id.name);
        TextView TaskTime = (TextView) v.findViewById(R.id.time);
        TextView TaskLocation = (TextView) v.findViewById(R.id.location);
        TextView TaskDescription = (TextView) v.findViewById(R.id.description);


        //set text for Text View
        TaskName.setText(mTodo.get(position).getTaskName());
        TaskTime.setText(mTodo.get(position).getTime());
        TaskLocation.setText(mTodo.get(position).getLocation());
        TaskDescription.setText(mTodo.get(position).getDescription());

        //save the task
        v.setTag(mTodo.get(position).getTaskName());

        return v;
    }
}
