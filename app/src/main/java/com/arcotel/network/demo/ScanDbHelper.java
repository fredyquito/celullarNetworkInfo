package com.arcotel.network.demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

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
        Log.d("SqlLite","entra a creat la tabla"+ScanContract.ScanEntry.TABLE_NAME);
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

    public void printScanQuery(Cursor queryCursor){
        Log.d("SqlLite","Entra a printScanQuery");


        while(queryCursor.moveToNext()){
            String bdd_id = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry._ID));
            String countryISO = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.COUNTRYISO));
            String operatorId = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.OPERATORID));
            String operatorName = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.OPERATORNAME));
            String isConected = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.ISCONECTED));
            String phoneSignalType = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.PHONESIGNALTYPE));
            String phoneNetworType = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.PHONENETWORKTYPE));
            String signalQuality = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.SIGNALQUALITY));
            String networkConectivityType = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.NETWORKCONECTIVITYTYPE));
            String phoneSignalStrength = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.PHONESIGNALSTRENGTH));
            String downloadMovileSpeed = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.DOWNLOADMOVILESPEED));
            String uploadMovileSpeed = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.UPLOADMOVILSPEED));
            String wifiSpeed = queryCursor.getString(queryCursor.getColumnIndex(ScanContract.ScanEntry.WIFISPEED));
            Log.d("printScanQuery ","valor es "+bdd_id+
                    ""+countryISO+
                    " "+operatorId+
                    " "+operatorName+
                    " "+isConected+
                    " "+phoneSignalType+
                    " "+phoneNetworType+
                    " "+signalQuality+
                    " "+networkConectivityType+
                    " "+phoneSignalStrength+
                    " "+downloadMovileSpeed+
                    " "+uploadMovileSpeed+
                    " "+wifiSpeed);
        }
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




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
