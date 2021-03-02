package com.youximao.sdk.app.floatwindow;

import android.app.Activity;
import android.os.Bundle;



public class WindowActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fw_activity_main);
        FloatWindowService.startService(this, false);
    }



//    private void start() {
//        if (null != mInterface) {
//            Activity mContext = mInterface.getActivity();
//            FloatWindowService.startService(mContext, isShowNavigationBar);
//            ServiceInterfaceManager.setServiceInterface(new ServiceInterface() {
//                @Override
//                public void showFloatWindow() {
//                    if (FloatWindowService.getInstance() != null) {
//                        FloatWindowService.getInstance().showSmallWindow();
//                    }
//                }
//
//                @Override
//                public void hideFloatWindow() {
//                    if (FloatWindowService.getInstance() != null) {
//                        FloatWindowService.getInstance().hideSmallWindow();
//                    }
//                }
//
//                @Override
//                public void stopFloatWindow() {
//                    HostInterface mInterface = HostInterfaceManager.getInstance().getHostInterface();
//                    if (null != mInterface) {
//                        Context mContext = mInterface.getActivity();
//                        if (FloatWindowService.getInstance() != null) {
//                            FloatWindowService.stopService(mContext);
//                        }
//                    } else {
//                        FloatWindowService.stopService(WindowActivity.this);
//                    }
//                }
//            });
//            finish();
//        } else {
//            FloatWindowService.startService(WindowActivity.this, isShowNavigationBar);
//        }
//    }


}
