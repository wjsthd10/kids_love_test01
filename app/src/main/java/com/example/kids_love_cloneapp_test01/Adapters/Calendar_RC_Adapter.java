package com.example.kids_love_cloneapp_test01.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kids_love_cloneapp_test01.Items.RC_Calendar_item;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Calendar_RC_Adapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<RC_Calendar_item> items;

    public Calendar_RC_Adapter(Context context, ArrayList<RC_Calendar_item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(context).inflate(R.layout.rc_calendar_item_01, parent, false);
        VH holder=new VH(itemView);
//        Log.d("viewType", viewType+"");
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH) holder;
//        참가인원 설정
        int participants=0;
        if (items.get(position).participants!=null){
            participants=Integer.parseInt(items.get(position).participants);
        }

//        item아이콘, 배경색 설정
        Glide.with(context).load(R.drawable.ic_white_assignment_24).into(vh.image);
        vh.background.setBackgroundColor(Color.parseColor("#F73194"));
        if (items.get(position).winning!=null){
            Glide.with(context).load(R.drawable.ic_white_groups_24).into(vh.image);
            vh.background.setBackgroundColor(Color.parseColor("#F3AF00"));
        }

//        행사일 데이터
        vh.header.setText(items.get(position).header);

//        행사 제목 + 참여인원 표시
        vh.title.setText(items.get(position).title);
        if (items.get(position).maxParticipants!=null){
            vh.title.setText(items.get(position).title+"("+participants+"/"+items.get(position).maxParticipants+")");
        }

//        전송될명단 개인일때랑 다수 일때 구분 => todo 부반으로 나눠서 보내지는거도 추가해야함....
        vh.kids.setText(items.get(position).kids);
        if (items.get(position).kidsNum!=null&& Integer.parseInt(items.get(position).kidsNum)!=1){
            vh.kids.setText(items.get(position).kids+" 외 "+(Integer.parseInt(items.get(position).kidsNum)-1)+"명");
        }

//        위치정보 표시
        if (items.get(position).location!=null){
            vh.location.setText(items.get(position).location);
        }else vh.location.setVisibility(View.GONE);

//        일정개시자의 정보 표시 이름 + 직책
        vh.from.setText("From."+items.get(position).from+" "+items.get(position).teacher_position);

        if (items.get(position).userFace!=null){
            vh.getEmoji.setText("내 표정");
            vh.icon.setVisibility(View.VISIBLE);
            switch (items.get(position).userFace){
                case "good": Glide.with(context).load(R.drawable.ic_emoticon_good_24).into(vh.icon);break;
                case "nice": Glide.with(context).load(R.drawable.ic_nice_24).into(vh.icon);break;
                case "usually": Glide.with(context).load(R.drawable.ic_usually_24).into(vh.icon);break;
                case "bad": Glide.with(context).load(R.drawable.ic__bad_24).into(vh.icon);break;
                case "verybad": Glide.with(context).load(R.drawable.ic_verybad_24).into(vh.icon);break;
            }
        }
        vh.imageText.setVisibility(View.INVISIBLE);
        vh.imageNum.setVisibility(View.INVISIBLE);
        if (items.get(position).imageNum!=null && Integer.parseInt(items.get(position).imageNum)>0){
            vh.imageText.setVisibility(View.VISIBLE);
            vh.imageNum.setVisibility(View.VISIBLE);
            vh.imageNum.setText(items.get(position).imageNum);
        }
//        뷰에 데이터 입력 부분 끝

//        todo clickEvent해야함.



    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class VH extends RecyclerView.ViewHolder{

        TextView header, title, kids, location, from;
//        로케이션은 없으면 gone주기
        TextView getEmoji, imageText, imageNum;

        ImageView image, icon;
        LinearLayout click_lay, click_emoji, click_question, click_share, background;



        public VH(@NonNull View itemView) {
            super(itemView);
//            데이터 보여질 뷰들
            header=itemView.findViewById(R.id.msg_header_calendar_itme);
            title=itemView.findViewById(R.id.rc_calendar_item_title);
            kids=itemView.findViewById(R.id.rc_calendar_item_kids);
            location=itemView.findViewById(R.id.rc_calendar_item_location);
            from=itemView.findViewById(R.id.rc_calendar_item_from);
            image=itemView.findViewById(R.id.images_header_calendar_item01);
            background=itemView.findViewById(R.id.calendar_item_background);

//            클릭이벤트처리용
            click_lay=itemView.findViewById(R.id.click_rc_calendar_item);
            click_emoji=itemView.findViewById(R.id.emoji_calendar_item_onclick);
            click_question=itemView.findViewById(R.id.question_calendar_item_onclick);
            click_share=itemView.findViewById(R.id.share_calendar_item_onclick);

//            남긴표정
            getEmoji=itemView.findViewById(R.id.getEmoji_calendar_item);
            icon=itemView.findViewById(R.id.setEmoji_icon);
            imageText=itemView.findViewById(R.id.rc_item_imageText);
            imageNum=itemView.findViewById(R.id.rc_item_imagesNum);

        }
    }
}
