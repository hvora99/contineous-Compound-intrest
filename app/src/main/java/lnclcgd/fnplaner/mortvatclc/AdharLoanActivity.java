package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class AdharLoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_adhar_loan);

        TopOnAdsHelper.LOADBANNERAD(AdharLoanActivity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(AdharLoanActivity.this,findViewById(R.id.native_ad_container));

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



        LinearLayout llInstant=findViewById(R.id.ll_instant);
        LinearLayout llLoanGuide=findViewById(R.id.ll_loan_guide);
        llLoanGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 Intent i = new Intent ( AdharLoanActivity.this,LoanGuide2.class );
                TopOnAdsHelper.LoadInterstitial(AdharLoanActivity.this,i,false);

            }
        });
        llInstant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent ( AdharLoanActivity.this,LoanGuide2.class );
                TopOnAdsHelper.LoadInterstitial(AdharLoanActivity.this,i,false);            }
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