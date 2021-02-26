package com.ryg.chapter_3.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @author xiaosy
 * @create 2/24/21
 * @Describe
 **/
public class ScrollViewEx3 extends ScrollView {
    public ScrollViewEx3(Context context) {
        super(context);
    }

    public ScrollViewEx3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewEx3(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int y = (int)ev.getY();
        Log.e("xsy","y="+y);
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                if(y < 1000){
                    intercepted = true;
                }else{
                    intercepted = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
            default:
                break;
        }
        return intercepted;
    }
}
