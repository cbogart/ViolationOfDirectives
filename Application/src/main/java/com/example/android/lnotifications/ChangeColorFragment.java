/*
* Copyright 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.lnotifications;

import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * This fragment changes the color of the HeadsUpNotification Tab Button.  If the
 * button is pressed in this fragment before accessing HeadsUpFragment, then the
 * HeadsUpFragment button will be green.  If HeadsUpFragments is clicked first, then
 * the button will start out gray.  If the user then transitions back to this
 * fragment and clicks the change color button, the application will crash.
 * Fix this bug!
 */
public class ChangeColorFragment extends Fragment {

    /**
     * NotificationId used for the notifications from this Fragment.
     */
    private static final int NOTIFICATION_ID = 1;


    /**
     * Button to change the color of another button.
     */
    private Button changeColorButton;



    private int buttonColor = 0;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment NotificationFragment.
     */
    public static ChangeColorFragment newInstance() {
        ChangeColorFragment fragment = new ChangeColorFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    public ChangeColorFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("Inflating change color fragment");
        return inflater.inflate(R.layout.fragment_change_color, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeColorButton = (Button) view.findViewById(R.id.change_color_button);
        changeColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HeadsUpNotificationFragment headsUpNotificationFragment = ((LNotificationActivity) getActivity()).getHeadsUpNotificationFragment();
                Bundle colorArgs = new Bundle();
                colorArgs.putInt("ButtonColor", Color.GREEN);
                headsUpNotificationFragment.setArguments(colorArgs);
            }
        });
    }

    /**
     * Creates a new notification depending on the argument.
     *
     * @param makeHeadsUpNotification A boolean value to indicating whether a notification will be
     *                                created as a heads-up notification or not.
     *                                <ul>
     *                                <li>true : Creates a heads-up notification.</li>
     *                                <li>false : Creates a non-heads-up notification.</li>
     *                                </ul>
     *
     * @return A Notification instance.
     */
    //@VisibleForTesting
    Notification createNotification(boolean makeHeadsUpNotification) {
        Notification.Builder notificationBuilder = new Notification.Builder(getActivity())
                .setSmallIcon(R.drawable.ic_launcher_notification)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setCategory(Notification.CATEGORY_MESSAGE)
                .setContentTitle("Sample Notification")
                .setContentText("This is a normal notification.");
        if (makeHeadsUpNotification) {
            Intent push = new Intent();
            push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            push.setClass(getActivity(), LNotificationActivity.class);

            PendingIntent fullScreenPendingIntent = PendingIntent.getActivity(getActivity(), 0,
                    push, PendingIntent.FLAG_CANCEL_CURRENT);
            notificationBuilder
                    .setContentText("Heads-Up Notification on Android L or above.")
                    .setFullScreenIntent(fullScreenPendingIntent, true);
        }
        return notificationBuilder.build();
    }

}