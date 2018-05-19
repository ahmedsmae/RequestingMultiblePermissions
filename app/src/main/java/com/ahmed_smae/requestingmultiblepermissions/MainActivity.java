package com.ahmed_smae.requestingmultiblepermissions;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btnRequestPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRequestPermissions = findViewById(R.id.btnRequestPermissions);
        btnRequestPermissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkRequestPermissions();
            }
        });


    }

    private void checkRequestPermissions(){
        for (int i = 0; i < Permissions.permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(this, Permissions.permissions[i]) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "checkRequestPermissions: permission: " + Permissions.permissions[i] + " already granted");
                takeAction (Permissions.requestCodes[i]);
            } else {
                ActivityCompat.requestPermissions(this, new String[] {Permissions.permissions[i]}, Permissions.requestCodes[i + 1]);
                Log.d(TAG, "checkRequestPermissions: requesting permission for " + Permissions.permissions[i]);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: starts");
        if (grantResults.length > 0){
            for (int i = 0; i < grantResults.length; i++){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    Log.d(TAG, "onRequestPermissionsResult: permission " + permissions[i] + " just granted");
                    takeAction(requestCode);
                }else{
                    Log.d(TAG, "onRequestPermissionsResult: permission " + permissions[i] + " refused");
                }
            }
        }
    }


    private void takeAction(int i){
        switch (i){
            case 1:
                Log.d(TAG, "onRequestPermissionsResult: can run " + Permissions.permissions[1] + " code now");
                // WRITE_EXTERNAL_STORAGE

            case 2:
                Log.d(TAG, "onRequestPermissionsResult: can run " + Permissions.permissions[2] + " code now");
                // READ_EXTERNAL_STORAGE

            case 3:
                Log.d(TAG, "onRequestPermissionsResult: can run " + Permissions.permissions[3] + " code now");
                // CAMERA

            case 4:
                Log.d(TAG, "onRequestPermissionsResult: can run " + Permissions.permissions[4] + " code now");
                // ACCESS_COARSE_LOCATION

            case 5:
                Log.d(TAG, "onRequestPermissionsResult: can run " + Permissions.permissions[5] + " code now");
                // ACCESS_FINE_LOCATION

            case 6:
                Log.d(TAG, "onRequestPermissionsResult: can run " + Permissions.permissions[6] + " code now");
                // READ_CONTACTS

            case 7:
                Log.d(TAG, "onRequestPermissionsResult: can run " + Permissions.permissions[7] + " code now");
                // WRITE_CONTACTS

            case 8:
                Log.d(TAG, "onRequestPermissionsResult: can run " + Permissions.permissions[8] + " code now");
                // CALL_PHONE

        }
    }
}
