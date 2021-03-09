package com.ryg.chapter_3;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

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
        view = (MyView) findViewById(R.id.view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveByObjectAnimator();
//                moveByValueAnimator();
//                move();
//                moveAnimatorSet();
//                scale();
//                rotate();
//                alpha();
            }
        });
    }

    private void move() {
        int right = view.getRight();
        ViewGroup viewParent = (ViewGroup) view.getParent();
        int viewParentWidth = viewParent.getWidth();
        int translationX = viewParentWidth - right;
        ObjectAnimator animator = ObjectAnimator
                .ofFloat(view, "translationX", (float) translationX);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.setDuration(1000 * 2);
        animator.setRepeatMode(ObjectAnimator.REVERSE);
        animator.start();
    }



    private void moveByValueAnimator(){
        int right = view.getRight();
        ViewGroup viewParent = (ViewGroup) view.getParent();
        int viewParentWidth = viewParent.getWidth();
        int translationX = viewParentWidth - right;

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, translationX);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float)animation.getAnimatedValue();
                view.setTranslationX(value);
            }
        });
        valueAnimator.setDuration(1000 * 2);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }


    private void moveByObjectAnimator(){

       ViewHolder viewHolder = new ViewHolder(view);
        int right = view.getRight();
        ViewGroup viewParent = (ViewGroup) view.getParent();
        int viewParentWidth = viewParent.getWidth();
        int translationX = viewParentWidth - right;
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(viewHolder, "move",(float) translationX)
               .setDuration(1000);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.start();
    }


    private class ViewHolder{
        private View targetView;

        public ViewHolder(View targetView) {
            this.targetView = targetView;
        }

        public float getMove(){
            return 0;
        }
        public void setMove(float value){
            view.setTranslationX(value);
        }
    }

    private void moveAnimatorSet() {
        AnimatorSet animatorSet = new AnimatorSet();
        ViewGroup viewParent = (ViewGroup) view.getParent();
        int viewParentWidth = viewParent.getWidth();
        int translationX1 = viewParentWidth - view.getRight();
        int translationX2 = -view.getLeft();
        ObjectAnimator animator1 = ObjectAnimator
                .ofFloat(view, "translationX", 0, (float) translationX1);
        ObjectAnimator animator2 = ObjectAnimator
                .ofFloat(view, "translationX", (float) translationX1, (float) translationX2);
        animator2.setRepeatCount(ObjectAnimator.INFINITE);
        animator2.setRepeatMode(ObjectAnimator.REVERSE);
//        animatorSet.playSequentially(animator1, animator2);
//        animatorSet.play(animator2).after(animator1);
        animatorSet.play(animator1).before(animator2);
        animatorSet.setDuration(1000 * 1);
        animatorSet.start();
    }

    private void scale() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(view, "scaleX", 2);
        objectAnimator1.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator1.setRepeatMode(ObjectAnimator.REVERSE);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(view, "scaleY", 2);
        objectAnimator2.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator2.setRepeatMode(ObjectAnimator.REVERSE);
        animatorSet.playTogether(objectAnimator1, objectAnimator2);
        animatorSet.start();
    }

    private void rotate() {
        ObjectAnimator.ofFloat(view, "rotationX", 0,360).start();
//        ObjectAnimator.ofFloat(view, "rotation", 0,360).start();
    }

    private void alpha() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,"alpha", 1, 0, 1);
        objectAnimator.setDuration(1000 * 2);
        objectAnimator.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
