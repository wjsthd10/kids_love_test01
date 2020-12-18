package com.example.kids_love_cloneapp_test01.fragment_replace;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kids_love_cloneapp_test01.R;
import com.example.kids_love_cloneapp_test01.fragments.Album_FG;
import com.example.kids_love_cloneapp_test01.fragments.Notification_FG;

public class Replace_fragment{

    FragmentManager manager;

    public Replace_fragment() {
    }

    public Replace_fragment(FragmentManager manager) {
        this.manager = manager;
    }

    public void notiy_FG(){
        manager.beginTransaction().replace(R.id.main_pager, new Notification_FG());
    }
    public void album_FG(){
        manager.beginTransaction().replace(R.id.main_pager, new Album_FG());
    }
}
