package com.ryg.chapter_3;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.ryg.chapter_3.ui.MyView;

public class ThirdActivity extends Activity {
    private static final String TAG = "ThirdActivity";
    private MyView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        view = (MyView) findViewById(R.id.view);
        Log.e(TAG, "onCreate");
        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Rect localRect = new Rect();
                view.getLocalVisibleRect(localRect);
                Log.e(TAG, "local rect=" + localRect);
                Rect globalRect = new Rect();
                view.getGlobalVisibleRect(globalRect);
                Log.e(TAG, "global rect=" + globalRect);

                int[] globalPoint = new int[2];
                view.getLocationOnScreen(globalPoint);
                Log.e(TAG, "screen point[x=" + globalPoint[0] + ", y=" + globalPoint[1] + "]");

                int[] windowPoint = new int[2];
                view.getLocationInWindow(windowPoint);
                Log.e(TAG, "window point[x=" + windowPoint[0] + ", y=" + windowPoint[1] + "]");

            }
        });
        measureView();
    }
    //获取view的宽度和长度
    private void measureView() {
        int widthMeasureSize = dp2px(this, 100);
        int widthMeasureMode = View.MeasureSpec.EXACTLY;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(widthMeasureSize, widthMeasureMode);
        int heightMeasureSize = dp2px(this, 100);
        int heightMeasureMode = View.MeasureSpec.EXACTLY;
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(heightMeasureSize, heightMeasureMode);
        view.measure(widthMeasureSpec, heightMeasureSpec);
        int width = view.getMeasuredWidth();
        int height = view.getMeasuredHeight();
        Log.e("xsy","width="+width+", height="+height);
    }

    /**
     * convert dp to its equivalent px
     * <p>
     * 将dp转换为与之相等的px
     */
    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
