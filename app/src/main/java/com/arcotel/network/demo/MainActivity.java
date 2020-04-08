package com.arcotel.network.demo;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.arcotel.network.demo.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_PERMISSION_PHONE_STATE=1;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        String permissionACLocation =  Manifest.permission.ACCESS_COARSE_LOCATION;
        String permissionAFLocation = Manifest.permission.ACCESS_FINE_LOCATION;
        String permissionInternet = Manifest.permission.INTERNET;
        String permissionAccessWifi = Manifest.permission.ACCESS_WIFI_STATE;
        Log.d("Pre-permiso","la variable permoso tiene: "+permissionACLocation);
        Log.d("Pre-permiso","la variable permoso tiene: "+permissionAFLocation);
        Log.d("Pre-permiso","la variable permoso tiene: "+permissionInternet);
        Log.d("Pre-permiso","la variable permoso tiene: "+permissionAccessWifi);
        this.showPhoneStatePermission(permissionACLocation);
        this.showPhoneStatePermission(permissionAFLocation);
        this.showPhoneStatePermission(permissionInternet);
        this.showPhoneStatePermission(permissionAccessWifi);

        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }

    private void showPhoneStatePermission(String permission) {
        Log.d("Entra showPhoneState","la variable permiso tiene: "+permission);
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, permission);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    permission)) {
                Log.d("Entra showExplanation","la variable permiso tiene: "+permission);
                showExplanation("Permission Needed", "Rationale", permission, REQUEST_PERMISSION_PHONE_STATE);
            } else {
                Log.d("Entra requestpermision","la variable permiso tiene: "+permission);
                requestPermission(permission, REQUEST_PERMISSION_PHONE_STATE);
            }
        } else {
            Toast.makeText(this, "Permission (already) Granted!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_PHONE_STATE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denied!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void showExplanation(String title,String message,final String permission,final int permissionRequestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        requestPermission(permission, permissionRequestCode);
                    }
                });
        builder.create().show();
    }

    private void requestPermission(String permissionName, int permissionRequestCode) {
        Log.d("Entra requestPermission","la variable permiso tiene: "+permissionName);
        ActivityCompat.requestPermissions(this,
                new String[]{permissionName}, permissionRequestCode);
    }


}