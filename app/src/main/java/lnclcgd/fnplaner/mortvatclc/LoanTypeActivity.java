package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class LoanTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_loan_type);

        TopOnAdsHelper.LOADBANNERAD(LoanTypeActivity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(LoanTypeActivity.this,findViewById(R.id.native_ad_container));

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

        findViewById(R.id.txt_personal).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanTypeActivity.this, InfoActivity.class);
                intent.putExtra("title", "Personal Loan");
                intent.putExtra("txthn", LoanTypeActivity.this.getString(R.string.str1));
                intent.putExtra("txten", LoanTypeActivity.this.getString(R.string.str11));

                LoanTypeActivity.this.startActivity(intent);

            }
        });
        findViewById(R.id.txt_home).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanTypeActivity.this, InfoActivity.class);
                intent.putExtra("title", "Home Loan");
                intent.putExtra("txthn", LoanTypeActivity.this.getString(R.string.str2));
                intent.putExtra("txten", LoanTypeActivity.this.getString(R.string.str22));

                LoanTypeActivity.this.startActivity(intent);

            }
        });
        findViewById(R.id.txt_bussiness).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanTypeActivity.this, InfoActivity.class);
                intent.putExtra("title", "Bussiness Loan");
                intent.putExtra("txthn", LoanTypeActivity.this.getString(R.string.str3));
                intent.putExtra("txten", LoanTypeActivity.this.getString(R.string.str33));

                LoanTypeActivity.this.startActivity(intent);

            }
        });
        findViewById(R.id.txt_education).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanTypeActivity.this, InfoActivity.class);
                intent.putExtra("title", "Education Loan");
                intent.putExtra("txthn", LoanTypeActivity.this.getString(R.string.str4));
                intent.putExtra("txten", LoanTypeActivity.this.getString(R.string.str44));

                LoanTypeActivity.this.startActivity(intent);

            }
        });
        findViewById(R.id.txt_car).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanTypeActivity.this, InfoActivity.class);
                intent.putExtra("title", "Car Loan");
                intent.putExtra("txthn", LoanTypeActivity.this.getString(R.string.str5));
                intent.putExtra("txten", LoanTypeActivity.this.getString(R.string.str55));

                LoanTypeActivity.this.startActivity(intent);

            }
        });
        findViewById(R.id.txt_gold).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanTypeActivity.this, InfoActivity.class);
                intent.putExtra("title", "Gold Loan");
                intent.putExtra("txthn", LoanTypeActivity.this.getString(R.string.str6));
                intent.putExtra("txten", LoanTypeActivity.this.getString(R.string.str66));

                LoanTypeActivity.this.startActivity(intent);

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