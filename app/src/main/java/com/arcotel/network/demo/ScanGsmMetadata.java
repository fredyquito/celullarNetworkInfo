package com.arcotel.network.demo;

import android.content.ContentValues;
import android.util.Log;

public class ScanGsmMetadata {

    private String timestamp;
    private String countryISO;
    private String phoneOperatorId;
    private String simOperatorId;
    private String operatorMcc;
    private String operatorMnc;
    private String devManufacturer;
    private String devModel;
    private String isConected;
    private String phoneNetStandard;
    private String phoneNetTechnology;
    private String internetConNetwork;
    private double latitude;
    private double longitude;
    private double pingTimeMilis;
    private double downloadSpeed;
    private double uploadSpeed;
    private int phoneSignalStrength;
    private int phoneAsuStrength;
    private int phoneSignalLevel;
    private int cellGsmLac;
    private int cellGsmCid;
    private int cellGsmArcfn;
    private String signalQuality;
    private int fieldIsRegistered;

    public ScanGsmMetadata(String timestamp, String countryISO, String phoneOperatorId, String simOperatorId, String operatorMcc,
                           String operatorMnc, String devManufacturer, String devModel, String isConected, String phoneNetStandard,
                           String phoneNetTechnology, String internetConNetwork, double latitude, double longitude, double pingTimeMilis,
                           double downloadSpeed, double uploadSpeed, int phoneSignalStrength, int phoneAsuStrength, int phoneSignalLevel,
                           int cellGsmLac, int cellGsmCid, int cellGsmArcfn, String signalQuality, int fieldIsRegistered){
        this.timestamp = timestamp;
        this.countryISO = countryISO;
        this.phoneOperatorId = phoneOperatorId;
        this.simOperatorId = simOperatorId;
        this.operatorMcc = operatorMcc;
        this.operatorMnc = operatorMnc;
        this.devManufacturer = devManufacturer;
        this.devModel = devModel;
        this.isConected = isConected;
        this.phoneNetStandard = phoneNetStandard;
        this.phoneNetTechnology = phoneNetTechnology;
        this.internetConNetwork = internetConNetwork;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pingTimeMilis = pingTimeMilis;
        this.downloadSpeed = downloadSpeed;
        this.uploadSpeed = uploadSpeed;
        this.phoneSignalStrength = phoneSignalStrength;
        this.phoneAsuStrength = phoneAsuStrength;
        this.phoneSignalLevel = phoneSignalLevel;
        this.cellGsmLac = cellGsmLac;
        this.cellGsmCid = cellGsmCid;
        this.cellGsmArcfn = cellGsmArcfn;
        this.signalQuality = signalQuality;
        this.fieldIsRegistered = fieldIsRegistered;
    }

    public String getTimestamp(){
        return timestamp;
    }
    public String getCountryISO(){
        return countryISO;
    }
    public String getPhoneOperatorId(){
        return phoneOperatorId;
    }
    public String getSimOperatorId(){
        return simOperatorId;
    }
    public String getOperatorMcc(){
        return operatorMcc;
    }
    public String getOperatorMnc(){
        return operatorMnc;
    }
    public String getDevManufacturer(){
        return devManufacturer;
    }
    public String getDevModel(){
        return devModel;
    }
    public String getIsConected(){
        return isConected;
    }
    public String getPhoneNetStandard(){
        return phoneNetStandard;
    }
    public String getPhoneNetTechnology(){
        return phoneNetTechnology;
    }
    public String getInternetConNetwork(){
        return internetConNetwork;
    }
    public double getLatitude(){
        return latitude;
    }
    public double getLongitude(){
        return longitude;
    }
    public double getPingTimeMilis(){return pingTimeMilis;}
    public double getDownloadSpeed(){
        return downloadSpeed;
    }
    public double getUploadSpeed(){
        return uploadSpeed;
    }
    public int getPhoneSignalStrength(){
        return phoneSignalStrength;
    }
    public int getPhoneAsuStrength(){
        return phoneAsuStrength;
    }
    public int getPhoneSignalLevel(){
        return phoneSignalLevel;
    }
    public int getCellGsmLac(){
        return cellGsmLac;
    }
    public int getCellGsmCid(){
        return cellGsmCid;
    }
    public int getCellGsmArcfn(){
        return cellGsmArcfn;
    }
    public String getSignalQuality(){
        return signalQuality;
    }
    public int getFieldIsRegistered(){
        return fieldIsRegistered;
    }

    public ContentValues toContentValues() {
        Log.d("SqlLite","entra a toContenCalues en ScanGsmMetadata");
        ContentValues values = new ContentValues();
        values.put(ScanContract.ScanGsmContract.TIMESTAMP, timestamp);
        values.put(ScanContract.ScanGsmContract.COUNTRYISO, countryISO);
        values.put(ScanContract.ScanGsmContract.PHONEOPERATORID, phoneOperatorId);
        values.put(ScanContract.ScanGsmContract.SIMOPERATORID, simOperatorId);
        values.put(ScanContract.ScanGsmContract.OPERATORMCC, operatorMcc);
        values.put(ScanContract.ScanGsmContract.OPERATORMNC, operatorMnc);
        values.put(ScanContract.ScanGsmContract.DEVMANUFACTURER, devManufacturer);
        values.put(ScanContract.ScanGsmContract.DEVMODEL, devModel);
        values.put(ScanContract.ScanGsmContract.ISCONECTED, isConected);
        values.put(ScanContract.ScanGsmContract.PHONENETSTANDARD, phoneNetStandard);
        values.put(ScanContract.ScanGsmContract.PHONENETTECHNOLOGY, phoneNetTechnology);
        values.put(ScanContract.ScanGsmContract.INTERNETCONNETWORK, internetConNetwork);
        values.put(ScanContract.ScanGsmContract.LATITUDE, latitude);
        values.put(ScanContract.ScanGsmContract.LONGITUDE, longitude);
        values.put(ScanContract.ScanGsmContract.PINGTIMEMILIS, pingTimeMilis);
        values.put(ScanContract.ScanGsmContract.DOWNLOADSPEED, downloadSpeed);
        values.put(ScanContract.ScanGsmContract.UPLOADSPEED, uploadSpeed);
        values.put(ScanContract.ScanGsmContract.PHONESIGNALSTRENGTH, phoneSignalStrength);
        values.put(ScanContract.ScanGsmContract.PHONEASUSTRENGTH, phoneAsuStrength);
        values.put(ScanContract.ScanGsmContract.PHONESIGNALLEVEL, phoneSignalLevel);
        values.put(ScanContract.ScanGsmContract.CELLGSMLAC, cellGsmLac);
        values.put(ScanContract.ScanGsmContract.CELLGSMCID, cellGsmCid);
        values.put(ScanContract.ScanGsmContract.CELLGSMARCFN, cellGsmArcfn);
        values.put(ScanContract.ScanGsmContract.SIGNALQUALITY, signalQuality);
        values.put(ScanContract.ScanGsmContract.FIELDISREGISTERED, fieldIsRegistered);
        return values;
    }



}
