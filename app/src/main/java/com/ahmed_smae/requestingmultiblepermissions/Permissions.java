package com.ahmed_smae.requestingmultiblepermissions;

import android.Manifest;

/**
 * Created by Ahmed Afifi on 5/19/2018.
 */
public class Permissions {
    public static String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.CALL_PHONE
    };

    public static Integer[] requestCodes = new Integer[]{
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8
    };


}
