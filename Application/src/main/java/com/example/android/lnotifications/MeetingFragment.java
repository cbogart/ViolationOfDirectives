package com.example.android.lnotifications;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by root on 7/8/15.
 */
public class MeetingFragment extends Fragment{


    private boolean initializeButtons = false;

    private NotificationManager mNotificationManager;

    /**
     * Button to confirm the meeting time
     */
    private Button confirmMeetingButton;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NotificationFragment.
     */
    public static MeetingFragment newInstance() {
        MeetingFragment fragment = new MeetingFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    public MeetingFragment() {
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
        return inflater.inflate(R.layout.fragment_meeting, container, false);
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(!initializeButtons) {
            addButtonToLayout("Start time:");
            addButtonToLayout("End time:");
            initializeButtons = true;
        }
            confirmMeetingButton = (Button) view.findViewById(R.id.meeting_button);
            confirmMeetingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view2) {
                    TimeSelectionFragment startPicker = (TimeSelectionFragment) getFragmentManager().findFragmentByTag("Start time:");
                    TimeSelectionFragment endPicker = (TimeSelectionFragment) getFragmentManager().findFragmentByTag("End time:");
                    String meetingStartTime = startPicker.getButtonText();
                    String meetingEndTime = endPicker.getButtonText();
                    String displayString = "Meeting set from: " + meetingStartTime + " to " + meetingEndTime;
                    Toast.makeText(getActivity(), displayString, Toast.LENGTH_SHORT).show();
                }
            });

    }

    public void addButtonToLayout(String buttonText){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        TimeSelectionFragment tsf = new TimeSelectionFragment();
        Bundle args = new Bundle();
        args.putCharSequence("description", buttonText);
        tsf.setArguments(args);
        ft.add(R.id.meeting_layout, tsf, buttonText);
        ft.commit();
    }

    @Override
    public void onDetach(){
        initializeButtons = false;
        super.onDetach();
    }

}
