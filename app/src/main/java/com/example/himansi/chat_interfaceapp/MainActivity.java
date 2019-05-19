package com.example.himansi.chat_interfaceapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver receiver;
    IntentFilter intentFilter;
    private static ConnectivityManager manager;
    private static FragmentManager fragmentManager;
    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.black));
        setContentView(R.layout.activity_main);
        NetworkChangeReceiver();
        context=getApplicationContext();
        fragmentManager=getSupportFragmentManager();
        replaceFragment();

        Toast.makeText(this,"Tap on screen",Toast.LENGTH_SHORT).show();
    }



    private void NetworkChangeReceiver() {
           intentFilter=new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
           receiver=new BroadcastReceiver() {
               @Override
               public void onReceive(Context context, Intent intent) {
                    if(!isConnected()){
                        Toast.makeText(getApplicationContext(),"Internet lost",Toast.LENGTH_SHORT).show();

                    }
               }
           };
            registerReceiver(receiver,intentFilter);
    }

    public static boolean isConnected() {
        manager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info=null;
        if(manager!=null)
        {
            info=manager.getActiveNetworkInfo();
        }
        if(info!=null && info.isConnected())
        {
            return true;
        }
        return false;
    }

    public static void replaceFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isConnected()) {
            fragmentTransaction.replace(R.id.fragment_holder, new chat());
            fragmentTransaction.commit();
        } else {
            fragmentTransaction.replace(R.id.fragment_holder, new check_internet());
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }

    @Override
    protected void onResume() {
        registerReceiver(receiver,intentFilter);
        super.onResume();
    }
}
