package com.mer.services.servicesexample.boundService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BoundServiceEx extends Service {
    private final IBinder iBinder = new LocalServiceBinder();
    private final String TAG = "BoundServiceEx";

    public String getMsg() {
        return "Hello";
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind(Intent) Mandatory");
        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind(Intent)");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }
}
