package lnclcgd.fnplaner.mortvatclc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Objects;

import lnclcgd.fnplaner.mortvatclc.AdHelper.TopOnAdsHelper;

public class Main2Activity extends AppCompatActivity {


    public  LinearLayout llAdhar;
    public  LinearLayout llBankinfo;
    public  LinearLayout llCashCounter;
    public  LinearLayout llEpf;
    public  LinearLayout llHoliday;
    public  LinearLayout llInstantloan;
    public  LinearLayout llLoanGuide;
    public  LinearLayout llLoantype;


    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate (savedInstanceState);
        Objects.requireNonNull (getSupportActionBar ( )).hide ();
        setContentView ( R.layout.activity_main2);

        TopOnAdsHelper.LOADBANNERAD(Main2Activity.this,findViewById(R.id.banner_container));
        TopOnAdsHelper.LoadNativeAd(Main2Activity.this,findViewById(R.id.native_ad_container));


        llAdhar = findViewById(R.id.ll_adhar);
        llBankinfo = findViewById(R.id.ll_bankinfo);
        llCashCounter = findViewById(R.id.ll_cash_counter);
        llEpf = findViewById(R.id.ll_epf);
        llHoliday = findViewById(R.id.ll_holiday);
        llInstantloan = findViewById(R.id.ll_instantloan);
        llLoanGuide = findViewById(R.id.ll_loan_guide);
        llLoantype = findViewById(R.id.ll_loantype);

        llLoanGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent (Main2Activity.this, LoanGuide.class));
            }
        });
        llAdhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(Main2Activity.this, AdharLoanActivity.class));

            }
        });
        llLoantype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this, LoanTypeActivity.class));

            }
        });
        llBankinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Main2Activity.this, BankInfoActivity.class));

            }
        });

        llInstantloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(Main2Activity.this, IntantLoanActivity.class));

            }
        });
        llHoliday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(Main2Activity.this, HolidayActivity.class));

            }
        });
        llEpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity(new Intent(Main2Activity.this, LoanEpfActivity.class));

            }
        });
        llCashCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 startActivity( new Intent(Main2Activity.this, CashCounterActivity.class));
            }
        });

    }
}