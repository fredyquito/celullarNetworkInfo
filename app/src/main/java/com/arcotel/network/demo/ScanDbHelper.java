package com.arcotel.network.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Pair;

import androidx.annotation.Nullable;

import java.util.ArrayList;

//import SQLiteOpenHelper;

public class ScanDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ScanArcotelDemo.db";

    public ScanDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("SqlLite","Entra a crear la base de datos "+DATABASE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SqlLite","entra a crear la tabla"+ScanContract.ScanEntry.TABLE_NAME);
        db.execSQL("CREATE TABLE " + ScanContract.ScanEntry.TABLE_NAME + " ("
                + ScanContract.ScanEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ScanContract.ScanEntry.COUNTRYISO + " TEXT NOT NULL,"
                + ScanContract.ScanEntry.OPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanEntry.OPERATORNAME + " TEXT NOT NULL,"
                + ScanContract.ScanEntry.ISCONECTED + " TEXT NOT NULL,"
                + ScanContract.ScanEntry.PHONESIGNALTYPE + " TEXT NOT NULL,"
                + ScanContract.ScanEntry.PHONENETWORKTYPE + " TEXT NOT NULL,"
                + ScanContract.ScanEntry.SIGNALQUALITY + " TEXT NOT NULL,"
                + ScanContract.ScanEntry.NETWORKCONECTIVITYTYPE + " TEXT NOT NULL,"
                + ScanContract.ScanEntry.PHONESIGNALSTRENGTH + " INT NOT NULL,"
                + ScanContract.ScanEntry.DOWNLOADMOVILESPEED + " INT NOT NULL,"
                + ScanContract.ScanEntry.UPLOADMOVILSPEED + " INT NOT NULL,"
                + ScanContract.ScanEntry.WIFISPEED + " INT NOT NULL,"
                + ScanContract.ScanEntry.LATITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanEntry.LONGITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanEntry.ISREGISTERED + " INT NOT NULL,"
                + "UNIQUE (" + ScanContract.ScanEntry._ID + "))");
        Log.d("SqlLite","entra a crear la tabla"+ScanContract.ScanLteContract.TABLE_NAME);
        db.execSQL("CREATE TABLE "+ScanContract.ScanLteContract.TABLE_NAME+" ("
                +ScanContract.ScanLteContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ScanContract.ScanLteContract.TIMESTAMP + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.COUNTRYISO + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.PHONEOPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.SIMOPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.OPERATORMCC + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.OPERATORMNC + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.DEVMANUFACTURER + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.DEVMODEL + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.ISCONECTED + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.PHONENETSTANDARD + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.PHONENETTECHNOLOGY + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.INTERNETCONNETWORK + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.LATITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanLteContract.LONGITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanLteContract.PINGTIMEMILIS + " DOUBLE NOT NULL,"
                + ScanContract.ScanLteContract.DOWNLOADSPEED + " DOUBLE NOT NULL,"
                + ScanContract.ScanLteContract.UPLOADSPEED + " DOUBLE NOT NULL,"
                + ScanContract.ScanLteContract.PHONESIGNALSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.PHONEASUSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.PHONESIGNALLEVEL + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.PHONERSRPSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.PHONERSRQSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.PHONERSSNRSTRENGTH + " DOUBLE NOT NULL,"
                + ScanContract.ScanLteContract.PHONETIMINGADVANCE + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.PHONECQISTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.CELLLTEPCI + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.CELLLTETAC + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.CELLLTEENODEB + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.CELLLTECID + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.CELLLTEEARFCN + " INTEGER NOT NULL,"
                + ScanContract.ScanLteContract.SIGNALQUALITY + " TEXT NOT NULL,"
                + ScanContract.ScanLteContract.FIELDISREGISTERED + " INTEGER NOT NULL,"
                + "UNIQUE (" + ScanContract.ScanLteContract._ID+"))");
        Log.d("SqlLite","entra a crear la tabla"+ScanContract.ScanGsmContract.TABLE_NAME);
        db.execSQL("CREATE TABLE "+ScanContract.ScanGsmContract.TABLE_NAME+" ("
                +ScanContract.ScanGsmContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ScanContract.ScanGsmContract.TIMESTAMP + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.COUNTRYISO + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.PHONEOPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.SIMOPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.OPERATORMCC + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.OPERATORMNC + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.DEVMANUFACTURER + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.DEVMODEL + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.ISCONECTED + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.PHONENETSTANDARD + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.PHONENETTECHNOLOGY + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.INTERNETCONNETWORK + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.LATITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanGsmContract.LONGITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanGsmContract.PINGTIMEMILIS + " DOUBLE NOT NULL,"
                + ScanContract.ScanGsmContract.DOWNLOADSPEED + " DOUBLE NOT NULL,"
                + ScanContract.ScanGsmContract.UPLOADSPEED + " DOUBLE NOT NULL,"
                + ScanContract.ScanGsmContract.PHONESIGNALSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanGsmContract.PHONEASUSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanGsmContract.PHONESIGNALLEVEL + " INTEGER NOT NULL,"
                + ScanContract.ScanGsmContract.CELLGSMLAC + " INTEGER NOT NULL,"
                + ScanContract.ScanGsmContract.CELLGSMCID + " INTEGER NOT NULL,"
                + ScanContract.ScanGsmContract.CELLGSMARCFN + " INTEGER NOT NULL,"
                + ScanContract.ScanGsmContract.SIGNALQUALITY + " TEXT NOT NULL,"
                + ScanContract.ScanGsmContract.FIELDISREGISTERED + " INTEGER NOT NULL,"
                + "UNIQUE (" + ScanContract.ScanGsmContract._ID+"))");
        Log.d("SqlLite","entra a crear la tabla"+ScanContract.ScanWcdmaContract.TABLE_NAME);
        db.execSQL("CREATE TABLE "+ScanContract.ScanWcdmaContract.TABLE_NAME+" ("
                +ScanContract.ScanWcdmaContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ScanContract.ScanWcdmaContract.TIMESTAMP + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.COUNTRYISO + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.PHONEOPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.SIMOPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.OPERATORMCC + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.OPERATORMNC + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.DEVMANUFACTURER + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.DEVMODEL + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.ISCONECTED + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.PHONENETSTANDARD + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.PHONENETTECHNOLOGY + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.INTERNETCONNETWORK + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.LATITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanWcdmaContract.LONGITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanWcdmaContract.PINGTIMEMILIS + " DOUBLE NOT NULL,"
                + ScanContract.ScanWcdmaContract.DOWNLOADSPEED + " DOUBLE NOT NULL,"
                + ScanContract.ScanWcdmaContract.UPLOADSPEED + " DOUBLE NOT NULL,"
                + ScanContract.ScanWcdmaContract.PHONESIGNALSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.PHONEASUSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.PHONESIGNALLEVEL + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.CELLWCDMALAC + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.CELLWCDMAUCID + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.CELLWCDMAPSC + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.CELLWCDMACID + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.CELLWCDMARNC + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.CELLWCDMAUARFCN + " INTEGER NOT NULL,"
                + ScanContract.ScanWcdmaContract.SIGNALQUALITY + " TEXT NOT NULL,"
                + ScanContract.ScanWcdmaContract.FIELDISREGISTERED + " INTEGER NOT NULL,"
                + "UNIQUE (" + ScanContract.ScanWcdmaContract._ID+"))");
        Log.d("SqlLite","entra a crear la tabla"+ScanContract.ScanCdmaContract.TABLE_NAME);
        db.execSQL("CREATE TABLE "+ScanContract.ScanCdmaContract.TABLE_NAME+" ("
                +ScanContract.ScanCdmaContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ScanContract.ScanCdmaContract.TIMESTAMP + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.COUNTRYISO + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.PHONEOPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.SIMOPERATORID + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.OPERATORMCC + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.OPERATORMNC + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.DEVMANUFACTURER + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.DEVMODEL + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.ISCONECTED + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.PHONENETSTANDARD + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.PHONENETTECHNOLOGY + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.INTERNETCONNETWORK + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.LATITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanCdmaContract.LONGITUDE + " DOUBLE NOT NULL,"
                + ScanContract.ScanCdmaContract.PINGTIMEMILIS + " DOUBLE NOT NULL,"
                + ScanContract.ScanCdmaContract.DOWNLOADSPEED + " DOUBLE NOT NULL,"
                + ScanContract.ScanCdmaContract.UPLOADSPEED + " DOUBLE NOT NULL,"
                + ScanContract.ScanCdmaContract.PHONESIGNALSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanCdmaContract.PHONEASUSTRENGTH + " INTEGER NOT NULL,"
                + ScanContract.ScanCdmaContract.PHONESIGNALLEVEL + " INTEGER NOT NULL,"
                + ScanContract.ScanCdmaContract.CELLBSLAT + " INTEGER NOT NULL,"
                + ScanContract.ScanCdmaContract.CELLBSLON + " INTEGER NOT NULL,"
                + ScanContract.ScanCdmaContract.CELLSID + " INTEGER NOT NULL,"
                + ScanContract.ScanCdmaContract.CELLNID + " INTEGER NOT NULL,"
                + ScanContract.ScanCdmaContract.CELLBID + " INTEGER NOT NULL,"
                + ScanContract.ScanCdmaContract.SIGNALQUALITY + " TEXT NOT NULL,"
                + ScanContract.ScanCdmaContract.FIELDISREGISTERED + " INTEGER NOT NULL,"
                + "UNIQUE (" + ScanContract.ScanCdmaContract._ID+"))");


    }

    //Sección de inserción en las tablas
    public void saveSqlScan(ScanMetadata scanMetadata) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Log.d("SqlLite","entra a insert SqlLite");
        sqLiteDatabase.insert(ScanContract.ScanEntry.TABLE_NAME,null,scanMetadata.toContentValues());
    }
    public void saveLteSqlScan(ScanLteMetadata scanLteMetadata) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Log.d("SqlLite","entra a saveLteSqlScan");
        sqLiteDatabase.insert(ScanContract.ScanLteContract.TABLE_NAME,null,scanLteMetadata.toContentValues());
    }
    public void saveWcdmaSqlScan(ScanWcdmaMetadata scanWcdmaMetadata) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Log.d("SqlLite","entra a saveWcdmaSqlScan");
        sqLiteDatabase.insert(ScanContract.ScanWcdmaContract.TABLE_NAME,null,scanWcdmaMetadata.toContentValues());
    }
    public void saveGsmSqlScan(ScanGsmMetadata scanGsmMetadata) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Log.d("SqlLite","entra a saveWcdmaSqlScan");
        sqLiteDatabase.insert(ScanContract.ScanGsmContract.TABLE_NAME,null,scanGsmMetadata.toContentValues());
    }
    public void saveCdmaSqlScan(ScanCdmaMetadata scanCdmaMetadata) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Log.d("SqlLite","entra a saveWcdmaSqlScan");
        sqLiteDatabase.insert(ScanContract.ScanCdmaContract.TABLE_NAME,null,scanCdmaMetadata.toContentValues());
    }

    //Sección de consultas de tablas
    public void querySqlScan(){

    }
    public Cursor getScanInfoById(String scanId) {
        Cursor c = getReadableDatabase().query(
                ScanContract.ScanEntry.TABLE_NAME,
                null,
                ScanContract.ScanEntry._ID + " LIKE ?",new String[]{scanId},
                null,
                null,
                null);
        return c;
    }

    //Sección Update para Json
    public void updateIsRegisteredById(String scanId) {
        ContentValues cv = new ContentValues();
        cv.put(ScanContract.ScanEntry.ISREGISTERED,"1");
        int c = getWritableDatabase().update(ScanContract.ScanEntry.TABLE_NAME,
                cv,ScanContract.ScanEntry._ID + " LIKE ?",new String[]{scanId});
        Log.d("updateIsRegisteredByID","el valor de la consulta es "+c);
    }
    public void updateLteIsRegisteredById(String scanId) {
        ContentValues cv = new ContentValues();
        cv.put(ScanContract.ScanLteContract.FIELDISREGISTERED,"1");
        int c = getWritableDatabase().update(ScanContract.ScanLteContract.TABLE_NAME,
                cv,ScanContract.ScanLteContract._ID + " LIKE ?",new String[]{scanId});
        Log.d("updateIsRegisteredByID","el valor de la consulta es "+c);
    }
    public void updateWcdmaIsRegisteredById(String scanId) {
        ContentValues cv = new ContentValues();
        cv.put(ScanContract.ScanWcdmaContract.FIELDISREGISTERED,"1");
        int c = getWritableDatabase().update(ScanContract.ScanWcdmaContract.TABLE_NAME,
                cv,ScanContract.ScanWcdmaContract._ID + " LIKE ?",new String[]{scanId});
        Log.d("updateIsRegisteredByID","el valor de la consulta es "+c);
    }
    public void updateCdmaIsRegisteredById(String scanId) {
        ContentValues cv = new ContentValues();
        cv.put(ScanContract.ScanCdmaContract.FIELDISREGISTERED,"1");
        int c = getWritableDatabase().update(ScanContract.ScanCdmaContract.TABLE_NAME,
                cv,ScanContract.ScanCdmaContract._ID + " LIKE ?",new String[]{scanId});
        Log.d("updateIsRegisteredByID","el valor de la consulta es "+c);
    }
    public void updateGsmIsRegisteredById(String scanId) {
        ContentValues cv = new ContentValues();
        cv.put(ScanContract.ScanGsmContract.FIELDISREGISTERED,"1");
        int c = getWritableDatabase().update(ScanContract.ScanGsmContract.TABLE_NAME,
                cv,ScanContract.ScanGsmContract._ID + " LIKE ?",new String[]{scanId});
        Log.d("updateIsRegisteredByID","el valor de la consulta es "+c);
    }

    //Seccion consultas para Json
    public Cursor getScanInfoByIsRegistered(int isRegistered) {
        Log.d("getScanInfoByIsRegred","Entra al metodo");
        Cursor c = getReadableDatabase().query(
                ScanContract.ScanEntry.TABLE_NAME,
                null,
                ScanContract.ScanEntry.ISREGISTERED + " LIKE ?",new String[]{String.valueOf(isRegistered)},
                null,
                null,
                null);
        return c;
    }
    public Cursor getScanLteInfoByIsRegistered(int isRegistered) {
        Log.d("LteInfoByIsRegistered","Entra al metodo");
        Cursor c = getReadableDatabase().query(
                ScanContract.ScanLteContract.TABLE_NAME,
                null,
                ScanContract.ScanLteContract.FIELDISREGISTERED + " LIKE ?",new String[]{String.valueOf(isRegistered)},
                null,
                null,
                null);
        return c;
    }
    public Cursor getScanWcdmaInfoByIsRegistered(int isRegistered) {
        Log.d("LteInfoByIsRegistered","Entra al metodo");
        Cursor c = getReadableDatabase().query(
                ScanContract.ScanWcdmaContract.TABLE_NAME,
                null,
                ScanContract.ScanWcdmaContract.FIELDISREGISTERED + " LIKE ?",new String[]{String.valueOf(isRegistered)},
                null,
                null,
                null);
        return c;
    }
    public Cursor getScanCdmaInfoByIsRegistered(int isRegistered) {
        Log.d("LteInfoByIsRegistered","Entra al metodo");
        Cursor c = getReadableDatabase().query(
                ScanContract.ScanCdmaContract.TABLE_NAME,
                null,
                ScanContract.ScanCdmaContract.FIELDISREGISTERED + " LIKE ?",new String[]{String.valueOf(isRegistered)},
                null,
                null,
                null);
        return c;
    }
    public Cursor getScanGsmInfoByIsRegistered(int isRegistered) {
        Log.d("LteInfoByIsRegistered","Entra al metodo");
        Cursor c = getReadableDatabase().query(
                ScanContract.ScanGsmContract.TABLE_NAME,
                null,
                ScanContract.ScanGsmContract.FIELDISREGISTERED + " LIKE ?",new String[]{String.valueOf(isRegistered)},
                null,
                null,
                null);
        return c;
    }

    //Sección crar formato para JSON
    public ArrayList<String> getScanInfoInJson(Cursor getScanInfoByIsRegistered){
        ArrayList<String> jsonQueryFormat = new ArrayList<String>();
        int contador = 0;
        Log.d("getScanInfoInJson","Entra al metodo");
        while(getScanInfoByIsRegistered.moveToNext()){
            Log.d("getScanInfoInJson","Entra al while");
            String scan_id = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry._ID));
            String countryISO = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.COUNTRYISO));
            String operatorId = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.OPERATORID));
            String operatorName = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.OPERATORNAME));
            String isConected = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.ISCONECTED));
            String phoneSignalType = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.PHONESIGNALTYPE));
            String phoneNetworType = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.PHONENETWORKTYPE));
            String signalQuality = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.SIGNALQUALITY));
            String networkConectivityType = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.NETWORKCONECTIVITYTYPE));
            String phoneSignalStrength = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.PHONESIGNALSTRENGTH));
            String downloadMovileSpeed = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.DOWNLOADMOVILESPEED));
            String uploadMovileSpeed = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.UPLOADMOVILSPEED));
            String wifiSpeed = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.WIFISPEED));
            String latitude = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.LATITUDE));
            String longitude = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.LONGITUDE));
            String isRegistered = getScanInfoByIsRegistered.getString(getScanInfoByIsRegistered.getColumnIndex(ScanContract.ScanEntry.ISREGISTERED));

            if (Integer.parseInt(isRegistered) == 0 ){
                Log.d("getScanInfoInJson","Entra al if");
                Log.d("getScanInfoInJson","antes contador es "+contador);
                jsonQueryFormat.add("{\"countryiso\":\""+countryISO+"\"," +
                        "\"operatorid\":\""+operatorId+"\"," +
                        "\"operatorname\":\""+operatorName+"\"," +
                        "\"isconected\":\""+isConected+"\"," +
                        "\"phonesignaltype\":\""+phoneSignalType+"\"," +
                        "\"phonenetworktype\":\""+phoneNetworType+"\"," +
                        "\"signalquality\":\""+signalQuality+"\"," +
                        "\"networkconectivitytype\":\""+networkConectivityType+"\"," +
                        "\"phonesignalstrength\":\""+phoneSignalStrength+"\"," +
                        "\"downloadmovilespeed\":\""+downloadMovileSpeed+"\"," +
                        "\"uploadmovilspeed\":\""+uploadMovileSpeed+"\"," +
                        "\"wifispeed\":\""+wifiSpeed+"\"," +
                        "\"latitude\":\""+latitude+"\"," +
                        "\"longitude\":\""+longitude+"\"}");

                updateIsRegisteredById(scan_id);
                Log.d("getScanInfoInJson","despues contador es "+contador);
                Log.d("getScanInfoInJson","jsonQueryFormat es "+jsonQueryFormat.get(contador));
                contador = contador+1;
            }
        }
        return jsonQueryFormat;
    }
    public ArrayList<String> getScanLteInfoInJson(Cursor getScanLteInfoByIsRegistered){
        ArrayList<String> jsonQueryFormat = new ArrayList<String>();
        int contador = 0;
        Log.d("getScanInfoInJson","Entra al metodo");
        while(getScanLteInfoByIsRegistered.moveToNext()){
            Log.d("getScanInfoInJson","Entra al while");
            String scan_id = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract._ID));
            String timestamp = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.TIMESTAMP));
            String countryISO = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.COUNTRYISO));
            String phoneOperatorId = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONEOPERATORID));
            String simOperatorId = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.SIMOPERATORID));
            String operatorMcc = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.OPERATORMCC));
            String operatorMnc = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.OPERATORMNC));
            String devManufacturer = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.DEVMANUFACTURER));
            String devModel = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.DEVMODEL));
            String isConected = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.ISCONECTED));
            String phoneNetStandard = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONENETSTANDARD));
            String phoneNetTechnology = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONENETTECHNOLOGY));
            String internetConNetwork = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.INTERNETCONNETWORK));
            String latitude = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.LATITUDE));
            String longitude = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.LONGITUDE));
            String pingTimeMilis = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PINGTIMEMILIS));
            String downloadSpeed = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.DOWNLOADSPEED));
            String uploadSpeed = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.UPLOADSPEED));
            String phoneSignalStrength = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONESIGNALSTRENGTH));
            String phoneAsuStrength = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONEASUSTRENGTH));
            String phoneSignalLevel = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONESIGNALLEVEL));
            String phoneRsrpStrength = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONERSRPSTRENGTH));
            String phoneRsrqStrength = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONERSRQSTRENGTH));
            String phoneRssnrStrength = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONERSSNRSTRENGTH));
            String phoneTimingAdvance = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONETIMINGADVANCE));
            String phoneCqiStrength = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.PHONECQISTRENGTH));
            String cellLtePci = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.CELLLTEPCI));
            String cellLteTac = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.CELLLTETAC));
            String cellLteeNodeB = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.CELLLTEENODEB));
            String cellLteCid = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.CELLLTECID));
            String cellLteEarfcn = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.CELLLTEEARFCN));
            String signalQuality = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.SIGNALQUALITY));
            String fieldIsRegistered = getScanLteInfoByIsRegistered.getString(getScanLteInfoByIsRegistered.getColumnIndex(ScanContract.ScanLteContract.FIELDISREGISTERED));


            if (Integer.parseInt(fieldIsRegistered) == 0 ){
                Log.d("getScanInfoInJson","Entra al if");
                Log.d("getScanInfoInJson","antes contador es "+contador);
                jsonQueryFormat.add("{\"timestamp\":\""+timestamp+"\"," +
                        "\"countryISO\":\""+countryISO+"\"," +
                        "\"phoneOperatorId\":\""+phoneOperatorId+"\"," +
                        "\"simOperatorId\":\""+simOperatorId+"\"," +
                        "\"operatorMcc\":\""+operatorMcc+"\"," +
                        "\"operatorMnc\":\""+operatorMnc+"\"," +
                        "\"devManufacturer\":\""+devManufacturer+"\"," +
                        "\"devModel\":\""+devModel+"\"," +
                        "\"isConected\":\""+isConected+"\"," +
                        "\"phoneNetStandard\":\""+phoneNetStandard+"\"," +
                        "\"phoneNetTechnology\":\""+phoneNetTechnology+"\"," +
                        "\"internetConNetwork\":\""+internetConNetwork+"\"," +
                        "\"latitude\":\""+latitude+"\"," +
                        "\"longitude\":\""+longitude+"\"," +
                        "\"pingTimeMilis\":\""+pingTimeMilis+"\"," +
                        "\"downloadSpeed\":\""+downloadSpeed+"\"," +
                        "\"uploadSpeed\":\""+uploadSpeed+"\"," +
                        "\"phoneSignalStrength\":\""+phoneSignalStrength+"\"," +
                        "\"phoneAsuStrength\":\""+phoneAsuStrength+"\"," +
                        "\"phoneSignalLevel\":\""+phoneSignalLevel+"\"," +
                        "\"phoneRsrpStrength\":\""+phoneRsrpStrength+"\"," +
                        "\"phoneRsrqStrength\":\""+phoneRsrqStrength+"\"," +
                        "\"phoneRssnrStrength\":\""+phoneRssnrStrength+"\"," +
                        "\"phoneTimingAdvance\":\""+phoneTimingAdvance+"\"," +
                        "\"phoneCqiStrength\":\""+phoneCqiStrength+"\"," +
                        "\"cellLtePci\":\""+cellLtePci+"\"," +
                        "\"cellLteTac\":\""+cellLteTac+"\"," +
                        "\"cellLteeNodeB\":\""+cellLteeNodeB+"\"," +
                        "\"cellLteCid\":\""+cellLteCid+"\"," +
                        "\"cellLteEarfcn\":\""+cellLteEarfcn+"\"," +
                        "\"signalQuality\":\""+signalQuality+"\"," +
                        "\"fieldIsRegistered\":\""+fieldIsRegistered+"\"}");

                updateLteIsRegisteredById(scan_id);
                Log.d("getScanInfoInJson","despues contador es "+contador);
                Log.d("getScanInfoInJson","jsonQueryFormat es "+jsonQueryFormat.get(contador));
                contador = contador+1;
            }
        }
        return jsonQueryFormat;
    }
    public ArrayList<String> getScanWcdmaInfoInJson(Cursor getScanWcdmaInfoByIsRegistered){
        ArrayList<String> jsonQueryFormat = new ArrayList<String>();
        int contador = 0;
        Log.d("getScanInfoInJson","Entra al metodo");
        while(getScanWcdmaInfoByIsRegistered.moveToNext()){
            Log.d("getScanInfoInJson","Entra al while");
            String scan_id = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract._ID));
            String timestamp = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.TIMESTAMP));
            String countryISO = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.COUNTRYISO));
            String phoneOperatorId = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.PHONEOPERATORID));
            String simOperatorId = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.SIMOPERATORID));
            String operatorMcc = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.OPERATORMCC));
            String operatorMnc = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.OPERATORMNC));
            String devManufacturer = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.DEVMANUFACTURER));
            String devModel = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.DEVMODEL));
            String isConected = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.ISCONECTED));
            String phoneNetStandard = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.PHONENETSTANDARD));
            String phoneNetTechnology = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.PHONENETTECHNOLOGY));
            String internetConNetwork = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.INTERNETCONNETWORK));
            String latitude = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.LATITUDE));
            String longitude = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.LONGITUDE));
            String pingTimeMilis = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.PINGTIMEMILIS));
            String downloadSpeed = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.DOWNLOADSPEED));
            String uploadSpeed = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.UPLOADSPEED));
            String phoneSignalStrength = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.PHONESIGNALSTRENGTH));
            String phoneAsuStrength = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.PHONEASUSTRENGTH));
            String phoneSignalLevel = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.PHONESIGNALLEVEL));
            String cellWcdmaLac = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.CELLWCDMALAC));
            String cellWcdmaUcid = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.CELLWCDMAUCID));
            String cellWcdmaPsc = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.CELLWCDMAPSC));
            String cellWcdmaCid = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.CELLWCDMACID));
            String cellWcdmaRnc = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.CELLWCDMARNC));
            String cellWcdmaUarfcn = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.CELLWCDMAUARFCN));
            String signalQuality = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.SIGNALQUALITY));
            String fieldIsRegistered = getScanWcdmaInfoByIsRegistered.getString(getScanWcdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanWcdmaContract.FIELDISREGISTERED));



            if (Integer.parseInt(fieldIsRegistered) == 0 ){
                Log.d("getScanInfoInJson","Entra al if");
                Log.d("getScanInfoInJson","antes contador es "+contador);
                jsonQueryFormat.add("{\"timestamp\":\""+timestamp+"\"," +
                        "\"countryISO\":\""+countryISO+"\"," +
                        "\"phoneOperatorId\":\""+phoneOperatorId+"\"," +
                        "\"simOperatorId\":\""+simOperatorId+"\"," +
                        "\"operatorMcc\":\""+operatorMcc+"\"," +
                        "\"operatorMnc\":\""+operatorMnc+"\"," +
                        "\"devManufacturer\":\""+devManufacturer+"\"," +
                        "\"devModel\":\""+devModel+"\"," +
                        "\"isConected\":\""+isConected+"\"," +
                        "\"phoneNetStandard\":\""+phoneNetStandard+"\"," +
                        "\"phoneNetTechnology\":\""+phoneNetTechnology+"\"," +
                        "\"internetConNetwork\":\""+internetConNetwork+"\"," +
                        "\"latitude\":\""+latitude+"\"," +
                        "\"longitude\":\""+longitude+"\"," +
                        "\"pingTimeMilis\":\""+pingTimeMilis+"\"," +
                        "\"downloadSpeed\":\""+downloadSpeed+"\"," +
                        "\"uploadSpeed\":\""+uploadSpeed+"\"," +
                        "\"phoneSignalStrength\":\""+phoneSignalStrength+"\"," +
                        "\"phoneAsuStrength\":\""+phoneAsuStrength+"\"," +
                        "\"phoneSignalLevel\":\""+phoneSignalLevel+"\"," +
                        "\"cellWcdmaLac\":\""+cellWcdmaLac+"\"," +
                        "\"cellWcdmaUcid\":\""+cellWcdmaUcid+"\"," +
                        "\"cellWcdmaPsc\":\""+cellWcdmaPsc+"\"," +
                        "\"cellWcdmaCid\":\""+cellWcdmaCid+"\"," +
                        "\"cellWcdmaRnc\":\""+cellWcdmaRnc+"\"," +
                        "\"cellWcdmaUarfcn\":\""+cellWcdmaUarfcn+"\"," +
                        "\"signalQuality\":\""+signalQuality+"\"," +
                        "\"fieldIsRegistered\":\""+fieldIsRegistered+"\"}");

                updateWcdmaIsRegisteredById(scan_id);
                Log.d("getScanInfoInJson","despues contador es "+contador);
                Log.d("getScanInfoInJson","jsonQueryFormat es "+jsonQueryFormat.get(contador));
                contador = contador+1;
            }
        }
        return jsonQueryFormat;
    }
    public ArrayList<String> getScanCdmaInfoInJson(Cursor getScanCdmaInfoByIsRegistered){
        ArrayList<String> jsonQueryFormat = new ArrayList<String>();
        int contador = 0;
        Log.d("getScanInfoInJson","Entra al metodo");
        while(getScanCdmaInfoByIsRegistered.moveToNext()){
            Log.d("getScanInfoInJson","Entra al while");
            String scan_id = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract._ID));
            String timestamp = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.TIMESTAMP));
            String countryISO = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.COUNTRYISO));
            String phoneOperatorId = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.PHONEOPERATORID));
            String simOperatorId = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.SIMOPERATORID));
            String operatorMcc = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.OPERATORMCC));
            String operatorMnc = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.OPERATORMNC));
            String devManufacturer = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.DEVMANUFACTURER));
            String devModel = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.DEVMODEL));
            String isConected = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.ISCONECTED));
            String phoneNetStandard = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.PHONENETSTANDARD));
            String phoneNetTechnology = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.PHONENETTECHNOLOGY));
            String internetConNetwork = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.INTERNETCONNETWORK));
            String latitude = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.LATITUDE));
            String longitude = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.LONGITUDE));
            String pingTimeMilis = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.PINGTIMEMILIS));
            String downloadSpeed = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.DOWNLOADSPEED));
            String uploadSpeed = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.UPLOADSPEED));
            String phoneSignalStrength = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.PHONESIGNALSTRENGTH));
            String phoneAsuStrength = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.PHONEASUSTRENGTH));
            String phoneSignalLevel = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.PHONESIGNALLEVEL));
            String cellBslat = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.CELLBSLAT));
            String cellBslon = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.CELLBSLON));
            String cellSid = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.CELLSID));
            String cellNid = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.CELLNID));
            String cellBid = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.CELLBID));
            String signalQuality = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.SIGNALQUALITY));
            String fieldIsRegistered = getScanCdmaInfoByIsRegistered.getString(getScanCdmaInfoByIsRegistered.getColumnIndex(ScanContract.ScanCdmaContract.FIELDISREGISTERED));


            if (Integer.parseInt(fieldIsRegistered) == 0 ){
                Log.d("getScanInfoInJson","Entra al if");
                Log.d("getScanInfoInJson","antes contador es "+contador);
                jsonQueryFormat.add("{\"timestamp\":\""+timestamp+"\"," +
                        "\"countryISO\":\""+countryISO+"\"," +
                        "\"phoneOperatorId\":\""+phoneOperatorId+"\"," +
                        "\"simOperatorId\":\""+simOperatorId+"\"," +
                        "\"operatorMcc\":\""+operatorMcc+"\"," +
                        "\"operatorMnc\":\""+operatorMnc+"\"," +
                        "\"devManufacturer\":\""+devManufacturer+"\"," +
                        "\"devModel\":\""+devModel+"\"," +
                        "\"isConected\":\""+isConected+"\"," +
                        "\"phoneNetStandard\":\""+phoneNetStandard+"\"," +
                        "\"phoneNetTechnology\":\""+phoneNetTechnology+"\"," +
                        "\"internetConNetwork\":\""+internetConNetwork+"\"," +
                        "\"latitude\":\""+latitude+"\"," +
                        "\"longitude\":\""+longitude+"\"," +
                        "\"pingTimeMilis\":\""+pingTimeMilis+"\"," +
                        "\"downloadSpeed\":\""+downloadSpeed+"\"," +
                        "\"uploadSpeed\":\""+uploadSpeed+"\"," +
                        "\"phoneSignalStrength\":\""+phoneSignalStrength+"\"," +
                        "\"phoneAsuStrength\":\""+phoneAsuStrength+"\"," +
                        "\"phoneSignalLevel\":\""+phoneSignalLevel+"\"," +
                        "\"cellBslat\":\""+cellBslat+"\"," +
                        "\"cellBslon\":\""+cellBslon+"\"," +
                        "\"cellSid\":\""+cellSid+"\"," +
                        "\"cellNid\":\""+cellNid+"\"," +
                        "\"cellBid\":\""+cellBid+"\"," +
                        "\"signalQuality\":\""+signalQuality+"\"," +
                        "\"fieldIsRegistered\":\""+fieldIsRegistered+"\"}");

                updateCdmaIsRegisteredById(scan_id);
                Log.d("getScanInfoInJson","despues contador es "+contador);
                Log.d("getScanInfoInJson","jsonQueryFormat es "+jsonQueryFormat.get(contador));
                contador = contador+1;
            }
        }
        return jsonQueryFormat;
    }
    public ArrayList<String> getScanGsmInfoInJson(Cursor getScanGsmInfoByIsRegistered){
        ArrayList<String> jsonQueryFormat = new ArrayList<String>();
        int contador = 0;
        Log.d("getScanInfoInJson","Entra al metodo");
        while(getScanGsmInfoByIsRegistered.moveToNext()){
            Log.d("getScanInfoInJson","Entra al while");
            String scan_id = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract._ID));
            String timestamp = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.TIMESTAMP));
            String countryISO = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.COUNTRYISO));
            String phoneOperatorId = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.PHONEOPERATORID));
            String simOperatorId = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.SIMOPERATORID));
            String operatorMcc = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.OPERATORMCC));
            String operatorMnc = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.OPERATORMNC));
            String devManufacturer = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.DEVMANUFACTURER));
            String devModel = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.DEVMODEL));
            String isConected = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.ISCONECTED));
            String phoneNetStandard = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.PHONENETSTANDARD));
            String phoneNetTechnology = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.PHONENETTECHNOLOGY));
            String internetConNetwork = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.INTERNETCONNETWORK));
            String latitude = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.LATITUDE));
            String longitude = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.LONGITUDE));
            String pingTimeMilis = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.PINGTIMEMILIS));
            String downloadSpeed = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.DOWNLOADSPEED));
            String uploadSpeed = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.UPLOADSPEED));
            String phoneSignalStrength = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.PHONESIGNALSTRENGTH));
            String phoneAsuStrength = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.PHONEASUSTRENGTH));
            String phoneSignalLevel = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.PHONESIGNALLEVEL));
            String cellGsmLac = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.CELLGSMLAC));
            String cellGsmCid = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.CELLGSMCID));
            String cellGsmArcfn = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.CELLGSMARCFN));
            String signalQuality = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.SIGNALQUALITY));
            String fieldIsRegistered = getScanGsmInfoByIsRegistered.getString(getScanGsmInfoByIsRegistered.getColumnIndex(ScanContract.ScanGsmContract.FIELDISREGISTERED));



            if (Integer.parseInt(fieldIsRegistered) == 0 ){
                Log.d("getScanInfoInJson","Entra al if");
                Log.d("getScanInfoInJson","antes contador es "+contador);
                jsonQueryFormat.add("{\"timestamp\":\""+timestamp+"\"," +
                        "\"countryISO\":\""+countryISO+"\"," +
                        "\"phoneOperatorId\":\""+phoneOperatorId+"\"," +
                        "\"simOperatorId\":\""+simOperatorId+"\"," +
                        "\"operatorMcc\":\""+operatorMcc+"\"," +
                        "\"operatorMnc\":\""+operatorMnc+"\"," +
                        "\"devManufacturer\":\""+devManufacturer+"\"," +
                        "\"devModel\":\""+devModel+"\"," +
                        "\"isConected\":\""+isConected+"\"," +
                        "\"phoneNetStandard\":\""+phoneNetStandard+"\"," +
                        "\"phoneNetTechnology\":\""+phoneNetTechnology+"\"," +
                        "\"internetConNetwork\":\""+internetConNetwork+"\"," +
                        "\"latitude\":\""+latitude+"\"," +
                        "\"longitude\":\""+longitude+"\"," +
                        "\"pingTimeMilis\":\""+pingTimeMilis+"\"," +
                        "\"downloadSpeed\":\""+downloadSpeed+"\"," +
                        "\"uploadSpeed\":\""+uploadSpeed+"\"," +
                        "\"phoneSignalStrength\":\""+phoneSignalStrength+"\"," +
                        "\"phoneAsuStrength\":\""+phoneAsuStrength+"\"," +
                        "\"phoneSignalLevel\":\""+phoneSignalLevel+"\"," +
                        "\"cellGsmLac\":\""+cellGsmLac+"\"," +
                        "\"cellGsmCid\":\""+cellGsmCid+"\"," +
                        "\"cellGsmArcfn\":\""+cellGsmArcfn+"\"," +
                        "\"signalQuality\":\""+signalQuality+"\"," +
                        "\"fieldIsRegistered\":\""+fieldIsRegistered+"\"}");

                updateGsmIsRegisteredById(scan_id);
                Log.d("getScanInfoInJson","despues contador es "+contador);
                Log.d("getScanInfoInJson","jsonQueryFormat es "+jsonQueryFormat.get(contador));
                contador = contador+1;
            }
        }
        return jsonQueryFormat;
    }

    //Sección de consultas para traer toda la información de las tablas por tecnología
    public Cursor getAllScanInfo() {
        return getReadableDatabase()
                .query(
                        ScanContract.ScanEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }
    public Cursor getAllLteScanInfo() {
        return getReadableDatabase()
                .query(
                        ScanContract.ScanLteContract.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }
    public Cursor getAllWcdmaScanInfo() {
        return getReadableDatabase()
                .query(
                        ScanContract.ScanWcdmaContract.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }
    public Cursor getAllCdmaScanInfo() {
        return getReadableDatabase()
                .query(
                        ScanContract.ScanCdmaContract.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }
    public Cursor getAllGsmScanInfo() {
        return getReadableDatabase()
                .query(
                        ScanContract.ScanGsmContract.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    //sección para consultas de actualización de mapas
    public ArrayList<String> getMapQuery(Cursor queryCursor){
        Log.d("SqlLite","Entra a getMapQuery");

        ArrayList<String> queryMapFormat = new ArrayList<String>();
        int contador = 0;

        while(queryCursor.moveToNext()){
            String operatorName = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.OPERATORNAME));
            String phoneNetworType = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.PHONENETWORKTYPE));
            String phoneSignalStrength = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.PHONESIGNALSTRENGTH));
            String signalQuality = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.SIGNALQUALITY));
            String latitude = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.LATITUDE));
            String longitude = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.LONGITUDE));
            queryMapFormat.add(operatorName+";"
                    +phoneNetworType+";"
                    +phoneSignalStrength+";"
                    +latitude+";"
                    +longitude+";"
                    +signalQuality);

            Log.d("getMapQuery","queryMapFormat es "+queryMapFormat.get(contador)+" contador es "+contador);
            contador = contador+1;
        }
        return queryMapFormat;
    }
    public ArrayList<String> getMapLteQuery(Cursor queryLteCursor){
        Log.d("SqlLite","Entra a getMapQuery");

        ArrayList<String> queryMapFormat = new ArrayList<String>();
        int contador = 0;

        while(queryLteCursor.moveToNext()){
            String operatorName = queryLteCursor.getString(queryLteCursor.getColumnIndex(ScanContract.ScanLteContract.PHONEOPERATORID));
            String phoneNetworType = queryLteCursor.getString(queryLteCursor.getColumnIndex(ScanContract.ScanLteContract.PHONENETSTANDARD));
            String phoneTimestamp = queryLteCursor.getString(queryLteCursor.getColumnIndex(ScanContract.ScanLteContract.TIMESTAMP));
            String phoneSignalStrength = queryLteCursor.getString(queryLteCursor.getColumnIndex(ScanContract.ScanLteContract.PHONESIGNALSTRENGTH));
            String signalQuality = queryLteCursor.getString(queryLteCursor.getColumnIndex(ScanContract.ScanLteContract.SIGNALQUALITY));
            String latitude = queryLteCursor.getString(queryLteCursor.getColumnIndex(ScanContract.ScanLteContract.LATITUDE));
            String longitude = queryLteCursor.getString(queryLteCursor.getColumnIndex(ScanContract.ScanLteContract.LONGITUDE));
            queryMapFormat.add(operatorName+";"
                    +phoneNetworType+";"
                    +phoneSignalStrength+";"
                    +phoneTimestamp+";"
                    +latitude+";"
                    +longitude+";"
                    +signalQuality);

            Log.d("getMapQuery","queryMapFormat es "+queryMapFormat.get(contador)+" contador es "+contador);
            contador = contador+1;
        }
        return queryMapFormat;
    }
    public ArrayList<String> getMapWcdmaQuery(Cursor queryWcdmaCursor){
        Log.d("SqlLite","Entra a getMapQuery");

        ArrayList<String> queryMapFormat = new ArrayList<String>();
        int contador = 0;

        while(queryWcdmaCursor.moveToNext()){
            String operatorName = queryWcdmaCursor.getString(queryWcdmaCursor.getColumnIndex(ScanContract.ScanWcdmaContract.PHONEOPERATORID));
            String phoneNetworType = queryWcdmaCursor.getString(queryWcdmaCursor.getColumnIndex(ScanContract.ScanWcdmaContract.PHONENETTECHNOLOGY));
            String phoneTimestamp = queryWcdmaCursor.getString(queryWcdmaCursor.getColumnIndex(ScanContract.ScanWcdmaContract.TIMESTAMP));
            String phoneSignalStrength = queryWcdmaCursor.getString(queryWcdmaCursor.getColumnIndex(ScanContract.ScanWcdmaContract.PHONESIGNALSTRENGTH));
            String signalQuality = queryWcdmaCursor.getString(queryWcdmaCursor.getColumnIndex(ScanContract.ScanWcdmaContract.SIGNALQUALITY));
            String latitude = queryWcdmaCursor.getString(queryWcdmaCursor.getColumnIndex(ScanContract.ScanWcdmaContract.LATITUDE));
            String longitude = queryWcdmaCursor.getString(queryWcdmaCursor.getColumnIndex(ScanContract.ScanWcdmaContract.LONGITUDE));
            queryMapFormat.add(operatorName+";"
                    +phoneNetworType+";"
                    +phoneSignalStrength+";"
                    +phoneTimestamp+";"
                    +latitude+";"
                    +longitude+";"
                    +signalQuality);



            Log.d("getMapQuery","queryMapFormat es "+queryMapFormat.get(contador)+" contador es "+contador);
            contador = contador+1;
        }
        return queryMapFormat;
    }
    public ArrayList<String> getMapCdmaQuery(Cursor queryCdmaCursor){
        Log.d("SqlLite","Entra a getMapQuery");

        ArrayList<String> queryMapFormat = new ArrayList<String>();
        int contador = 0;

        while(queryCdmaCursor.moveToNext()){
            String operatorName = queryCdmaCursor.getString(queryCdmaCursor.getColumnIndex(ScanContract.ScanCdmaContract.PHONEOPERATORID));
            String phoneNetworType = queryCdmaCursor.getString(queryCdmaCursor.getColumnIndex(ScanContract.ScanCdmaContract.PHONENETSTANDARD));
            String phoneTimestamp = queryCdmaCursor.getString(queryCdmaCursor.getColumnIndex(ScanContract.ScanCdmaContract.TIMESTAMP));
            String phoneSignalStrength = queryCdmaCursor.getString(queryCdmaCursor.getColumnIndex(ScanContract.ScanCdmaContract.PHONESIGNALSTRENGTH));
            String signalQuality = queryCdmaCursor.getString(queryCdmaCursor.getColumnIndex(ScanContract.ScanCdmaContract.SIGNALQUALITY));
            String latitude = queryCdmaCursor.getString(queryCdmaCursor.getColumnIndex(ScanContract.ScanCdmaContract.LATITUDE));
            String longitude = queryCdmaCursor.getString(queryCdmaCursor.getColumnIndex(ScanContract.ScanCdmaContract.LONGITUDE));
            queryMapFormat.add(operatorName+";"
                    +phoneNetworType+";"
                    +phoneSignalStrength+";"
                    +phoneTimestamp+";"
                    +latitude+";"
                    +longitude+";"
                    +signalQuality);

            Log.d("getMapQuery","queryMapFormat es "+queryMapFormat.get(contador)+" contador es "+contador);
            contador = contador+1;
        }
        return queryMapFormat;
    }
    public ArrayList<String> getMapGsmQuery(Cursor queryGsmCursor){
        Log.d("SqlLite","Entra a getMapQuery");

        ArrayList<String> queryMapFormat = new ArrayList<String>();
        int contador = 0;

        while(queryGsmCursor.moveToNext()){
            String operatorName = queryGsmCursor.getString(queryGsmCursor.getColumnIndex(ScanContract.ScanGsmContract.PHONEOPERATORID));
            String phoneNetworType = queryGsmCursor.getString(queryGsmCursor.getColumnIndex(ScanContract.ScanGsmContract.PHONENETSTANDARD));
            String phoneTimestamp = queryGsmCursor.getString(queryGsmCursor.getColumnIndex(ScanContract.ScanGsmContract.TIMESTAMP));
            String phoneSignalStrength = queryGsmCursor.getString(queryGsmCursor.getColumnIndex(ScanContract.ScanGsmContract.PHONESIGNALSTRENGTH));
            String signalQuality = queryGsmCursor.getString(queryGsmCursor.getColumnIndex(ScanContract.ScanGsmContract.SIGNALQUALITY));
            String latitude = queryGsmCursor.getString(queryGsmCursor.getColumnIndex(ScanContract.ScanGsmContract.LATITUDE));
            String longitude = queryGsmCursor.getString(queryGsmCursor.getColumnIndex(ScanContract.ScanGsmContract.LONGITUDE));
            queryMapFormat.add(operatorName+";"
                    +phoneNetworType+";"
                    +phoneSignalStrength+";"
                    +phoneTimestamp+";"
                    +latitude+";"
                    +longitude+";"
                    +signalQuality);

            Log.d("getMapQuery","queryMapFormat es "+queryMapFormat.get(contador)+" contador es "+contador);
            contador = contador+1;
        }
        return queryMapFormat;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("SqlLite","Entra a OnUpgrade");
        db.execSQL("DROP TABLE IF EXISTS "+ScanContract.ScanEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ScanContract.ScanWcdmaContract.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ScanContract.ScanGsmContract.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ScanContract.ScanCdmaContract.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ScanContract.ScanLteContract.TABLE_NAME);
        onCreate(db);

    }
}
