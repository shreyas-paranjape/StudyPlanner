package com.gts.planner.model;

import android.database.Cursor;

public class Event {

    public static Event fromCursor(Cursor eventCursor) {
        return new Event();
    }
}
