package com.example.android.lnotifications;

import android.app.Notification;
import android.test.ActivityInstrumentationTestCase2;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by root on 4/21/15.
 */
public class AddedFragmentTest extends
        ActivityInstrumentationTestCase2<LNotificationActivity> {

    private LNotificationActivity mActivity;
    private HeadsUpNotificationFragment mFragment;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    public AddedFragmentTest() {
        super(LNotificationActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
        super.setUp();
        mActivity = getActivity();
        // The first tab should be {@link HeadsUpNotificationFragment}, that is tested in the
        // {@link LNotificationActivityTest}.
        mActivity.getActionBar().setSelectedNavigationItem(0);
        getInstrumentation().waitForIdleSync();
        mFragment = (AddedFragment) mActivity.getFragmentManager()
                .findFragmentById(R.id.container);

    }


    public void testOnContextItemSelected() {
        mActivity.getMenuInflater().inflate(R.menu.context_menu, null);
        MenuItem item = (MenuItem)mActivity.findViewById(R.id.create_new);
        assertTrue(item!=null);
        mFragment.onContextItemSelected(item);
        Toast.makeText(mActivity.getApplicationContext(),outContent.toString(),Toast.LENGTH_LONG);
        try{
            Thread.sleep(8000);
        }catch(Exception e){

        }
    }

    @Override
    public void tearDown(){
        System.setOut(null);
    }

}
