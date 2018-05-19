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
        for (int i = 1; i < Permissions.permissions.length - 1; i++) {
            if (ContextCompat.checkSelfPermission(this, Permissions.permissions[i]) == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "checkRequestPermissions: permission: " + Permissions.permissions[i] + " already granted");
                takeAction (i);
            } else {
                ActivityCompat.requestPermissions(this, Permissions.permissions, i);
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
                    Log.d(TAG, "onRequestPermissionsResult: permission " + Permissions.permissions[i] + " just granted");
                    takeAction(requestCode);
                }else{
                    Log.d(TAG, "onRequestPermissionsResult: permission " + Permissions.permissions[i] + " refused");
                }
            }
        }
    }


    private void takeAction(int requestCode){
        switch (requestCode){
            case Permissions.WRITE_EXTERNAL_STORAGE :
                Log.d(TAG, "onRequestPermissionsResult: can run WRITE_EXTERNAL_STORAGE and READ_EXTERNAL_STORAGE code now");
                // WRITE_EXTERNAL_STORAGE and READ_EXTERNAL_STORAGE

            case Permissions.CAMERA :
                Log.d(TAG, "onRequestPermissionsResult: can run CAMERA code now");
                // CAMERA

            case Permissions.ACCESS_COARSE_LOCATION :
                Log.d(TAG, "onRequestPermissionsResult: can run ACCESS_COARSE_LOCATION and ACCESS_FINE_LOCATION code now");
                // ACCESS_COARSE_LOCATION and ACCESS_FINE_LOCATION

            case Permissions.READ_CONTACTS :
                Log.d(TAG, "onRequestPermissionsResult: can run READ_CONTACTS and WRITE_CONTACTS code now");
                // READ_CONTACTS and WRITE_CONTACTS

            case Permissions.CALL_PHONE :
                Log.d(TAG, "onRequestPermissionsResult: can run CALL_PHONE code now");
                // CALL_PHONE

        }
    }
}
