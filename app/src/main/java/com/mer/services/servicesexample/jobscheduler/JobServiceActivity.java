package com.mer.services.servicesexample.jobscheduler;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mer.services.servicesexample.R;

public class JobServiceActivity extends Activity {

    private final String TAG = "JobServiceEx";
    int JOB_ID = 101;
    JobScheduler scheduler;
    JobInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobservice);

        ComponentName componentName = new ComponentName(this, JobServiceEx.class);
        info = new JobInfo.Builder(JOB_ID, componentName)
                .setPeriodic(5000, 5000)
                .build();

        scheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
    }

    protected void startJobService(View view) {
        Log.d(TAG, "startJobService");
        scheduler.schedule(info);
    }

    protected void stopJobService(View view) {
        Log.d(TAG, "stopJobService");
        scheduler.cancel(JOB_ID);
    }
}
