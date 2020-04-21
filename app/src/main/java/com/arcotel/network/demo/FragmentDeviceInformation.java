package com.arcotel.network.demo;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDeviceInformation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDeviceInformation extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button btnGetDevInfo;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentDeviceInformation() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDeviceInformation.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDeviceInformation newInstance(String param1, String param2) {
        FragmentDeviceInformation fragment = new FragmentDeviceInformation();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_device_information,container,false);
        final TextView textViewGetHwSwInfo_rw = root.findViewById(R.id.textViewGetHwSwInfo);
        final ScanHwAndSwInformation scanHwAndSwInformation = new ScanHwAndSwInformation();
        btnGetDevInfo = root.findViewById(R.id.btnGetDevInfo);
        btnGetDevInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String getHwSwDevInformation = scanHwAndSwInformation.getHardwareAndSoftwareInfo();
                Log.d("GetDeviceInformation","la infor es "+getHwSwDevInformation);
                textViewGetHwSwInfo_rw.setText(getHwSwDevInformation);
            }
        });
        return root;
    }
}
