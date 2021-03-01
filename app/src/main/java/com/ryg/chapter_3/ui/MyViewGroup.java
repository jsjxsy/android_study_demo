package com.ryg.chapter_3.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * @author xiaosy
 * @create 2/23/21
 * @Describe
 **/
public class MyViewGroup extends LinearLayout implements View.OnTouchListener, View.OnClickListener {
    public static final String TAG = MyViewGroup.class.getSimpleName();

    public MyViewGroup(Context context) {
        super(context);
        setWillNotDraw(true);
//        setOnTouchListener(this);
//        setOnClickListener(this);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(true);
//        setOnTouchListener(this);
//        setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public MyViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setWillNotDraw(true);
//        setOnTouchListener(this);
//        setOnClickListener(this);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int measuredWidth = 0;
//        int measuredHeight = 0;
//        final int childCount = getChildCount();
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
//
//        int widthSpaceSize = MeasureSpec.getSize(widthMeasureSpec);
//        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightSpaceSize = MeasureSpec.getSize(heightMeasureSpec);
//        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
//        if (childCount == 0) {
//            setMeasuredDimension(0, 0);
//        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
//            final View childView = getChildAt(0);
//            measuredHeight = childView.getMeasuredHeight();
//            setMeasuredDimension(widthSpaceSize, childView.getMeasuredHeight());
//        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
//            final View childView = getChildAt(0);
//            measuredWidth = childView.getMeasuredWidth() * childCount;
//            setMeasuredDimension(measuredWidth, heightSpaceSize);
//        } else {
//            final View childView = getChildAt(0);
//            measuredWidth = childView.getMeasuredWidth() * childCount;
//            measuredHeight = childView.getMeasuredHeight();
//            setMeasuredDimension(measuredWidth, measuredHeight);
//        }
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        Log.d(TAG, "width:" + getWidth());
//        int childLeft = 0;
//        final int childCount = getChildCount();
//
//        for (int i = 0; i < childCount; i++) {
//            final View childView = getChildAt(i);
//            if (childView.getVisibility() != View.GONE) {
//                final int childWidth = childView.getMeasuredWidth();
//                childView.layout(childLeft, 0, childLeft + childWidth,
//                        childView.getMeasuredHeight());
//                childLeft += childWidth;
//            }
//        }
//    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean flag = false;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "dispatchTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                if (!flag) {
                    return true;
                }
                Log.e(TAG, "dispatchTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "dispatchTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "dispatchTouchEvent CANCEL");
                break;
            default:
                Log.e(TAG, "dispatchTouchEvent");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onInterceptTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onInterceptTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onInterceptTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onInterceptTouchEvent CANCEL");
                break;
            default:
                Log.e(TAG, "onInterceptTouchEvent");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        int childLeft = 0;
//        int childCount = getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            final View childView = getChildAt(i);
//            if (childView.getVisibility() != View.GONE) {
//                final int childWidth = childView.getMeasuredWidth();
//                Log.e("xsy", "childWidth=" + childWidth);
//                Log.e("xsy", "childHeight=" + childView.getMeasuredHeight());
//                childView.layout(childLeft, 0, childLeft + childWidth,
//                        childView.getMeasuredHeight());
//                childLeft += childWidth;
//            }
//        }
//    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
//    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouchEvent DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouchEvent MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouchEvent UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onTouchEvent CANCEL");
                break;
            default:
                Log.e(TAG, "onTouchEvent");
                break;
        }
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG, "onTouch DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG, "onTouch MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG, "onTouch UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.e(TAG, "onTouch CANCEL");
                break;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        Log.e(TAG, "onClick");
    }

}
