package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.kids_love_cloneapp_test01.Items.RC_Home_item;
import com.example.kids_love_cloneapp_test01.MainActivity;
import com.example.kids_love_cloneapp_test01.R;
import com.example.kids_love_cloneapp_test01.fragment_replace.Replace_fragment;
import com.example.kids_love_cloneapp_test01.fragments.Home_FG;
import com.example.kids_love_cloneapp_test01.fragments.Notification_FG;

import java.util.ArrayList;

public class Home_RC_Adapter extends RecyclerView.Adapter{

    Context context;
    ArrayList<RC_Home_item> items;
    Replace_fragment replace=new Replace_fragment();
    FragmentAdapter adapter;
    ViewPager viewPager;

    public Home_RC_Adapter(Context context, ArrayList<RC_Home_item> items) {
        this.context = context;
        this.items=items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.rc_home_items, parent, false);
        VH holder=new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        Glide.with(context).load(items.get(position).images).into(vh.icons);
        vh.name.setText(items.get(position).name);

        vh.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity) v.getContext();
                viewPager=activity.findViewById(R.id.main_pager);
//                Toast.makeText(context, position+""+items.get(position).name, Toast.LENGTH_SHORT).show();
                switch (items.get(position).name){
                    case "알림장":viewPager.setCurrentItem(1);break;
                    case "출결/통학": viewPager.setCurrentItem(2);break;
                    case "앨범":viewPager.setCurrentItem(3);break;
                    case "일정":viewPager.setCurrentItem(4);break;
                    case "단체방":viewPager.setCurrentItem(5);break;


                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView icons;
        TextView name;
        LinearLayout click;

        public VH(@NonNull View itemView) {
            super(itemView);
            icons=itemView.findViewById(R.id.home_items_image);
            name=itemView.findViewById(R.id.home_items_name);
            click=itemView.findViewById(R.id.home_item_clicked);
            viewPager=itemView.findViewById(R.id.main_pager);
        }
    }



}
