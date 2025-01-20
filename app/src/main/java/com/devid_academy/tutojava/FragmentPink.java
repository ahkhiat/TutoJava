package com.devid_academy.tutojava;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FragmentPink extends Fragment {


    public FragmentPink() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_pink, container, false);

        String PinkFragmentMessage = getString(R.string.fg_pink_message);

        Button btnFgPink = view.findViewById(R.id.btn_fg_pink);
        btnFgPink.setOnClickListener(v -> ((FragmentsActivity) getActivity()).showToast(PinkFragmentMessage));

        return view;
    }
}