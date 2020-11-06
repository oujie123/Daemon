package com.gacrnd.gcs.daemon.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.gacrnd.gcs.daemon.jobscheduler.MyJobService;


public class KeepLiveWork extends Worker {

    public KeepLiveWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.e("Jack", "doWork: ");

        MyJobService.startJob(getApplicationContext());

        return Result.success();
    }
}
