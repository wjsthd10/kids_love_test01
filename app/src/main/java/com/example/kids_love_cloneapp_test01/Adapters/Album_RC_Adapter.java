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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kids_love_cloneapp_test01.Items.RC_Album_item;
import com.example.kids_love_cloneapp_test01.R;
import com.example.kids_love_cloneapp_test01.click_album.Click_Album;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Album_RC_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RC_Album_item> items;

    public Album_RC_Adapter(Context context, ArrayList<RC_Album_item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_album_item, parent, false);
        VH holder=new VH(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
        RC_Album_item item=items.get(position);
//        String imgUrl="http://wjsthd10.dothome.co.kr/MyProject01/"+item.imgUrl;       // 외부저장소 사용하면 경로를 지정해줘야함

        vh.dd_header_album.setText(items.get(position).dd_header_album);
        vh.dd_text_album.setText(items.get(position).dd_text_album);
        vh.title_album.setText(items.get(position).title_album);
        vh.title_date_album.setText(items.get(position).title_date_album);
        vh.msg_album.setText(items.get(position).msg_album);


        Glide.with(context).load(items.get(position).album_image01).into(vh.album_image01);
        if (items.get(position).album_image02==null){
            vh.album_image02.setVisibility(View.GONE);
        }else Glide.with(context).load(items.get(position).album_image02).into(vh.album_image02);
//        url느림...

        vh.recomdeNum_album.setText(items.get(position).recomdeNum_album);
        vh.imageNum_album.setText(items.get(position).imageNum_album);
        
        vh.albumLay.setOnClickListener(new View.OnClickListener() {// 아이템 클릭
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "Adapter_Listener", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, Click_Album.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });
        vh.emojiLay.setOnClickListener(new View.OnClickListener() {// 내표정버튼
            @Override
            public void onClick(View v) {

            }
        });
        vh.questionLay.setOnClickListener(new View.OnClickListener() {// 문의버튼
            @Override
            public void onClick(View v) {

            }
        });
        vh.shareLay.setOnClickListener(new View.OnClickListener() {// 공유하기 버튼
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class VH extends RecyclerView.ViewHolder{

        TextView dd_header_album, dd_text_album, title_album, title_date_album, msg_album, recomdeNum_album, imageNum_album;
        ImageView album_image01, album_image02;
        LinearLayout albumLay, emojiLay, questionLay, shareLay;

        public VH(@NonNull View itemView) {
            super(itemView);
            dd_header_album=itemView.findViewById(R.id.dd_header_album_item);
            dd_text_album=itemView.findViewById(R.id.title_header_album_item);
            title_album=itemView.findViewById(R.id.title_header_album_item);
            title_date_album=itemView.findViewById(R.id.titleData_header_album_item);
            msg_album=itemView.findViewById(R.id.msg_header_album_itme);

            album_image01=itemView.findViewById(R.id.images_header_album_item01);
            album_image02=itemView.findViewById(R.id.images_header_album_item02_gone);

            recomdeNum_album=itemView.findViewById(R.id.recomdeNum_album_item);
            imageNum_album=itemView.findViewById(R.id.imagesNum_album_item);

            albumLay=itemView.findViewById(R.id.album_lay_onclick_showImage);
            emojiLay=itemView.findViewById(R.id.emoji_album_item_onclick);
            questionLay=itemView.findViewById(R.id.question_album_item_onclick);
            shareLay=itemView.findViewById(R.id.share_album_item_onclick);

        }
    }

}
