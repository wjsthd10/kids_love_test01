package com.example.kids_love_cloneapp_test01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kids_love_cloneapp_test01.Adapters.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ImageView leftBtn, rightBtn;
    TextView home,notice,attendance,album, calendar,group_room;
    HorizontalScrollView scrollView;
    LinearLayout hintText;
    ViewPager pager;
    Fragment[] fragments=new Fragment[6];
    static final int NUM_PAGES=6;

    FragmentManager fragmentManager=getSupportFragmentManager();
    FragmentTransaction transaction;
    TabLayout tabLayout;
    FragmentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftBtn=findViewById(R.id.navBtn_left);
        rightBtn=findViewById(R.id.navBtn_right);
        home=findViewById(R.id.home_bottombar);
        notice=findViewById(R.id.notice_bottombar);
        attendance=findViewById(R.id.attendance_bottombar);
        album=findViewById(R.id.album_bottombar);
        calendar=findViewById(R.id.calendar_bottombar);
        group_room=findViewById(R.id.Group_room_bottombar);
        scrollView=findViewById(R.id.scrollview_title);
        hintText=findViewById(R.id.hint_text);
        pager=findViewById(R.id.main_pager);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    Log.i("scrolly", scrollX+" , "+scrollY+" , "+oldScrollX+" , "+oldScrollY);
                    // scrollx가 0일때 왼쪽 끝 180일때 오른쪽 끝
                    switch (scrollX){
                        case 0: rightBtn.setVisibility(View.VISIBLE);
                                leftBtn.setVisibility(View.GONE);
                                break;
                        case 180: rightBtn.setVisibility(View.GONE);
                                  leftBtn.setVisibility(View.VISIBLE);
                                  break;
                    }
                }
            });
        }
        adapter=new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }//onCreate....




    public void click_dehaze_button(View view) {
        // 햄버거버튼 클릭
    }

//    오른쪽으로 가는 버튼 완료
    public void navBtn_right(View view) {
        // 네비에 있는 오른쪽으로 가는 버튼
        scrollView.scrollTo(180,0 );
    }


    public void click_home(View view) {
        // 홈버튼 클릭했을때
    }

    public void click_notice(View view) {
        //알림장 클릭
    }

    public void click_attendance(View view) {
        // 출결/통학 클릭
    }

    public void click_album(View view) {
        //앨범 클릭
    }

    public void click_calendar(View view) {
        //일정 클릭
    }

    public void click_Group_room(View view) {
        // 단체방 클릭
    }

//    왼쪽으로 가는 버튼 완료
    public void navBtn_left(View view) {
        //왼쪽 버튼
        scrollView.scrollTo(0, 0);
    }

    public void click_help(View view) {
        //도움말 클릭
    }

    public void click_floating_home(View view) {
        //floating botton
    }

    public void click_clear_hint(View view) {
        // 힌트종료버튼
        hintText.setVisibility(View.GONE);
    }

}