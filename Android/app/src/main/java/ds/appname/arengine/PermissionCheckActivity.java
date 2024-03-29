/*
 * Copyright 2017 Maxst, Inc. All Rights Reserved.
 */

package ds.appname.arengine;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import ds.appname.arengine.instantTracker.InstantTrackerActivity;

import java.util.ArrayList;

public class PermissionCheckActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermission();
    }

    private void checkPermission() {
        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                startActivity(new Intent(PermissionCheckActivity.this, InstantTrackerActivity.class));
                finish();
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String deniedString : deniedPermissions) {
                    stringBuilder.append(deniedString);
                    stringBuilder.append("\n");
                }

                stringBuilder.append("Permission denied");
                Toast.makeText(PermissionCheckActivity.this, stringBuilder.toString(), Toast.LENGTH_SHORT).show();
                finish();
            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionlistener)
                .setPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
    }
}
