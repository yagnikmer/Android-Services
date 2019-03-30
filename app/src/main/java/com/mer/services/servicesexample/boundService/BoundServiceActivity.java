package com.mer.services.servicesexample.boundService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.mer.services.servicesexample.R;

public class BoundServiceActivity extends Activity {

    TextView textView;
    boolean isBind = false;
    BoundServiceEx serviceEx;
    private final String TAG = "BoundServiceEx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound);
        textView = findViewById(R.id.text);

        Intent intent = new Intent(this,BoundServiceEx.class);
        bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
    }

    public void getInfo(View view) {
        textView.setText(serviceEx.getMsg());
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "Activity onServiceConnected");
            LocalServiceBinder serviceBinder = (LocalServiceBinder) service;
            serviceEx = serviceBinder.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "Activity onServiceDisconnected");
            isBind = false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBind) {
            unbindService(serviceConnection);
            isBind = false;
        }
    }
}
