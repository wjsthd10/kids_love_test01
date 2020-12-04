package com.example.kids_love_cloneapp_test01.customcalendar_set;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Att_CalendarListViewModel extends ViewModel {

    MutableLiveData<ArrayList<Object>> att_calendarList=new MutableLiveData<>();


    public void setCalendarList(){
        GregorianCalendar cal=new GregorianCalendar();// today
        ArrayList<Object> calendaList=new ArrayList<>();

        for (int i=-300; i<300; i++){
            try {
                GregorianCalendar calendar=new GregorianCalendar(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY)+i,1,0,0,0);
                calendaList.add(calendar.getTimeInMillis());// 날짜 타입
                int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK)-1;// 해당 월에 시작하는 요일 -1을 하면 빈칸을 구할수 있다
                int max=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//해당월의 마지막 요일

                for (int j=0;j<dayOfWeek;j++){
                    calendaList.add("empty");// 비어있는 일자 타입
                }

                for (int j=0; j<=max; j++){
                    calendaList.add(new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),j));// 일자타입
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        att_calendarList.setValue(calendaList);
    }
    // push
}
