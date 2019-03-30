package com.mer.services.servicesexample.boundService;

import android.os.Binder;
import android.util.Log;

public class LocalServiceBinder extends Binder {

    private final String TAG = "BoundServiceEx";

    BoundServiceEx getService() {
        Log.d(TAG, "LocalServiceEx getService()");
        return new BoundServiceEx();
    }
}
