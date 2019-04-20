package com.mer.services.servicesexample.foregroundService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mer.services.servicesexample.R;

public class ForeGroundServiceActivity extends Activity {

    TextView textView;
    Intent foregroundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forebround);
        textView = findViewById(R.id.text);
        foregroundService = new Intent(this, ForeGroundService.class);
    }

    protected void startForegroundService(View view) {
        startService(foregroundService);
    }

    protected void stopForegroundService(View view) {
        stopService(foregroundService);
    }
}
