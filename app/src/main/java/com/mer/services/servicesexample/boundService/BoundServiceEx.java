package com.mer.services.servicesexample.boundService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BoundServiceEx extends Service {
    private final IBinder iBinder = new LocalServiceEx();
    private final String TAG = "BoundServiceEx";

    public class LocalServiceEx extends Binder {
        BoundServiceEx getService() {
            Log.d(TAG, "LocalServiceEx getService()");
            return BoundServiceEx.this;
        }
    }

    public String getMsg() {
        return "Hello";
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand(Intent, flags, startId)");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind(Intent) Mandatory");
        return iBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind(Intent)");
        super.onRebind(intent);
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
