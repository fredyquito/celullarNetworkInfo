package com.arcotel.network.demo;

import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMapLocation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMapLocation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Context fragmentMapLocationContext;
    private LocationAddress locationAddress;
    private Button buttonColectInfo;
    private Button buttonUploadInfo;
    private ScanDbHelper scanDbHelper;
    private ScanMetadata scanMetadata;
    private Cursor cursorQuery;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;

    public FragmentMapLocation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMapLocation.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMapLocation newInstance(String param1, String param2) {
        FragmentMapLocation fragment = new FragmentMapLocation();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_map_location, container, false);


        fragmentMapLocationContext = container.getContext();
        locationAddress = new LocationAddress();
        Pair<Double,Double> latLonLocation = locationAddress.getLatLongFromLocation(getContext());

        ScanCellularActivity scanCellularActivity = new ScanCellularActivity(fragmentMapLocationContext);
        final String countryISO = scanCellularActivity.getDevCountryIso();
        final String deviceIMEI = scanCellularActivity.getDeviceIMEI();
        final String operatorId = scanCellularActivity.getDevOperatorID();
        final String operatorName = scanCellularActivity.getDevOperatorName();
        final String isConected = scanCellularActivity.getDevIsConected();
        final String phoneSignalType = scanCellularActivity.getPhoneSignalType();
        final String phoneNetworType = scanCellularActivity.getPhoneNetworType();
        final int phoneSignalStrength = scanCellularActivity.getDevStrengthSignal();
        final String signalQuality = scanCellularActivity.getSignalQuality(phoneSignalStrength);
        final ScanInternetSpeed scanInternetSpeed = new ScanInternetSpeed(fragmentMapLocationContext);


        final double latitude;
        final double longitude;
        latitude = latLonLocation.first;
        longitude = latLonLocation.second;

        //latitude = -0.341969;
        //longitude = -78.530128;

        int downloadMovileSpeed = 0;
        int uploadMovileSpeed = 0;
        int wifiSpeed=0;
        final String networkConectivityType = scanInternetSpeed.getNetworkConectivityType();

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

        final int isRegistered = 0;

        final int wifiSpeedAux = wifiSpeed;
        final int downloadMovileSpeedAux = downloadMovileSpeed;
        final int uploadMovileSpeedAux = uploadMovileSpeed;

        buttonColectInfo = mView.findViewById(R.id.buttonColectInfo);
        buttonColectInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                scanMetadata = new ScanMetadata(countryISO,operatorId,operatorName,isConected,phoneSignalType,phoneNetworType,
                        signalQuality,networkConectivityType,phoneSignalStrength,downloadMovileSpeedAux,uploadMovileSpeedAux,wifiSpeedAux,latitude,longitude,isRegistered);

                scanDbHelper = new ScanDbHelper(getContext());
                scanDbHelper.saveSqlScan(scanMetadata);


            }
        });

        buttonUploadInfo = mView.findViewById(R.id.buttonUploadInfo);
        buttonUploadInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if(networkConectivityType == "WIFI"){
                    cursorQuery = scanDbHelper.getScanInfoByIsRegistered(0);
                    ArrayList<String> jsonInputString  =  scanDbHelper.getScanInfoInJson(cursorQuery);
                    for(int i = 0 ; i < jsonInputString.size(); i++){
                        Log.d("URL_JSON","Entra a HttpJsonPost en fragmentNetwork valor de i es "+i);
                        HttpJsonPost jsonPost = new HttpJsonPost();
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                            Log.d("URL_JSON","Crea y envia jsonInputString "+jsonInputString.get(i));
                            String response = jsonPost.postJsonToServer("http://192.168.1.50:5005/add", jsonInputString.get(i));
                            Log.d("Finall URL Post","mensaje es "+response);
                        }
                    }
                }else if(networkConectivityType == "MOBILE"){
                }
            }
        });


        return mView;
    }


}
