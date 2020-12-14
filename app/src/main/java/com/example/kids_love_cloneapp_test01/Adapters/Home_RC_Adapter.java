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
import com.example.kids_love_cloneapp_test01.Items.RC_Home_item;
import com.example.kids_love_cloneapp_test01.R;
import com.example.kids_love_cloneapp_test01.fragments.Notification_FG;

import java.util.ArrayList;

public class Home_RC_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RC_Home_item> items=new ArrayList<>();

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
//                Toast.makeText(context, position+""+items.get(position).name, Toast.LENGTH_SHORT).show();
                switch (items.get(position).name){
                    case "알림장":

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

        }
    }

}
