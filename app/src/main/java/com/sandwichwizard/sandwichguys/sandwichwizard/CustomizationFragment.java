package com.sandwichwizard.sandwichguys.sandwichwizard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sandwichwizard.sandwichguys.sandwichwizard.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class CustomizationFragment extends Fragment {

    public CustomizationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_customization, container, false);
        return rootView;
    }
}