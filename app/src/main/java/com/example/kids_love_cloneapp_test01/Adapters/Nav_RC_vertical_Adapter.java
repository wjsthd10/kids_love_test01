package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kids_love_cloneapp_test01.Items.RC_nav_item_vertical;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Nav_RC_vertical_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RC_nav_item_vertical> items;

    public Nav_RC_vertical_Adapter(Context context, ArrayList<RC_nav_item_vertical> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.nav_rc_vertival_item, parent, false);
        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;

        RC_nav_item_vertical item=items.get(position);
        if (items.get(position).lay01_image!=null){// 사진이 있을때만
            Glide.with(context).load(items.get(position).lay01_image).into(vh.lay01_image);
        }

        vh.lay01_name.setText(items.get(position).lay01_name+"("+items.get(position).lay01_age+")");
        vh.lay01_birthday.setText(items.get(position).lay01_birthday);
        vh.lay01_point.setText(items.get(position).lay01_point+"P");
        vh.lay02_schoolName.setText(items.get(position).lay02_schoolName);

//        lay02
        if (items.get(position).lay02_ban!=null){// 데이터 있음
            vh.lay02_ban.setText(items.get(position).lay02_ban);
        }else {// 데이터 없음
            vh.lay02_ban.setVisibility(View.INVISIBLE);// 부반 안보이기
        }

        if (items.get(position).lay03_schoolName_food!=null){// 데이터 있음
            vh.lay03_schoolName_food.setText(items.get(position).lay03_schoolName_food);
            vh.nav_click_food.setVisibility(View.VISIBLE);
            vh.nav_click_reset.setVisibility(View.VISIBLE);
            vh.nav_click_setSchool.setVisibility(View.GONE);
        }else {// 데이터 없음
            vh.lay03_schoolName_food.setText("급식 정보가 없습니다.");
            vh.nav_click_food.setVisibility(View.GONE);
            vh.nav_click_reset.setVisibility(View.GONE);
            vh.nav_click_setSchool.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView lay01_image;
        TextView lay01_name, lay01_birthday, lay01_point;
        TextView lay02_schoolName, lay02_ban;
        TextView lay03_schoolName_food;
//        받아오는 데이터들 연결시킬 뷰

//        visibility
        TextView nav_click_food, nav_click_reset, nav_click_setSchool;

//        constlay
        ConstraintLayout lay01, lay02;
        LinearLayout lay03;

        public VH(@NonNull View itemView) {
            super(itemView);
            lay01_image=itemView.findViewById(R.id.nav_RC_kids_image);
            lay01_name=itemView.findViewById(R.id.nav_RC_item_kidsName);// + lay01_age를 붙여서 출력하기
            lay01_birthday=itemView.findViewById(R.id.nav_RC_item_kidsAge);
            lay01_point=itemView.findViewById(R.id.nav_RC_item_point);
//            lay01-----

            lay02_schoolName=itemView.findViewById(R.id.nav_RC_item_schoolName);
            lay02_ban=itemView.findViewById(R.id.nav_RC_item_ban);
//            lay02----------

            lay03_schoolName_food=itemView.findViewById(R.id.nav_schoolName_food);
//            lay03--------------

            nav_click_food=itemView.findViewById(R.id.nav_click_food);
            nav_click_reset=itemView.findViewById(R.id.nav_click_reset);
            nav_click_setSchool=itemView.findViewById(R.id.nav_click_setSchool);// 기본값
//            visibility_set

            lay01=itemView.findViewById(R.id.click_lay01);
            lay02=itemView.findViewById(R.id.click_lay02);
            lay03=itemView.findViewById(R.id.click_lay03);
//            clicked Lay
        }
    }

}
