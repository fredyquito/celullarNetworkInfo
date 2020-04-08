package com.arcotel.network.demo;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentNetworkInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNetworkInfo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Context fragmentNetworkContext;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private final int REQUEST_PERMISSION_PHONE_STATE=1;
    private ScanDbHelper scanDbHelper;
    private ScanMetadata scanMetadata;


    public FragmentNetworkInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentNetworkInfo.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentNetworkInfo newInstance(String param1, String param2) {
        FragmentNetworkInfo fragment = new FragmentNetworkInfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }



    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_network_info,container,false);
        TextView textViewLocationInfo_ro = root.findViewById(R.id.textViewNetworkInfo_ro);
        TextView textViewLocationInfo_rw = root.findViewById(R.id.textViewNetworkInfo_rw);
        fragmentNetworkContext = container.getContext();

        ScanCellularActivity scanCellularActivity = new ScanCellularActivity(fragmentNetworkContext);
        String countryISO = scanCellularActivity.getDevCountryIso();
        String operatorId = scanCellularActivity.getDevOperatorID();
        String operatorName = scanCellularActivity.getDevOperatorName();
        String isConected = scanCellularActivity.getDevIsConected();
        String phoneSignalType = scanCellularActivity.getPhoneSignalType();
        String phoneNetworType = scanCellularActivity.getPhoneNetworType();
        int phoneSignalStrength = scanCellularActivity.getDevStrengthSignal();
        String signalQuality = scanCellularActivity.getSignalQuality(phoneSignalStrength);
        ScanInternetSpeed scanInternetSpeed = new ScanInternetSpeed(fragmentNetworkContext);

        int downloadMovileSpeed = 0;
        int uploadMovileSpeed = 0;
        int wifiSpeed=0;
        String networkConectivityType = scanInternetSpeed.getNetworkConectivityType();

        if(networkConectivityType == "WIFI"){
            wifiSpeed = scanInternetSpeed.checkWifiInternetSpeed();
        }else if(networkConectivityType == "MOBILE"){
            Pair<Integer, Integer> speedBandwithMovile = scanInternetSpeed.checkMovileInternetSpeed();
            downloadMovileSpeed = speedBandwithMovile.first.intValue();
            uploadMovileSpeed = speedBandwithMovile.second.intValue();
        }


        textViewLocationInfo_ro.setText(
                        "country ISO \n" +
                        "ID de operador \n" +
                        "Nombre de operador \n" +
                        "Estado Conexión móvil \n" +
                        "Tipo de teléfono \n" +
                        "Tipo de red móvil \n" +
                        "Potencia de la señal \n" +
                        "Calidad de la señal \n" +
                        "Tipo de conexión (Internet) \n" +
                        "Mobile Upload Kbps \n" +
                        "Mobile Doenload Kbps \n" +
                        "Wifi Speed Mbps ");
        textViewLocationInfo_rw.setText(
                        ""+countryISO+"\n" +
                        ""+operatorId+"\n" +
                        ""+operatorName+"\n" +
                        ""+isConected+"\n" +
                        ""+phoneSignalType+"\n" +
                        ""+phoneNetworType+"\n" +
                        ""+phoneSignalStrength+"\n" +
                        ""+signalQuality+"\n"+
                        ""+networkConectivityType+"\n" +
                        ""+uploadMovileSpeed+"\n" +
                        ""+downloadMovileSpeed+"\n" +
                        ""+wifiSpeed);

        scanMetadata = new ScanMetadata(countryISO,operatorId,operatorName,isConected,phoneSignalType,phoneNetworType,
                signalQuality,networkConectivityType,phoneSignalStrength,downloadMovileSpeed,uploadMovileSpeed,wifiSpeed);

        scanDbHelper = new ScanDbHelper(getContext());
        scanDbHelper.saveSqlScan(scanMetadata);

        Cursor cursorQuery = scanDbHelper.getAllScanInfo();
        scanDbHelper.printScanQuery(cursorQuery);

        if(networkConectivityType == "WIFI"){
            String jsonInputString = "{\"countryiso\":\""+countryISO+"\"," +
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
                    "\"wifispeed\":\""+wifiSpeed+"\"}";

            Log.d("URL_JSON","Entra a HttpJsonPost en fragmentNetwork");
            HttpJsonPost jsonPost = new HttpJsonPost();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Log.d("URL_JSON","Crea y envia jsonInputString "+jsonInputString);
                String response = jsonPost.postJsonToServer("http://192.168.1.50:5005/add", jsonInputString);
                Log.d("Finall URL Post","mensaje es "+response);
            }
        }else if(networkConectivityType == "MOBILE"){

        }








        return root;
    }




}
