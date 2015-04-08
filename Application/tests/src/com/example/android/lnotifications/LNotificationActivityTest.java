package com.example.android.lnotifications;

import android.app.Fragment;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Unit tests for {@link LNotificationActivity}.
 */
public class LNotificationActivityTest extends
        ActivityInstrumentationTestCase2<LNotificationActivity> {

    private LNotificationActivity mActivity;

    public LNotificationActivityTest() {
        super(LNotificationActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
    }

    public void testPreconditions() {
        assertNotNull(String.format("%s is null", LNotificationActivity.class.getSimpleName()),
                mActivity);
    }

    public void testFirstTabInActionBarIsHeadsUpNotificationFragment() {
        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                mActivity.getActionBar().setSelectedNavigationItem(0);
            }
        });
        getInstrumentation().waitForIdleSync();
        Fragment fragment = mActivity.getFragmentManager().findFragmentById(R.id.container);
        assertTrue(fragment instanceof HeadsUpNotificationFragment);
    }

    public void testSecondtabInActionBarIsVisibilityMetadataFragment() {
        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                mActivity.getActionBar().setSelectedNavigationItem(1);
            }
        });
        getInstrumentation().waitForIdleSync();
        Fragment fragment = mActivity.getFragmentManager().findFragmentById(R.id.container);
        assertTrue(fragment instanceof VisibilityMetadataFragment);
    }

    public void testThirdtabInActionBarIsOtherMetadataFragment() {
        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                mActivity.getActionBar().setSelectedNavigationItem(2);
            }
        });
        getInstrumentation().waitForIdleSync();
        Fragment fragment = mActivity.getFragmentManager().findFragmentById(R.id.container);
        assertTrue(fragment instanceof OtherMetadataFragment);
    }

    public void testSameFragmentTags(){
        Fragment f = mActivity.getFragmentManager().findFragmentByTag("testTag");
        assertTrue(f instanceof NonUIFragment1);
    }
}
