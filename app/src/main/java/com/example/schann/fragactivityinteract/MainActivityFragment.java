package com.example.schann.fragactivityinteract;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A placeholder fragment containing a simple view.
 */

public class MainActivityFragment extends Fragment {

    OnHeadlineSelectedListener mCallback;
    EditText txt;
    TextView txtView;

    public interface OnHeadlineSelectedListener {
        public void onArticleSelected(int length);
    }

    public MainActivityFragment() {


    }

    public void ChangeTxtViewOnFrag(String newValue) {
        txtView.setText(newValue);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        txt = (EditText) v.findViewById(R.id.editText);
        txtView = (TextView) v.findViewById(R.id.textView);

        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCallback.onArticleSelected(s.length());
                // Log.d("LENGTH", s.length()+" ");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
}
