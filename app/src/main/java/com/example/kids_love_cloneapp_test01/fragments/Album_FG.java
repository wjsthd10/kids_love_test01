package com.example.kids_love_cloneapp_test01.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kids_love_cloneapp_test01.Adapters.Album_RC_Adapter;
import com.example.kids_love_cloneapp_test01.Items.RC_Album_item;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Album_FG extends Fragment implements View.OnClickListener {

    ArrayList<RC_Album_item> items=new ArrayList<>();
    Album_RC_Adapter rc_adapter;
    RecyclerView recyclerView;
    Context context;

    public Album_FG() {
    }

    public Album_FG(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items.add(new RC_Album_item(
                "08",
                "화",
                "from. QA유치원",
                "2020년 12월 08일 오후 14:20",
                "이미지 URL로 보여주기...",
                "https://i.pinimg.com/originals/05/1f/f3/051ff3fb781ff83c9b0f8a32f9922fa6.png",
//                "https://i.pinimg.com/originals/05/1f/f3/051ff3fb781ff83c9b0f8a32f9922fa6.png",
                "5",
                "2"
        ));
    }
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        뷰만들어서 넣기
        View view=inflater.inflate(R.layout.album_fg_lay, container, false);
        
//        FragmentAdapter에서 생성할때 this를 파라미터로 넘겨주지 않고 기본 생성자로 만들었음 그래서 넘어온 context가 없어서 nullpointexaption남
        rc_adapter=new Album_RC_Adapter(container.getContext(), items);
        recyclerView=view.findViewById(R.id.recycler_album);
        recyclerView.setAdapter(rc_adapter);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.album_lay_onclick_showImage:
//                click_album_item_showImage(v);
        }
    }


}
