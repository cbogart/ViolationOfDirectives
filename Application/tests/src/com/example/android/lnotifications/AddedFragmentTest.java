package com.example.android.lnotifications;

import android.test.ActivityInstrumentationTestCase2;
/**
 * Created by root on 4/18/15.
 */
public class AddedFragmentTest extends
        ActivityInstrumentationTestCase2<LNotificationActivity> {

private LNotificationActivity mActivity;
private AddedFragment mFragment;

public AddedFragmentTest() {
        super(LNotificationActivity.class);
        }

@Override
protected void setUp() throws Exception {
        super.setUp();
        mActivity = getActivity();
        mFragment = (AddedFragment)mActivity.getFragmentManager().findFragmentById(R.id.container);

        }

public void testFragmentDisplayed(){
    assertTrue(mFragment!=null);
     assertTrue(!mFragment.isVisible());
  }
}
