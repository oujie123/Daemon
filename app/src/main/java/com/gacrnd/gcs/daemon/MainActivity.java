package com.gacrnd.gcs.daemon;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.gacrnd.gcs.daemon.activity.KeepManager;
import com.gacrnd.gcs.daemon.service.ForegroundService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1像素保活
        //KeepManager.getInstance().registerKeep(this);

         //前台服务保活
        //startService(new Intent(this, ForegroundService.class));

        //sticky
        startService(new Intent(this, StickyService.class));

        // 账户拉活
//        AccountHelper.addAccount(this);
//        AccountHelper.autoSync();

       // MyJobService.startJob(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //KeepManager.getInstance().unregisterKeep(this);
    }
}
