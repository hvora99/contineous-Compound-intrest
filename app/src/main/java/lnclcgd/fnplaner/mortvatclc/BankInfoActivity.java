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

public class BankInfoActivity extends AppCompatActivity {

    public LinearLayout llAxis;
    public  LinearLayout llBob;
    public  LinearLayout llBoi;
    public  LinearLayout llCanara;
    public  LinearLayout llHdfc;
    public  LinearLayout llIcic;
    public  LinearLayout llIdbi;
    public  LinearLayout llIdfc;
    public  LinearLayout llKotak;
    public  LinearLayout llPunjabnational;
    public  LinearLayout llSbi;
    public  LinearLayout llUboi;
    public  LinearLayout llVijyabank;
    public  LinearLayout llYes;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_bank_info);

        TopOnAdsHelper.LOADBANNERAD(BankInfoActivity.this,findViewById(R.id.banner_container));

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

        llAxis.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "18004195959");
                                    i.putExtra("mini", "18004196969");
                                    i.putExtra("customer", "18604195555");
                                     startActivity (i);

            }
        });
        llBob.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);
                                    i.putExtra("bankbalance", "08468001111");
                                    i.putExtra("mini", "08468001122");
                                    i.putExtra("customer", "18001024455");
                                     startActivity (i);

            }
        });
        llBoi.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "09015135135");
                                    i.putExtra("mini", "9810558585");
                                    i.putExtra("customer", "1800220229");
                                    startActivity (i);

            }
        });
        llCanara.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "09015734744");
                                    i.putExtra("mini", "09015483483");
                                    i.putExtra("customer", "18004250018");
                                    startActivity (i);


            }
        });
        llHdfc.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "18002703333");
                                    i.putExtra("mini", "18002703355");
                                    i.putExtra("customer", "18602676161");
                                    startActivity (i);


            }
        });
        llIcic.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "9594612612");
                                    i.putExtra("mini", "9594613613");
                                    i.putExtra("customer", "18002003344");
                                    startActivity (i);

            }
        });

        llIdbi.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "18008431122");
                                    i.putExtra("mini", "18008431133");
                                    i.putExtra("customer", "18002094324");
                                    startActivity (i);

            }
        });
        llIdfc.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "18002700720");
                                    i.putExtra("mini", "5676732");
                                    i.putExtra("customer", "18004194332");
                                    startActivity (i);

            }
        });
        llKotak.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "18002740110");
                                    i.putExtra("mini", "9971056767");
                                    i.putExtra("customer", "18602662666");
                                     startActivity (i);


            }
        });
        llPunjabnational.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "18001802223");
                                    i.putExtra("mini", "5607040");
                                    i.putExtra("customer", "18001802222");
                                    startActivity (i);


            }
        });
        llSbi.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "09223766666");
                                    i.putExtra("mini", "09223866666");
                                    i.putExtra("customer", "18004253800");
                                    startActivity (i);


            }
        });
        llUboi.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "09223002586");
                                    i.putExtra("mini", "09223008486");
                                    i.putExtra("customer", "18002082244");
                                    startActivity (i);

            }
        });

        llVijyabank.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "18001035525");
                                    i.putExtra("mini", "18001035535");
                                    i.putExtra("customer", "18004255885");
                                    startActivity (i);
            }
        });

        llYes.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick ( View view ) {
                                Intent i = new Intent (BankInfoActivity.this, BankDetailsActivity.class);

                                    i.putExtra("bankbalance", "09223920000");
                                    i.putExtra("mini", "09223921111");
                                    i.putExtra("customer", "18001200");
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