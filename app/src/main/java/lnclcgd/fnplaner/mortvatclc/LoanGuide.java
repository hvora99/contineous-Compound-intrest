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

public class LoanGuide extends AppCompatActivity {
    public int anInt = 0;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_loan_guide);

        TopOnAdsHelper.LOADBANNERAD(LoanGuide.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(LoanGuide.this,findViewById(R.id.native_ad_container));


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

        LinearLayout lon1 = findViewById (R.id.ic_personal_loan);
        lon1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "What is AadharCard Loan?");
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b1));
                intent.putExtra("pos", LoanGuide.this.anInt);
                LoanGuide.this.startActivity(intent);

            }
        });
        LinearLayout lon2 = findViewById (R.id.ic_home_loan);
        lon2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "For What Purposes can it be used?");
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b2));
                intent.putExtra("pos", LoanGuide.this.anInt);

                LoanGuide.this.startActivity(intent);

            }
        });

        LinearLayout lon3 = findViewById (R.id.ic_education_loan);
        lon3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "Which Eligblity criteria for loan?");
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b3));
                intent.putExtra("pos", LoanGuide.this.anInt);

                LoanGuide.this.startActivity(intent);

            }
        });

        LinearLayout lon4 = findViewById (R.id.ic_Creditcard);
        lon4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, " How Much can one borrow?");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b4));

                LoanGuide.this.startActivity(intent);

            }
        });

        LinearLayout lon5 = findViewById (R.id.ic_business_loan);
        lon5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "From which bank/financial institution should one borrow?");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b5));

                LoanGuide.this.startActivity(intent);

            }
        });

        LinearLayout lon6 = findViewById (R.id.ic_Gold_Loan);
        lon6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 LoanGuide.this.anInt = 5;
                Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "How do Banks decide on the maximum loan amount?");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b6));
                LoanGuide.this.startActivity(intent);


            }
        });

        LinearLayout lon7 = findViewById (R.id.ic_car_loan);
        lon7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "What are the common rates for loan?");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b7));

                LoanGuide.this.startActivity(intent);

            }
        });

        LinearLayout lon8 = findViewById (R.id.ic_bike_loan);
        lon8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "Key documents required when apply for a loan?");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b8));

                LoanGuide.this.startActivity(intent);

            }
        });

        LinearLayout lon9 = findViewById (R.id.ic_diff);
        lon9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "Difference between part payment, prepayment and perclosure");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b9));

                LoanGuide.this.startActivity(intent);

            }
        });

        LinearLayout lon10 = findViewById (R.id.ic_loanappruv);

        lon10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "loan approval process");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b10));

                LoanGuide.this.startActivity(intent);

            }
        });

        LinearLayout lon11 = findViewById (R.id.ic_credit);
        lon11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "Credit Report And Score");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b11));

                LoanGuide.this.startActivity(intent);

            }
        });
        
        LinearLayout lon12 = findViewById (R.id.ic_beni);
        lon12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                 Intent intent = new Intent(LoanGuide.this, details.class);
                intent.putExtra(details.Title, "How is having a higher credit score beneficial?");
                intent.putExtra("pos", LoanGuide.this.anInt);
                intent.putExtra(details.Desc, LoanGuide.this.getString(R.string.b12));

                LoanGuide.this.startActivity(intent);

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