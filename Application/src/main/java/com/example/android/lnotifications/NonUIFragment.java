package com.example.android.lnotifications;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by root on 4/8/15.
 */
public class NonUIFragment extends Fragment {

    private NotificationManager mNotificationManager;

    String backgroundDataString = "sampleData";


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
        return null;
    }

    @Override
    public void onResume(){
        super.onResume();
        System.out.println("Running background fragment");

    }

    public String getBackgroundData(){
        return backgroundDataString;
    }

}
