package com.example.kids_love_cloneapp_test01.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Attendance_FG extends Fragment implements View.OnClickListener {



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.attendance_fg_lay, container, false);

        return view;
    }
}
