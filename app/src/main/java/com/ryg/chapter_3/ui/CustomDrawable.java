package com.ryg.chapter_3.ui;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author xiaosy
 * @create 3/9/21
 * @Describe
 **/
public class CustomDrawable extends Drawable {
    private Paint paintDrawable;

    public CustomDrawable() {
        this.paintDrawable = new Paint();
        this.paintDrawable.setTextSize(40);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        Rect rect = getBounds();
        int cx = rect.centerX()-100;
        int cy = rect.centerY();
        paintDrawable.setColor(Color.parseColor("#0000ff"));
        canvas.drawRect(rect, paintDrawable);
        this.paintDrawable.setColor(Color.parseColor("#00ff00"));
        canvas.drawText("this is test", (float) cx, (float) cy, paintDrawable);
    }

    @Override
    public void setAlpha(int alpha) {
        paintDrawable.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paintDrawable.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @SuppressLint("WrongConstant")
    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
