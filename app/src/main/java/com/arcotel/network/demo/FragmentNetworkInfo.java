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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentNetworkInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNetworkInfo extends Fragment implements OnMapReadyCallback {
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
    private Cursor cursorQuery;
    private LocationAddress locationAddress;
    View root;
    GoogleMap mGoogleMap;
    MapView mMapView;


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

        root = inflater.inflate(R.layout.fragment_network_info,container,false);
        TextView textViewLocationInfo_ro = root.findViewById(R.id.textViewNetworkInfo_ro);
        TextView textViewLocationInfo_rw = root.findViewById(R.id.textViewNetworkInfo_rw);
        fragmentNetworkContext = container.getContext();
        locationAddress = new LocationAddress();
        Pair<Double,Double> latLonLocation = locationAddress.getLatLongFromLocation(getContext());

        ScanCellularActivity scanCellularActivity = new ScanCellularActivity(fragmentNetworkContext);
        String countryISO = scanCellularActivity.getDevCountryIso();
        String deviceIMEI = scanCellularActivity.getDeviceIMEI();
        String operatorId = scanCellularActivity.getDevOperatorID();
        String operatorName = scanCellularActivity.getDevOperatorName();
        String isConected = scanCellularActivity.getDevIsConected();
        String phoneSignalType = scanCellularActivity.getPhoneSignalType();
        String phoneNetworType = scanCellularActivity.getPhoneNetworType();
        int phoneSignalStrength = scanCellularActivity.getDevStrengthSignal();
        int phoneStrengthAsu = 20;
        int phoneBand = 5;
        int phoneLAC = 33101;
        int phoneUCID = 620144;
        int phoneCID = 30320;
        int phoneRNC = 9;
        int phonePSC = 420;
        String signalQuality = scanCellularActivity.getSignalQuality(phoneSignalStrength);
        ScanInternetSpeed scanInternetSpeed = new ScanInternetSpeed(fragmentNetworkContext);


        double latitude;
        double longitude;
        latitude = latLonLocation.first;
        longitude = latLonLocation.second;
        Log.d("FragmenNetworking","valores de latitud y longitud "+latitude+" long "+longitude);

        int downloadMovileSpeed = 0;
        int uploadMovileSpeed = 0;
        int wifiSpeed=0;
        String networkConectivityType = scanInternetSpeed.getNetworkConectivityType();

        if(networkConectivityType == "WIFI"){
            wifiSpeed = scanInternetSpeed.checkWifiInternetSpeed();
        }else if(networkConectivityType == "MOBILE"){
            Pair<Integer, Integer> speedBandwithMovile = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                speedBandwithMovile = scanInternetSpeed.checkMovileInternetSpeed();
            }
            downloadMovileSpeed = speedBandwithMovile.first.intValue();
            uploadMovileSpeed = speedBandwithMovile.second.intValue();
        }

        int isRegistered = 0;
        textViewLocationInfo_ro.setText(
                        "country ISO \n" +
                        "Device IMEI \n" +
                        "MCC/MNC \n" +
                        "Nombre de operador \n" +
                        "Estado Conexión móvil \n" +
                        "Tipo de teléfono \n" +
                        "Tipo de red móvil \n" +
                        "Potencia de la señal \n" +
                        "ASU \n" +
                        "Band \n" +
                        "LAC \n" +
                        "UCID \n" +
                        "CID \n" +
                        "RNC \n" +
                        "PSC \n" +
                        "Calidad de la señal \n" +
                        "Tipo de conexión (Internet) \n" +
                        "Mobile Upload Kbps \n" +
                        "Mobile Download Kbps \n" +
                        "Wifi Speed Mbps \n" +
                        "Latitud \n" +
                        "Longitud ");
        textViewLocationInfo_rw.setText(
                        ""+countryISO+"\n" +
                        ""+deviceIMEI+"\n" +
                        ""+operatorId+"\n" +
                        ""+operatorName+"\n" +
                        ""+isConected+"\n" +
                        ""+phoneSignalType+"\n" +
                        ""+phoneNetworType+"\n" +
                        ""+phoneSignalStrength+"\n" +
                        ""+phoneStrengthAsu+"\n" +
                        ""+phoneBand+"\n" +
                        ""+phoneLAC+"\n" +
                        ""+phoneUCID+"\n" +
                        ""+phoneCID+"\n" +
                        ""+phoneRNC+"\n" +
                        ""+phonePSC+"\n" +
                        ""+signalQuality+"\n"+
                        ""+networkConectivityType+"\n" +
                        ""+uploadMovileSpeed+"\n" +
                        ""+downloadMovileSpeed+"\n" +
                        ""+wifiSpeed+"\n" +
                        ""+latitude+"\n" +
                        ""+longitude);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        mMapView = (MapView) root.findViewById(R.id.mapView2);
        if (mMapView != null){
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        locationAddress = new LocationAddress();
        Pair<Double,Double> latLonLocation = locationAddress.getLatLongFromLocation(getContext());
        double latitudeOnMap;
        double longitudeOnMap;
        latitudeOnMap = latLonLocation.first;
        longitudeOnMap = latLonLocation.second;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        scanMetadata = new ScanMetadata("","","","","","",
                "","",0,0,0,0,0.0,0.0,0);

        scanDbHelper = new ScanDbHelper(getContext());



        cursorQuery = scanDbHelper.getAllScanInfo();
        ArrayList<String> queryMapFormat = scanDbHelper.getMapQuery(cursorQuery);
        for(int i = 0 ; i < queryMapFormat.size(); i++){
            String[] parts = queryMapFormat.get(i).split(":");
            Log.d("onMapReady","Entra a queryMapFormat en onMapReady valor de i es "+i);
            String operatorName = parts[0];
            String phoneNetworType = parts[1];
            int phoneSignalStrength = Integer.parseInt(parts[2]);
            double latitude = Double.parseDouble(parts[3]);
            double longitudeMDouble = Double.parseDouble(parts[4]);
            googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitudeMDouble)).title(""+operatorName).snippet(" "+phoneNetworType+" - "+phoneSignalStrength));
        }
        googleMap.addMarker(new MarkerOptions().position(new LatLng(latitudeOnMap,longitudeOnMap)).title("Mi caletos").snippet("Espero salir de aqui algún dia :X"));

        CameraPosition miLocation = CameraPosition.builder().target(new LatLng(latitudeOnMap,longitudeOnMap)).zoom(12).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(miLocation));
    }
}
