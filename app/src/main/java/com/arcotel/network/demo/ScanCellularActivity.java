package com.arcotel.network.demo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.List;

public class ScanCellularActivity {
    private static final int TODO = 100;
    private static int VERY_BAD=-110;
    private static int BAD=-100;
    private static int AVERAGE=-80;
    private static int GOOD=-75;
    private static int VERY_GOOD=-70;


    TelephonyManager telephonyManager;
    ConnectivityManager connMgr;
    Context context;

    public ScanCellularActivity(Context context) {
        this.context = context;
        this.telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        this.connMgr = (ConnectivityManager) context.getSystemService(Activity.CONNECTIVITY_SERVICE);
    }

    public String getPhoneSignalType() {
        String varPhoneSignalType = "";
        int phoneType = telephonyManager.getPhoneType();
        switch (phoneType) {
            case (TelephonyManager.PHONE_TYPE_CDMA):
                varPhoneSignalType = "CDMA";
                break;
            case (TelephonyManager.PHONE_TYPE_GSM):
                varPhoneSignalType = "GSM";
                break;
            case (TelephonyManager.PHONE_TYPE_NONE):
                varPhoneSignalType = "NONE";
                break;
        }
        return varPhoneSignalType;
    }

    public String getPhoneNetworType() {
        String varPhoneNetworType = "";
        int phoneNetType = telephonyManager.getNetworkType();
        switch (phoneNetType) {
            case 7:
                varPhoneNetworType = "1xRTT";
                break;
            case 4:
                varPhoneNetworType = "CDMA";
                break;
            case 2:
                varPhoneNetworType = "EDGE";
                break;
            case 14:
                varPhoneNetworType = "eHRPD";
                break;
            case 5:
                varPhoneNetworType = "EVDO rev. 0";
                break;
            case 6:
                varPhoneNetworType = "EVDO rev. A";
                break;
            case 12:
                varPhoneNetworType = "EVDO rev. B";
                break;
            case 1:
                varPhoneNetworType = "GPRS";
                break;
            case 8:
                varPhoneNetworType = "HSDPA";
                break;
            case 10:
                varPhoneNetworType = "HSPA";
                break;
            case 15:
                varPhoneNetworType = "HSPA+";
                break;
            case 9:
                varPhoneNetworType = "HSUPA";
                break;
            case 11:
                varPhoneNetworType = "iDen";
                break;
            case 13:
                varPhoneNetworType = "LTE";
                break;
            case 3:
                varPhoneNetworType = "UMTS";
                break;
            case 0:
                varPhoneNetworType = "Unknown";
                break;
        }
        return varPhoneNetworType;
    }

    public String getDevIsConected() {
        String conectado;
        NetworkInfo networkInfo = connMgr != null ? connMgr.getActiveNetworkInfo() : null;
        boolean isConected = networkInfo != null && networkInfo.isConnected();
        if (isConected) {
            conectado = "conectado";
        } else {
            conectado = "No conectado";
        }
        return conectado;
    }

    public String getDevOperatorName() {
        String operatorName = telephonyManager.getNetworkOperatorName();
        return operatorName;

    }

    public String getDevCountryIso() {
        String countryIso = telephonyManager.getNetworkCountryIso();
        return countryIso;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getDevMmsProfile() {
        String mmsProfile = telephonyManager.getMmsUserAgent();
        return mmsProfile;
    }

    public String getDevOperatorID() {
        String operatoId = telephonyManager.getNetworkOperator();
        return operatoId;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public int getDevStrengthSignal() {
        int strength=-77;
        @SuppressLint("MissingPermission") List<CellInfo> cellInfos = telephonyManager.getAllCellInfo();   //This will give info of all sims present inside your mobile
        if(cellInfos != null) {
            for (int i = 0 ; i < cellInfos.size() ; i++) {
                if (cellInfos.get(i).isRegistered()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                        if (cellInfos.get(i) instanceof CellInfoWcdma) {
                            CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfos.get(i);
                            CellSignalStrengthWcdma cellSignalStrengthWcdma = cellInfoWcdma.getCellSignalStrength();
                            strength = cellSignalStrengthWcdma.getDbm();
                        } else if (cellInfos.get(i) instanceof CellInfoGsm) {
                            CellInfoGsm cellInfogsm = (CellInfoGsm) cellInfos.get(i);
                            CellSignalStrengthGsm cellSignalStrengthGsm = cellInfogsm.getCellSignalStrength();
                            strength = cellSignalStrengthGsm.getDbm();
                        } else if (cellInfos.get(i) instanceof CellInfoLte) {
                            CellInfoLte cellInfoLte = (CellInfoLte) cellInfos.get(i);
                            CellSignalStrengthLte cellSignalStrengthLte = cellInfoLte.getCellSignalStrength();
                            strength = cellSignalStrengthLte.getDbm();
                        } else if (cellInfos.get(i) instanceof CellInfoCdma) {
                            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfos.get(i);
                            CellSignalStrengthCdma cellSignalStrengthCdma = cellInfoCdma.getCellSignalStrength();
                            strength = cellSignalStrengthCdma.getDbm();
                        }
                    }
                }
            }
        }
        return strength;

    }

    public String getSignalQuality(int dbm){
        String signalQuality="";
        if(dbm >= VERY_GOOD){
            signalQuality = "VERY_GOOD";
        }else if(dbm >= GOOD ){
            signalQuality = "GOOD";
        }else if(dbm >= AVERAGE ){
            signalQuality = "AVERAGE";
        }else if(dbm >= BAD ){
            signalQuality = "BAD";
        }else if (dbm >= VERY_BAD){
            signalQuality = "VERY_BAD";
        }else {
            signalQuality = "UNKNOWN";
        }
        return signalQuality;
    }


}
