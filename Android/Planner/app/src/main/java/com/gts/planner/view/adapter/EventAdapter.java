package com.gts.planner.view.adapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gts.planner.R;
import com.gts.planner.model.Event;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {

    private Cursor eventCursor;

    public EventAdapter(SQLiteDatabase database) {
        eventCursor = database.rawQuery(
                "",
                new String[]{}
        );
    }

    @Override
    public EventHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new EventHolder(
                inflater.inflate(R.layout.item_event, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(EventHolder holder, int position) {
        if (eventCursor.moveToPosition(position)) {
            holder.initView(Event.fromCursor(eventCursor));
        }
    }

    @Override
    public int getItemCount() {
        return eventCursor.getCount();
    }

    static class EventHolder extends RecyclerView.ViewHolder {

        public EventHolder(View itemView) {
            super(itemView);
        }

        public void initView(Event event) {

        }
    }
}
