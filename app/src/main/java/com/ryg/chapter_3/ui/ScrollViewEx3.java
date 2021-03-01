package com.ryg.chapter_3.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * @author xiaosy
 * @create 2/24/21
 * @Describe
 **/
public class ScrollViewEx3 extends ScrollView {
    private ListView listView;

    public void setListView(ListView listView) {
        this.listView = listView;
    }


    public ScrollViewEx3(Context context) {
        super(context);
    }

    public ScrollViewEx3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewEx3(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    int startY=0;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;

        int top = listView.getTop();
        int bottom = listView.getBottom();
        Log.e("xsy","top="+top+", bottom="+bottom);

        Rect rect = new Rect();
        listView.getGlobalVisibleRect(rect);
        Log.e("xsy","rect"+rect);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startY =  (int) ev.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                int y = (int) ev.getRawY();
                Log.e("xsy","startY="+startY);
                Log.e("xsy","y="+y);
                bottom = top+ rect.bottom;
                //down
                if (y > rect.top && y< rect.bottom && y > startY && listView.getFirstVisiblePosition() == 0) {
                    intercepted = true;
                    Log.e("xsy", "down");
                    //up
                } else if (y > rect.top && y< rect.bottom && y < startY && listView.getLastVisiblePosition() == listView.getCount() - 1) {
                    Log.e("xsy", "up");
                    intercepted = true;
                } else if (y < rect.top || y > rect.bottom) {
                    Log.e("xsy", "y < top || y > bottom");
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
            default:
                break;
        }
        return super.onInterceptTouchEvent(ev) && intercepted;
    }

}
