package com.example.android.dinnerapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Fragment;

/**
 * Created by jocelyn on 3/12/15.
 */

/*
 * This fragment displays an info box with a solid heading
 */
public class UseInfoBoxFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.show_info, container, false);
    }
}