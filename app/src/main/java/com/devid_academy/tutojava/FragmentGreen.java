package com.devid_academy.tutojava;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class FragmentGreen extends Fragment {

    private String title;

    public FragmentGreen(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_green, container, false);

        TextView titreFragmentGreen = view.findViewById(R.id.tv_fg_green);
        titreFragmentGreen.setText(this.title);

        return view;
    }
}