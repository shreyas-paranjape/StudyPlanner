package com.gts.sqlitetutorial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    private final Cursor cursor;

    public TaskAdapter(SQLiteDatabase database) {
        cursor = database.rawQuery(
                "select * from task",
                new String[]{}
        );
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new TaskHolder(
                inflater.inflate(R.layout.item_task, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(TaskHolder holder, int position) {
        if (cursor.moveToPosition(position)) {
            Task task = Task.fromCursor(cursor);
            holder.initView(task);
        }
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    static class TaskHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;

        public TaskHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }

        public void initView(Task task) {
            tvTitle.setText(task.getTitle());
        }
    }
}
