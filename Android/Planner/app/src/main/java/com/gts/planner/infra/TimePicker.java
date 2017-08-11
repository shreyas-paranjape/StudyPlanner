package com.gts.planner.infra;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by 7408588 on 7/20/2017.
 */

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    private SimpleDateFormat formatter = new SimpleDateFormat("hh:mm aa", Locale.getDefault());

    TimePickerDialog dialog;
    TimeSelectListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        listener = (TimeSelectListener) getActivity();

        final Calendar c = Calendar.getInstance();
        try {
            c.setTime(formatter.parse(getArguments().getString("sel_time")));
        } catch (ParseException e) {
            // do nothing
        }
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return dialog = new TimePickerDialog(getActivity(),this,hour, minute, false );
    }
    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        listener.onTimeSet(view, hourOfDay, minute);
    }

    public static interface TimeSelectListener{
      void onTimeSet(android.widget.TimePicker view, int hour, int minute);
    }
}
