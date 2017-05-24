package com.example.android.lnotifications;

import android.test.ActivityInstrumentationTestCase2;
import android.view.ContextMenu;
import android.view.View;

import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

/**
 * Created by ZFC on 5/23/2017.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ContextMenu.class, View.class, ContextMenu.ContextMenuInfo.class})
public class PowerMockTest extends ActivityInstrumentationTestCase2<LNotificationActivity> {

    private LNotificationActivity mActivity;
    private HeadsUpNotificationFragment mFragment;

    public PowerMockTest() {
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

    public void testOnCreateContextMenu(){
        ContextMenu menu = PowerMock.createMock(ContextMenu.class);
        System.out.println(menu.getClass().toString());
        System.out.println("!!!!");
       // View v = PowerMock.createMock(View.class);
        //ContextMenu.ContextMenuInfo menuInfo = PowerMock.createMock(ContextMenu.ContextMenuInfo.class);
        View v = null;
        ContextMenu.ContextMenuInfo menuInfo = null;
        mFragment.onCreateContextMenu(menu, v, menuInfo);
        assertEquals(2,menu.size());

    }
}
