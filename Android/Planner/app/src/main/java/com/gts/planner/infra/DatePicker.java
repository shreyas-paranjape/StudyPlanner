package com.gts.planner.infra;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;

import com.gts.planner.controller.AddTaskActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by 7408588 on 7/14/2017.
 */

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    private DateSelectListener listener;
    private DatePickerDialog dialog;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        listener = (DateSelectListener) getActivity();
        final Calendar c = Calendar.getInstance();
        try {
            c.setTime(formatter.parse(getArguments().getString("sel_date")));
        } catch (ParseException e) {
           // do nothing
        }
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return dialog = new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
        listener.onDateSet(view,year,month,dayOfMonth);
    }

    public static interface DateSelectListener {
        void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth);

        void onTimeSet(android.widget.TimePicker view, int hour, int minute);
    }

}

