package com.example.android.lnotifications;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by root on 4/8/15.
 */
public class NonUIFragment2 extends Fragment {

    private NotificationManager mNotificationManager;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNotificationManager = (NotificationManager) getActivity().getSystemService(Context
                .NOTIFICATION_SERVICE);
    }

    @Override
    public void onResume(){
        super.onResume();
        System.out.println("non-ui fragment 2 is running");
    }

}
