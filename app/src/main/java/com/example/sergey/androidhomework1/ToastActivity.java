package com.example.sergey.androidhomework1;

import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class ToastActivity extends AppCompatActivity {

    private IToastServiceInterface toastService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_toast);

        Intent serviceIntent = new Intent()
                .setComponent(new ComponentName(
                        "com.example.sergey.androidhomework1",
                        "com.example.sergey.androidhomework1.ToastService"));
        //startService(new Intent(getBaseContext(), ToastService.class));
        startService(serviceIntent);
        bindService(serviceIntent, mConnection, BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            toastService = IToastServiceInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName className) {
            toastService = null;
        }
    };

    @Override
    protected void onDestroy()
    {
        stopService(new Intent(getBaseContext(), ToastService.class));
        super.onDestroy();
    }

    public void printHello(View view) {
        //startService(new Intent(getBaseContext(), ToastService.class));
        try {
            toastService.createToast("Hello !!!");
        } catch(RemoteException e) {

        }
    }
    public void printGoodbye(View view) {
        try {
            toastService.createToast("Goodbye !!!");
        } catch(RemoteException e) {

        }
    }
}
