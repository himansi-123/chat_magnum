package com.example.himansi.chat_interfaceapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class check_internet extends Fragment {

    Button retry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_check_internet, container, false);

        retry = view.findViewById(R.id.retry);
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!MainActivity.isConnected()) {
                    Toast.makeText(getContext(),"No network connection",Toast.LENGTH_SHORT).show();
                } else
                    MainActivity.replaceFragment();
            }
        });

        return view;

    }
}
