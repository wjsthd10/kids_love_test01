package com.example.kids_love_cloneapp_test01.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.kids_love_cloneapp_test01.Items.Album_clickItems;
import com.example.kids_love_cloneapp_test01.R;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class BigImage_Adapter extends RecyclerView.Adapter {

    Context context;
    Intent intent;
    int img_num;
    int position_intent;
    Uri[] uri2=new Uri[img_num];

    ArrayList<Album_clickItems> items;
    ArrayList<String> items_str;


    public BigImage_Adapter(Context context) {
        this.context = context;
    }

    public BigImage_Adapter(Context context, Intent intent) {
        this.context = context;
        this.intent = intent;
        img_num=intent.getIntExtra("items_size", 1);
    }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView=LayoutInflater.from(context).inflate(R.layout.slide_image_lay, parent, false);
        VH holer=new VH(itemView);
        return holer;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Bundle bundle=((Activity)context).getIntent().getExtras();
        if (bundle!=null){
            img_num=bundle.getInt("items_size");
            position_intent=bundle.getInt("position");
            items_str=bundle.getStringArrayList("items_String");
        }
        VH vh= (VH) holder;
        Uri uri=Uri.parse(items_str.get(position_intent));
        Glide.with(context).load(uri).into(vh.imageView);
        Toast.makeText(context, position+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return img_num;
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView imageView;

        public VH(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.bigImage);
        }
    }

}
