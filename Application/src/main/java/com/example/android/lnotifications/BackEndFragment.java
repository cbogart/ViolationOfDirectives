package com.example.android.lnotifications;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by root on 4/7/15.
 */
public class BackEndFragment extends Fragment {

    @Override
    public void onCreate(Bundle b){
       super.onCreate(b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity(), "non-ui fragment id: " + Integer.toString(this.getId()), Toast.LENGTH_LONG).show();
        // A non UI fragment
        return null;
    }

    @Override
    public void onResume(){
        super.onResume();
        System.out.println("Backend is still alive");
    }
}
