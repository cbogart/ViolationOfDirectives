package com.example.android.lnotifications;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

public class BackgroundTestFragment extends Fragment {
    private class ResourcesTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            Log.i("Background Info","in doInBackground of ResourcesTask");
            BackgroundTestFragment.this.getResources();
            return new Object();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        Log.i("Background Info", "in BackgroundTestFragment onCreate");
        super.onCreate(savedInstanceState);
        ResourcesTask r = new ResourcesTask();
        r.execute();
    }
}
