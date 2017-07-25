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
import android.widget.TextView;

import com.gts.planner.R;
import com.gts.planner.model.Event;
import com.gts.planner.model.Task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventHolder> {

    private Cursor eventCursor;
    private SQLiteDatabase database;

    public EventAdapter(SQLiteDatabase database) {
        this.database = database;

        eventCursor = database.rawQuery(query(),
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
            Task task =Task.fromCursor(eventCursor);
            holder.initView(task);
        }
    }
    public String query(){
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        Calendar tomorrow = Calendar.getInstance();
<<<<<<< HEAD
        tomorrow.add(Calendar.HOUR_OF_DAY,1);

        String q = "Select * from Task";//"select title from Task where DueDate between " + today.getTime().getTime() +
                //" AND " + tomorrow.getTime().getTime() ;
=======
        tomorrow.add(Calendar.DAY_OF_MONTH,1);
        tomorrow.set(Calendar.HOUR, 0);
        tomorrow.set(Calendar.MINUTE, 0);
        tomorrow.set(Calendar.SECOND, 0);
        tomorrow.set(Calendar.MILLISECOND, 0);
        String q = "select * from Task"; //where DueDate between " +today.getTime().getTime()+ " AND "+tomorrow.getTime().getTime();
                //+ today.getTime().getTime() +
              //  " AND " + tomorrow.getTime().getTime() ;
>>>>>>> 3cd847920121a2de908761b69f8ba4f5c1b85d93
               // " UNION select paper from Exam where sDate BETWEEN  " + today.getTime().getTime() +
               // " AND "+ tomorrow.getTime().getTime();
                //" UNION select title from Course where sDate between " + today.getTime().getTime()+" AND "
        // + tomorrow.getTime().getTime();
        return q;
    }
    public void reload(){
        eventCursor.close();
        eventCursor =   database.rawQuery( query(),
                new String[]{}
        );
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return eventCursor.getCount();
    }

    static class EventHolder extends RecyclerView.ViewHolder {
        private TextView tvtitle;
        public EventHolder(View itemView) {
            super(itemView);
            tvtitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }

        public void initView(Task task) {
            tvtitle.setText(task.getTitle());
        }
    }
}
