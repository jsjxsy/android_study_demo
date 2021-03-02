package com.ryg.chapter_3.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ryg.chapter_3.R;

/**
 * @author xiaosy
 * @create 3/2/21
 * @Describe title view
 **/
public class YFHeaderView extends LinearLayout {
    private ImageView img_left;
    private TextView text_center;
    private ImageView img_right;
    private RelativeLayout layout_root;
    private Context context;
    private String element;

    private int showView;

    public YFHeaderView(Context context) {
        super(context);
        this.context = context;
        initView(context);
    }

    public YFHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);
        initAttrs(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public YFHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView(context);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.HeaderBar);
        String title = mTypedArray.getString(R.styleable.HeaderBar_title_text);
        Log.e("xsy", "title=" + title);
        setTitle(title);
        showView = mTypedArray.getInt(R.styleable.HeaderBar_show_views, 0x26);
        Log.e("xsy", "showView=" + showView);
        text_center.setTextColor(mTypedArray.getColor(R.styleable.HeaderBar_title_text_color, Color.WHITE));
        showView(showView);
        mTypedArray.recycle();
    }

    private void showView(int showView) {
        String value = Integer.toBinaryString(showView);
        Log.e("xsy","value="+value);
        Long data = Long.valueOf(Integer.toBinaryString(showView));
        Log.e("xsy","data="+data);
        element = String.format("%06d", data);
        Log.e("xsy", "element=" + element);
        for (int i = 0; i < element.length(); i++) {
            if (i == 0) ;
            if (i == 1)
                text_center.setVisibility(element.substring(i, i + 1).equals("1") ? View.VISIBLE : View.GONE);
            if (i == 2)
                img_right.setVisibility(element.substring(i, i + 1).equals("1") ? View.VISIBLE : View.GONE);
            if (i == 3) ;
            if (i == 4)
                img_left.setVisibility(element.substring(i, i + 1).equals("1") ? View.VISIBLE : View.GONE);
            if (i == 5) ;
        }

    }

    private void initView(final Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_header, this, true);
        img_left = (ImageView) findViewById(R.id.header_left_img);
        img_right = (ImageView) findViewById(R.id.header_right_img);
        text_center = (TextView) findViewById(R.id.header_center_text);
        layout_root = (RelativeLayout) findViewById(R.id.header_root_layout);
//        layout_root.setBackgroundColor(Color.BLACK);
//        text_center.setTextColor(Color.WHITE);

        img_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, element + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            text_center.setText(title);
        }
    }


    private void setLeftListener(OnClickListener onClickListener) {
        img_left.setOnClickListener(onClickListener);
    }

    private void setRightListener(OnClickListener onClickListener) {
        img_right.setOnClickListener(onClickListener);
    }
}
