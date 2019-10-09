package kr.co.glenda.loginapp.login.common;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;

import kr.co.glenda.loginapp.BuildConfig;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRoom();
        initSteho();
    }

    private void initRoom(){
        AppDatabaseProvider.getINSTANCE(getApplicationContext());
    }

    private void initSteho() {
        //chrome://inspect/#devices
        Log.d("MyApp", BuildConfig.BUILD_TYPE + "");
        if(BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
        }
    }

}
