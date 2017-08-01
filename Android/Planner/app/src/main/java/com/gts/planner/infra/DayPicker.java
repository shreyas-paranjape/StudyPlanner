package com.gts.planner.infra;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
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
    private Bundle data; // A heap of data to be passed into the parent Activity
    private String[] days_of_the_week = {"Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday"}; // Array containing the days of the week

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        data = getArguments();


        // Catching for NullPointer Exception
      try{
          mSelectedDays = data.getStringArrayList("days");
      } catch(NullPointerException e){
          mSelectedDays = new ArrayList();
      }



        //creating the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //setting the dialog title text
        builder.setTitle("Pick the days on which you have the class!");

        builder.setMultiChoiceItems(days_of_the_week, null,
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
            }
        });

         builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // do nothing
            }
        });



        return builder.create();
    }
}