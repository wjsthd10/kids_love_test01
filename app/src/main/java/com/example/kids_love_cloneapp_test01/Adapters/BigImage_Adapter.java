package com.example.kids_love_cloneapp_test01.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.kids_love_cloneapp_test01.Items.Album_clickItems;

import java.util.ArrayList;

public class BigImage_Adapter extends PagerAdapter {

    Context context;
    Intent intent;

    public BigImage_Adapter(Context context) {
        this.context = context;
    }

    public BigImage_Adapter(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
    }




    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
