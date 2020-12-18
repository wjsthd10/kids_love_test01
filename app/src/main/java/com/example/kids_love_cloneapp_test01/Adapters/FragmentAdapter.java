package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.kids_love_cloneapp_test01.MainActivity;
import com.example.kids_love_cloneapp_test01.fragments.Album_FG;
import com.example.kids_love_cloneapp_test01.fragments.Attendance_FG;
import com.example.kids_love_cloneapp_test01.fragments.Calendar_FG;
import com.example.kids_love_cloneapp_test01.fragments.Group_room_FG;
import com.example.kids_love_cloneapp_test01.fragments.Home_FG;
import com.example.kids_love_cloneapp_test01.fragments.Notification_FG;

public class FragmentAdapter extends FragmentPagerAdapter {

    Fragment[] fragments=new Fragment[6];

    Context context;

    public FragmentAdapter(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        this.context = context;
    }

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments[0]=new Home_FG();
        fragments[1]=new Notification_FG();
        fragments[2]=new Attendance_FG();
        fragments[3]=new Album_FG();
        fragments[4]=new Calendar_FG();
        fragments[5]=new Group_room_FG();
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
