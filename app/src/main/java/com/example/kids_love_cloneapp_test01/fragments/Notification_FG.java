package com.example.kids_love_cloneapp_test01.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kids_love_cloneapp_test01.Adapters.Notification_RC_Adapter;
import com.example.kids_love_cloneapp_test01.Items.RC_Notification_item;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Notification_FG extends Fragment{

    ArrayList<RC_Notification_item> items=new ArrayList<>();
    Notification_RC_Adapter rc_adapter;
    RecyclerView recyclerView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.notification_fg_lay, container, false);

        rc_adapter=new Notification_RC_Adapter(container.getContext(), items);
        recyclerView=view.findViewById(R.id.recycler_notiy);
        recyclerView.setAdapter(rc_adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    void loadData(){
        items.clear();
        items.add(new RC_Notification_item(
                "03",
               "From, QA유치원",
               "2020년 12월 3일 오후 18:32",
               "목",
                "12월 4일 식단표가 등록되었습니다."
        ));

    }
}
