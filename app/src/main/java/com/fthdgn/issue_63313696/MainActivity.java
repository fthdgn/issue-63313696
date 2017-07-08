package com.fthdgn.issue_63313696;

import android.os.Bundle;
import android.provider.CallLog;
import android.support.annotation.RequiresPermission;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCallLog();
    }

    @RequiresPermission(android.Manifest.permission.READ_CALL_LOG)
    void getCallLog() {
        getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, CallLog.Calls._ID + " DESC");

    }
}
