package com.example.android.lnotifications;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by root on 4/21/15.
 */
public class AddedFragment extends HeadsUpNotificationFragment{


    public static AddedFragment newInstance() {
        AddedFragment fragment = new AddedFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        System.out.println("context item was selected (AddedFragment)!!!!!");
        //D_FRG_045 - fragment should call parent's onContextItemSelected
        //super.onContextItemSelected(item);
        return false;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerForContextMenu(view);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
}
