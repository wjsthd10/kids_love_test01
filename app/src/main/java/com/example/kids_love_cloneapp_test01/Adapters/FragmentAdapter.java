package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.kids_love_cloneapp_test01.fragments.Home_FG;
import com.example.kids_love_cloneapp_test01.fragments.Notification_FG;

public class FragmentAdapter extends FragmentPagerAdapter {

    Fragment[] fragments=new Fragment[6];

    public FragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments[0]=new Home_FG();
        fragments[1]=new Notification_FG();
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
//        여기서 있는 양보다 많은 페이지수를 넘기면 null포인트나옴
//        todo fragment나머지 다 만들면 변경하기
        return 2;
    }
}
