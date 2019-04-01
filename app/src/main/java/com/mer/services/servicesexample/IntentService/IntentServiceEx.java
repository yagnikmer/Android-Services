package com.mer.services.servicesexample.IntentService;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

public class IntentServiceEx extends IntentService {

    private static final String TAG = "IntentServiceEx";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    public IntentServiceEx() {
        super(TAG);
        Log.d(TAG, "IntentServiceEx");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");
        String str = intent.getStringExtra("msg");
        for (int i = 0; i < 10; i++) {
            SystemClock.sleep(1000);
            Log.d(TAG, str + " - " + i);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
