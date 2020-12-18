package com.example.kids_love_cloneapp_test01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kids_love_cloneapp_test01.Adapters.FragmentAdapter;
import com.example.kids_love_cloneapp_test01.Adapters.Nav_RC_Adapter;
import com.example.kids_love_cloneapp_test01.Adapters.Nav_RC_vertical_Adapter;
import com.example.kids_love_cloneapp_test01.Items.RC_nav_item;
import com.example.kids_love_cloneapp_test01.Items.RC_nav_item_vertical;
import com.example.kids_love_cloneapp_test01.fragment_replace.Replace_fragment;
import com.example.kids_love_cloneapp_test01.fragments.Home_FG;
import com.example.kids_love_cloneapp_test01.fragments.Notification_FG;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ImageView leftBtn, rightBtn, toggle, home_btn;
    HorizontalScrollView scrollView;
    LinearLayout hintText;
    ViewPager pager;
    DrawerLayout drawerLayout;
    ArrayList<RC_nav_item> nav_items=new ArrayList<>();

    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    FragmentAdapter adapter;

    Nav_RC_Adapter nav_rc_adapter;
    RecyclerView nav_rc_hori, nav_rc_vertical;

    Nav_RC_vertical_Adapter nav_rc_vertical_adapter;
    ArrayList<RC_nav_item_vertical> nav_items_vertical=new ArrayList<>();
    int hintNum=0;// home화면에 힌트 끄면 안보이게 할 숫자
    int scrollpositionSet=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=findViewById(R.id.drawer_frame_lay);
        drawerLayout=findViewById(R.id.drawer_lay);

        nav_rc_vertical=findViewById(R.id.nav_RC_vertical);

        leftBtn=findViewById(R.id.navBtn_left);
        rightBtn=findViewById(R.id.navBtn_right);
        scrollView=findViewById(R.id.scrollview_title);
        hintText=findViewById(R.id.hint_text);
        pager=findViewById(R.id.main_pager);
        nav_rc_hori=findViewById(R.id.nav_RC_hori);
        toggle=findViewById(R.id.main_pager_toggle);
        home_btn=findViewById(R.id.main_homeButton);

//      topscroll
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
        fragmentTransaction=getSupportFragmentManager().beginTransaction();

        adapter=new FragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Toast.makeText(MainActivity.this, positionOffset+"scrolled", Toast.LENGTH_SHORT).show();  페이지 스크롤 될때
                scrollpositionSet=positionOffsetPixels;
                scrollView.scrollBy(positionOffsetPixels/150,0);// 오른쪽으로 이동!

                if (position<0){
                    Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
                }

//                알림장 572 다시 0으로
            }

            @Override
            public void onPageSelected(int position) {
//                Toast.makeText(MainActivity.this, position+"selected", Toast.LENGTH_SHORT).show();    //페이지 선택될때
//                toolbar이동
                Glide.with(MainActivity.this).load(R.drawable.ic_blue_add_24).into(toggle);
                home_btn.setVisibility(View.VISIBLE);
                hintText.setVisibility(View.GONE);

                if (position==0){
                    Glide.with(MainActivity.this).load(R.drawable.ic_baseline_more_horiz_24).into(toggle);
                    if (hintNum==0){
                        hintText.setVisibility(View.VISIBLE);
                    }
                    home_btn.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {// 페이지가 갖고있는 상태 리턴해줌
                Toast.makeText(MainActivity.this,state+"state", Toast.LENGTH_SHORT).show();   //    1:스크롤 시작, 2:다음페이지이동, 0:스크롤 종료
//                툴바눌러서 이동할때는 2->0순서
//                toolbar멈추기


            }
        });


        //        네비연결
        loadData();
        nav_rc_adapter=new Nav_RC_Adapter(this, nav_items);
        nav_rc_hori.setAdapter(nav_rc_adapter);

        nav_rc_vertical_adapter=new Nav_RC_vertical_Adapter(this, nav_items_vertical);
        nav_rc_vertical.setAdapter(nav_rc_vertical_adapter);

    }//onCreate....

    public void loadData(){
        nav_items.add(new RC_nav_item(R.drawable.ic_blue_help_outline_24, "문의함"));
        nav_items.add(new RC_nav_item(R.drawable.ic_baseline_directions_bus_24, "통학버스"));
        nav_items.add(new RC_nav_item(R.drawable.ic_baseline_food_bank_24, "급식정보"));
        nav_items.add(new RC_nav_item(R.drawable.ic_baseline_timer_24, "체력측정"));
        nav_items.add(new RC_nav_item(R.drawable.ic_baseline_stars_24, "승급승단"));

        nav_items_vertical.add(new RC_nav_item_vertical(
                "https://i.pinimg.com/originals/05/1f/f3/051ff3fb781ff83c9b0f8a32f9922fa6.png",
                "이름 테스트",
                "28",
                "1993.10.27",
                "200",
                "QA테스트 학원",
                "취업부",
                "학원급식"
        ));
        nav_items_vertical.add(new RC_nav_item_vertical(
                null,
                "이름 테스트",
                "28",
                "1993.10.27",
                "200",
                "QA테스트 학원",
                null,
                null
        ));
        nav_items_vertical.add(new RC_nav_item_vertical(
                "data:image/jpeg;base64,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",
                "이름 테스트",
                "28",
                "1993.10.27",
                "200",
                "QA테스트 학원",
                null,
                "학원급식"
        ));

    }




    public void click_dehaze_button(View view) {
        // 햄버거버튼 클릭
        drawerLayout.openDrawer(Gravity.LEFT);
    }

//    오른쪽으로 가는 버튼 완료
    public void navBtn_right(View view) {
        // 네비에 있는 오른쪽으로 가는 버튼
        scrollView.scrollTo(180,0 );
    }


    public void click_home(View view) {
        // 홈버튼 클릭했을때
        pager.setCurrentItem(0);
        scrollView.scrollTo(0,0);

        drawerLayout.closeDrawer(Gravity.LEFT);

    }

    public void click_notice(View view) {
        //알림장 클릭
        pager.setCurrentItem(1);

    }

    public void click_attendance(View view) {
        // 출결/통학 클릭
        pager.setCurrentItem(2);
    }

    public void click_album(View view) {
        //앨범 클릭
        pager.setCurrentItem(3);
        scrollView.scrollTo(scrollpositionSet/100, 0);
    }

    public void click_calendar(View view) {
        //일정 클릭
        pager.setCurrentItem(4);
    }

    public void click_Group_room(View view) {
        // 단체방 클릭
        pager.setCurrentItem(5);
    }

//    왼쪽으로 가는 버튼 완료
    public void navBtn_left(View view) {
        //왼쪽 버튼
        scrollView.scrollTo(0, 0);
    }

    public void click_help(View view) {
        //todo 도움말 클릭
        Toast.makeText(this, "도움말 버튼클릭", Toast.LENGTH_SHORT).show();
    }

    public void click_floating_home(View view) {
        //todo floating botton
    }

    public void click_clear_hint(View view) {
        // 힌트종료버튼
        hintText.setVisibility(View.GONE);// 페이지 넘어가면 Gone으로 변경
        hintNum=1;

    }

    public void click_push(View view){
//        todo 추천버튼클릭
        Toast.makeText(this, "추천버튼 클릭", Toast.LENGTH_SHORT).show();
    }

}