package lnclcgd.fnplaner.mortvatclc.AdHelper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.anythink.banner.api.ATBannerExListener;
import com.anythink.banner.api.ATBannerView;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATNetworkConfirmInfo;
import com.anythink.core.api.AdError;
import com.anythink.interstitial.api.ATInterstitial;
import com.anythink.interstitial.api.ATInterstitialExListener;
import com.anythink.nativead.api.ATNative;
import com.anythink.nativead.api.ATNativeAdView;
import com.anythink.nativead.api.ATNativeDislikeListener;
import com.anythink.nativead.api.ATNativeEventExListener;
import com.anythink.nativead.api.ATNativeNetworkListener;
import com.anythink.nativead.api.NativeAd;
import com.anythink.network.admob.AdmobATConst;
import com.anythink.rewardvideo.api.ATRewardVideoAd;
import com.anythink.rewardvideo.api.ATRewardVideoExListener;

import java.util.HashMap;
import java.util.Map;

import lnclcgd.fnplaner.mortvatclc.R;

public class TopOnAdsHelper {

    public static String appid = "a62fb80bb094ae";
    public static String appKey = "f8e3918f57593cc4ada70c5555d1be1d";

    public static String splashId = "b62bd3e47092f5";
    public static String rewardId = "b6236aacb0ja86";
    public static String nativeId = "b62fb80eb5068e";
    public static String interstitialId = "b62fb896ecf287";
    public static String bannerId = "b62fb80ea5e802";


    private static final String TAG = TopOnAdsHelper.class.getSimpleName();


    @SuppressLint("StaticFieldLeak")
    static ImageView mCloseView;
    @SuppressLint("StaticFieldLeak")
    static ATNative atNatives;
    @SuppressLint("StaticFieldLeak")
    static ATNativeAdView anyThinkNativeAdView;
//    public static NativeAd mNativeAd;

