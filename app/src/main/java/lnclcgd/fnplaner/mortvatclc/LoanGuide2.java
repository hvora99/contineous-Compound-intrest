package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class LoanGuide2 extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_loan_guide2);

        TopOnAdsHelper.LOADBANNERAD(LoanGuide2.this,findViewById(R.id.banner_container));

        ImageView q3 = (ImageView) findViewById(R.id.q2);
        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  openportal1 ();

            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager (this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<> ();


        input.add("बिजनेस लोन मिलेगा अब आधार कार्ड से");
        input.add("बिआधार कार्ड से हुई लोन मिलने में आसानी");
        input.add("बिआधार कार्ड से कितने तरह का लोन");
        input.add("बआधार कार्ड से लोन के लिए जरूरी योग्यता");
        input.add("आधार कार्ड से घर के लिए लोन");
        input.add("बिमुद्रा योजना– Mudra Yojna Kya");
        input.add("बिक्या आधार कार्ड से लोन मिल सकता है?");
        input.add("बिआधार कार्ड पर लोन कैसे मिलेगा");

        RecyclerView.Adapter mAdapter = new OurAdapterr(input, this);
        recyclerView.setAdapter(mAdapter);
    }

    public void openportal1() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor( ContextCompat.getColor(this, R.color.colorPrimary));
        CustomTabsIntent build = builder.build();
        build.intent.setPackage("com.android.chrome");
        build.launchUrl(this, Uri.parse("https://41.go.qureka.com/"));
    }
}