package com.ryg.chapter_3.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.ryg.chapter_3.MainActivity;

/**
 * @author xiaosy
 * @create 3/4/21
 * @Describe
 **/
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Toast.makeText(context, "this is toast", Toast.LENGTH_SHORT).show();
        Log.e("xsy","BootReceiver");
        if(action.equals("com.ryg.chapter_3.action.start")){
            Log.e("xsy","BootReceiver send message");
            Message obMessage = mHandler.obtainMessage();
            obMessage.obj = context;
            mHandler.sendMessageDelayed(obMessage, 5000);//延时5秒启动；
        }
    }


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Context context = (Context) msg.obj;
            //启动初始页
            startSplashActivity(context);
        }
    };

    private void startSplashActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}