    public static void LoadNativeAd(Activity activity, RelativeLayout relativeLayout){

        initCloseView(activity);

        int padding = dip2px(10,activity);
        final int containerHeight = dip2px(340,activity);
        final int adViewWidth = activity.getResources().getDisplayMetrics().widthPixels - 2 * padding;
        final int adViewHeight = containerHeight - 2 * padding;

        final NativeDemoRender anyThinkRender = new NativeDemoRender(activity);
        anyThinkRender.setCloseView(mCloseView);

//        for (int i = 0; i < placementNameList.size(); i++) {
//            atNatives[i] = new ATNative(this, placementIdMap.get(placementNameList.get(i)), new ATNativeNetworkListener() {
//                @Override
//                public void onNativeAdLoaded() {
//                    Log.e(TAG, "onNativeAdLoaded");
////                    Toast.makeText(MainActivity.this, "load success..."
////                            , Toast.LENGTH_LONG).show();
//                }
//
//                @Override
//                public void onNativeAdLoadFail(AdError adError) {
//                    Log.e(TAG, "onNativeAdLoadFail, " + adError.getFullErrorInfo());
////                    Toast.makeText(MainActivity.this, "load fail...：" + adError.getFullErrorInfo(), Toast.LENGTH_LONG).show();
//
//                }
//            });
//
//            if (anyThinkNativeAdView == null) {
//                anyThinkNativeAdView = new ATNativeAdView(this);
//            }
//        }

        atNatives = new ATNative(activity, nativeId, new ATNativeNetworkListener() {
            @Override
            public void onNativeAdLoaded() {
                Log.e(TAG, "onNativeAdLoaded");
//                    Toast.makeText(MainActivity.this, "load success..."
//                            , Toast.LENGTH_LONG).show();

                NativeAd nativeAd = atNatives.getNativeAd();
                if (nativeAd != null) {

                    Log.w(TAG, "nativeAd: not null*************" );

                    if (anyThinkNativeAdView != null) {
                        Log.w(TAG, "anyThinkNativeAdView: not null*************" );

                        anyThinkNativeAdView.removeAllViews();
//                        anyThinkNativeAdView = new ATNativeAdView(activity);

//                        if(anyThinkNativeAdView.getParent()!=null){
//                            anyThinkNativeAdView = new ATNativeAdView(activity);
//                        }

                        if (anyThinkNativeAdView.getParent() != null) {
                            ((ViewGroup) anyThinkNativeAdView.getParent()).removeView(anyThinkNativeAdView);
                            anyThinkNativeAdView.removeAllViews();
                        }

                        if (anyThinkNativeAdView.getParent() == null) {
                            relativeLayout.addView(anyThinkNativeAdView, new RelativeLayout.LayoutParams(activity.getResources().getDisplayMetrics().widthPixels, containerHeight));
                        }
                    }else{
                        Log.w(TAG, "anyThinkNativeAdView: null*************" );

                    }

//                    if (mNativeAd != null) {
//                        mNativeAd.destory();
//                    }
//                    mNativeAd = nativeAd;
                    nativeAd.setNativeEventListener(new ATNativeEventExListener() {
                        @Override
                        public void onDeeplinkCallback(ATNativeAdView view, ATAdInfo adInfo, boolean isSuccess) {
                            Log.e(TAG, "onDeeplinkCallback:" + adInfo.toString() + "--status:" + isSuccess);
                        }

                        @Override
                        public void onAdImpressed(ATNativeAdView view, ATAdInfo entity) {
                            Log.e(TAG, "native ad onAdImpressed:\n" + entity.toString());
                        }

                        @Override
                        public void onAdClicked(ATNativeAdView view, ATAdInfo entity) {
                            Log.e(TAG, "native ad onAdClicked:\n" + entity.toString());
                        }

                        @Override
                        public void onAdVideoStart(ATNativeAdView view) {
                            Log.e(TAG, "native ad onAdVideoStart");
                        }

                        @Override
                        public void onAdVideoEnd(ATNativeAdView view) {
                            Log.e(TAG, "native ad onAdVideoEnd");
                        }

                        @Override
                        public void onAdVideoProgress(ATNativeAdView view, int progress) {
                            Log.e(TAG, "native ad onAdVideoProgress:" + progress);
                        }
                    });
                    nativeAd.setDislikeCallbackListener(new ATNativeDislikeListener() {
                        @Override
                        public void onAdCloseButtonClick(ATNativeAdView view, ATAdInfo entity) {
                            Log.i(TAG, "native ad onAdCloseButtonClick");
                            if (view.getParent() != null) {
                                ((ViewGroup) view.getParent()).removeView(view);
                                view.removeAllViews();
                            }
                        }
                    });
                    try {
                        nativeAd.renderAdView(anyThinkNativeAdView, anyThinkRender);
                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                    if (mCloseView.getParent() != null) {
                        ((ViewGroup) mCloseView.getParent()).removeView(mCloseView);
                    }
                    anyThinkNativeAdView.addView(mCloseView);

                    anyThinkNativeAdView.setVisibility(View.VISIBLE);
                    nativeAd.prepare(anyThinkNativeAdView, anyThinkRender.getClickView(), null);
                } else {
                    Log.e(TAG, "this placement no cache!" );
//            Toast.makeText(MainActivity.this, "this placement no cache!", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onNativeAdLoadFail(AdError adError) {
                Log.e(TAG, "onNativeAdLoadFail, " + adError.getFullErrorInfo());
//                    Toast.makeText(MainActivity.this, "load fail...：" + adError.getFullErrorInfo(), Toast.LENGTH_LONG).show();

            }
        });

//        if (anyThinkNativeAdView == null) {
            anyThinkNativeAdView = new ATNativeAdView(activity);
//        }

        if (anyThinkNativeAdView.getParent() != null) {
            ((ViewGroup) anyThinkNativeAdView.getParent()).removeView(anyThinkNativeAdView);
            anyThinkNativeAdView.removeAllViews();
        }

        Map<String, Object> localMap = new HashMap<>();

        // since v5.6.4
        localMap.put(ATAdConst.KEY.AD_WIDTH, adViewWidth);
        localMap.put(ATAdConst.KEY.AD_HEIGHT, adViewHeight);

        atNatives.setLocalExtra(localMap);

        atNatives.makeAdRequest();

        anyThinkNativeAdView.setPadding(2, 2, 2, 2);
    }

    public static int dip2px(float dipValue,Activity activity) {
        float scale = activity.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    private static void initCloseView(Activity activity) {
        if (mCloseView == null) {
            mCloseView = new ImageView(activity);
            mCloseView.setImageResource(R.drawable.ad_close);

            int padding = dip2px(5,activity);
            mCloseView.setPadding(padding, padding, padding, padding);

            int size = dip2px(30,activity);
            int margin = dip2px(2,activity);

            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(size, size);
            layoutParams.topMargin = margin;
            layoutParams.rightMargin = margin;
            layoutParams.gravity = Gravity.TOP | Gravity.RIGHT;

            mCloseView.setLayoutParams(layoutParams);
        }
    }

    public static void LOADBANNERAD(Activity activity,RelativeLayout relativeLayout){

        ATBannerView mBannerView;

        mBannerView = new ATBannerView(activity);
        mBannerView.setPlacementId(bannerId);
        relativeLayout.addView(mBannerView, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, dip2px(50,activity)));

        Map<String, Object> localExtra = new HashMap<>();
        localExtra.put(AdmobATConst.ADAPTIVE_TYPE, AdmobATConst.ADAPTIVE_ANCHORED);
        localExtra.put(AdmobATConst.ADAPTIVE_ORIENTATION, AdmobATConst.ORIENTATION_CURRENT);
        localExtra.put(AdmobATConst.ADAPTIVE_WIDTH, activity.getResources().getDisplayMetrics().widthPixels);
        mBannerView.setLocalExtra(localExtra);

        mBannerView.loadAd();

        mBannerView.setBannerAdListener(new ATBannerExListener() {

            @Override
            public void onDeeplinkCallback(boolean isRefresh, ATAdInfo adInfo, boolean isSuccess) {
                Log.e(TAG, "onDeeplinkCallback:" + adInfo.toString() + "--status:" + isSuccess);
            }

            @Override
            public void onDownloadConfirm(Context context, ATAdInfo atAdInfo, ATNetworkConfirmInfo atNetworkConfirmInfo) {

            }

            @Override
            public void onBannerLoaded() {
                Log.e(TAG, "onBannerLoaded");
//                Toast.makeText(MainActivity.this,
//                        "onBannerLoaded",
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerFailed(AdError adError) {
                Log.e(TAG, "onBannerFailed: " + adError.getFullErrorInfo());
//                Toast.makeText(MainActivity.this,
//                        "onBannerFailed: " + adError.getFullErrorInfo(),
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerClicked(ATAdInfo entity) {
                Log.e(TAG, "onBannerClicked:" + entity.toString());
//                Toast.makeText(MainActivity.this,
//                        "onBannerClicked",
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerShow(ATAdInfo entity) {
                Log.e(TAG, "onBannerShow:" + entity.toString());
//                Toast.makeText(MainActivity.this,
//                        "onBannerShow",
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerClose(ATAdInfo entity) {
                Log.e(TAG, "onBannerClose:" + entity.toString());
//                Toast.makeText(MainActivity.this,
//                        "onBannerClose",
//                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBannerAutoRefreshed(ATAdInfo entity) {
                Log.e(TAG, "onBannerAutoRefreshed:" + entity.toString());
            }

            @Override
            public void onBannerAutoRefreshFail(AdError adError) {
                Log.e(TAG, "onBannerAutoRefreshFail: " + adError.getFullErrorInfo());

            }
        });

    }


    public static void LoadInterstitial(Activity activity,Intent intent,boolean isFinish) {

        ATInterstitial mInterstitialAd;
        final CustomDialogClass loader = new CustomDialogClass(activity);
        loader.show();

        mInterstitialAd = new ATInterstitial(activity, interstitialId);
        mInterstitialAd.setAdListener(new ATInterstitialExListener() {

            @Override
            public void onDeeplinkCallback(ATAdInfo adInfo, boolean isSuccess) {
                Log.i(TAG, "onDeeplinkCallback:" + adInfo.toString() + "--status:" + isSuccess);
            }

            @Override
            public void onDownloadConfirm(Context context, ATAdInfo atAdInfo, ATNetworkConfirmInfo atNetworkConfirmInfo) {

            }

            @Override
            public void onInterstitialAdLoaded() {
                Log.e(TAG, "onInterstitialAdLoaded");
//                Toast.makeText(MainActivity.this, "onInterstitialAdLoaded", Toast.LENGTH_SHORT).show();
                if (loader.isShowing())
                    loader.dismiss();

                mInterstitialAd.show(activity);
            }

            @Override
            public void onInterstitialAdLoadFail(AdError adError) {
                Log.e(TAG, "onInterstitialAdLoadFail:\n" + adError.getFullErrorInfo());
//                Toast.makeText(MainActivity.this, "onInterstitialAdLoadFail:" + adError.getFullErrorInfo(), Toast.LENGTH_SHORT).show();
                if (loader.isShowing())
                    loader.dismiss();

                if(intent!=null){
                    activity.startActivity(intent);
                }

                if(isFinish){
                    activity.finish();
                }
            }

            @Override
            public void onInterstitialAdClicked(ATAdInfo entity) {
                Log.e(TAG, "onInterstitialAdClicked:\n" + entity.toString());
//                Toast.makeText(MainActivity.this, "onInterstitialAdClicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdShow(ATAdInfo entity) {
                Log.e(TAG, "onInterstitialAdShow:\n" + entity.toString());
//                Toast.makeText(MainActivity.this, "onInterstitialAdShow", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdClose(ATAdInfo entity) {
                Log.e(TAG, "onInterstitialAdClose:\n" + entity.toString());
//                Toast.makeText(MainActivity.this, "onInterstitialAdClose", Toast.LENGTH_SHORT).show();

                if(intent!=null){
                    activity.startActivity(intent);
                }

                if(isFinish){
                    activity.finish();
                }
            }

            @Override
            public void onInterstitialAdVideoStart(ATAdInfo entity) {
                Log.e(TAG, "onInterstitialAdVideoStart:\n" + entity.toString());
//                Toast.makeText(MainActivity.this, "onInterstitialAdVideoStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdVideoEnd(ATAdInfo entity) {
                Log.e(TAG, "onInterstitialAdVideoEnd:\n" + entity.toString());
//                Toast.makeText(MainActivity.this, "onInterstitialAdVideoEnd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onInterstitialAdVideoError(AdError adError) {
                Log.e(TAG, "onInterstitialAdVideoError:\n" + adError.getFullErrorInfo());
//                Toast.makeText(MainActivity.this, "onInterstitialAdVideoError", Toast.LENGTH_SHORT).show();
            }

        });
        mInterstitialAd.load();
    }


    public static void ShowRewardedVideo(Activity activity) {

        final CustomDialogClass loader = new CustomDialogClass(activity);
        loader.show();

        ATRewardVideoAd mRewardVideoAd;

        mRewardVideoAd = new ATRewardVideoAd(activity, rewardId);


        mRewardVideoAd.setAdListener(new ATRewardVideoExListener() {

            @Override
            public void onDeeplinkCallback(ATAdInfo adInfo, boolean isSuccess) {
                Log.e(TAG, "onDeeplinkCallback:" + adInfo.toString() + "--status:" + isSuccess);
            }

            @Override
            public void onDownloadConfirm(Context context, ATAdInfo atAdInfo, ATNetworkConfirmInfo atNetworkConfirmInfo) {

            }

            @Override
            public void onRewardedVideoAdAgainPlayStart(ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdAgainPlayEnd(ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdAgainPlayFailed(AdError adError, ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdAgainPlayClicked(ATAdInfo atAdInfo) {

            }

            @Override
            public void onAgainReward(ATAdInfo atAdInfo) {

            }

            @Override
            public void onRewardedVideoAdLoaded() {
                Log.e(TAG, "onRewardedVideoAdLoaded");
//                Toast.makeText(SecondActivity.this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
                if (loader.isShowing())
                    loader.dismiss();
                mRewardVideoAd.show(activity);

            }

            @Override
            public void onRewardedVideoAdFailed(AdError errorCode) {
                Log.e(TAG, "onRewardedVideoAdFailed error:" + errorCode.getFullErrorInfo());
                if (loader.isShowing())
                    loader.dismiss();
                Toast.makeText(activity, "onRewardedVideoAdFailed:" + errorCode.getFullErrorInfo(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayStart(ATAdInfo entity) {
                Log.e(TAG, "onRewardedVideoAdPlayStart:\n" + entity.toString());
//                Toast.makeText(SecondActivity.this, "onRewardedVideoAdPlayStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayEnd(ATAdInfo entity) {
                Log.e(TAG, "onRewardedVideoAdPlayEnd:\n" + entity.toString());
//                Toast.makeText(SecondActivity.this, "onRewardedVideoAdPlayEnd", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayFailed(AdError errorCode, ATAdInfo entity) {
                Log.e(TAG, "onRewardedVideoAdPlayFailed error:" + errorCode.getFullErrorInfo());
//                Toast.makeText(SecondActivity.this, "onRewardedVideoAdPlayFailed:" + errorCode.getFullErrorInfo(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdClosed(ATAdInfo entity) {
                Log.e(TAG, "onRewardedVideoAdClosed:\n" + entity.toString());
                Toast.makeText(activity, "Reward Added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdPlayClicked(ATAdInfo entity) {
                Log.e(TAG, "onRewardedVideoAdPlayClicked:\n" + entity.toString());
//                Toast.makeText(SecondActivity.this, "onRewardedVideoAdPlayClicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onReward(ATAdInfo entity) {
                Log.e(TAG, "onReward:\n" + entity.toString());
//                Toast.makeText(SecondActivity.this, "onReward", Toast.LENGTH_SHORT).show();
            }
        });
        mRewardVideoAd.load();
    }


}
