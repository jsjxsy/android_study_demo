package com.ryg.chapter_3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ryg.chapter_3.ui.MyView;

/**
 * RelativeLayout添加
 * 自定义Drawable实现动画
 */
public class NineActivity extends Activity {
    private MyView view;
    private boolean flag;
    private int originWidth;
    private int originHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        view = (MyView) findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    scaleSmall();
                    moveView();
                    flag = false;
                } else {
                    if (originHeight == 0 || originWidth == 0) {
                        getOriginWidthHeight();
                    }
                    scaleBig();
                    moveViewByBig();
                    flag = true;
                }
            }
        });

    }

    private void getOriginWidthHeight() {
        originWidth = view.getWidth();
        originHeight = view.getHeight();
    }

    private void scaleBig() {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        view.requestLayout();

    }

    private void scaleSmall() {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = originWidth;
        layoutParams.height = originHeight;
        view.requestLayout();
    }

    private void moveView(){
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = 100;
        layoutParams.rightMargin = 100;
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        view.requestLayout();
    }

    private void moveViewByBig(){
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = 0;
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams.removeRule(RelativeLayout.ALIGN_PARENT_TOP);

    }
}
