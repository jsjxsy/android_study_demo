package com.ryg.chapter_3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * 实现scroll各种方式
 */
public class EightActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
    }
    public void ButtonClick(View view){
        sendBroadcast();
        kill();
    }

    public void kill() {
        int myProcess = android.os.Process.myPid();
        android.os.Process.killProcess(myProcess);
    }

    @SuppressLint("WrongConstant")
    public void sendBroadcast() {
        Log.e("xsy","sendBroadcast");
        Intent startIntent = new Intent();
        startIntent.setPackage(getPackageName());
        startIntent.setAction("com.ryg.chapter_3.action.start");
        startIntent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(startIntent);
    }

}
