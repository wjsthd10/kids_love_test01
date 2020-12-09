package com.example.kids_love_cloneapp_test01.click_album;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.kids_love_cloneapp_test01.Adapters.BigImage_Adapter;
import com.example.kids_love_cloneapp_test01.R;

public class Click_Album_BigImage extends AppCompatActivity {

    ViewPager pager;
    BigImage_Adapter bigAdapter;

    Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click__album__big_image);
        pager=findViewById(R.id.bigImage_pager);
        bigAdapter=new BigImage_Adapter(this, intent);

    }

    public void click_back_album(View view) {finish();
    }

    public void click_download_all(View view) {
//        전부 다운로드
    }

    public void click_download(View view) {
//        한장 다운로드
    }
}