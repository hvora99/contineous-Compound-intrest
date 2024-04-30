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

public class HolidayActivity extends AppCompatActivity {


    public LinearLayout llAxis;
    public  LinearLayout llBob;
    public  LinearLayout llBoi;
    public  LinearLayout llCanara;
    public  LinearLayout llHdfc;
    public  LinearLayout llIcic;
    public  LinearLayout llIdbi;
    public  LinearLayout llIdfc;
    public  LinearLayout llKotak;
    public  LinearLayout llMain;
    public  LinearLayout llPunjabnational;
    public  LinearLayout llSbi;
    public  LinearLayout llUboi;
    public  LinearLayout llVijyabank;
    public  LinearLayout llYes;
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_holiday);

        TopOnAdsHelper.LOADBANNERAD(HolidayActivity.this,findViewById(R.id.banner_container));

        ImageView q3 = (ImageView) findViewById(R.id.q2);
        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openportal1 ();

            }
        });

        ImageView q4 = (ImageView) findViewById(R.id.q3);
        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  openportal1 ();

            }
        });

        ImageView q5 = (ImageView) findViewById(R.id.q4);
        q5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  openportal1 ();

            }
        });

        ImageView q6 = (ImageView) findViewById(R.id.q5);
        q6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  openportal1 ();

            }
        });

        ImageView q7 = (ImageView) findViewById(R.id.q6);
        q7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  openportal1 ();

            }
        });

        ImageView q8 = (ImageView) findViewById(R.id.q7);
        q8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  openportal1 ();

            }
        });

        ImageView q9 = (ImageView) findViewById(R.id.q8);
        q9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  openportal1 ();

            }
        });



        llAxis = findViewById(R.id.ll_axis);
        llBob = findViewById(R.id.ll_bob);
        llBoi = findViewById(R.id.ll_boi);
        llCanara = findViewById(R.id.ll_canara);
        llHdfc = findViewById(R.id.ll_hdfc);
        llIcic = findViewById(R.id.ll_icic);
        llIdbi = findViewById(R.id.ll_idbi);
        llIdfc = findViewById(R.id.ll_idfc);
        llKotak = findViewById(R.id.ll_kotak);
        llPunjabnational = findViewById(R.id.ll_punjabnational);
        llSbi = findViewById(R.id.ll_sbi);
        llUboi = findViewById(R.id.ll_uboi);
        llVijyabank = findViewById(R.id.ll_vijyabank);
        llYes = findViewById(R.id.ll_yes);
        llMain = findViewById(R.id.ll_main);

        llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doWork();
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
    
    private void doWork() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setPackage("com.android.chrome");
        build.launchUrl(this, Uri.parse("https://www.bankbazaar.com/indian-holiday/january-holidays.html"));
    }
}