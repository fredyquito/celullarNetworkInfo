package com.arcotel.network.demo;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.util.Pair;
import androidx.fragment.app.Fragment;

import android.telephony.SignalStrength;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;


import com.arcotel.network.demo.test.HttpDownloadTest;
import com.arcotel.network.demo.test.HttpUploadTest;
import com.arcotel.network.demo.test.PingTest;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


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

    private static int VERY_BAD=-110;
    private static int BAD=-100;
    private static int AVERAGE=-80;
    private static int GOOD=-75;
    private static int VERY_GOOD=-70;


    static int position = 0;
    static int lastPosition = 0;
    GetSpeedTestHostsHandler getSpeedTestHostsHandler = null;
    HashSet<String> tempBlackList;


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


    @Override
    public void onResume() {
        super.onResume();

        getSpeedTestHostsHandler = new GetSpeedTestHostsHandler();
        getSpeedTestHostsHandler.start();
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
        //String countryISO = scanCellularActivity.getDevCountryIso();
        //String deviceIMEI = scanCellularActivity.getDeviceIMEI();
        //String operatorId = scanCellularActivity.getDevOperatorID();
        String operatorName = scanCellularActivity.getDevOperatorName();
        String isConected = scanCellularActivity.getDevIsConected();
        //String phoneSignalType = scanCellularActivity.getPhoneSignalType();
        String phoneNetworType = scanCellularActivity.getPhoneNetworType();
        //int phoneSignalStrength = scanCellularActivity.getDevStrengthSignal()[0];
        //int phoneStrengthAsu = scanCellularActivity.getDevStrengthSignal()[1];
        //int phoneStrengthLevel = scanCellularActivity.getDevStrengthSignal()[2];
        int phoneBand = 5;
        int phoneLAC = 33101;
        int phoneUCID = 620144;
        int phoneCID = 30320;
        int phoneRNC = 9;
        int phonePSC = 420;
        String signalQuality = "";
        ScanInternetSpeed scanInternetSpeed = new ScanInternetSpeed(fragmentNetworkContext);


        double latitude;
        double longitude;
        latitude = latLonLocation.first;
        longitude = latLonLocation.second;
        Log.d("FragmenNetworking","valores de latitud y longitud "+latitude+" long "+longitude);

        String networkConectivityType = scanInternetSpeed.getNetworkConectivityType();

        Log.d("ANALI>AR ESTO "," el valor de phoneNetworType es "+phoneNetworType);

        //Seccion HSPA
        if(phoneNetworType == "HSPA+" || phoneNetworType == "HSPA" || phoneNetworType == "UMTS"){
            ArrayList<Integer> strengthInfo = scanCellularActivity.getDevStrengthSignal();
            ArrayList<Integer> cellIdentity = scanCellularActivity.getDevCellIdentity();
            signalQuality = scanCellularActivity.getSignalQuality(strengthInfo.get(0));
            textViewLocationInfo_ro.setText(
                            //Seccion HSPA - HSPA+ - UMTS - WCDMA
                            "Nombre de operador \n" +
                            "Estado Conexión móvil \n" +
                            "Tipo de red móvil \n" +
                            "Potencia de la señal (dBm) \n" +
                            "LAC \n" +
                            "UCID \n" + //UCID: UMTS Cell Identifier (28-bit)
                            "CID \n" + //CID: Cell Identifier (16-bit)
                            "RNC \n" + //RNC: Controlling RNC/BSS Identifier (12-bit)
                            "PSC \n" + //PSC: Primary Srambling Code of Cell
                            "Calidad de la señal \n" +
                            "Tipo de conexión (Internet) \n" +
                            "Latitud \n" +
                            "Longitud ");
            textViewLocationInfo_rw.setText(

                    ""+operatorName+"\n" +
                            ""+isConected+"\n" +
                            ""+phoneNetworType+"\n" +
                            ""+strengthInfo.get(0)+"\n" +
                            ""+cellIdentity.get(0)+"\n" +
                            ""+cellIdentity.get(1)+"\n" +
                            ""+cellIdentity.get(3)+"\n" +
                            ""+cellIdentity.get(4)+"\n" +
                            ""+cellIdentity.get(2)+"\n" +
                            ""+signalQuality+"\n"+
                            ""+networkConectivityType+"\n" +
                            ""+latitude+"\n" +
                            ""+longitude);

        }

        //Seccion Lte
        if(phoneNetworType == "LTE"){
            double snr=0.0;
            ArrayList<Integer> strengthInfo = scanCellularActivity.getDevStrengthSignal();
            ArrayList<Integer> cellIdentity = scanCellularActivity.getDevCellIdentity();
            signalQuality = scanCellularActivity.getSignalQuality(strengthInfo.get(0));

            try {
                snr = (double) SignalStrength.class.getMethod("getLteRssnr").invoke(strengthInfo.get(3))/10D;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            textViewLocationInfo_ro.setText(
                    //Sección LTE
                            "Nombre de operador \n" +
                            "Estado Conexión móvil \n" +
                            "Tipo de red móvil \n" +
                            "RSRP (dBm) \n" + //RSRP: Reference Signal Received Power
                            "RSRQ (dBm) \n" + //RSRQ: Reference Signal Received Quality
                            "Rssnr (dBm) \n" + //RSSNR: Reference Signal Signal to Noise Ratio
                            "eNodeB \n" + // eNB: eNodeB Identifier (20-bit)
                            "TAC \n" + //TAC: Tracking Area Code (16-bit)
                            "CID \n" + //LCID: Local Cell Identifier (8-bit)
                            "PCI \n" + //PCI: Physical Cell ID (0-503)
                            "ARFCN \n" + //EARFCN: E-UTRA Absolute Radio Frequency Channel Number (0-65535)
                            "Calidad de la señal \n" +
                            "Tipo de conexión (Internet) \n" +
                            "Latitud \n" +
                            "Longitud ");
            textViewLocationInfo_rw.setText(

                    ""+operatorName+"\n" +
                            ""+isConected+"\n" +
                            ""+phoneNetworType+"\n" +
                            ""+strengthInfo.get(3)+"\n" +
                            ""+strengthInfo.get(4)+"\n" +
                            ""+snr+"\n" +
                            ""+cellIdentity.get(2)+"\n" +
                            ""+cellIdentity.get(1)+"\n" +
                            ""+cellIdentity.get(3)+"\n" +
                            ""+cellIdentity.get(0)+"\n" +
                            ""+cellIdentity.get(4)+"\n" +
                            ""+signalQuality+"\n"+
                            ""+networkConectivityType+"\n" +
                            ""+latitude+"\n" +
                            ""+longitude);
        }

        //Seccion GSM
        if(phoneNetworType == "GSM" || phoneNetworType == "GPRS" || phoneNetworType == "EDGE"){
            ArrayList<Integer> strengthInfo = scanCellularActivity.getDevStrengthSignal();
            ArrayList<Integer> cellIdentity = scanCellularActivity.getDevCellIdentity();
            signalQuality = scanCellularActivity.getSignalQuality(strengthInfo.get(0));
            textViewLocationInfo_ro.setText(
                    //Seccion GSM - GPRS - EDGE
                            "Nombre de operador \n" +
                            "Estado Conexión móvil \n" +
                            "Tipo de red móvil \n" +
                            "Potencia de la señal (dBm) \n" +
                            "LAC \n" + //LAC: GSM Location Area (16-bit)
                            "CID \n" + //CID: GSM Cell Identifier (16-bit, for Base transceiver station (BTS) or sector of a BTS)
                            "ARFCN \n" + //ARFCN: Absolute Radio Frequency Channel Number (0-1023)
                            "Calidad de la señal \n" +
                            "Tipo de conexión (Internet) \n" +
                            "Latitud \n" +
                            "Longitud ");
            textViewLocationInfo_rw.setText(

                    ""+operatorName+"\n" +
                            ""+isConected+"\n" +
                            ""+phoneNetworType+"\n" +
                            ""+strengthInfo.get(0)+"\n" +
                            ""+cellIdentity.get(0)+"\n" +
                            ""+cellIdentity.get(1)+"\n" +
                            ""+cellIdentity.get(2)+"\n" +
                            ""+signalQuality+"\n"+
                            ""+networkConectivityType+"\n" +
                            ""+latitude+"\n" +
                            ""+longitude);
        }

        //Seccion CDMA
        if(phoneNetworType == "CDMA" || phoneNetworType == "EVDO_0" || phoneNetworType == "EVDO_A" || phoneNetworType == "EVDO_B"){
            ArrayList<Integer> strengthInfo = scanCellularActivity.getDevStrengthSignal();
            ArrayList<Integer> cellIdentity = scanCellularActivity.getDevCellIdentity();
            signalQuality = scanCellularActivity.getSignalQuality(strengthInfo.get(0));
            textViewLocationInfo_ro.setText(
                    //Seccion CDMA - EVDO
                            "Nombre de operador \n" +
                            "Estado Conexión móvil \n" +
                            "Tipo de red móvil \n" +
                            "Potencia de la señal (dBm) \n" +
                            "BSLat \n" + //BSLat: Base station latitude
                            "BSLon \n" + //BSLon: Base station longitude
                            "SID \n" + //SID: System Identifier (15-bit)
                            "NID \n" + //NID: Network Identifier (16-bit)
                            "BID \n" + //BID: Base Station Identifier (16-bit)
                            "Calidad de la señal \n" +
                            "Tipo de conexión (Internet) \n" +
                            "Latitud \n" +
                            "Longitud ");
            textViewLocationInfo_rw.setText(

                    ""+operatorName+"\n" +
                            ""+isConected+"\n" +
                            ""+phoneNetworType+"\n" +
                            ""+strengthInfo.get(0)+"\n" +
                            ""+cellIdentity.get(0)+"\n" +
                            ""+cellIdentity.get(1)+"\n" +
                            ""+cellIdentity.get(2)+"\n" +
                            ""+cellIdentity.get(3)+"\n" +
                            ""+cellIdentity.get(4)+"\n" +
                            ""+signalQuality+"\n"+
                            ""+networkConectivityType+"\n" +
                            ""+latitude+"\n" +
                            ""+longitude);

        }



//desde aqui comienza el test de internet
        final Button startButton = (Button) root.findViewById(R.id.startButton);
        final DecimalFormat dec = new DecimalFormat("#.##");
        startButton.setText("Comenzar Test");

        tempBlackList = new HashSet<>();

        getSpeedTestHostsHandler = new GetSpeedTestHostsHandler();
        getSpeedTestHostsHandler.start();

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startButton.setEnabled(false);

                //Restart test icin eger baglanti koparsa
                if (getSpeedTestHostsHandler == null) {
                    getSpeedTestHostsHandler = new GetSpeedTestHostsHandler();
                    getSpeedTestHostsHandler.start();
                }

                new Thread(new Runnable() {
                    RotateAnimation rotate;

                    ImageView barImageView = (ImageView) root.findViewById(R.id.barImageView);
                    TextView pingTextView = (TextView) root.findViewById(R.id.pingTextView);
                    TextView downloadTextView = (TextView) root.findViewById(R.id.downloadTextView);
                    TextView uploadTextView = (TextView) root.findViewById(R.id.uploadTextView);

                    @Override
                    public void run() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startButton.setText("Consiguiendo mejor servidor basado en ping...");
                            }
                        });

                        //Get egcodes.speedtest hosts
                        int timeCount = 600; //1min
                        while (!getSpeedTestHostsHandler.isFinished()) {
                            timeCount--;
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                            }
                            if (timeCount <= 0) {
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(fragmentNetworkContext, "No Connection...", Toast.LENGTH_LONG).show();
                                        startButton.setEnabled(true);
                                        startButton.setTextSize(16);
                                        startButton.setText("Comenzar de nuevo");
                                    }
                                });
                                getSpeedTestHostsHandler = null;
                                return;
                            }
                        }

                        //Find closest server
                        HashMap<Integer, String> mapKey = getSpeedTestHostsHandler.getMapKey();
                        HashMap<Integer, List<String>> mapValue = getSpeedTestHostsHandler.getMapValue();
                        double selfLat = getSpeedTestHostsHandler.getSelfLat();
                        double selfLon = getSpeedTestHostsHandler.getSelfLon();
                        double tmp = 19349458;
                        double dist = 0.0;
                        int findServerIndex = 0;
                        for (int index : mapKey.keySet()) {
                            if (tempBlackList.contains(mapValue.get(index).get(5))) {
                                continue;
                            }

                            Location source = new Location("Source");
                            source.setLatitude(selfLat);
                            source.setLongitude(selfLon);

                            List<String> ls = mapValue.get(index);
                            Location dest = new Location("Dest");
                            dest.setLatitude(Double.parseDouble(ls.get(0)));
                            dest.setLongitude(Double.parseDouble(ls.get(1)));

                            double distance = source.distanceTo(dest);
                            if (tmp > distance) {
                                tmp = distance;
                                dist = distance;
                                findServerIndex = index;
                            }
                        }
                        String uploadAddr = mapKey.get(findServerIndex);
                        final List<String> info = mapValue.get(findServerIndex);
                        final double distance = dist;

                        if (info == null) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    startButton.setTextSize(12);
                                    startButton.setText("Problemas con el servidor de localizacion, intente de nuevo.");
                                }
                            });
                            return;
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startButton.setTextSize(13);
                                startButton.setText(String.format("Host Location: %s [Distance: %s km]", info.get(2), new DecimalFormat("#.##").format(distance / 1000)));
                            }
                        });

                        //Init Ping graphic
                        final LinearLayout chartPing = (LinearLayout) root.findViewById(R.id.chartPing);
                        XYSeriesRenderer pingRenderer = new XYSeriesRenderer();
                        XYSeriesRenderer.FillOutsideLine pingFill = new XYSeriesRenderer.FillOutsideLine(XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ALL);
                        pingFill.setColor(Color.parseColor("#4d5a6a"));
                        pingRenderer.addFillOutsideLine(pingFill);
                        pingRenderer.setDisplayChartValues(false);
                        pingRenderer.setShowLegendItem(false);
                        pingRenderer.setColor(Color.parseColor("#4d5a6a"));
                        pingRenderer.setLineWidth(5);
                        final XYMultipleSeriesRenderer multiPingRenderer = new XYMultipleSeriesRenderer();
                        multiPingRenderer.setXLabels(0);
                        multiPingRenderer.setYLabels(0);
                        multiPingRenderer.setZoomEnabled(false);
                        multiPingRenderer.setXAxisColor(Color.parseColor("#647488"));
                        multiPingRenderer.setYAxisColor(Color.parseColor("#2F3C4C"));
                        multiPingRenderer.setPanEnabled(true, true);
                        multiPingRenderer.setZoomButtonsVisible(false);
                        multiPingRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00));
                        multiPingRenderer.addSeriesRenderer(pingRenderer);

                        //Init Download graphic
                        final LinearLayout chartDownload = (LinearLayout) root.findViewById(R.id.chartDownload);
                        XYSeriesRenderer downloadRenderer = new XYSeriesRenderer();
                        XYSeriesRenderer.FillOutsideLine downloadFill = new XYSeriesRenderer.FillOutsideLine(XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ALL);
                        downloadFill.setColor(Color.parseColor("#4d5a6a"));
                        downloadRenderer.addFillOutsideLine(downloadFill);
                        downloadRenderer.setDisplayChartValues(false);
                        downloadRenderer.setColor(Color.parseColor("#4d5a6a"));
                        downloadRenderer.setShowLegendItem(false);
                        downloadRenderer.setLineWidth(5);
                        final XYMultipleSeriesRenderer multiDownloadRenderer = new XYMultipleSeriesRenderer();
                        multiDownloadRenderer.setXLabels(0);
                        multiDownloadRenderer.setYLabels(0);
                        multiDownloadRenderer.setZoomEnabled(false);
                        multiDownloadRenderer.setXAxisColor(Color.parseColor("#647488"));
                        multiDownloadRenderer.setYAxisColor(Color.parseColor("#2F3C4C"));
                        multiDownloadRenderer.setPanEnabled(false, false);
                        multiDownloadRenderer.setZoomButtonsVisible(false);
                        multiDownloadRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00));
                        multiDownloadRenderer.addSeriesRenderer(downloadRenderer);

                        //Init Upload graphic
                        final LinearLayout chartUpload = (LinearLayout) root.findViewById(R.id.chartUpload);
                        XYSeriesRenderer uploadRenderer = new XYSeriesRenderer();
                        XYSeriesRenderer.FillOutsideLine uploadFill = new XYSeriesRenderer.FillOutsideLine(XYSeriesRenderer.FillOutsideLine.Type.BOUNDS_ALL);
                        uploadFill.setColor(Color.parseColor("#4d5a6a"));
                        uploadRenderer.addFillOutsideLine(uploadFill);
                        uploadRenderer.setDisplayChartValues(false);
                        uploadRenderer.setColor(Color.parseColor("#4d5a6a"));
                        uploadRenderer.setShowLegendItem(false);
                        uploadRenderer.setLineWidth(5);
                        final XYMultipleSeriesRenderer multiUploadRenderer = new XYMultipleSeriesRenderer();
                        multiUploadRenderer.setXLabels(0);
                        multiUploadRenderer.setYLabels(0);
                        multiUploadRenderer.setZoomEnabled(false);
                        multiUploadRenderer.setXAxisColor(Color.parseColor("#647488"));
                        multiUploadRenderer.setYAxisColor(Color.parseColor("#2F3C4C"));
                        multiUploadRenderer.setPanEnabled(false, false);
                        multiUploadRenderer.setZoomButtonsVisible(false);
                        multiUploadRenderer.setMarginsColor(Color.argb(0x00, 0xff, 0x00, 0x00));
                        multiUploadRenderer.addSeriesRenderer(uploadRenderer);

                        //Reset value, graphics
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                pingTextView.setText("0 ms");
                                chartPing.removeAllViews();
                                downloadTextView.setText("0 Mbps");
                                chartDownload.removeAllViews();
                                uploadTextView.setText("0 Mbps");
                                chartUpload.removeAllViews();
                            }
                        });
                        final List<Double> pingRateList = new ArrayList<>();
                        final List<Double> downloadRateList = new ArrayList<>();
                        final List<Double> uploadRateList = new ArrayList<>();
                        Boolean pingTestStarted = false;
                        Boolean pingTestFinished = false;
                        Boolean downloadTestStarted = false;
                        Boolean downloadTestFinished = false;
                        Boolean uploadTestStarted = false;
                        Boolean uploadTestFinished = false;

                        //Init Test
                        final PingTest pingTest = new PingTest(info.get(6).replace(":8080", ""), 6);
                        final HttpDownloadTest downloadTest = new HttpDownloadTest(uploadAddr.replace(uploadAddr.split("/")[uploadAddr.split("/").length - 1], ""));
                        final HttpUploadTest uploadTest = new HttpUploadTest(uploadAddr);


                        //Tests
                        while (true) {
                            if (!pingTestStarted) {
                                pingTest.start();
                                pingTestStarted = true;
                            }
                            if (pingTestFinished && !downloadTestStarted) {
                                downloadTest.start();
                                downloadTestStarted = true;
                            }
                            if (downloadTestFinished && !uploadTestStarted) {
                                uploadTest.start();
                                uploadTestStarted = true;
                            }


                            //Ping Test
                            if (pingTestFinished) {
                                //Failure
                                if (pingTest.getAvgRtt() == 0) {
                                    System.out.println("Ping error...");
                                } else {
                                    //Success
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            pingTextView.setText(dec.format(pingTest.getAvgRtt()) + " ms");
                                        }
                                    });
                                }
                            } else {
                                pingRateList.add(pingTest.getInstantRtt());

                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        pingTextView.setText(dec.format(pingTest.getInstantRtt()) + " ms");
                                    }
                                });

                                //Update chart
                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        // Creating an  XYSeries for Income
                                        XYSeries pingSeries = new XYSeries("");
                                        pingSeries.setTitle("");

                                        int count = 0;
                                        List<Double> tmpLs = new ArrayList<>(pingRateList);
                                        for (Double val : tmpLs) {
                                            pingSeries.add(count++, val);
                                        }

                                        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
                                        dataset.addSeries(pingSeries);

                                        GraphicalView chartView = ChartFactory.getLineChartView(fragmentNetworkContext, dataset, multiPingRenderer);
                                        chartPing.addView(chartView, 0);

                                    }
                                });
                            }


                            //Download Test
                            if (pingTestFinished) {
                                if (downloadTestFinished) {
                                    //Failure
                                    if (downloadTest.getFinalDownloadRate() == 0) {
                                        System.out.println("Download error...");
                                    } else {
                                        //Success
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                downloadTextView.setText(dec.format(downloadTest.getFinalDownloadRate()) + " Mbps");
                                            }
                                        });
                                    }
                                } else {
                                    //Calc position
                                    double downloadRate = downloadTest.getInstantDownloadRate();
                                    downloadRateList.add(downloadRate);
                                    position = getPositionByRate(downloadRate);

                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //rotate = new RotateAnimation(lastPosition, position, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                                            //rotate.setInterpolator(new LinearInterpolator());
                                            //rotate.setDuration(100);
                                            //barImageView.startAnimation(rotate);
                                            downloadTextView.setText(dec.format(downloadTest.getInstantDownloadRate()) + " Mbps");

                                        }

                                    });
                                    lastPosition = position;

                                    //Update chart
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Creating an  XYSeries for Income
                                            XYSeries downloadSeries = new XYSeries("");
                                            downloadSeries.setTitle("");

                                            List<Double> tmpLs = new ArrayList<>(downloadRateList);
                                            int count = 0;
                                            for (Double val : tmpLs) {
                                                downloadSeries.add(count++, val);
                                            }

                                            XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
                                            dataset.addSeries(downloadSeries);

                                            GraphicalView chartView = ChartFactory.getLineChartView(fragmentNetworkContext, dataset, multiDownloadRenderer);
                                            chartDownload.addView(chartView, 0);
                                        }
                                    });

                                }
                            }


                            //Upload Test
                            if (downloadTestFinished) {
                                if (uploadTestFinished) {
                                    //Failure
                                    if (uploadTest.getFinalUploadRate() == 0) {
                                        System.out.println("Upload error...");
                                    } else {
                                        //Success
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                uploadTextView.setText(dec.format(uploadTest.getFinalUploadRate()) + " Mbps");
                                            }
                                        });
                                    }
                                } else {
                                    //Calc position
                                    double uploadRate = uploadTest.getInstantUploadRate();
                                    uploadRateList.add(uploadRate);
                                    position = getPositionByRate(uploadRate);

                                    getActivity().runOnUiThread(new Runnable() {

                                        @Override
                                        public void run() {
                                            //rotate = new RotateAnimation(lastPosition, position, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                                            //rotate.setInterpolator(new LinearInterpolator());
                                            //rotate.setDuration(100);
                                            //barImageView.startAnimation(rotate);
                                            uploadTextView.setText(dec.format(uploadTest.getInstantUploadRate()) + " Mbps");
                                        }

                                    });
                                    lastPosition = position;

                                    //Update chart
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            // Creating an  XYSeries for Income
                                            XYSeries uploadSeries = new XYSeries("");
                                            uploadSeries.setTitle("");

                                            int count = 0;
                                            List<Double> tmpLs = new ArrayList<>(uploadRateList);
                                            for (Double val : tmpLs) {
                                                if (count == 0) {
                                                    val = 0.0;
                                                }
                                                uploadSeries.add(count++, val);
                                            }

                                            XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
                                            dataset.addSeries(uploadSeries);

                                            GraphicalView chartView = ChartFactory.getLineChartView(fragmentNetworkContext, dataset, multiUploadRenderer);
                                            chartUpload.addView(chartView, 0);
                                        }
                                    });

                                }
                            }

                            //Test bitti
                            if (pingTestFinished && downloadTestFinished && uploadTest.isFinished()) {
                                break;
                            }

                            if (pingTest.isFinished()) {
                                pingTestFinished = true;
                            }
                            if (downloadTest.isFinished()) {
                                downloadTestFinished = true;
                            }
                            if (uploadTest.isFinished()) {
                                uploadTestFinished = true;
                            }

                            if (pingTestStarted && !pingTestFinished) {
                                try {
                                    Thread.sleep(300);
                                } catch (InterruptedException e) {
                                }
                            } else {
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                }
                            }
                        }

                        //Thread bitiminde button yeniden aktif ediliyor
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startButton.setEnabled(true);
                                startButton.setTextSize(16);
                                startButton.setText("Comenzar de Nuevo");
                            }
                        });


                    }
                }).start();
            }
        });




        return root;
    }


    public int getPositionByRate(double rate) {
        if (rate <= 1) {
            return (int) (rate * 30);

        } else if (rate <= 10) {
            return (int) (rate * 6) + 30;

        } else if (rate <= 30) {
            return (int) ((rate - 10) * 3) + 90;

        } else if (rate <= 50) {
            return (int) ((rate - 30) * 1.5) + 150;

        } else if (rate <= 100) {
            return (int) ((rate - 50) * 1.2) + 180;
        }

        return 0;
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
            String signalQuality = parts[5].replace(" ","");
            Log.d("OnMapReady","El valor de signalQUality es : "+signalQuality);
            if(phoneSignalStrength >= VERY_GOOD){
                Log.d("OnMapReady VERY_GOOD","El valor de ccccccccccccc signalQUality es : "+signalQuality);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitudeMDouble)).title(""+operatorName+"| Red Movil: "+phoneNetworType).snippet(" | Potencia: "+phoneSignalStrength+" | Latitud: "+latitude+" |longitud: "+longitudeMDouble)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.radio_icon_green_s)));
            }
            else if(phoneSignalStrength >= GOOD ){
                Log.d("OnMapReady GOOD","El valor de xddddd signalQUality es : "+signalQuality);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitudeMDouble)).title(""+operatorName+"| Red Movil: "+phoneNetworType).snippet(" | Potencia: "+phoneSignalStrength+" | Latitud: "+latitude+" |longitud: "+longitudeMDouble)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.radio_icon_yellow_s)));
            }
            else if(phoneSignalStrength >= AVERAGE ){
                Log.d("OnMapReady AVERAGE","El valor de sssssssssss signalQUality es : "+signalQuality);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitudeMDouble)).title(""+operatorName+"| Red Movil: "+phoneNetworType).snippet(" | Potencia: "+phoneSignalStrength+" | Latitud: "+latitude+" |longitud: "+longitudeMDouble)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.radio_icon_orange_s)));
            }
            else if(phoneSignalStrength >= BAD ){
                Log.d("OnMapReady BAD","El valor de eeeeeeee signalQUality es : "+signalQuality);
                googleMap.addMarker(new MarkerOptions().position(new LatLng(latitude,longitudeMDouble)).title(""+operatorName+"| Red Movil: "+phoneNetworType).snippet(" | Potencia: "+phoneSignalStrength+" | Latitud: "+latitude+" |longitud: "+longitudeMDouble)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.radio_icon_red_s)));
            }

        }
        //googleMap.addMarker(new MarkerOptions().position(new LatLng(latitudeOnMap,longitudeOnMap)).title("Mi caletos").snippet("Espero salir de aqui algún dia :X")
        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.radio_icon_green_s)));

        CameraPosition miLocation = CameraPosition.builder().target(new LatLng(latitudeOnMap,longitudeOnMap)).zoom(12).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(miLocation));
    }
}
