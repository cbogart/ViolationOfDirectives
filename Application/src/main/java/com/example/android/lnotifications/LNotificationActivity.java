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
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//import com.android.documentsui.*;

/**
 * Launcher Activity for the L Notification samples application.
 */
public class LNotificationActivity extends Activity {
    private TextView tv;
    //private FileOperations fileop;
    private String[] file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_notification);
        setTitle(R.string.title_lnotification_activity);
        ActionBar actionBar = getActionBar();

        // Use ViewPager in the support library where possible.
        // At this time, the support library for L is not ready so using the deprecated method
        // to create tabs.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.Tab tabHeadsUpNotification = actionBar.newTab().setText("Heads Up");
        ActionBar.Tab tabVisibilityMetadata = actionBar.newTab().setText("Visibility");
        ActionBar.Tab tabOtherMetadata = actionBar.newTab().setText("Others");
        tabHeadsUpNotification.setTabListener(new FragmentTabListener(HeadsUpNotificationFragment
                .newInstance()));
        tabVisibilityMetadata.setTabListener(new FragmentTabListener(VisibilityMetadataFragment
                .newInstance()));
        tabOtherMetadata.setTabListener(new FragmentTabListener(OtherMetadataFragment.newInstance
                ()));
        actionBar.addTab(tabHeadsUpNotification, 0);
        actionBar.addTab(tabVisibilityMetadata, 1);
        actionBar.addTab(tabOtherMetadata, 2);
        */

        //code below here taken from https://stackoverflow.com/questions/9280965/arrayadapter-requires-the-resource-id-to-be-a-textview-xml-problems
        //this.fileop = new FileOperations();
        //this.file = fileop.ReadFileAsList("Installed_packages.txt");
        //setContentView(R.layout.failing_view);
        //tv = (TextView) findViewById(R.id.TextView01);
        ListView lv = new ListView(this);
        lv.setTextFilterEnabled(true);
        //lv.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, this.file));
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, R.layout.failing_view);
        //ArrayAdapter<String> a = new ArrayAdapter<String>(this, R.layout.simple_text_view);
        //ArrayAdapter<String> a = new ArrayAdapter<String>(this, R.id.TextView01);
        lv.setAdapter(a);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });
        //setContentView(lv);
        //a.add(lv);
        a.add("Test string");
        Log.d("debug info", "a count: "+a.getCount());
        a.getView(0,null, lv);
    }

    /**
     * TabListener that replaces a Fragment when a tab is clicked.
     */
    private static class FragmentTabListener implements ActionBar.TabListener {
        public Fragment fragment;

        public FragmentTabListener(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            //do nothing.
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.container, fragment);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }
    }
}
