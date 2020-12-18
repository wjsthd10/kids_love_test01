package com.example.kids_love_cloneapp_test01.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kids_love_cloneapp_test01.Adapters.Calendar_RC_Adapter;
import com.example.kids_love_cloneapp_test01.Items.RC_Calendar_item;
import com.example.kids_love_cloneapp_test01.R;

import java.util.ArrayList;

public class Calendar_FG extends Fragment {
    ArrayList<RC_Calendar_item> items=new ArrayList<>();
    RecyclerView recyclerView;
    Context context;
    Calendar_RC_Adapter calendar_rc_adapter;

    public Calendar_FG(Context context) {
        this.context = context;
    }// context받는 생성자

    public Calendar_FG() {
    }//생성자


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();

    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.calendar_fg_lay, container, false);
        recyclerView=view.findViewById(R.id.recycler_calendar);
        calendar_rc_adapter=new Calendar_RC_Adapter(container.getContext(), items);
        recyclerView.setAdapter(calendar_rc_adapter);


        return view;
    }
    //        todo 선택된 날짜데이터 서버로 보내기. onClick됬을때
    public void loadData(){
        items.clear();
//        todo 로드할때 지정된 월에 해당하는 데이터만 받아오기
//        todo 오늘 버튼 클릭시 오늘의 데이터만 받아오게 분기 만들어야함
        items.add(new RC_Calendar_item(
                "행사일 12월 16일(수) ~ 12월 16일(수)",
                "일정 테스트 item",
                "김래원 ",
                "3",
                null,
                "테스트8",
                null,
                "지도관장",
                null,
                null,
                null,
                "good",
                null

        ));
        items.add(new RC_Calendar_item(
                "행사일 12월 16일(수) ~ 12월 16일(수)",
                "인원제한 있는 행사",
                "김래원",
                "2",
                "서울특별시 양천구 신월 3동",
                "김봉팔",
                "100,000",// 상금이 있는가 없는가로 이모티콘 변경
                "원장",//from뒤에 직책추가
                null,// 현재 참여인원 0명으로 입력하기
                "5",// 참가자 숫자 제한이 있는가 확인
                "1",
                null,
                null
        ));

        items.add(new RC_Calendar_item(
                "행사일 12월 16일(수) ~ 12월 16일(수)",
                "구로구 행사",
                null,
                "2",
                "서울특별시 구로구",
                "김봉팔",
                "100,000",// 상금이 있는가 없는가로 이모티콘 변경
                "원장",//from뒤에 직책추가
                null,// 현재 참여인원 0명으로 입력하기
                "5",// 참가자 숫자 제한이 있는가 확인
                "4",
                "verybad",
                "개나리반"
        ));

    }
}
