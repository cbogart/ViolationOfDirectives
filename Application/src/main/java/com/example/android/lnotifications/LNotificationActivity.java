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

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

/**
 * Launcher Activity for the L Notification samples application.
 */
public class LNotificationActivity extends Activity {

    private HeadsUpNotificationFragment headsUpNotificationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        setTitle(R.string.title_lnotification_activity);
        ActionBar actionBar = getActionBar();

        // Use ViewPager in the support library where possible.
        // At this time, the support library for L is not ready so using the deprecated method
        // to create tabs.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab changeColorNotification = actionBar.newTab().setText("Change Color");
        ActionBar.Tab tabHeadsUpNotification = actionBar.newTab().setText("Heads Up");
        ActionBar.Tab tabVisibilityMetadata = actionBar.newTab().setText("Visibility");
        ActionBar.Tab tabOtherMetadata = actionBar.newTab().setText("Others");
        changeColorNotification.setTabListener(new FragmentTabListener(this,ChangeColorFragment
                .newInstance(), "visibility"));
        headsUpNotificationFragment = HeadsUpNotificationFragment.newInstance();

        tabHeadsUpNotification.setTabListener(new FragmentTabListener(this,headsUpNotificationFragment,
                "heads up"));
        tabVisibilityMetadata.setTabListener(new FragmentTabListener(this,VisibilityMetadataFragment
                .newInstance(), "visibility"));
        tabOtherMetadata.setTabListener(new FragmentTabListener(this,OtherMetadataFragment.newInstance
                (),"others"));
        actionBar.addTab(changeColorNotification, 0);
        actionBar.addTab(tabHeadsUpNotification, 1);
        actionBar.addTab(tabVisibilityMetadata, 2);
        actionBar.addTab(tabOtherMetadata, 3);
    }

    public HeadsUpNotificationFragment getHeadsUpNotificationFragment(){
        return headsUpNotificationFragment;
    }

    /**
     * TabListener that replaces a Fragment when a tab is clicked.
     */
    private static class FragmentTabListener implements ActionBar.TabListener {
        public Activity activity;
        public Fragment fragment;
        public String tag;

        public FragmentTabListener(Activity activity, Fragment fragment, String tag) {
            this.activity = activity;
            this.fragment = fragment;
            this.tag = tag;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            //do nothing.
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            
            if (fragment == null) {

                fragment = Fragment.instantiate(activity, fragment.getClass().getName());

                ft.add(R.id.container, fragment, tag);
                System.out.println("adding fragment");

            } else {
                System.out.println("attaching fragment");
                if(fragment.getView()==null) {
                    ft.add(R.id.container, fragment, tag);
                }
                else {
                    ft.show(fragment);

                }
            }
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.hide(fragment);
        }
    }
}
