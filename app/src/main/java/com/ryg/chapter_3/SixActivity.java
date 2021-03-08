package com.ryg.chapter_3;

import android.app.Activity;
import android.os.Bundle;

import com.ryg.chapter_3.ui.MyView;

/**
 * 实现属性动画
 * animation和animator
 * 自定义Animation
 */
public class SixActivity extends Activity {
    private MyView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);
        view = (MyView)findViewById(R.id.view);
    }

    private void move() {

    }

    private void scale() {

    }

    private void rotate(){

    }

    private void alpha() {

    }
}
