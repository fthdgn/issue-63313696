package com.fthdgn.issue_63313696;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        getCallLog();
    }

    @RequiresPermission(Manifest.permission.READ_CALL_LOG)
    void getCallLog() {
        //Lint should not complain about this line
        getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, CallLog.Calls._ID + " DESC");
    }
}
