package lnclcgd.fnplaner.mortvatclc;

import static lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper.splashId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATMediationRequestInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.splashad.api.ATSplashAd;
import com.anythink.splashad.api.ATSplashAdListener;
import com.anythink.splashad.api.ATSplashExListener;
import com.anythink.splashad.api.IATSplashEyeAd;
import com.facebook.FacebookSdk;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class splash extends AppCompatActivity implements ATSplashExListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    ATSplashAd splashAd;
    FrameLayout container;
    ATMediationRequestInfo atMediationRequestInfo = null;
    ViewGroup.LayoutParams layoutParams;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_splash);

        AudienceNetworkAds.initialize (this);
        AdSettings.addTestDevice("874771e9-10f1-447e-a8c0-54e68079d268");

        FacebookSdk.fullyInitialize ();

        container = findViewById(R.id.splash_ad_container);
        layoutParams = container.getLayoutParams();
        Configuration cf = getResources().getConfiguration();

        int ori = cf.orientation;

        if (ori == Configuration.ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            layoutParams.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.9);
            layoutParams.height = getResources().getDisplayMetrics().heightPixels;
        } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            layoutParams.width = getResources().getDisplayMetrics().widthPixels;
            layoutParams.height = (int) (getResources().getDisplayMetrics().heightPixels * 0.85);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
            layoutParams.width = getResources().getDisplayMetrics().widthPixels;
            layoutParams.height = (int) (getResources().getDisplayMetrics().heightPixels * 0.85);
        }


        splashAd = new ATSplashAd (this, splashId, atMediationRequestInfo, (ATSplashAdListener) this, 5000);

        Map<String, Object> localMap = new HashMap<> ();
        localMap.put(ATAdConst.KEY.AD_WIDTH, layoutParams.width);
        localMap.put(ATAdConst.KEY.AD_HEIGHT, layoutParams.height);
        splashAd.setLocalExtra(localMap);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (splashAd.isAdReady()) {
                    Log.e(TAG, "SplashAd is ready to show.");
                    splashAd.show(splash.this, container);
                } else {
                    Log.e(TAG, "SplashAd isn't ready to show, start to request.");
                    splashAd.loadAd();
                }
            }
        },3000);

        printHashKey ( this );

    }

    public static void printHashKey(Context pContext) {
        try {
            PackageInfo info = pContext.getPackageManager().getPackageInfo(pContext.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String( Base64.encode(md.digest(), 0));
                Log.i(TAG, "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "printHashKey()", e);
        } catch (Exception e) {
            Log.e(TAG, "printHashKey()", e);
        }
    }
    @Override
    public void onDeeplinkCallback( ATAdInfo adInfo, boolean isSuccess) {
        Log.e(TAG, "onDeeplinkCallback:" + adInfo.toString() + "--status:" + isSuccess);
    }

    @Override
    public void onNoAdError( AdError adError) {
        Log.e(TAG, "onNoAdError---------:" + adError.getFullErrorInfo());
        jumpToMainActivity();
    }

    @Override
    public void onAdShow(ATAdInfo entity) {
        Log.e(TAG, "onAdShow:\n" + entity.toString());
    }

    @Override
    public void onAdClick(ATAdInfo entity) {
        Log.e(TAG, "onAdClick:\n" + entity.toString());
    }

    @Override
    public void onAdDismiss(ATAdInfo entity, IATSplashEyeAd splashEyeAd) {
        Log.e(TAG, "onAdDismiss:\n" + entity.toString());
        jumpToMainActivity();
    }


    @Override
    public void onDownloadConfirm( Context context, ATAdInfo atAdInfo, ATNetworkConfirmInfo atNetworkConfirmInfo) {

    }

    @Override
    public void onAdLoaded(boolean b) {
        Log.e(TAG, "onAdLoaded---------");
        splashAd.show(this, container);
    }

    @Override
    public void onAdLoadTimeout() {

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (canJump) {
            jumpToMainActivity();
        }

        canJump = true;
    }

    @Override
    protected void onPause() {
        super.onPause();

        canJump = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (splashAd != null) {
            splashAd.onDestory();
        }

    }

    boolean hasHandleJump = false;
    boolean canJump;

    public void jumpToMainActivity() {

        if (!canJump) {
            canJump = true;
            return;
        }

        if (!hasHandleJump) {
            hasHandleJump = true;
            startActivity(new Intent(splash.this, NextActivity.class));
            finish();
        }

    }
}