package com.gts.planner.infra;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import android.widget.DatePicker;

import com.gts.planner.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;



public class DayPicker extends DialogFragment{


    private ArrayList mSelectedDays; // The array that stores the selected days
    private ArrayList mLastSavedState;
    private Bundle data; // A heap of data to be passed into the parent Activity
    private String[] days_of_the_week = {"Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday"}; // Array containing the days of the week
    private boolean[] selected_days = {false,false,false,false,false};

    DayPickerListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        data = getArguments();
        mSelectedDays = new ArrayList();

        // Catching for NullPointer Exception
      try{
          mLastSavedState = data.getStringArrayList("days");
      } catch(NullPointerException e){
          mLastSavedState = new ArrayList();
      }

        SelectionChecker(mLastSavedState, selected_days);

        //creating the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //setting the dialog title text
        builder.setTitle("Pick the days on which you have the class!");

        builder.setMultiChoiceItems(days_of_the_week, selected_days,
                        new DialogInterface.OnMultiChoiceClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedDays.add(which);
                                } else if (mSelectedDays.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedDays.remove(Integer.valueOf(which));
                                }
                           }

    });

        //setting action buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //putting the chosen dates into a bundle
                data.putStringArrayList("days", mSelectedDays);
                mLastSavedState = mSelectedDays;
                Intent intent = new Intent();
                intent.putExtra("data", data);
                listener.onDialogPositiveClick(DayPicker.this);
            }
        });

         builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                mSelectedDays.clear();
                listener.onDialogNegativeClick(DayPicker.this);
            }
        });

        return builder.create();
    }


    private void SelectionChecker(ArrayList SelectedDays, boolean[] selected_days) {
       if(SelectedDays.indexOf(0) >= 0 )
           selected_days[0]= true;
        if(SelectedDays.indexOf(1) >= 0)
            selected_days[1] = true;
        if(SelectedDays.indexOf(2) >= 0)
            selected_days[2] = true;
        if(SelectedDays.indexOf(3) >= 0)
            selected_days[3] = true;
        if(SelectedDays.indexOf(4) >= 0)
            selected_days[4] = true;
        return;
    }

    public static interface DayPickerListener{
        void onDialogPositiveClick(DialogFragment dialog);
        void onDialogNegativeClick(DialogFragment dialog);
    }


    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (DayPickerListener) activity;
        } catch (ClassCastException e){}
    }

}