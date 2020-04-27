package com.arcotel.network.demo;

import android.content.ContentValues;
import android.util.Log;

public class ScanWcdmaMetadata {
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
    private int cellWcdmaLac;
    private int cellWcdmaUcid;
    private int cellWcdmaPsc;
    private int cellWcdmaCid;
    private int cellWcdmaRnc;
    private int cellWcdmaUarfcn;
    private String signalQuality;
    private int fieldIsRegistered;

    public ScanWcdmaMetadata(String timestamp,String countryISO, String phoneOperatorId, String simOperatorId, String operatorMcc,
                             String operatorMnc, String devManufacturer, String devModel, String isConected, String phoneNetStandard,
                             String phoneNetTechnology, String internetConNetwork, double latitude, double longitude, double pingTimeMilis,
                             double downloadSpeed, double uploadSpeed, int phoneSignalStrength, int phoneAsuStrength, int phoneSignalLevel,
                             int cellWcdmaLac, int cellWcdmaUcid, int cellWcdmaPsc, int cellWcdmaCid, int cellWcdmaRnc, int cellWcdmaUarfcn,
                             String signalQuality, int fieldIsRegistered){
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
        this.cellWcdmaLac = cellWcdmaLac;
        this.cellWcdmaUcid = cellWcdmaUcid;
        this.cellWcdmaPsc = cellWcdmaPsc;
        this.cellWcdmaCid = cellWcdmaCid;
        this.cellWcdmaRnc = cellWcdmaRnc;
        this.cellWcdmaUarfcn = cellWcdmaUarfcn;
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
    public double getPingTimeMilis(){
        return pingTimeMilis;
    }
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
    public int getCellWcdmaLac(){
        return cellWcdmaLac;
    }
    public int getCellWcdmaUcid(){
        return cellWcdmaUcid;
    }
    public int getCellWcdmaPsc(){
        return cellWcdmaPsc;
    }
    public int getCellWcdmaCid(){
        return cellWcdmaCid;
    }
    public int getCellWcdmaRnc(){
        return cellWcdmaRnc;
    }
    public int getCellWcdmaUarfcn(){
        return cellWcdmaUarfcn;
    }
    public String getSignalQuality(){
        return signalQuality;
    }
    public int getFieldIsRegistered(){
        return fieldIsRegistered;
    }

    public ContentValues toContentValues() {
        Log.d("SqlLite","entra a toContenCalues en ScanWcdmaMetadata");
        ContentValues values = new ContentValues();
        values.put(ScanContract.ScanWcdmaContract.TIMESTAMP, timestamp);
        values.put(ScanContract.ScanWcdmaContract.COUNTRYISO, countryISO);
        values.put(ScanContract.ScanWcdmaContract.PHONEOPERATORID, phoneOperatorId);
        values.put(ScanContract.ScanWcdmaContract.SIMOPERATORID, simOperatorId);
        values.put(ScanContract.ScanWcdmaContract.OPERATORMCC, operatorMcc);
        values.put(ScanContract.ScanWcdmaContract.OPERATORMNC, operatorMnc);
        values.put(ScanContract.ScanWcdmaContract.DEVMANUFACTURER, devManufacturer);
        values.put(ScanContract.ScanWcdmaContract.DEVMODEL, devModel);
        values.put(ScanContract.ScanWcdmaContract.ISCONECTED, isConected);
        values.put(ScanContract.ScanWcdmaContract.PHONENETSTANDARD, phoneNetStandard);
        values.put(ScanContract.ScanWcdmaContract.PHONENETTECHNOLOGY, phoneNetTechnology);
        values.put(ScanContract.ScanWcdmaContract.INTERNETCONNETWORK, internetConNetwork);
        values.put(ScanContract.ScanWcdmaContract.LATITUDE, latitude);
        values.put(ScanContract.ScanWcdmaContract.LONGITUDE, longitude);
        values.put(ScanContract.ScanWcdmaContract.PINGTIMEMILIS, pingTimeMilis);
        values.put(ScanContract.ScanWcdmaContract.DOWNLOADSPEED, downloadSpeed);
        values.put(ScanContract.ScanWcdmaContract.UPLOADSPEED, uploadSpeed);
        values.put(ScanContract.ScanWcdmaContract.PHONESIGNALSTRENGTH, phoneSignalStrength);
        values.put(ScanContract.ScanWcdmaContract.PHONEASUSTRENGTH, phoneAsuStrength);
        values.put(ScanContract.ScanWcdmaContract.PHONESIGNALLEVEL, phoneSignalLevel);
        values.put(ScanContract.ScanWcdmaContract.CELLWCDMALAC, cellWcdmaLac);
        values.put(ScanContract.ScanWcdmaContract.CELLWCDMAUCID, cellWcdmaUcid);
        values.put(ScanContract.ScanWcdmaContract.CELLWCDMAPSC, cellWcdmaPsc);
        values.put(ScanContract.ScanWcdmaContract.CELLWCDMACID, cellWcdmaCid);
        values.put(ScanContract.ScanWcdmaContract.CELLWCDMARNC, cellWcdmaRnc);
        values.put(ScanContract.ScanWcdmaContract.CELLWCDMAUARFCN, cellWcdmaUarfcn);
        values.put(ScanContract.ScanWcdmaContract.SIGNALQUALITY, signalQuality);
        values.put(ScanContract.ScanWcdmaContract.FIELDISREGISTERED, fieldIsRegistered);
        return values;
    }



}
