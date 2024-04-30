package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class BankDetailsActivity extends AppCompatActivity {
    private String bankbalance;
    private String customer;
    private boolean isBack = false;
    private boolean isClick1 = false;
    private boolean isClick2 = false;
    private boolean isClick3 = false;
    private String mini;

    public ImageView ivCopyBalance;
    public ImageView ivCopyCare;
    public ImageView ivCopyMini;
    public LinearLayout top;
    public TextView tvBankBalance;
    public TextView tvCustmoreCare;
    public TextView tvMiniStatement;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_bank_details);

        TopOnAdsHelper.LOADBANNERAD(BankDetailsActivity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(BankDetailsActivity.this,findViewById(R.id.native_ad_container));

        ImageView q3 = (ImageView) findViewById(R.id.q1);
        q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openportal1 ();

            }
        });

        ImageView q4 = (ImageView) findViewById(R.id.q2);
        q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openportal1 ();

            }
        });


        ivCopyBalance = findViewById(R.id.iv_copy_balance);
        ivCopyCare = findViewById(R.id.iv_copy_care);
        ivCopyMini = findViewById(R.id.iv_copy_mini);
        top = findViewById(R.id.top);
        tvBankBalance = findViewById(R.id.tv_bank_balance);
        tvCustmoreCare = findViewById(R.id.tv_custmore_care);
        tvMiniStatement = findViewById(R.id.tv_mini_statement);

        Intent intent = getIntent();
        this.bankbalance = intent.getStringExtra("bankbalance");
        this.mini = intent.getStringExtra("mini");
        this.customer = intent.getStringExtra("customer");
        tvBankBalance.setText(this.bankbalance);
        tvMiniStatement.setText(this.mini);
        tvCustmoreCare.setText(this.customer);
        ivCopyBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClick1 = true;
                doWork();
            }
        });
        ivCopyMini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClick2 = true;
                doWork();
            }
        });
        ivCopyCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isClick1 = true;
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

    @SuppressLint("WrongConstant")
    private void doWork() {
        if (this.isClick1) {
            this.isClick1 = false;
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.bankbalance));
            Toast.makeText(this, "text Copy", 0).show();
        } else if (this.isClick2) {
            this.isClick2 = false;
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.mini));
            Toast.makeText(this, "text Copy", 0).show();
        } else if (this.isClick3) {
            this.isClick3 = false;
            ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", this.customer));
            Toast.makeText(this, "text Copy", 0).show();
        }
    }
}