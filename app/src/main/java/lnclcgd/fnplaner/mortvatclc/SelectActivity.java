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

public class SelectActivity extends AppCompatActivity {

    LinearLayout adhar1,adhar2;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_select);

        TopOnAdsHelper.LOADBANNERAD(SelectActivity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(SelectActivity.this,findViewById(R.id.native_ad_container));

        ImageView q3 = (ImageView) findViewById(R.id.q2);
        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openportal1 ();

            }
        });

        adhar1 = findViewById(R.id.adhar1);
        adhar2 = findViewById(R.id.adhar2);

        adhar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (SelectActivity.this, Main2Activity.class).putExtra("type", 1));

            }
        });
        adhar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectActivity.this, MainActivity.class).putExtra("type", 1));

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