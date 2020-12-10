package com.example.kids_love_cloneapp_test01.click_album;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kids_love_cloneapp_test01.Adapters.BigImage_Adapter;
import com.example.kids_love_cloneapp_test01.Items.Album_clickItems;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Click_Album_BigImage extends AppCompatActivity {

//    ViewPager pager;
    BigImage_Adapter bigAdapter;
    RecyclerView recyclerView;

    Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "click_Album_BigImage.class", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_click__album__big_image);

//        pager=findViewById(R.id.bigImage_pager);
        recyclerView=findViewById(R.id.bigImage_RC);
        LinearLayoutManager manager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        SnapHelper snapHelper=new PagerSnapHelper();
        recyclerView.setLayoutManager(manager);
        snapHelper.attachToRecyclerView(recyclerView);

        bigAdapter=new BigImage_Adapter(this, intent);


//        pager.setAdapter(bigAdapter);
        recyclerView.setAdapter(bigAdapter);
        ImageView imageView=findViewById(R.id.bigImage);
        int position=recyclerView.getChildAdapterPosition(imageView);
        Log.d("childAdapterposition", position+"");

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