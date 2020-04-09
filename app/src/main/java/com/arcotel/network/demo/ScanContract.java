package com.arcotel.network.demo;

import android.content.ContentValues;
import android.provider.BaseColumns;

public class ScanContract {

    public static abstract class ScanEntry implements BaseColumns {
        public static final String TABLE_NAME ="cellularScan";
        public static final String COUNTRYISO = "countryISO";
        public static final String OPERATORID = "operatorId";
        public static final String OPERATORNAME = "operatorName";
        public static final String ISCONECTED = "isConected";
        public static final String PHONESIGNALTYPE = "phoneSignalType";
        public static final String PHONENETWORKTYPE = "phoneNetworType";
        public static final String SIGNALQUALITY = "signalQuality";
        public static final String NETWORKCONECTIVITYTYPE = "networkConectivityType";
        public static final String PHONESIGNALSTRENGTH = "phoneSignalStrength";
        public static final String DOWNLOADMOVILESPEED = "downloadMovileSpeed";
        public static final String UPLOADMOVILSPEED = "uploadMovileSpeed";
        public static final String WIFISPEED = "wifiSpeed";
        public static final String ISREGISTERED = "isRegistered";
    }
}
