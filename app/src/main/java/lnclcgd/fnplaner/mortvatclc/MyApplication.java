package lnclcgd.fnplaner.mortvatclc;

import static com.facebook.ads.BuildConfig.DEBUG;
import static lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper.appKey;
import static lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper.appid;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import android.webkit.WebView;

import com.anythink.core.api.ATSDK;
import com.anythink.core.api.NetTrafficeCallback;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;


        AudienceNetworkInitializeHelper.initialize(this);

        if (DEBUG) {
            StrictMode.setThreadPolicy(
                    new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build());
        }


        //Android 9 or above must be set
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            String processName = getProcessName();
            if (!getPackageName().equals(processName)) {
                WebView.setDataDirectorySuffix(processName);
            }
        }

        ATSDK.setNetworkLogDebug(true);
        ATSDK.integrationChecking(this);

        ATSDK.checkIsEuTraffic(this, new NetTrafficeCallback() {

            @Override
            public void onResultCallback(boolean isEU) {
                if (isEU && ATSDK.getGDPRDataLevel(MyApplication.this) == ATSDK.UNKNOWN) {
                    ATSDK.showGdprAuth(MyApplication.this);
                }

                Log.e("MyApplication", "onResultCallback:" + isEU);
            }

            @Override
            public void onErrorCallback(String errorMsg) {
                Log.e("MyApplication", "onErrorCallback:" + errorMsg);
            }
        });

        ATSDK.setChannel("testChannle");
        ATSDK.setSubChannel("testSubChannle");
//        ATSDK.setBiddingTestDevice("998945725b40a32d");
        ATSDK.setBiddingTestDevice("e99b7cca3e793222");
        ATSDK.init(getApplicationContext(), appid, appKey);
    }

}
