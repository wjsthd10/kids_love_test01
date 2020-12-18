package com.example.kids_love_cloneapp_test01.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kids_love_cloneapp_test01.Adapters.FragmentAdapter;
import com.example.kids_love_cloneapp_test01.Adapters.Home_RC_Adapter;
import com.example.kids_love_cloneapp_test01.Items.RC_Home_item;
import com.example.kids_love_cloneapp_test01.MainActivity;
import com.example.kids_love_cloneapp_test01.R;
import com.example.kids_love_cloneapp_test01.RC_ItemDecoration.Home_ItemDecoration;

import java.util.ArrayList;

public class Home_FG extends Fragment{

    ArrayList<RC_Home_item> items=new ArrayList<>();
    RecyclerView recyclerView;
    Home_RC_Adapter rc_adapter;
    FragmentAdapter fragmentAdapter;

    public Home_FG(FragmentAdapter fragmentAdapter) {
        this.fragmentAdapter=fragmentAdapter;
    }

    public Home_FG() {
    }

    public static Home_FG newInstance(){
        return new Home_FG();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items.add(new RC_Home_item(R.drawable.ic_speaker_campaign_24, "알림장"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_history_blue_24,"출결/통학"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_photo_size_select_actual_24, "앨범"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_calendar_today_24, "일정"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_people_24, "단체방"));
        items.add(new RC_Home_item(R.drawable.ic_blue_help_outline_24, "문의함"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_directions_bus_24, "통학버스"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_medical_services_24, "투약의뢰"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_monetization_on_24, "납부현황"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_local_dining_24, "급식정보"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_timer_24, "체력측정"));
        items.add(new RC_Home_item(R.drawable.ic_baseline_stars_24, "승급승단"));

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.home_fg_lay, container,false);
        recyclerView=view.findViewById(R.id.rc_home_lay_items_01);

        int spacingInPixels=getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView.addItemDecoration(new Home_ItemDecoration(spacingInPixels));

        rc_adapter=new Home_RC_Adapter(getContext(), items);
        recyclerView.setAdapter(rc_adapter);

        return view;
    }

}
