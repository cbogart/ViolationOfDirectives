package com.example.android.lnotifications;

import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;

import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

import java.lang.reflect.Constructor;

/**
 * Created by ZFC on 5/23/2017.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest({ContextMenu.class, View.class, ContextMenu.ContextMenuInfo.class, MenuItem.class}) //, com.android.internal.view.menu.ContextMenuBuilder.class})
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
        //ContextMenu menu = PowerMock.createMock(ContextMenu.class);
        /*MenuItem menuItem = PowerMock.createMock(MenuItem.class);
        menu.add(EasyMock.anyInt(),EasyMock.anyInt(),EasyMock.anyInt(),EasyMock.anyObject(CharSequence.class));
        EasyMock.expect(menuItem.setChecked(EasyMock.anyBoolean())).andReturn(menuItem);
        EasyMock.expect(menuItem.setVisible(EasyMock.anyBoolean())).andReturn(menuItem);
        EasyMock.expect(menuItem.setEnabled(EasyMock.anyBoolean())).andReturn(menuItem);
        EasyMock.expect(menuItem.setCheckable(EasyMock.anyBoolean())).andReturn(menuItem);
        EasyMock.expect(menuItem.setTitleCondensed(EasyMock.anyObject(CharSequence.class))).andReturn(menuItem);
        EasyMock.expect(menuItem.setIcon(EasyMock.anyInt())).andReturn(menuItem);
        EasyMock.expect(menuItem.setAlphabeticShortcut(EasyMock.anyChar())).andReturn(menuItem);
        EasyMock.expect(menuItem.setNumericShortcut(EasyMock.anyChar())).andReturn(menuItem);
        EasyMock.expect(menuItem.setChecked(EasyMock.anyBoolean())).andReturn(menuItem);
        EasyMock.expect(menuItem.setVisible(EasyMock.anyBoolean())).andReturn(menuItem);
        EasyMock.expect(menuItem.setEnabled(EasyMock.anyBoolean())).andReturn(menuItem);
        EasyMock.expect(menuItem.setCheckable(EasyMock.anyBoolean())).andReturn(menuItem);
        EasyMock.expect(menuItem.setTitleCondensed(EasyMock.anyObject(CharSequence.class))).andReturn(menuItem);
        EasyMock.expect(menuItem.setIcon(EasyMock.anyInt())).andReturn(menuItem);
        EasyMock.expect(menuItem.setAlphabeticShortcut(EasyMock.anyChar())).andReturn(menuItem);
        EasyMock.expect(menuItem.setNumericShortcut(EasyMock.anyChar())).andReturn(menuItem);EasyMock.replay(menuItem);
        EasyMock.expect(menu.add(EasyMock.anyInt(),EasyMock.anyInt(),EasyMock.anyInt(),EasyMock.anyObject(CharSequence.class))).andReturn(menuItem);
        EasyMock.expect(menu.add(EasyMock.anyInt(),EasyMock.anyInt(),EasyMock.anyInt(),EasyMock.anyObject(CharSequence.class))).andReturn(menuItem);


        //you have to call replay to activate the expect method
        EasyMock.replay(menu);
        System.out.println(menu.getClass().toString());
        System.out.println("!!!!");
        */
       // View v = PowerMock.createMock(View.class);
        //ContextMenu.ContextMenuInfo menuInfo = PowerMock.createMock(ContextMenu.ContextMenuInfo.class);
        ContextMenu menu = null;
        try {
            Class<?> cl = Class.forName("com.android.internal.view.menu.ContextMenuBuilder");
            Constructor cons = cl.getConstructor(Context.class);
            Object menuObj = cons.newInstance(mFragment.getActivity().getApplicationContext());
            menu = (ContextMenu)menuObj;
        }
        catch(Exception e) {

        }
        View v = null;
        ContextMenu.ContextMenuInfo menuInfo = null;
        assertEquals(menu.size(),0);
        mFragment.onCreateContextMenu(menu, v, menuInfo);
        assertFalse(menu.size() == 0);

    }
}
