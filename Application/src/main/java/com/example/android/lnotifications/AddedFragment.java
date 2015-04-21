package com.example.android.lnotifications;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by root on 4/20/15.
 */
public class AddedFragment extends Fragment {

    CharSequence mLabel;

    /**
     * Create a new instance of MyFragment that will be initialized
     * with the given arguments.
     */
    static AddedFragment newInstance(CharSequence label) {
        AddedFragment f = new AddedFragment();
        Bundle b = new Bundle();
        b.putCharSequence("label", label);
        f.setArguments(b);
        return f;
    }

    /**
     * Parse attributes during inflation from a view hierarchy into the
     * arguments we handle.
     */
    @Override public void onInflate(Activity activity, AttributeSet attrs,
                                    Bundle savedInstanceState) {
        System.out.println("Added Fragment: "+this.isAdded()+"!!!!!!!!!!!!!!!!!!!!!");
        super.onInflate(activity, attrs, savedInstanceState);

        TypedArray a = activity.obtainStyledAttributes(attrs,
                R.styleable.FragmentArguments);
        //mLabel = a.getText(R.styleable.FragmentArguments_android_label);
        mLabel = "Crazy Label";
        a.recycle();
        //not sure how to make a test for this because we need this statement to
        //occur at a specific time in the app initializaion, not after the
        //app has already been initialized.
        //D_FRG_037 - testing that fragment is not attached to activity yetgt
        if(!this.isAdded()){

            throw new RuntimeException("the fragment was not attached to the activity in onInflate");
        }
    }

    /**
     * During creation, if arguments have been supplied to the fragment
     * then parse those out.
     */
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            mLabel = args.getCharSequence("label", mLabel);
        }
    }

    /**
     * Create the view for this fragment, using the arguments given to it.
     */
    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hello_world, container, false);
        View tv = v.findViewById(R.id.text);
        ((TextView)tv).setText(mLabel != null ? mLabel : "(no label)");
        tv.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));
        return v;
    }
}
