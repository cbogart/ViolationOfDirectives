package com.example.android.lnotifications;


import android.app.Notification;
import android.test.ActivityInstrumentationTestCase2;
/**
 * Created by root on 4/8/15.
 */
public class NonUIFragmentTest extends
        ActivityInstrumentationTestCase2<LNotificationActivity> {

    private LNotificationActivity mActivity;
    private NonUIFragment mFragment;

    public NonUIFragmentTest() {
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
        mFragment = (NonUIFragment) mActivity.getFragmentManager()
                .findFragmentById(R.id.container);
    }

    public void testIdAddedNonUIFragment(){
        assertTrue(mFragment!=null);
        assertTrue(mFragment.getBackgroundData().equals("sampleData"));
    }
}
