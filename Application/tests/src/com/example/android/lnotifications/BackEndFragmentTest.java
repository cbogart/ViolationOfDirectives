package com.example.android.lnotifications;

import android.app.Fragment;
import android.app.Notification;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Unit tests for {@link BackEndFragment}.
 */
public class BackEndFragmentTest extends
        ActivityInstrumentationTestCase2<LNotificationActivity> {

    private LNotificationActivity mActivity;

    public BackEndFragmentTest() {
        super(LNotificationActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        // The first tab should be {@link HeadsUpNotificationFragment}, that is tested in the
        // {@link LNotificationActivityTest}.
        mActivity.getActionBar().setSelectedNavigationItem(0);
        getInstrumentation().waitForIdleSync();
    }

    public void testGetFragmentByID(){
        Fragment f = mActivity.getFragmentManager().findFragmentById(0);
        if(f==null){
            System.out.println("found fragment is null");
        } else {
            System.out.println("found fragment's class: " + f.getClass().toString());
        }
        assertTrue(f==null);
        f = mActivity.getFragmentManager().findFragmentByTag("nonUI");
        //f.getFragmentManager().
        if(f==null){
            System.out.println("found fragment is null");
        } else {
            System.out.println("found fragment's class: " + f.getClass().toString());
        }
        assertTrue(f.getClass().equals(BackEndFragment.class));

    }

    // If Mockito can be used, mock the NotificationManager and tests Notifications are actually
    // created.
}
