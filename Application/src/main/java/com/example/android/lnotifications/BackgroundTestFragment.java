package com.example.android.lnotifications;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

//problem taken from https://stackoverflow.com/questions/47723082/fragment-illegalstatexception-on-getresources

//might later need to expand either this example or the checker to handle other ways the Fragment can
//be in the background (https://developer.android.com/reference/android/os/AsyncTask) AsyncTasks should
// ideally be used for short operations (a few seconds at the most.) If you need to keep threads running
// for long periods of time, it is highly recommended you use the various APIs provided by the
// java.util.concurrent package such as Executor, ThreadPoolExecutor and FutureTask.

//the question and answer in this case is vague enough that I'm not sure what the correct answer
//should be for this example

public class BackgroundTestFragment extends Fragment {
    private class ResourcesTask extends AsyncTask<Object, Object, String>{

        @Override
        protected String doInBackground(Object... voids) {
            Log.i("Background Info","in doInBackground of ResourcesTask");
            //BackgroundTestFragment.this.getResources();
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            Log.i("Background Info","in onPostExecute of ResourcesTask");
            BackgroundTestFragment.this.getResources();
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
