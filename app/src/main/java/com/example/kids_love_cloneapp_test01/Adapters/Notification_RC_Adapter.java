package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kids_love_cloneapp_test01.Items.RC_Notification_item;
import com.example.kids_love_cloneapp_test01.R;
import com.example.kids_love_cloneapp_test01.fragments.Home_FG;
import com.example.kids_love_cloneapp_test01.fragments.Notification_FG;

import java.util.ArrayList;

public class Notification_RC_Adapter extends RecyclerView.Adapter {
    Context context;
    ArrayList<RC_Notification_item> items;

    public Notification_RC_Adapter(Context context, ArrayList<RC_Notification_item> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//        parent에 getContext사용해야함
//        생성자로 받아온 context는 사용하면 에러남남

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_notiy_item_food, parent, false);
        VH holder=new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh=(VH)holder;

        RC_Notification_item item=items.get(position);
        Log.i("Data_Show", item.toString());
        vh.food_set.setText(items.get(position).food_set);
        vh.dd.setText(items.get(position).dd);
        vh.text_date.setText(items.get(position).text_date);
        vh.mini_date.setText(items.get(position).mini_date);
        vh.from.setText(items.get(position).from);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class VH extends RecyclerView.ViewHolder{

        TextView dd, from, mini_date, text_date, food_set;

        public VH(@NonNull View itemView) {
            super(itemView);
            dd=itemView.findViewById(R.id.date_dd_food);
            from=itemView.findViewById(R.id.from_notiy_food);
            mini_date=itemView.findViewById(R.id.mini_date_notiy_food);
            text_date=itemView.findViewById(R.id.date_text_food);
            food_set=itemView.findViewById(R.id.date_food_set_notiy);

        }
    }
}
