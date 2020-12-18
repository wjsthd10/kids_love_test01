package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kids_love_cloneapp_test01.Items.RC_Grouproom_item;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Group_Room_RC_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RC_Grouproom_item> items;

    public Group_Room_RC_Adapter(Context context, ArrayList<RC_Grouproom_item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.rc_group_room_item, parent, false);
        VH holder=new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;

        vh.day_num.setText(items.get(position).day_num);
        vh.day_text.setText(items.get(position).day_text);
        if (items.get(position).kids_name!=null){
            vh.kids_name.setText(items.get(position).kids_name+" 부모님");
        }else vh.kids_name.setText(items.get(position).teacher_name+" "+items.get(position).teacher_position);

        vh.date.setText(items.get(position).date);
        if (items.get(position).recomend_num!=null && Integer.parseInt(items.get(position).recomend_num)>0){
            vh.recomend_view.setVisibility(View.VISIBLE);
            vh.recomend_num.setVisibility(View.VISIBLE);
            vh.recomend_num.setText(items.get(position).recomend_num);
        }

        vh.body_title.setText(items.get(position).body_title);

        vh.click_lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position+"click", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class VH extends RecyclerView.ViewHolder{

        TextView day_num, day_text, kids_name, date, recomend_num, body_title, recomend_view;
        ConstraintLayout click_lay;

        public VH(@NonNull View itemView) {
            super(itemView);

            click_lay=itemView.findViewById(R.id.rc_group_item_lay);
            day_num=itemView.findViewById(R.id.rc_group_date_day);
            day_text=itemView.findViewById(R.id.rc_group_date_text);
            kids_name=itemView.findViewById(R.id.rc_group_header_from);
            date=itemView.findViewById(R.id.rc_group_header_date);
            recomend_num=itemView.findViewById(R.id.rc_group_header_recomendNum);
            recomend_view=itemView.findViewById(R.id.rc_group_recomendView);
            body_title=itemView.findViewById(R.id.rc_group_body_title);

        }
    }

}
