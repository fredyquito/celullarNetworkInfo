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
    public static final String DATABASE_NAME = "ScanArcotel.db";

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
    }

    public void saveSqlScan(ScanMetadata scanMetadata) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Log.d("SqlLite","entra a insert SqlLite");
        sqLiteDatabase.insert(ScanContract.ScanEntry.TABLE_NAME,null,scanMetadata.toContentValues());
    }

    public void querySqlScan(){

    }

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

    public ArrayList<String> getMapQuery(Cursor queryCursor){
        Log.d("SqlLite","Entra a getMapQuery");

        ArrayList<String> queryMapFormat = new ArrayList<String>();
        int contador = 0;

        while(queryCursor.moveToNext()){
            String operatorName = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.OPERATORNAME));
            String phoneNetworType = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.PHONENETWORKTYPE));
            String phoneSignalStrength = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.PHONESIGNALSTRENGTH));
            String latitude = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.LATITUDE));
            String longitude = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.LONGITUDE));
            queryMapFormat.add(operatorName+":"
                    +phoneNetworType+":"
                    +phoneSignalStrength+":"
                    +latitude+":"
                    +longitude);

            Log.d("getMapQuery","queryMapFormat es "+queryMapFormat.get(contador));
            contador = contador+1;
        }
        return queryMapFormat;
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

    public void updateIsRegisteredById(String scanId) {
        ContentValues cv = new ContentValues();
        cv.put(ScanContract.ScanEntry.ISREGISTERED,"1");
        int c = getWritableDatabase().update(ScanContract.ScanEntry.TABLE_NAME,
                cv,ScanContract.ScanEntry._ID + " LIKE ?",new String[]{scanId});
        Log.d("updateIsRegisteredByID","el valor de la consulta es "+c);
    }

    public Cursor getScanInfoByIsRegistered(int isRegistered) {
        Cursor c = getReadableDatabase().query(
                ScanContract.ScanEntry.TABLE_NAME,
                null,
                ScanContract.ScanEntry.ISREGISTERED + " LIKE ?",new String[]{String.valueOf(isRegistered)},
                null,
                null,
                null);
        return c;
    }


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




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
