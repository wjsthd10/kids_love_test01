package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kids_love_cloneapp_test01.Items.RC_nav_item;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Nav_RC_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RC_nav_item> items;

    public Nav_RC_Adapter(Context context, ArrayList<RC_nav_item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.nav_rc_horizontal, parent, false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        Glide.with(context).load(items.get(position).images).into(vh.imageView);
        vh.textView.setText(items.get(position).text);

        vh.navLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (items.get(position).text){
                    case "문의함": {
                        Toast.makeText(context, "다이얼로그로 자녀리스트 보여줌", Toast.LENGTH_SHORT).show();break;
                    }
                    case "통학버스":{
                        Toast.makeText(context, "통학버스 페이지로 이동", Toast.LENGTH_SHORT).show();break;
                    }
                    case "급식정보":{
                        Toast.makeText(context, "급식정보 페이지로 이동", Toast.LENGTH_SHORT).show();break;
                    }
                    case "체력측정":{
                        Toast.makeText(context, "체력측정 페이지로 이동", Toast.LENGTH_SHORT).show();break;
                    }
                    case "승급승단":{
                        Toast.makeText(context, "승급승단 페이지로 이동", Toast.LENGTH_SHORT).show();break;
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        LinearLayout navLay;
        ImageView imageView;
        TextView textView;

        public VH(@NonNull View itemView) {
            super(itemView);

            navLay=itemView.findViewById(R.id.nav_rc_item_hori);
            imageView=itemView.findViewById(R.id.nav_item_hori_image);
            textView=itemView.findViewById(R.id.nav_item_hori_text);

        }
    }

}
