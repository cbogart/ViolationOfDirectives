package com.example.android.lnotifications;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.test.ActivityInstrumentationTestCase2;

/**
 * Unit tests for {@link HeadsUpNotificationFragment}.
 */
public class AddedFragmentTest extends
        ActivityInstrumentationTestCase2<LNotificationActivity> {

    private LNotificationActivity mActivity;
    private HeadsUpNotificationFragment mFragment;

    public AddedFragmentTest() {
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
        mFragment = (HeadsUpNotificationFragment) mActivity.getFragmentManager()
                .findFragmentById(R.id.container);
    }

    public void testDirective(){
        FragmentManager manager = mFragment.getFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        fragmentTransaction.remove(mFragment).commit();
        assertTrue(mFragment.getCalledOnDestory());
    }
}
