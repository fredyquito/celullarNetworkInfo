package com.arcotel.network.demo;


import android.content.ContentValues;
import android.util.Log;

public class ScanCdmaMetadata {

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
    private int cellBslat;
    private int cellBslon;
    private int cellSid;
    private int cellNid;
    private int cellBid;
    private String signalQuality;
    private int fieldIsRegistered;

    public ScanCdmaMetadata(String timestamp,String countryISO, String phoneOperatorId, String simOperatorId, String operatorMcc,
                            String operatorMnc, String devManufacturer, String devModel, String isConected, String phoneNetStandard,
                            String phoneNetTechnology, String internetConNetwork, double latitude, double longitude, double pingTimeMilis,
                            double downloadSpeed, double uploadSpeed, int phoneSignalStrength, int phoneAsuStrength, int phoneSignalLevel,
                            int cellBslat, int cellBslon, int cellSid, int cellNid, int cellBid, String signalQuality,
                            int fieldIsRegistered){
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
        this.cellBslat = cellBslat;
        this.cellBslon = cellBslon;
        this.cellSid = cellSid;
        this.cellNid = cellNid;
        this.cellBid = cellBid;
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
    public int getCellBslat(){
        return cellBslat;
    }
    public int getCellBslon(){
        return cellBslon;
    }
    public int getCellSid(){
        return cellSid;
    }
    public int getCellNid(){
        return cellNid;
    }
    public int getCellBid(){
        return cellBid;
    }
    public String getSignalQuality(){
        return signalQuality;
    }
    public int getFieldIsRegistered(){
        return fieldIsRegistered;
    }

    public ContentValues toContentValues() {
        Log.d("SqlLite","entra a toContenCalues en ScanCdmaMetadata");
        ContentValues values = new ContentValues();
        values.put(ScanContract.ScanCdmaContract.TIMESTAMP, timestamp);
        values.put(ScanContract.ScanCdmaContract.COUNTRYISO, countryISO);
        values.put(ScanContract.ScanCdmaContract.PHONEOPERATORID, phoneOperatorId);
        values.put(ScanContract.ScanCdmaContract.SIMOPERATORID, simOperatorId);
        values.put(ScanContract.ScanCdmaContract.OPERATORMCC, operatorMcc);
        values.put(ScanContract.ScanCdmaContract.OPERATORMNC, operatorMnc);
        values.put(ScanContract.ScanCdmaContract.DEVMANUFACTURER, devManufacturer);
        values.put(ScanContract.ScanCdmaContract.DEVMODEL, devModel);
        values.put(ScanContract.ScanCdmaContract.ISCONECTED, isConected);
        values.put(ScanContract.ScanCdmaContract.PHONENETSTANDARD, phoneNetStandard);
        values.put(ScanContract.ScanCdmaContract.PHONENETTECHNOLOGY, phoneNetTechnology);
        values.put(ScanContract.ScanCdmaContract.INTERNETCONNETWORK, internetConNetwork);
        values.put(ScanContract.ScanCdmaContract.LATITUDE, latitude);
        values.put(ScanContract.ScanCdmaContract.LONGITUDE, longitude);
        values.put(ScanContract.ScanCdmaContract.PINGTIMEMILIS, pingTimeMilis);
        values.put(ScanContract.ScanCdmaContract.DOWNLOADSPEED, downloadSpeed);
        values.put(ScanContract.ScanCdmaContract.UPLOADSPEED, uploadSpeed);
        values.put(ScanContract.ScanCdmaContract.PHONESIGNALSTRENGTH, phoneSignalStrength);
        values.put(ScanContract.ScanCdmaContract.PHONEASUSTRENGTH, phoneAsuStrength);
        values.put(ScanContract.ScanCdmaContract.PHONESIGNALLEVEL, phoneSignalLevel);
        values.put(ScanContract.ScanCdmaContract.CELLBSLAT, cellBslat);
        values.put(ScanContract.ScanCdmaContract.CELLBSLON, cellBslon);
        values.put(ScanContract.ScanCdmaContract.CELLSID, cellSid);
        values.put(ScanContract.ScanCdmaContract.CELLNID, cellNid);
        values.put(ScanContract.ScanCdmaContract.CELLBID, cellBid);
        values.put(ScanContract.ScanCdmaContract.SIGNALQUALITY, signalQuality);
        values.put(ScanContract.ScanCdmaContract.FIELDISREGISTERED, fieldIsRegistered);


        return values;
    }


}
