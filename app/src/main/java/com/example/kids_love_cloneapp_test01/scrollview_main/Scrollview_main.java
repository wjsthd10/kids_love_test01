package com.example.kids_love_cloneapp_test01.scrollview_main;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class Scrollview_main extends ScrollView {

    public Scrollview_main(Context context) {
        super(context);
    }

    public Scrollview_main(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public Scrollview_main(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
    }

    @Override
    public void setOnScrollChangeListener(OnScrollChangeListener l) {
        super.setOnScrollChangeListener(l);
    }
}
