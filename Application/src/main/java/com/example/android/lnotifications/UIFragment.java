package com.example.android.lnotifications;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by root on 4/8/15.
 */
public class UIFragment extends Fragment {


    private NotificationManager mNotificationManager;

    /**
     * Button to show a notification.
     */
    private Button mShowNotificationButton;

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
        //return inflater.inflate(R.layout.fragment_heads_up_notification, container, false);
        return inflater.inflate(R.layout.fragment_ui, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mShowNotificationButton = (Button) view.findViewById(R.id.test_ui_button);
        mShowNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mNotificationManager.notify(NOTIFICATION_ID, createNotification(
                 //       mUseHeadsUpCheckbox.isChecked()));
                Toast.makeText(getActivity(), "UI Fragment clicked", Toast.LENGTH_SHORT).show();
            }
        });
        //mUseHeadsUpCheckbox = (CheckBox) view.findViewById(R.id.use_heads_up_checkbox);
    }
}
