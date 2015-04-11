package com.sandwichwizard.sandwichguys.sandwichwizard;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Kyle on 3/12/2015.
 */
public class QuizFragment extends Fragment {
    // used to pass in args
    private String question;
    private String[] responses;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.quiz_fragment_layout, container, false);
    }
}
