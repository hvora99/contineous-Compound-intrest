package lnclcgd.fnplaner.mortvatclc;

import static com.facebook.ads.BuildConfig.DEBUG;

import android.content.Context;
import android.util.Log;

import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkAds;

public class AudienceNetworkInitializeHelper implements AudienceNetworkAds.InitListener {

  private AudienceNetworkInitializeHelper ( Context context) {
  }


  static void initialize(Context context) {
    if (!AudienceNetworkAds.isInitialized(context)) {
      if (DEBUG) {
        AdSettings.turnOnSDKDebugger(context);
      }

      AudienceNetworkAds.buildInitSettings(context)
          .withInitListener(new AudienceNetworkInitializeHelper(context))
          .initialize();
    }
  }

  @Override
  public void onInitialized(AudienceNetworkAds.InitResult result) {
    Log.d(AudienceNetworkAds.TAG, result.getMessage());
  }
}
