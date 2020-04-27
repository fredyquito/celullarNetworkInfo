package com.arcotel.network.demo;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
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
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.arcotel.network.demo.test.HttpDownloadTest;
import com.arcotel.network.demo.test.HttpUploadTest;
import com.arcotel.network.demo.test.PingTest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


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
    private double pingTimeMilis = 0.0 ;
    private double uploadSpeed = 0.0 ;
    private double downloadSpeed = 0.0 ;




    static int position = 0;
    static int lastPosition = 0;
    GetSpeedTestHostsHandler getSpeedTestHostsHandler = null;
    HashSet<String> tempBlackList;

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
        //Definicion de objetos de otras clases
        Pair<Double,Double> latLonLocation = locationAddress.getLatLongFromLocation(getContext());
        ScanHwAndSwInformation scanHwAndSwInformation = new ScanHwAndSwInformation();
        final ScanCellularActivity scanCellularActivity = new ScanCellularActivity(fragmentMapLocationContext);
        ArrayList<String> phoneInformation = scanCellularActivity.getOperatorInfo();
        ScanInternetSpeed scanInternetSpeed = new ScanInternetSpeed(fragmentMapLocationContext);
        final SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //Captura informacion para todos los dispositivos
        final String timestamp = s.format(new Date());
        final String countryISO = phoneInformation.get(0);
        final String phoneOperatorId =  phoneInformation.get(2);
        final String simOperatorId = phoneInformation.get(3);
        final String operatorMcc = scanCellularActivity.getDevMccId();
        final String operatorMnc = scanCellularActivity.getDevMncId();
        final String devManufacturer = scanHwAndSwInformation.getDevManufacturer();
        final String devModel = scanHwAndSwInformation.getDevModel();
        final String isConected = scanCellularActivity.getDevIsConected();
        final String phoneNetStandard = scanCellularActivity.getPhoneSignalType();
        final String phoneNetTechnology = scanCellularActivity.getPhoneNetworType();
        final String internetConNetwork = scanInternetSpeed.getNetworkConectivityType();
        final double latitude;
        final double longitude;
        latitude = latLonLocation.first;
        longitude = latLonLocation.second;
        final int isRegistered = 0;
        //scanDbHelper = new ScanDbHelper(getContext());

        /*buttonColectInfo = mView.findViewById(R.id.buttonColectInfo);
        buttonColectInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                scanMetadata = new ScanMetadata(countryISO,operatorMcc,simOperatorId,isConected,phoneNetStandard,phoneNetTechnology,
                        "bad",internetConNetwork,-76,23,12,12,latitude,longitude,isRegistered);

                scanDbHelper = new ScanDbHelper(getContext());
                scanDbHelper.saveSqlScan(scanMetadata);


            }
        });*/

        buttonUploadInfo = mView.findViewById(R.id.buttonUploadInfo);
        buttonUploadInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                if(internetConNetwork == "WIFI"){
                    Log.d("URL_JSON","Boton buttonUploadInfo presionado ");
                    Log.d("URL_JSON","Variable network es:  "+internetConNetwork);

                    scanDbHelper = new ScanDbHelper(getContext());
                    //seccion lte
                    cursorQuery = scanDbHelper.getScanLteInfoByIsRegistered(0);
                    ArrayList<String> jsonLteInputString  =  scanDbHelper.getScanLteInfoInJson(cursorQuery);
                    //Sección Wcdma
                    cursorQuery = scanDbHelper.getScanWcdmaInfoByIsRegistered(0);
                    ArrayList<String> jsonWcdmaInputString  =  scanDbHelper.getScanWcdmaInfoInJson(cursorQuery);
                    //Sección GSM
                    cursorQuery = scanDbHelper.getScanGsmInfoByIsRegistered(0);
                    ArrayList<String> jsonGsmInputString  =  scanDbHelper.getScanGsmInfoInJson(cursorQuery);
                    //Sección CDMA
                    cursorQuery = scanDbHelper.getScanCdmaInfoByIsRegistered(0);
                    ArrayList<String> jsonCdmaInputString  =  scanDbHelper.getScanCdmaInfoInJson(cursorQuery);
                    if(jsonLteInputString.size() != 0){
                        for(int i = 0 ; i < jsonLteInputString.size(); i++){
                            Log.d("URL_JSON","LTEvalor de i es "+i);
                            HttpJsonPost jsonPost = new HttpJsonPost();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                                Log.d("URL_JSON","Crea y envia jsonInputString "+jsonLteInputString.get(i));
                                String response = jsonPost.postJsonToServer("http://192.168.1.50:5005/addlte", jsonLteInputString.get(i));
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Log.d("Finall URL Post","mensaje es "+response);
                            }
                        }
                    }else if(jsonWcdmaInputString.size() != 0){
                        for(int i = 0 ; i < jsonWcdmaInputString.size(); i++){
                            Log.d("URL_JSON","WCDMA i es "+i);
                            HttpJsonPost jsonPost = new HttpJsonPost();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                                Log.d("URL_JSON","Crea y envia jsonInputString "+jsonWcdmaInputString.get(i));
                                String response = jsonPost.postJsonToServer("http://192.168.1.50:5005/addwcdma", jsonWcdmaInputString.get(i));
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Log.d("Finall URL Post","mensaje es "+response);
                            }
                        }
                    }else if(jsonGsmInputString.size() != 0){
                        for(int i = 0 ; i < jsonGsmInputString.size(); i++){
                            Log.d("URL_JSON","GSM i es "+i);
                            HttpJsonPost jsonPost = new HttpJsonPost();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                                Log.d("URL_JSON","Crea y envia jsonInputString "+jsonGsmInputString.get(i));
                                String response = jsonPost.postJsonToServer("http://192.168.1.50:5005/addgsm", jsonGsmInputString.get(i));
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Log.d("Finall URL Post","mensaje es "+response);
                            }
                        }
                    }else if(jsonCdmaInputString.size() != 0){
                        for(int i = 0 ; i < jsonCdmaInputString.size(); i++){
                            Log.d("URL_JSON","CDMA de i es "+i);
                            HttpJsonPost jsonPost = new HttpJsonPost();
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                                Log.d("URL_JSON","Crea y envia jsonInputString "+jsonCdmaInputString.get(i));
                                String response = jsonPost.postJsonToServer("http://192.168.1.50:5005/addcdma", jsonCdmaInputString.get(i));
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                Log.d("Finall URL Post","mensaje es "+response);
                            }
                        }
                    }else{
                        buttonUploadInfo.setText("No hay datos que insertar");
                    }
                }else if(internetConNetwork == "MOBILE"){
                    buttonUploadInfo.setText("No se puede subir con red Mobil");
                }
            }
        });


        //desde aqui comienza el test de internet
        final Button startButton = (Button) mView.findViewById(R.id.buttonColectInfo);
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

                    ImageView barImageView = (ImageView) mView.findViewById(R.id.barImageView);
                    TextView pingTextView = (TextView) mView.findViewById(R.id.pingTextView);
                    TextView downloadTextView = (TextView) mView.findViewById(R.id.downloadTextView);
                    TextView uploadTextView = (TextView) mView.findViewById(R.id.uploadTextView);

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
                                        Toast.makeText(fragmentMapLocationContext, "No Connection...", Toast.LENGTH_LONG).show();
                                        startButton.setEnabled(true);
                                        startButton.setTextSize(16);
                                        startButton.setText("Comenzar de nuevo");
                                        Log.d("SpeedVars","El valor de ping es"+pingTimeMilis+" el valor de download es "+downloadSpeed+" el valor de upload es "+uploadSpeed);
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
                        final LinearLayout chartPing = (LinearLayout) mView.findViewById(R.id.chartPing);
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
                        final LinearLayout chartDownload = (LinearLayout) mView.findViewById(R.id.chartDownload);
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
                        final LinearLayout chartUpload = (LinearLayout) mView.findViewById(R.id.chartUpload);
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
                                    pingTimeMilis = 0.0;
                                } else {
                                    //Success
                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            pingTextView.setText(dec.format(pingTest.getAvgRtt()) + " ms");
                                            pingTimeMilis=Double.parseDouble(dec.format(pingTest.getAvgRtt()));
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

                                        GraphicalView chartView = ChartFactory.getLineChartView(fragmentMapLocationContext, dataset, multiPingRenderer);
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
                                        downloadSpeed = 0.0;
                                    } else {
                                        //Success
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                downloadTextView.setText(dec.format(downloadTest.getFinalDownloadRate()) + " Mbps");
                                                downloadSpeed = Double.parseDouble(dec.format(downloadTest.getFinalDownloadRate()));
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

                                            GraphicalView chartView = ChartFactory.getLineChartView(fragmentMapLocationContext, dataset, multiDownloadRenderer);
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
                                        uploadSpeed = 0.0;
                                    } else {
                                        //Success
                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                //Log.d("UploadSpeed","entra a hilo valor de variable "+uploadSpeed);
                                                uploadTextView.setText(dec.format(uploadTest.getFinalUploadRate()) + " Mbps");
                                                //uploadSpeed = Double.parseDouble(dec.format(uploadTest.getFinalUploadRate()));

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
                                            uploadSpeed = Double.parseDouble(dec.format(uploadTest.getFinalUploadRate()));
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

                                            GraphicalView chartView = ChartFactory.getLineChartView(fragmentMapLocationContext, dataset, multiUploadRenderer);
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

                                Log.d("SpeedVars","El valor de ping es"+pingTimeMilis+" el valor de download es "+downloadSpeed+" el valor de upload es "+uploadSpeed+" red "+phoneNetTechnology);
                                //Seccion HSPA
                                if(phoneNetTechnology == "HSPA+" || phoneNetTechnology == "HSPA" || phoneNetTechnology == "UMTS"){
                                    ArrayList<Integer> strengthInfo = scanCellularActivity.getDevStrengthSignal();
                                    ArrayList<Integer> cellIdentity = scanCellularActivity.getDevCellIdentity();
                                    int phoneSignalStrength =  strengthInfo.get(0);
                                    int phoneAsuStrength =  strengthInfo.get(1);
                                    int phoneSignalLevel =  strengthInfo.get(2);
                                    int cellWcdmaLac = cellIdentity.get(0);
                                    int cellWcdmaUcid = cellIdentity.get(1);
                                    int cellWcdmaPsc = cellIdentity.get(2);
                                    int cellWcdmaCid = cellIdentity.get(3);
                                    int cellWcdmaRnc = cellIdentity.get(4);
                                    int cellWcdmaUarfcn = cellIdentity.get(5);
                                    String signalQuality = scanCellularActivity.getSignalQuality(strengthInfo.get(0));
                                    int fieldIsRegistered = 0;
                                    ScanWcdmaMetadata scanWcdmaMetadata = new ScanWcdmaMetadata(timestamp,countryISO,phoneOperatorId,simOperatorId,operatorMcc,
                                                                                operatorMnc,devManufacturer,devModel,isConected,phoneNetStandard,phoneNetTechnology,
                                                                                internetConNetwork,latitude,longitude,pingTimeMilis,downloadSpeed,uploadSpeed,
                                                                                phoneSignalStrength,phoneAsuStrength,phoneSignalLevel,cellWcdmaLac,cellWcdmaUcid,
                                                                                cellWcdmaPsc,cellWcdmaCid,cellWcdmaRnc,cellWcdmaUarfcn,signalQuality,fieldIsRegistered);
                                    scanDbHelper = new ScanDbHelper(getContext());
                                    scanDbHelper.saveWcdmaSqlScan(scanWcdmaMetadata);
                                }
                                //Seccion Lte
                                if(phoneNetTechnology == "LTE"){
                                    ArrayList<Integer> strengthInfo = scanCellularActivity.getDevStrengthSignal();
                                    ArrayList<Integer> cellIdentity = scanCellularActivity.getDevCellIdentity();
                                    int phoneSignalStrength = strengthInfo.get(0);
                                    int phoneAsuStrength = strengthInfo.get(1);
                                    int phoneSignalLevel = strengthInfo.get(2);
                                    int phoneRsrpStrength = strengthInfo.get(3);
                                    int phoneRsrqStrength = strengthInfo.get(4);
                                    double phoneRssnrStrength = 5.4;
                                    int phoneTimingAdvance = strengthInfo.get(6);
                                    int phoneCqiStrength = strengthInfo.get(7);
                                    int cellLtePci = cellIdentity.get(0);
                                    int cellLteTac = cellIdentity.get(1);
                                    int cellLteeNodeB = cellIdentity.get(2);
                                    int cellLteCid = cellIdentity.get(3);
                                    int cellLteEarfcn = cellIdentity.get(4);
                                    String signalQuality = scanCellularActivity.getSignalQuality(strengthInfo.get(0));
                                    int fieldIsRegistered = 0;
                                    ScanLteMetadata scanLteMetadata = new ScanLteMetadata(timestamp,countryISO,phoneOperatorId,simOperatorId,operatorMcc,operatorMnc,
                                                                                    devManufacturer,devModel,isConected,phoneNetStandard,phoneNetTechnology,internetConNetwork,
                                                                                    latitude,longitude,pingTimeMilis,downloadSpeed,uploadSpeed,phoneSignalStrength,phoneAsuStrength,
                                                                                    phoneSignalLevel,phoneRsrpStrength,phoneRsrqStrength,phoneRssnrStrength,phoneTimingAdvance,
                                                                                    phoneCqiStrength,cellLtePci,cellLteTac,cellLteeNodeB,cellLteCid,cellLteEarfcn,signalQuality,fieldIsRegistered);
                                    scanDbHelper = new ScanDbHelper(getContext());
                                    scanDbHelper.saveLteSqlScan(scanLteMetadata);
                                }
                                //Seccion GSM
                                if(phoneNetTechnology == "GSM" || phoneNetTechnology == "GPRS" || phoneNetTechnology == "EDGE"){
                                    ArrayList<Integer> strengthInfo = scanCellularActivity.getDevStrengthSignal();
                                    ArrayList<Integer> cellIdentity = scanCellularActivity.getDevCellIdentity();
                                    int phoneSignalStrength =  strengthInfo.get(0);
                                    int phoneAsuStrength =  strengthInfo.get(1);
                                    int phoneSignalLevel =  strengthInfo.get(2);
                                    int cellGsmLac  = cellIdentity.get(0);
                                    int cellGsmCid  = cellIdentity.get(1);
                                    int cellGsmArcfn = cellIdentity.get(2);
                                    String signalQuality = scanCellularActivity.getSignalQuality(strengthInfo.get(0));
                                    int fieldIsRegistered = 0;
                                    ScanGsmMetadata scanGsmMetadata = new ScanGsmMetadata(timestamp,countryISO,phoneOperatorId,simOperatorId,operatorMcc,
                                                                                        operatorMnc,devManufacturer,devModel,isConected,phoneNetStandard,phoneNetTechnology,
                                                                                        internetConNetwork,latitude,longitude,pingTimeMilis,downloadSpeed,uploadSpeed,phoneSignalStrength,
                                                                                        phoneAsuStrength,phoneSignalLevel,cellGsmLac,cellGsmCid,cellGsmArcfn,signalQuality,fieldIsRegistered);
                                    scanDbHelper = new ScanDbHelper(getContext());
                                    scanDbHelper.saveGsmSqlScan(scanGsmMetadata);

                                }
                                //Seccion CDMA
                                if(phoneNetTechnology == "CDMA" || phoneNetTechnology == "EVDO_0" || phoneNetTechnology == "EVDO_A" || phoneNetTechnology == "EVDO_B"){
                                    ArrayList<Integer> strengthInfo = scanCellularActivity.getDevStrengthSignal();
                                    ArrayList<Integer> cellIdentity = scanCellularActivity.getDevCellIdentity();
                                    int phoneSignalStrength =  strengthInfo.get(0);
                                    int phoneAsuStrength =  strengthInfo.get(0);
                                    int phoneSignalLevel =  strengthInfo.get(0);
                                    int cellBslat = cellIdentity.get(0);
                                    int cellBslon = cellIdentity.get(1);
                                    int cellSid = cellIdentity.get(2);
                                    int cellNid = cellIdentity.get(3);
                                    int cellBid = cellIdentity.get(4);
                                    String signalQuality = scanCellularActivity.getSignalQuality(strengthInfo.get(0));
                                    int fieldIsRegistered = 0;
                                    ScanCdmaMetadata scanCdmaMetadata = new ScanCdmaMetadata(timestamp,countryISO,phoneOperatorId,simOperatorId,operatorMcc,operatorMnc,
                                                                                            devManufacturer,devModel,isConected,phoneNetStandard,phoneNetTechnology,internetConNetwork,
                                                                                            latitude,longitude,pingTimeMilis,downloadSpeed,uploadSpeed,phoneSignalStrength,phoneAsuStrength,
                                                                                            phoneSignalLevel,cellBslat,cellBslon,cellSid,cellNid,cellBid,signalQuality,fieldIsRegistered);
                                    scanDbHelper = new ScanDbHelper(getContext());
                                    scanDbHelper.saveCdmaSqlScan(scanCdmaMetadata);
                                }
                            }
                        });


                    }
                }).start();
            }
        });


        return mView;
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


}
