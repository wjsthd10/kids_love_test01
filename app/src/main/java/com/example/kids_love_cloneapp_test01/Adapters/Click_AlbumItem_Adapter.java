package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kids_love_cloneapp_test01.Items.Album_clickItems;
import com.example.kids_love_cloneapp_test01.R;
import com.example.kids_love_cloneapp_test01.click_album.Click_Album_BigImage;

import java.util.ArrayList;

public class Click_AlbumItem_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Album_clickItems> items;

    public Click_AlbumItem_Adapter(Context context, ArrayList<Album_clickItems> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.image_item_album, parent, false);
        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        Album_clickItems item=items.get(position);

        Glide.with(context).load(items.get(position).album_images).into(vh.imageView);

        vh.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Click_Album_BigImage.class);
                intent.putExtra("position", position);
                intent.putExtra("items_size", items.size());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        ImageView imageView;

        public VH(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image_item_album);

        }
    }

}
