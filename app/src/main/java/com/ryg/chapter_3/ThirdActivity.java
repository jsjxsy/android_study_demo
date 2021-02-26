package com.ryg.chapter_3;

import com.ryg.chapter_3.R;
import com.ryg.chapter_3.ui.MyView;
import com.ryg.chapter_3.ui.MyViewGroup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class ThirdActivity extends Activity {
    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

}
