package com.ryg.chapter_3.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * @author xiaosy
 * @create 3/9/21
 * @Describe
 **/
public class CustomAnimation extends Animation {
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }
}
