package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.IccOpenLogicalChannelResponse;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class IntantLoanActivity extends AppCompatActivity {

    public ImageView icTest1;
    public  ImageView icTest10;
    public  ImageView icTest11;
    public  ImageView icTest12;
    public  ImageView icTest2;
    public  ImageView icTest3;
    public  ImageView icTest4;
    public  ImageView icTest5;
    public  ImageView icTest6;
    public  ImageView icTest7;
    public  ImageView icTest8;
    public  ImageView icTest9;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_intant_loan);

        TopOnAdsHelper.LOADBANNERAD(IntantLoanActivity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(IntantLoanActivity.this,findViewById(R.id.native_ad_container));


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

        icTest1 = findViewById(R.id.ic_test1);
        icTest2 = findViewById(R.id.ic_test2);
        icTest3 = findViewById(R.id.ic_test3);
        icTest4 = findViewById(R.id.ic_test4);
        icTest5 = findViewById(R.id.ic_test5);
        icTest6 = findViewById(R.id.ic_test6);
        icTest7 = findViewById(R.id.ic_test7);
        icTest8 = findViewById(R.id.ic_test8);
        icTest9 = findViewById(R.id.ic_test9);
        icTest10 = findViewById(R.id.ic_test10);
        icTest11 = findViewById(R.id.ic_test11);
        icTest12 = findViewById(R.id.ic_test12);

        icTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "Active UNA");
                                   i.putExtra(details.Desc, getString(R.string.a1));
                                   startActivity (i);

             }
        });

        icTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "Balance Online");
                                   i.putExtra(details.Desc, getString(R.string.a2));
                                    startActivity (i);


            }
        });
        icTest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "Pensioners");
                                   i.putExtra(details.Desc, getString(R.string.a3));
                                    startActivity (i);


            }
        });
        icTest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "TRRN Status");
                                   i.putExtra(details.Desc, getString(R.string.a4));
                                    startActivity (i);


            }
        });

        icTest5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (IntantLoanActivity.this, details.class);
                   i.putExtra(details.Title, "Claim");
                   i.putExtra(details.Desc, getString(R.string.a5));
                    startActivity (i);

            }
        });
        icTest6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "Balance Online");
                                   i.putExtra(details.Desc, getString(R.string.a6));
                                    startActivity (i);

            }
        });
        icTest7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "Balance (SMS)");
                                   i.putExtra(details.Desc, getString(R.string.a7));
                                    startActivity (i);


            }
        });
        icTest8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "FAQ");
                                   i.putExtra(details.Desc, getString(R.string.a8));
                                    startActivity (i);


            }
        });
        icTest9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "News");
                                   i.putExtra(details.Desc, getString(R.string.a9));
                                    startActivity (i);


            }
        });
        icTest10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                       i.putExtra(details.Title, "Helpline");
                                       i.putExtra(details.Desc, getString(R.string.a10));
                                       startActivity (i);


            }
        });
        icTest11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "EPF Online");
                                   i.putExtra(details.Desc, getString(R.string.a11));
                                   startActivity (i);


            }
        });

        icTest12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                                Intent i = new Intent (IntantLoanActivity.this, details.class);
                                   i.putExtra(details.Title, "Locate Office");
                                   i.putExtra(details.Desc, getString(R.string.a12));
                                   startActivity (i);
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