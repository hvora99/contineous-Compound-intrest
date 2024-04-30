package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class NextActivity extends AppCompatActivity {

    ImageView start;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_next);

        TopOnAdsHelper.LOADBANNERAD(NextActivity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(NextActivity.this,findViewById(R.id.native_ad_container));


        ImageView q1 = (ImageView) findViewById(R.id.q1);
        ImageView q2 = (ImageView) findViewById(R.id.q2);
        ImageView q3 = (ImageView) findViewById(R.id.q3);

        q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openportal1 ();

            }
        });

        q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openportal1 ();

            }
        });

        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openportal1 ();

            }
        });

        CardView startLoancalc = (CardView) findViewById(R.id.start);
        CardView rateloancalc = (CardView) findViewById(R.id.rate);
        CardView privacy = (CardView) findViewById(R.id.privacy);
        CardView shareapps = (CardView) findViewById(R.id.share);

        startLoancalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent ( NextActivity.this,SelectActivity.class );
                TopOnAdsHelper.LoadInterstitial(NextActivity.this,i,false);


            }
        });




        rateloancalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AboutAppHelper.rateApp(NextActivity.this);
            }
        });

        shareapps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AboutAppHelper.share_myapp(NextActivity.this);
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AboutAppHelper.Pricacypolicy_my(NextActivity.this);
            }
        });
    }

    public void openportal1() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor( ContextCompat.getColor(this, R.color.colorPrimary));
        CustomTabsIntent build = builder.build();
        build.intent.setPackage("com.android.chrome");
        build.launchUrl(this, Uri.parse("https://41.go.qureka.com/"));
    }

}