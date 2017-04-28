package com.example.sergey.androidhomework1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ToastService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
// We want this service to continue running until it is explicitly
// stopped, so return sticky.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    private final IToastServiceInterface.Stub mBinder = new IToastServiceInterface.Stub() {
        public void createToast(String str)  {
            Toast.makeText(getBaseContext(), str, Toast.LENGTH_LONG).show();
        }
    };

}
