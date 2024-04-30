package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_main);

        TopOnAdsHelper.LOADBANNERAD(MainActivity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(MainActivity.this,findViewById(R.id.native_ad_container));


        LinearLayout compoundloan = findViewById (R.id.loansecond);
        compoundloan.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Intent i = new Intent ( MainActivity.this,Emicalc.class);
                TopOnAdsHelper.LoadInterstitial(MainActivity.this,i,false);

            }
        });

        LinearLayout mortloan = findViewById (R.id.loanfirst);
        mortloan.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Intent i = new Intent ( MainActivity.this,MortgageLoan.class);
                TopOnAdsHelper.LoadInterstitial(MainActivity.this,i,false);

            }
        });
    }
}