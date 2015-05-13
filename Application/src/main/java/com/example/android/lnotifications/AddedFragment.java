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
 * Created by root on 5/12/15.
 */
public class AddedFragment extends Fragment {
        CharSequence mLabel;

        /**
         * Create a new instance of MyFragment that will be initialized
         * with the given arguments.
         */
        static AddedFragment newInstance(CharSequence label) {
            AddedFragment f = new AddedFragment();
            /*Bundle b = new Bundle();
            b.putCharSequence("label", label);
            f.setArguments(b);*/
            return f;
        }

        /**
         * Parse attributes during inflation from a view hierarchy into the
         * arguments we handle.
         */
        @Override public void onInflate(Activity activity, AttributeSet attrs,
                                        Bundle savedInstanceState) {
            super.onInflate(activity, attrs, savedInstanceState);

            System.out.println("!!!In onInflate!!!");

            TypedArray a = activity.obtainStyledAttributes(attrs,
                    R.styleable.AddedFragment);
            mLabel = a.getText(R.styleable.AddedFragment_label);
            a.recycle();

            //D_FRG_51 - should only extract agruments in onInflate
            getActivity().getActionBar().setTitle("The title for the action bar");
        }

        /**
         * During creation, if arguments have been supplied to the fragment
         * then parse those out.
         */
        @Override public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            /*Bundle args = getArguments();
            if (args != null) {
                mLabel = args.getCharSequence("label", mLabel);
            }*/

        }

        /**
         * Create the view for this fragment, using the arguments given to it.
         */
        @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                           Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_other_metadata, container, false);
            /*View tv = v.findViewById(R.id.text);
            ((TextView)tv).setText(mLabel != null ? mLabel : "(no label)");
            tv.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.gallery_thumb));*/
            return v;
        }
}
