package com.ahmed_smae.requestingmultiblepermissions;

import android.Manifest;

/**
 * Created by Ahmed Afifi on 5/19/2018.
 */
public class Permissions {
    public static String[] permissions = new String[]{
            "",
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            //Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            //Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_CONTACTS,
            //Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.CALL_PHONE
    };

    public static final int WRITE_EXTERNAL_STORAGE = 1;
    //public static final int READ_EXTERNAL_STORAGE = 2;
    public static final int CAMERA = 3;
    public static final int ACCESS_COARSE_LOCATION = 4;
    //public static final int ACCESS_FINE_LOCATION = 5;
    public static final int READ_CONTACTS = 6;
    //public static final int WRITE_CONTACTS = 7;
    public static final int CALL_PHONE = 8;


}
