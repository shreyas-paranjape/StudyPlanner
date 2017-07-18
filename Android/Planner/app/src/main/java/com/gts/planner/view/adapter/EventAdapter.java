package com.gts.planner.view.adapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.sip.SipAudioCall;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.gts.planner.R;
import com.gts.planner.model.Event;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {

    private Cursor eventCursor;

    public EventAdapter(SQLiteDatabase database) {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.HOUR_OF_DAY,1);
        tomorrow.add(Calendar.MINUTE,1);
        tomorrow.add(Calendar.SECOND,1);
        tomorrow.add(Calendar.MILLISECOND,1);


        eventCursor = database.rawQuery(
                "select title from Task where DueDate between " + today.getTime().getTime() +
                        " AND " + tomorrow.getTime().getTime() +
                " UNION select paper from Exam where sDate BETWEEN  " + today.getTime().getTime() +
                        " AND "+ tomorrow.getTime().getTime()+
                " UNION select title from Course where sDate between " + today.getTime().getTime()
                +" AND " + tomorrow.getTime().getTime(),
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
