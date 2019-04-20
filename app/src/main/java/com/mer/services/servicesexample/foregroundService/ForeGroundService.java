package com.mer.services.servicesexample.foregroundService;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ForeGroundService extends Service {
    public static final String TAG = "ForeGroundServiceEx";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        Notification notification = new Notification.Builder(this)
                .build();
        startForeground(100, notification);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        stopForeground(false);
        stopForeground(STOP_FOREGROUND_DETACH);
        stopForeground(STOP_FOREGROUND_REMOVE);
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }
}
