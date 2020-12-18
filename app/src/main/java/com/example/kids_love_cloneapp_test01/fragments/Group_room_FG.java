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

import com.example.kids_love_cloneapp_test01.Adapters.Group_Room_RC_Adapter;
import com.example.kids_love_cloneapp_test01.Items.RC_Grouproom_item;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Group_room_FG extends Fragment {
    ArrayList<RC_Grouproom_item> items=new ArrayList<>();
    Group_Room_RC_Adapter rc_adapter;
    RecyclerView recyclerView;

    public void loadData(){
        items.clear();
        items.add(new RC_Grouproom_item(
                "18",
                "금",
                "웰티즌키즈",
                "2020년 12월 18일 09:37",
                "2",
                null,
                null,
                "웰티즌키즈의 부모님이 만든 단체방"
        ));
        items.add(new RC_Grouproom_item(
                "17",
                "목",
                null,
                "2020년 12월 17일 15:03",
                null,
                "김봉팔",
                "장수반담임",
                "장수반 단체방"
        ));

        items.add(new RC_Grouproom_item(
                "10",
                "목",
                null,
                "2020년 12월 10일 09:03",
                null,
                "이원장",
                "원장",
                "선생님 단체방"
        ));

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.group_room_fg_lay, container, false);
        rc_adapter=new Group_Room_RC_Adapter(container.getContext(), items);
        recyclerView=view.findViewById(R.id.recycler_group_room);
        recyclerView.setAdapter(rc_adapter);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }
}
