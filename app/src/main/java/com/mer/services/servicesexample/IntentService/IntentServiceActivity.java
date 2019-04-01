package com.mer.services.servicesexample.IntentService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mer.services.servicesexample.R;

public class IntentServiceActivity extends Activity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        intent = new Intent(this, IntentServiceEx.class);
    }

    public void startService(View view) {
        intent.putExtra("msg", "Yagnik");
        startService(intent);
    }

    public void stopService(View view) {
        stopService(intent);
    }
}
