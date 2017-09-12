package com.example.android.lnotifications;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by root on 7/8/15.
 */
public class TimeSelectionFragment extends  Fragment{
    

    private NotificationManager mNotificationManager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NotificationFragment.
     */
    public static TimeSelectionFragment newInstance() {
        TimeSelectionFragment fragment = new TimeSelectionFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    public TimeSelectionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNotificationManager = (NotificationManager) getActivity().getSystemService(Context
                .NOTIFICATION_SERVICE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_selection, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView descriptionView = (TextView)view.findViewById(R.id.time_select_text);
        descriptionView.setText(getArguments().getCharSequence("description"));
        Button timeButton = (Button) view.findViewById(R.id.time_select_button);
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment tpf = new TimePickerFragment();
                tpf.setTimeSelectionFragment(TimeSelectionFragment.this);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                tpf.show(ft, "selectTimeDialog");

            }
        });
    }

    public void setButtonText(String text){
        ((Button)getView().findViewById(R.id.time_select_button)).setText(text);
    }

    public String getButtonText(){
        return (String)((Button)getView().findViewById(R.id.time_select_button)).getText();
    }

}
