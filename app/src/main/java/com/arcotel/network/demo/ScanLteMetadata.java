package com.arcotel.network.demo;

import android.content.ContentValues;
import android.util.Log;

public class ScanLteMetadata {

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
    private int phoneRsrpStrength;
    private int phoneRsrqStrength;
    private double phoneRssnrStrength;
    private int phoneTimingAdvance;
    private int phoneCqiStrength;
    private int cellLtePci;
    private int cellLteTac;
    private int cellLteeNodeB;
    private int cellLteCid;
    private int cellLteEarfcn;
    private String signalQuality;
    private int fieldIsRegistered;


    public ScanLteMetadata(String timestamp, String countryISO, String phoneOperatorId, String simOperatorId, String operatorMcc,
                           String operatorMnc, String devManufacturer, String devModel, String isConected, String phoneNetStandard,
                           String phoneNetTechnology, String internetConNetwork, double latitude, double longitude, double pingTimeMilis,
                           double downloadSpeed, double uploadSpeed, int phoneSignalStrength, int phoneAsuStrength, int phoneSignalLevel,
                           int phoneRsrpStrength, int phoneRsrqStrength, double phoneRssnrStrength, int phoneTimingAdvance,
                           int phoneCqiStrength, int cellLtePci, int cellLteTac, int cellLteeNodeB, int cellLteCid, int cellLteEarfcn,
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
        this.phoneRsrpStrength = phoneRsrpStrength;
        this.phoneRsrqStrength = phoneRsrqStrength;
        this.phoneRssnrStrength = phoneRssnrStrength;
        this.phoneTimingAdvance = phoneTimingAdvance;
        this.phoneCqiStrength = phoneCqiStrength;
        this.cellLtePci = cellLtePci;
        this.cellLteTac = cellLteTac;
        this.cellLteeNodeB = cellLteeNodeB;
        this.cellLteCid = cellLteCid;
        this.cellLteEarfcn = cellLteEarfcn;
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
    public int getPhoneRsrpStrength(){
        return phoneRsrpStrength;
    }
    public int getPhoneRsrqStrength(){
        return phoneRsrqStrength;
    }
    public double getPhoneRssnrStrength(){
        return phoneRssnrStrength;
    }
    public int getPhoneTimingAdvance(){
        return phoneTimingAdvance;
    }
    public int getPhoneCqiStrength(){
        return phoneCqiStrength;
    }
    public int getCellLtePci(){
        return cellLtePci;
    }
    public int getCellLteTac(){
        return cellLteTac;
    }
    public int getCellLteeNodeB(){
        return cellLteeNodeB;
    }
    public int getCellLteCid(){
        return cellLteCid;
    }
    public int getCellLteEarfcn(){
        return cellLteEarfcn;
    }
    public String getSignalQuality(){
        return signalQuality;
    }
    public int getFieldIsRegistered(){
        return fieldIsRegistered;
    }

    public ContentValues toContentValues() {
        Log.d("SqlLite","entra a toContenvalues en ScanLteMetaData");
        ContentValues values = new ContentValues();
        values.put(ScanContract.ScanLteContract.TIMESTAMP, timestamp);
        values.put(ScanContract.ScanLteContract.COUNTRYISO, countryISO);
        values.put(ScanContract.ScanLteContract.PHONEOPERATORID, phoneOperatorId);
        values.put(ScanContract.ScanLteContract.SIMOPERATORID, simOperatorId);
        values.put(ScanContract.ScanLteContract.OPERATORMCC, operatorMcc);
        values.put(ScanContract.ScanLteContract.OPERATORMNC, operatorMnc);
        values.put(ScanContract.ScanLteContract.DEVMANUFACTURER, devManufacturer);
        values.put(ScanContract.ScanLteContract.DEVMODEL, devModel);
        values.put(ScanContract.ScanLteContract.ISCONECTED, isConected);
        values.put(ScanContract.ScanLteContract.PHONENETSTANDARD, phoneNetStandard);
        values.put(ScanContract.ScanLteContract.PHONENETTECHNOLOGY, phoneNetTechnology);
        values.put(ScanContract.ScanLteContract.INTERNETCONNETWORK, internetConNetwork);
        values.put(ScanContract.ScanLteContract.LATITUDE, latitude);
        values.put(ScanContract.ScanLteContract.LONGITUDE, longitude);
        values.put(ScanContract.ScanLteContract.PINGTIMEMILIS, pingTimeMilis);
        values.put(ScanContract.ScanLteContract.DOWNLOADSPEED, downloadSpeed);
        values.put(ScanContract.ScanLteContract.UPLOADSPEED, uploadSpeed);
        values.put(ScanContract.ScanLteContract.PHONESIGNALSTRENGTH, phoneSignalStrength);
        values.put(ScanContract.ScanLteContract.PHONEASUSTRENGTH, phoneAsuStrength);
        values.put(ScanContract.ScanLteContract.PHONESIGNALLEVEL, phoneSignalLevel);
        values.put(ScanContract.ScanLteContract.PHONERSRPSTRENGTH, phoneRsrpStrength);
        values.put(ScanContract.ScanLteContract.PHONERSRQSTRENGTH, phoneRsrqStrength);
        values.put(ScanContract.ScanLteContract.PHONERSSNRSTRENGTH, phoneRssnrStrength);
        values.put(ScanContract.ScanLteContract.PHONETIMINGADVANCE, phoneTimingAdvance);
        values.put(ScanContract.ScanLteContract.PHONECQISTRENGTH, phoneCqiStrength);
        values.put(ScanContract.ScanLteContract.CELLLTEPCI, cellLtePci);
        values.put(ScanContract.ScanLteContract.CELLLTETAC, cellLteTac);
        values.put(ScanContract.ScanLteContract.CELLLTEENODEB, cellLteeNodeB);
        values.put(ScanContract.ScanLteContract.CELLLTECID, cellLteCid);
        values.put(ScanContract.ScanLteContract.CELLLTEEARFCN, cellLteEarfcn);
        values.put(ScanContract.ScanLteContract.SIGNALQUALITY, signalQuality);
        values.put(ScanContract.ScanLteContract.FIELDISREGISTERED, fieldIsRegistered);

        return values;
    }






}
