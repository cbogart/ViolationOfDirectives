package com.example.android.lnotifications;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by root on 7/8/15.
 */
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener{

    private int selectedHour = 0;
    private int selectedMinute = 0;
    private TimeSelectionFragment selectFrag;


    public void setTimeSelectionFragment(TimeSelectionFragment timeSelectionFragment){
        this.selectFrag = timeSelectionFragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        selectedHour = hourOfDay;
        selectedMinute = minute;
        int hour = 0;
        if(hourOfDay > 12){
            hour = hourOfDay - 12;
        } else{
            hour = hourOfDay;
        }
        String minuteString;
        if(minute < 10){
            minuteString = "0"+String.valueOf(minute);
        }else{
            minuteString = String.valueOf(minute);
        }
        selectFrag.setButtonText(hour+":"+minuteString);
    }

    public int getSelectedHour(){
        return selectedHour;
    }

    public int getSelectedMinute(){
        return selectedMinute;
    }
}
