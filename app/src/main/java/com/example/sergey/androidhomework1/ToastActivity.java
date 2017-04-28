package com.example.sergey.androidhomework1;

import android.support.v7.app.AppCompatActivity;
import android.content.ComponentName;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startService(new Intent(getBaseContext(), ToastService.class));
        setContentView(R.layout.activity_toast);
    }
    @Override
    protected void onDestroy()
    {
        stopService(new Intent(getBaseContext(), ToastService.class));
        super.onDestroy();
    }

    public void startService(View view) {
        //startService(new Intent(getBaseContext(), ToastService.class));
    }
    public void stopService(View view) {
        //stopService(new Intent(getBaseContext(), ToastService.class));
    }
}
