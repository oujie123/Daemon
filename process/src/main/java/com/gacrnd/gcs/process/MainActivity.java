package com.gacrnd.gcs.process;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 双进程 + 前台服务 + job
        startService(new Intent(this, LocalService.class));
        startService(new Intent(this, RemoteService.class));
        MyJobService.startJob(this);
    }
}
