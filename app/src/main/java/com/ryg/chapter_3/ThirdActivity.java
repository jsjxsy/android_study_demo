package com.ryg.chapter_3;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.ryg.chapter_3.ui.MyView;

public class ThirdActivity extends Activity {
    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        final MyView view = (MyView) findViewById(R.id.view);
        Log.e(TAG,"onCreate");
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
                Log.e(TAG, "screen point[x=" + globalPoint[0]+", y="+globalPoint[1]+"]");

                int[] windowPoint = new int[2];
                view.getLocationInWindow(windowPoint);
                Log.e(TAG, "window point[x=" + windowPoint[0]+", y="+windowPoint[1]+"]");

            }
        });

    }



}
