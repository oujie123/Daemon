package com.gacrnd.gcs.daemon;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.gacrnd.gcs.daemon.account.AccountHelper;
import com.gacrnd.gcs.daemon.activity.KeepManager;
import com.gacrnd.gcs.daemon.jobscheduler.MyJobService;
import com.gacrnd.gcs.daemon.service.ForegroundService;
import com.gacrnd.gcs.daemon.workmanager.KeepLiveWork;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1像素保活
        // KeepManager.getInstance().registerKeep(this);

         //前台服务保活
        //startService(new Intent(this, ForegroundService.class));

        //sticky
        //startService(new Intent(this, StickyService.class));

        // 账户拉活
//        AccountHelper.addAccount(this);
//        AccountHelper.autoSync();

//        MyJobService.startJob(this);

        OneTimeWorkRequest oneTimeWorkRequest = new OneTimeWorkRequest
                .Builder(KeepLiveWork.class)
                .setInitialDelay(10, TimeUnit.SECONDS)
                .build();

        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //KeepManager.getInstance().unregisterKeep(this);
    }
}
