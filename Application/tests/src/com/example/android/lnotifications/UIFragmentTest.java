package com.example.android.lnotifications;

import android.app.Fragment;
import android.app.Notification;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by root on 4/8/15.
 */
public class UIFragmentTest extends
        ActivityInstrumentationTestCase2<LNotificationActivity> {

    private LNotificationActivity mActivity;
    private UIFragment mFragment;

    public UIFragmentTest() {
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
        mFragment = (UIFragment) mActivity.getFragmentManager()
                .findFragmentByTag("sampleFragment");
        //.findFragmentById(R.id.container);
    }

    public void testFragmentIsVisible() {
        assertTrue(mFragment!=null);
        assertTrue(mFragment.getView().isShown());
        //assertTrue(mFragment.isVisible());
    }
}
