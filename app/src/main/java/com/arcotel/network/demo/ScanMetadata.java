package com.arcotel.network.demo;

import android.content.ContentValues;
import android.util.Log;

import java.util.UUID;

public class ScanMetadata {

    private String countryISO;
    private String operatorId;
    private String operatorName;
    private String isConected;
    private String phoneSignalType;
    private String phoneNetworType;
    private String signalQuality;
    private String networkConectivityType;
    private int phoneSignalStrength;
    private int downloadMovileSpeed;
    private int uploadMovileSpeed;
    private int wifiSpeed;
    private int isRegistered;


    public ScanMetadata(String countryISO,String operatorId, String operatorName,String isConected, String phoneSignalType,
                        String phoneNetworType, String signalQuality, String networkConectivityType, int phoneSignalStrength, int  downloadMovileSpeed,
                        int uploadMovileSpeed,int wifiSpeed, int isRegistered ) {
        this.countryISO = countryISO;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.isConected = isConected;
        this.phoneSignalType = phoneSignalType;
        this.phoneNetworType = phoneNetworType;
        this.signalQuality = signalQuality;
        this.networkConectivityType = networkConectivityType;
        this.phoneSignalStrength = phoneSignalStrength;
        this.downloadMovileSpeed = downloadMovileSpeed;
        this.uploadMovileSpeed = uploadMovileSpeed;
        this.wifiSpeed = wifiSpeed;
        this.isRegistered = isRegistered;
    }

    public String getCountryISO() {
        return countryISO;
    }
    public String getOperatorId() {
        return operatorId;
    }
    public String getOperatorName() {
        return operatorName;
    }
    public String getIsConected() {
        return isConected;
    }
    public String getPhoneSignalType() {
        return phoneSignalType;
    }
    public String getPhoneNetworType() {
        return phoneNetworType;
    }
    public String getSignalQuality() {
        return signalQuality;
    }
    public String getNetworkConectivityType() {
        return networkConectivityType;
    }
    public int getPhoneSignalStrength() {
        return phoneSignalStrength;
    }
    public int getDownloadMovileSpeed() {
        return downloadMovileSpeed;
    }
    public int getUploadMovileSpeed() {
        return uploadMovileSpeed;
    }
    public int getWifiSpeed() {
        return wifiSpeed;
    }
    public int isRegistered(){
        return isRegistered;
    }

    public ContentValues toContentValues() {
        Log.d("SqlLite","entra a toContenCalues en ScanMetaData");
        ContentValues values = new ContentValues();
        values.put(ScanContract.ScanEntry.COUNTRYISO, countryISO);
        values.put(ScanContract.ScanEntry.OPERATORID, operatorId);
        values.put(ScanContract.ScanEntry.OPERATORNAME, operatorName);
        values.put(ScanContract.ScanEntry.ISCONECTED, isConected);
        values.put(ScanContract.ScanEntry.PHONESIGNALTYPE, phoneSignalType);
        values.put(ScanContract.ScanEntry.PHONENETWORKTYPE, phoneNetworType);
        values.put(ScanContract.ScanEntry.SIGNALQUALITY, signalQuality);
        values.put(ScanContract.ScanEntry.NETWORKCONECTIVITYTYPE, networkConectivityType);
        values.put(ScanContract.ScanEntry.PHONESIGNALSTRENGTH, phoneSignalStrength);
        values.put(ScanContract.ScanEntry.DOWNLOADMOVILESPEED, downloadMovileSpeed);
        values.put(ScanContract.ScanEntry.UPLOADMOVILSPEED, uploadMovileSpeed);
        values.put(ScanContract.ScanEntry.WIFISPEED, wifiSpeed);
        values.put(ScanContract.ScanEntry.ISREGISTERED, isRegistered);
        return values;
    }


}
