package com.example.kids_love_cloneapp_test01.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kids_love_cloneapp_test01.Adapters.Notification_RC_Adapter;
import com.example.kids_love_cloneapp_test01.Items.RC_Notification_item;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Notification_FG extends Fragment implements View.OnClickListener {

    ArrayList<RC_Notification_item> items=new ArrayList<>();
    Notification_RC_Adapter rc_adapter;
    RecyclerView recyclerView;

    Context context;

    public Notification_FG() {
    }

    public Notification_FG(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items.add(new RC_Notification_item(
                "03",
                "From, QA유치원",
                "2020년 12월 3일 오후 18:32",
                "목",
                "12월 4일 식단표가 등록되었습니다."
        ));
//        loadData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.notification_fg_lay, container, false);

        View view=inflater.inflate(R.layout.notification_fg_lay, container, false);

        rc_adapter=new Notification_RC_Adapter(context, items);
        recyclerView=view.findViewById(R.id.recycler_notiy);
        recyclerView.setAdapter(rc_adapter);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_left_notiy:break;
            case R.id.btn_right_notiy:break;
            case R.id.yy_notiy:break;
            case R.id.mm_notiy:break;
            case R.id.to_day_notiy:break;
            case R.id.category_notiy:break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();
//        loadData();
    }

    void loadData(){
        for (int i=0;i<items.size();i++){
            items.add(new RC_Notification_item(
               "03",
               "From, QA유치원",
               "2020년 12월 3일 오후 18:32",
               "목",
               "12월 4일 식단표가 등록되었습니다."
            ));
        }
    }
}
