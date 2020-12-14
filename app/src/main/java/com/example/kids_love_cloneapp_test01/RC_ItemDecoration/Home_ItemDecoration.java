package com.example.kids_love_cloneapp_test01.RC_ItemDecoration;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Home_ItemDecoration extends RecyclerView.ItemDecoration {
    int space;

    public Home_ItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left=space;
        outRect.right=space;
        outRect.bottom=space;

        if (parent.getChildLayoutPosition(view)==0){
            outRect.top=space;
        }else {
            outRect.top=0;
        }
    }
}
