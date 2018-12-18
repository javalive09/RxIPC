package com.javalive09.ipc;

import com.javalive09.ipclib.IMethod;
import com.javalive09.ipclib.IPCHelper;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by peter on 2018/12/18
 */
public class Ser extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IPCHelper.registerMethod(new IMethod() {
            @Override
            public Bundle onCall(@NonNull String s, @Nullable String s1, @Nullable Bundle bundle) {
                SystemClock.sleep(5000);
                Bundle bundle1 = new Bundle();
                bundle1.putString("abc", "ipc.....");
                return bundle1;
            }
        }, "ipc-test");

    }
}
